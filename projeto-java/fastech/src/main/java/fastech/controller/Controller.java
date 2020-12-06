package fastech.controller;

import fastech.model.Collaborator;
import fastech.model.GlobalVars;
import fastech.model.Machine;
import fastech.model.Types;
import fastech.services.Connection;
import fastech.services.TakingDataServices;
import java.util.List;
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

        String getIdMachine = String.format("select top 1 idMachine from Machine m where m.Name = '%s' and m.fkCompanyBranch = ? order by idMachine desc;", nameMachine);

        List<Machine> idMachine = con.query(getIdMachine,
                new BeanPropertyRowMapper(Machine.class), globalVars.getFkCompany());

        idMachine.forEach((Machine m) -> {
            globalVars.setFkMachine(m.getIdMachine());
        });
        System.out.println(globalVars.getFkMachine());
    }

    public void registerMachine(String nameMachine) {

        String addMachine = String.format("insert into Machine(Name , fkCompanyBranch ) values ('%s', ?);", nameMachine);
        con.update(addMachine, globalVars.getFkCompany());

        setGlobalMachine(nameMachine);
        
        String nameCpu = tkDataServices.getNameProcessor();

        StringBuilder addComponents = new StringBuilder();
        addComponents.append(String.format("insert into Component (Name ,fkMachine ,fkType) values ('%s', ?, 1);", nameCpu));
        addComponents.append(String.format("insert into Component (Name ,fkMachine ,fkType) values ('%s', ?, 2);", "Memoria"));
        addComponents.append(String.format("insert into Component (Name ,fkMachine ,fkType) values ('%s', ?, 3);", "Disco"));
        addComponents.append(String.format("insert into Component (Name ,fkMachine ,fkType) values ('%s', ?, 4);", "Network"));

        con.update(addComponents.toString(),
                globalVars.getFkMachine(),
                globalVars.getFkMachine(),
                globalVars.getFkMachine(),
                globalVars.getFkMachine()
        );
        setGlobalVarComponentList();

    }
    
    public void setGlobalVarComponentList() {

        String selectComponet = "select * from Component where fkMachine = ?;";

        List<fastech.model.Component> components = con.query(selectComponet,
                new BeanPropertyRowMapper(fastech.model.Component.class), globalVars.getFkMachine());

        globalVars.setFkComponent(components);

    }

    public void insertData(String nameType) {

        Integer idType = selectTypeData(nameType);
        Integer idComponent = selectIdComponent(idType);
        Integer valueComponent = selectValuesComponent(idType);
        String insertData = String.format("insert into Data(dtMoment,value,Component_idComponent,Component_fkMachine) Values(CONVERT(DATETIME,'%s',120),?,?,?);",
                tkDataServices.dateNow());

        con.update(insertData, valueComponent, idComponent, globalVars.getFkMachine());
    }
    
    
    

    public Integer selectTypeData(String nameType) {
        String getIdType = "SELECT * FROM Types WHERE NameType = ?;";
        Integer idType = 0;
        List<Types> listIdType = con.query(getIdType,
                new BeanPropertyRowMapper(Types.class), nameType);

        for (Types t : listIdType) {
            idType = t.getIdType();
        }

        return idType;
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

    public Integer selectValuesComponent(Integer idType) {
        switch (idType) {
            case 1:
                return tkDataServices.getCpuUsage();
            case 2:
                return tkDataServices.getMemory();
            case 3:
                return tkDataServices.getAvailableDiskSpace();
        }
        System.out.println("Logger");
        return null;
    }
}
