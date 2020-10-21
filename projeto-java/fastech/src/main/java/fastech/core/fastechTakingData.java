/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fastech.core;

import fastech.taking.data.InfoCpu;
import fastech.taking.data.InfoDisk;
import fastech.taking.data.InfoListProcessors;
import fastech.taking.data.InfoMemory;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import oshi.SystemInfo;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.software.os.OperatingSystem;

/**
 *
 * @author Cliente
 */
public class fastechTakingData {

    private static final Logger logger = LoggerFactory.getLogger(fastechTakingData.class);

    public static List<String> oshi = new ArrayList<>();

    public static void main(String[] args) {
        SystemInfo si = new SystemInfo();
        OperatingSystem os = si.getOperatingSystem();
        HardwareAbstractionLayer hal = si.getHardware();

        InfoCpu.printProcessor(hal.getProcessor());
        InfoDisk.printDisks(hal.getDiskStores());
        InfoMemory.printMemory(hal.getMemory());
        InfoListProcessors.printProcesses(os, hal.getMemory());

        System.out.println(os.toString());
        for (int i = 0; i < oshi.size(); i++) {
            System.out.println(oshi.get(i));
        }
    }

}
