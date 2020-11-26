package fastech.controller;

import fastech.model.Collaborator;
import fastech.model.GlobalVars;
import fastech.model.Machine;
import fastech.services.Connection;
import fastech.services.TakingDataServices;
import java.awt.Component;
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

    public void login(String login, String passWord) {

        String selectLogin = "select * from Collaborator where login = ? and password = ?;";

        List<Collaborator> collaborator = con.query(selectLogin,
                new BeanPropertyRowMapper(Collaborator.class), login, passWord);

        if (collaborator.size() > 0) {

            collaborator.forEach((Collaborator c) -> {
                globalVars.setFkCompany(c.getFkCompanyBranch());
            });

        } else {

            System.out.println("Error");

        }
    }

    public void showAllMachine() {

        String selectAllMachines = "select M.Name, M.idMachine, M.fkCompanyBranch from Machine M "
                + "left join CompanyBranch C on M.fkCompanyBranch = C.idCompanyBranch "
                + "where M.fkCompanyBranch = ?;";

        List<Machine> machines = con.query(selectAllMachines,
                new BeanPropertyRowMapper(Machine.class), globalVars.getFkCompany());

        if (!(machines.size() > 0)) {
            System.out.println("Erro");
        }

        for (Machine m : machines) {
            System.out.println(m);
        }
    }

    public void setGlobalMachine(String nameMachine) {

        String getIdMachine = String.format("select top 1 idMachine from Machine m where m.Name = '%s' and m.fkCompanyBranch = ? order by idMachine desc;", nameMachine);

        List<Machine> idMachine = con.query(getIdMachine,
                new BeanPropertyRowMapper(Machine.class), globalVars.getFkCompany());

        idMachine.forEach((Machine m) -> {
            globalVars.setFkMachine(m.getIdMachine());
        });
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
                globalVars.getFkMachine(),
                globalVars.getFkMachine(),
                globalVars.getFkMachine(),
                globalVars.getFkMachine()
        );

    }

    public void setGlobalVarComponentList() {

        String selectComponet = "select * from Component;";

        List<fastech.model.Component> components = con.query(selectComponet,
                new BeanPropertyRowMapper(fastech.model.Component.class));

        globalVars.setFkComponent(components);

    }

    public void insertDataCpu() {
        
        setGlobalVarComponentList();

        globalVars.getFkComponent().forEach((fastech.model.Component c) -> {

            if (c.getFkType().equals(1)) {

                String insertCpuUsage = String.format("insert into Data(dtMoment,value,Component_idComponent,Component_fkMachine) Values('2020-11-25 23:53:00',50,1,2);");

//                Integer value = tkDataServices.getCpuUsage();

//                con.update(insertCpuUsage, value, c.getIdComponent(), globalVars.getFkMachine());
                con.update(insertCpuUsage);
            }
        });

    }

    public void insertDataMemory() {

        String insertMemoryUsage = String.format("insert into Data(dtMoment,value,Component_idComponent,Component_fkMachine) Values(CONVERT(DATETIME,'%s',120),?,?,?);",
                tkDataServices.dateNow());

        Integer value = tkDataServices.getMemory();

        con.update(insertMemoryUsage, value, 2, globalVars.getFkMachine());

    }

    public void insertDataFileSystem() {

        String insertDiskUsage = String.format("insert into Data(dtMoment,value,Component_idComponent,Component_fkMachine) Values(CONVERT(DATETIME,'%s',120),?,?,?);",
                tkDataServices.dateNow());

        Integer value = tkDataServices.getAvailableDiskSpace();

        con.update(insertDiskUsage, value, 3, globalVars.getFkMachine());

    }

}
