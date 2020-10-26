/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fastech.fastech;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.GlobalMemory;
import oshi.hardware.HWDiskStore;
import oshi.hardware.HWPartition;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.hardware.PhysicalMemory;
import oshi.hardware.VirtualMemory;
import oshi.software.os.OperatingSystem;

/**
 *
 * @author Cliente
 */
public class OshiApi {

    private static final Logger logger = LoggerFactory.getLogger(OshiApi.class);

    static List<String> oshi = new ArrayList<>();

    public static void main(String[] args) {
        SystemInfo si = new SystemInfo();
        OperatingSystem os = si.getOperatingSystem();
        HardwareAbstractionLayer hal = si.getHardware();
        
        printMemory(hal.getMemory());
        printDisks(hal.getDiskStores());
        printProcessor(hal.getProcessor());
        
        
        System.out.println(os.toString());
        for (int i = 0; i < oshi.size(); i++) {
            System.out.println(oshi.get(i));
        }
    }
    private static void printProcessor(CentralProcessor processor) {
        oshi.add(processor.toString());
    }
    

    private static void printMemory(GlobalMemory memory) {
        oshi.add("Physical Memory: \n " + memory.toString());
        VirtualMemory vm = memory.getVirtualMemory();
        oshi.add("Virtual Memory: \n " + vm.toString());
        List<PhysicalMemory> pmList = memory.getPhysicalMemory();
        if (!pmList.isEmpty()) {
            oshi.add("Physical Memory: ");
            for (PhysicalMemory pm : pmList) {
                oshi.add(" " + pm.toString());
            }
        }
    }
    private static void printDisks(List<HWDiskStore> list) {
        oshi.add("Disks:");
        for (HWDiskStore disk : list) {
            oshi.add(" " + disk.toString());

            List<HWPartition> partitions = disk.getPartitions();
            for (HWPartition part : partitions) {
                oshi.add(" |-- " + part.toString());
            }
        }

    }

}
