/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fastech.logger;

import fastech.oshi.gui.Oshi;

/**
 *
 * @author mmaia
 */
public class Validacao {
    
    public boolean validaMaquina(Oshi getvaluesProcessor) {
        boolean verificada = false;

        if (!(getvaluesProcessor.getMarcaMaquina() == null) || !(getvaluesProcessor.getSistemaOperacional() == null) || !(getvaluesProcessor.getMemoriaTotal() == null)
                || !(getvaluesProcessor.getInfoProcessador() == null) || !(getvaluesProcessor.getModelo() == null) || !(getvaluesProcessor.getNumeroSerie() == null)
                || !(getvaluesProcessor.getEspacoTotalHd() == null)) {
            verificada = true;
        }

        return verificada;
    }
}
