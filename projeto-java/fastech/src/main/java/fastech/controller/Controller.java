package fastech.controller;

import fastech.model.Collaborator;
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

    public void login(String login, String senha) {

        String selectLogin = "select * from Collaborator where login = ? and password = ?;";

        List<Collaborator> collaborator = con.query(selectLogin,
                new BeanPropertyRowMapper(Collaborator.class), login, senha);

        if (collaborator.size() > 0) {
            System.out.println("Existe a pessoa");
        } else {
            System.out.println("Error");
        }
    }
    
    public void selectMachine(){
        //Adicionar select para para pegar as GlobalVars fkCompany, fkMachine,fkComponet
        //Adicionar cadastro de maquinas atraves do java
    }

    public void insertCpu() {

        System.out.println(tkDataServices.dateNow());
        
        String insertCpuUsage = String.format("insert into Data(dtMoment,value,Component_idComponent,Component_fkMachine) Values(CONVERT(DATETIME,'%s',120),?,?,?);", tkDataServices.dateNow());
        Integer value = tkDataServices.getCpuUsage();
        con.update(insertCpuUsage,value,1,1);
        
    }

    public void insertMemory() {
        tkDataServices.getMemory();

    }

    public void insertFileSystem() {
        tkDataServices.getAvailableDiskSpace();
    }

}
