/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fastech.logger;

import fastech.services.TakingDataServices;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;


/**
 *
 * @author mmaia
 */
public class Logger {

    TakingDataServices dataServices = new TakingDataServices();
    private File arquivo;

    public Logger() {
        
        
        arquivo = new File("log.txt");
    }
    
    
    public void escreveTexto(String tipo, String recebe) throws IOException{
        FileWriter inserindo = new FileWriter(arquivo, true);
        inserindo.write(String.format("\n %s - %s - %s", tipo, dataServices.dateNow(), recebe));
        inserindo.close();
    }

}
    

