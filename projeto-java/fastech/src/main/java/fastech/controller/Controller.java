package fastech.controller;

import fastech.model.Collaborator;
import fastech.model.GlobalVars;
import fastech.model.Machine;
import fastech.model.Types;
import static fastech.services.AppSlack.slackSendMessage;
import fastech.services.Connection;
import fastech.services.TakingDataServices;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import oshi.SystemInfo;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.software.os.OperatingSystem;

/**
 *
 * @author Jorge
 */
public class Controller {

    List<Integer> valuesCpu;
    List<Integer> valuesMemory;

    public Controller() {
        this.valuesCpu = new ArrayList();
        this.valuesMemory = new ArrayList();
    }

    Connection config = new Connection();
    JdbcTemplate con = new JdbcTemplate(config.getDatasource());
    SystemInfo si = new SystemInfo();
    HardwareAbstractionLayer hal = si.getHardware();
    OperatingSystem os = si.getOperatingSystem();
    TakingDataServices tkDataServices = new TakingDataServices();
    GlobalVars globalVars = new GlobalVars();

    public String login(String login, String passWord) {

        String selectLogin = "select * from Collaborator where login = ? and password = ?;";

        List<Collaborator> collaborator = con.query(selectLogin,
                new BeanPropertyRowMapper(Collaborator.class), login, passWord);

        if (collaborator.size() > 0) {

            collaborator.forEach((Collaborator c) -> {
                Integer fk = c.getFkCompanyBranch();
                globalVars.setFkCompany(fk);
            });
            return "OK";
        } else {
            System.out.println("Logger login");
            return "N/OK";
        }
    }

    public List<Machine> showAllMachine() {

        String selectAllMachines = "select * from Machine M where M.fkCompanyBranch = ?;";

        List<Machine> machines = con.query(selectAllMachines,
                new BeanPropertyRowMapper(Machine.class), globalVars.getFkCompany());

        if (machines.size() > 0) {
            return machines;
        } else {
            System.out.println("Logger showAllMachine");
            return null;
        }
    }

    public void setGlobalMachine(String nameMachine) {

        String getIdMachine = String.format("select * from Machine m where m.Name = '%s' and m.fkCompanyBranch = ?;", nameMachine);

        List<Machine> listMachine = con.query(getIdMachine,
                new BeanPropertyRowMapper(Machine.class), globalVars.getFkCompany());

        for (Machine m : listMachine) {
            globalVars.setMachine(m);
        }

    }

    public void registerMachine(String nameMachine) {

        String addMachine = String.format("insert into Machine(Name , fkCompanyBranch ) values ('%s', ?);", nameMachine);
        con.update(addMachine, globalVars.getFkCompany());

        setGlobalMachine(nameMachine);

        StringBuilder addComponents = new StringBuilder();
        addComponents.append(String.format("insert into Component (Name ,fkMachine ,fkType) values ('%s', ?, 1);", "Cpu"));
        addComponents.append(String.format("insert into Component (Name ,fkMachine ,fkType) values ('%s', ?, 2);", "Memoria"));
        addComponents.append(String.format("insert into Component (Name ,fkMachine ,fkType) values ('%s', ?, 3);", "Disco"));
        addComponents.append(String.format("insert into Component (Name ,fkMachine ,fkType) values ('%s', ?, 4);", "Network"));

        con.update(addComponents.toString(),
                globalVars.getMachine().getIdMachine(),
                globalVars.getMachine().getIdMachine(),
                globalVars.getMachine().getIdMachine(),
                globalVars.getMachine().getIdMachine()
        );
        setGlobalVarComponentList();

    }

    public void setGlobalVarComponentList() {

        String selectComponet = "select * from Component where fkMachine = ?;";

        List<fastech.model.Component> components = con.query(selectComponet,
                new BeanPropertyRowMapper(fastech.model.Component.class), globalVars.getMachine().getIdMachine());

        globalVars.setFkComponent(components);

        setListTypes();
    }

    public void setListTypes() {
        String getIdType = "SELECT * FROM Types;";

        List<Types> listTypes = con.query(getIdType,
                new BeanPropertyRowMapper(Types.class));

        globalVars.setListTypes(listTypes);
    }

    public void insertData(String nameType) throws Exception {

        Integer idType = selectTypeData(nameType);
        Integer idComponent = selectIdComponent(idType);
        Integer valueComponent = selectValuesComponent(idType);
        String insertData = String.format("insert into Data(dtMoment,value,Component_idComponent,Component_fkMachine) Values(CONVERT(DATETIME,'%s',120),?,?,?);",
                tkDataServices.dateNow());

        con.update(insertData, valueComponent, idComponent, globalVars.getMachine().getIdMachine());
    }
    
    
    

    public Integer selectTypeData(String nameType) {

        for (Types t : globalVars.getListTypes()) {
            if (t.getNameType().equals(nameType)) {
                return t.getIdType();
            }
        }
        return null;
    }

    public Integer selectIdComponent(Integer idType) {
        Integer idComponent = 0;
        for (fastech.model.Component c : globalVars.getFkComponent()) {
            if (c.getFkType().equals(idType)) {

                idComponent = c.getIdComponent();
            }
        }

        return idComponent;

    }

    public void upDateStatus(Double avg, Integer idType) throws Exception {
        String statusCurrent;
        if (((idType == 1 || idType == 2) && avg >= 90) || (idType == 3 && avg >= 85)) {
            statusCurrent = "Danger";
            String messageDanger = String.format("@channel A maquina *%s* esta em "
                    + "estado critico", globalVars.getMachine().getName());
            slackSendMessage(messageDanger);
        } else if ((idType == 1 && avg >= 75) || (idType == 2 && avg >= 80) || (idType == 3 && avg >= 75)) {
            statusCurrent = "Warning";
        } else {
            statusCurrent = "Good";
        }
        String upDate = String.format("UPDATE Machine SET Status = '%s' WHERE idMachine = ?;", statusCurrent);
        con.update(upDate, globalVars.getMachine().getIdMachine());
    }

    public void setStatus(Integer value, Integer idType) throws Exception {
        switch (idType) {
            case 1:
                if (this.valuesCpu.size() < 20) {
                    this.valuesCpu.add(value);
                } else {
                    Integer sumValues = 0;
                    for (Integer i : valuesCpu) {
                        sumValues += i;
                    }
                    Double avgValues = Double.valueOf(sumValues / this.valuesCpu.size());
                    upDateStatus(avgValues, 1);
                    this.valuesCpu.clear();
                }
            case 2:
                if (this.valuesMemory.size() < 20) {
                    this.valuesMemory.add(value);
                } else {
                    Integer sumValues = 0;
                    for (Integer i : valuesMemory) {
                        sumValues += i;
                    }
                    Double avgValues = Double.valueOf(sumValues / this.valuesMemory.size());
                    upDateStatus(avgValues, 2);
                    this.valuesMemory.clear();
                }
        }
    }

    public Integer selectValuesComponent(Integer idType) throws Exception {
        switch (idType) {
            case 1:
                Integer valueCurrentCpu = tkDataServices.getCpuUsage();
                setStatus(valueCurrentCpu, 1);
                return valueCurrentCpu;
            case 2:
                Integer valueCurrentMemory = tkDataServices.getMemory();
                setStatus(valueCurrentMemory, 2);
                return valueCurrentMemory;
            case 3:
                Integer valueCurrentDisk = tkDataServices.getAvailableDiskSpace();
                upDateStatus(Double.valueOf(valueCurrentDisk), 3);
                return valueCurrentDisk;
        }
        System.out.println("Logger");
        return null;
    }
}
