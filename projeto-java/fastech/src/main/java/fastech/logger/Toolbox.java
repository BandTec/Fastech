/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fastech.logger;
import fastech.oshi.gui.Oshi;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author mmaia
 */
public class Toolbox {
    Validacao valida = new Validacao();
    String origem = this.getClass().getSimpleName();
    
   
    
        
      public String data() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }

    public String horas() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }

    public Toolbox() {
        Oshi getvaluesProcessor = null;
        valida.validaMaquina(getvaluesProcessor);
    }

}
