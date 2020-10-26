/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fastech.oshi.gui;

import java.util.Arrays;

/**
 *
 * @author igor
 */
public class TesteOshi   {
    public static void main(String[] args) {
        Oshi oshi = new Oshi();
        
        System.out.println(oshi.getValuesProcessor().toString());
        System.out.println(oshi.getValuesMemory().toString());
        System.out.println(oshi.getValuesFileSystem().toString());
        System.out.println(oshi.getValuesProcPid().toString());
        System.out.println(oshi.getValuesProcCpu().toString());
        System.out.println(oshi.getValuesProcMem().toString());
        System.out.println(oshi.getValuesProcName().toString());
    }
}
