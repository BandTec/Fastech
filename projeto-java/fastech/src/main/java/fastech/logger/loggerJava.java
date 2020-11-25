/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fastech.logger;

import fastech.services.InfoListProcessors;
import fastech.services.InfoCpu;
import fastech.services.InfoMemory;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author mmaia
 */
public class loggerJava {
    private String origem = this.getClass().getSimpleName();
    private boolean firstStart = true;
    private Toolbox tb = new Toolbox();

    public void gravarLinha(String linha) throws IOException {
        String data = tb.data();
        BufferedWriter arquivo = new BufferedWriter(new FileWriter("logs/" + data + ".log", true));
        try {
            arquivo.newLine();
            arquivo.append(linha);
        } catch (IOException e) {
            System.out.println("Exception ");
            arquivo.append(String.format("[%s] [ERRO] : IOException, erro ao adicionar linha.", data));

        } finally {
            arquivo.close();
        }
    }

    public void gravarLinha(String data, String tipo, String nomeClasse, String linha) throws IOException {
        String tempo = tb.horas();
        BufferedWriter arquivo = new BufferedWriter(new FileWriter("logs/" + data + ".log", true));
        try {
            arquivo.newLine();
            arquivo.append(String.format("[%s] [%s] [%s] : %s.", tempo, tipo, nomeClasse, linha));
        } catch (IOException e) {
            System.out.println("Exception ");
            arquivo.append(String.format("[%s] [ERRO] : IOException, erro ao adicionar linha.", data));

        } finally {
            arquivo.close();
        }
    }
    
        public void inicio() throws IOException {
            
            InfoCpu cpu = new InfoCpu();
            InfoListProcessors proc = new InfoListProcessors();
            InfoMemory mem = new InfoMemory();
            gravarLinha("==========================");
            gravarLinha(String.format("        Início da aplicação - %s %s ", tb.data(), tb.horas()));      
            gravarLinha(" =========================================== ");
            
           
            /*
            
            arrumar este trecho da próxima vez que mexer
            
        inf lp = new getHardware();
        info mq = new InfoMaquina();
        ThreadDsk dsk = new ThreadDsk();
        gravarLinha(" =========================================== ");
        gravarLinha(String.format("        Início da aplicação - %s %s ", tb.data(), tb.horas()));
        gravarLinha(" =========================================== ");
        gravarLinha(mq.getSistemaOperacional());
        gravarLinha(mq.getMarca());
        gravarLinha(mq.getModelo());
        gravarLinha(mq.getNumeroDeSerie());
        gravarLinha(hw.getProcessador());
        gravarLinha(hw.getMemoria() + " de RAM");
        gravarLinha(dsk.tamanho + "GB de armazenamento");
        gravarLinha(" =========================================== ");
*/

    
    }
  
}
