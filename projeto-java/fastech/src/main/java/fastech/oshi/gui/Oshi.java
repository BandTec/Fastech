/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fastech.oshi.gui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.GlobalMemory;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.software.os.FileSystem;
import oshi.software.os.OSFileStore;
import oshi.software.os.OSProcess;
import oshi.software.os.OperatingSystem;


/**
 *
 * @author igor
 */
public class Oshi {
    
    SystemInfo si = new SystemInfo();
    HardwareAbstractionLayer hal = si.getHardware();
    OperatingSystem os = si.getOperatingSystem();
    
    public Integer getValuesProcessor() {    
        return printProcessor(hal.getProcessor());
    }
    
    public Integer getValuesMemory() {     
        return printMemory(hal.getMemory());
    }
    
    public Integer getValuesFileSystem() {
        return printFileSystem(os.getFileSystem());
    }
    
    public List<String> getValuesProcPid() {
        return printProcPid(os, hal.getMemory());
    }
    
    public List<String> getValuesProcCpu() {
        return printProcCpu(os,hal.getMemory());
    }
    
    public List<String> getValuesProcMem() {
        return printProcMem(os,hal.getMemory());
    }
    
    public List<String> getValuesProcName() {
        return printProcName(os,hal.getMemory());
    }
    
    private static Integer printProcessor(CentralProcessor processor) {
        long[] prevTicks = processor.getSystemCpuLoadTicks();
        System.out.println(Arrays.toString(prevTicks));
        Double cpuLoad =  processor.getSystemCpuLoadBetweenTicks(prevTicks) * 100;
        System.out.println(String.format("%.2f", cpuLoad));
        Integer cpuLoadPercentage = cpuLoad.intValue();
        
        return cpuLoadPercentage;      
    }    
    
    private static Integer printMemory(GlobalMemory memory) {
        long available =  memory.getAvailable();
        long total = memory.getTotal();
        
        Double memoryUsage = 100.0 - (100d * available / total);
        
        Integer memoryUsagePercentage = memoryUsage.intValue();
        
        return memoryUsagePercentage;
    }
    
    private static Integer printFileSystem(FileSystem fileSystem) {
        List<OSFileStore> fileStore = fileSystem.getFileStores();
        
        long usable = fileStore.get(0).getUsableSpace();
        long total = fileStore.get(0).getTotalSpace();
        
        Double diskUsagePercentage = 100d * usable / total;
       
        Integer diskUsage = diskUsagePercentage.intValue();
        
        return diskUsage;
    }
    
    private static List<String> printProcPid(OperatingSystem os, GlobalMemory memory){
        List<String> valuesPid = new ArrayList<>();
        
        List<OSProcess> procs = os.getProcesses(5, OperatingSystem.ProcessSort.CPU);
        
        for (int i = 0; i < procs.size(); i++) {
            OSProcess p = procs.get(i);
            valuesPid.add(String.format("%5d \n",p.getProcessID()));
        }
        
        return valuesPid;
    }
    
    private static List<String> printProcCpu(OperatingSystem os, GlobalMemory memory){
        List<String> valuesCpu = new ArrayList<>();
        
        List<OSProcess> procs = os.getProcesses(5, OperatingSystem.ProcessSort.CPU);
        
        for (int i = 0; i < procs.size(); i++) {
            OSProcess p = procs.get(i);
            valuesCpu.add(String.format("%.0f \n", 100d * (p.getKernelTime() + p.getUserTime()) / p.getUpTime()));
        }
        
        return valuesCpu;
    }
    
    private static List<String> printProcMem(OperatingSystem os, GlobalMemory memory){
        List<String> valuesMem = new ArrayList<>();
        
        List<OSProcess> procs = os.getProcesses(5, OperatingSystem.ProcessSort.CPU);
        
        for (int i = 0; i < procs.size(); i++) {
            OSProcess p = procs.get(i);
            valuesMem.add(String.format("%.0f \n", 100d * p.getResidentSetSize() / memory.getTotal()));
        }
        
        return valuesMem;
    }
    
    private static List<String> printProcName(OperatingSystem os, GlobalMemory memory){
        List<String> valuesName = new ArrayList<>();
        
        List<OSProcess> procs = os.getProcesses(5, OperatingSystem.ProcessSort.CPU);
        
        for (int i = 0; i < procs.size(); i++) {
            OSProcess p = procs.get(i);
            valuesName.add(String.format("%s \n", p.getName()));
        }
        
        return valuesName;
    }
}
