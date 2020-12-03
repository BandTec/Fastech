package fastech.services;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import oshi.SystemInfo;
import oshi.hardware.CentralProcessor.TickType;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.software.os.OSFileStore;
import oshi.software.os.OSProcess;
import oshi.software.os.OperatingSystem;

/**
 *
 * @author Jorge
 */
public class TakingDataServices {

    SystemInfo si = new SystemInfo();
    HardwareAbstractionLayer hal = si.getHardware();
    OperatingSystem os = si.getOperatingSystem();
    long[] prevTicks = new long[TickType.values().length];

    public String getNameProcessor() {
        String array = hal.getProcessor().toString();
        String[] textArray = array.split("\n");
        return textArray[0];
    }

    public Integer getCpuUsage() {

        Double cpuLoad = hal.getProcessor().getSystemCpuLoadBetweenTicks(prevTicks) * 100;
        prevTicks = hal.getProcessor().getSystemCpuLoadTicks();

        Integer cpuLoadPercentage = cpuLoad.intValue();

        return cpuLoadPercentage;
    }

    public Integer getMemory() {
        
        long available = hal.getMemory().getAvailable();
        long total = hal.getMemory().getTotal();

        Double memoryUsage = 100d - (100d * available / total);

        Integer memoryUsagePercentage = memoryUsage.intValue();

        return memoryUsagePercentage;
    }

    public Integer getAvailableDiskSpace() {
        
        List<OSFileStore> fileStore = os.getFileSystem().getFileStores();

        long available = fileStore.get(0).getFreeSpace();
        long total = fileStore.get(0).getTotalSpace();

        Double diskUsagePercentage = 100d - (100d * available / total);

        Integer diskUsage = diskUsagePercentage.intValue();

        return diskUsage;
    }

    public List<String> getPidProc() {
        List<String> valuesPid = new ArrayList<>();

        List<OSProcess> procs = os.getProcesses(5, OperatingSystem.ProcessSort.CPU);

        for (int i = 0; i < procs.size(); i++) {
            OSProcess p = procs.get(i);
            valuesPid.add(String.format("%5d \n", p.getProcessID()));
        }

        return valuesPid;
    }

    public List<String> getCpuProc() {
        List<String> valuesCpu = new ArrayList<>();

        List<OSProcess> procs = os.getProcesses(5, OperatingSystem.ProcessSort.CPU);

        for (int i = 0; i < procs.size(); i++) {
            OSProcess p = procs.get(i);
            valuesCpu.add(String.format("%.0f \n", 100d * (p.getKernelTime() + p.getUserTime()) / p.getUpTime()));
        }

        return valuesCpu;
    }

    public List<String> getMemProc() {
        List<String> valuesMem = new ArrayList<>();

        List<OSProcess> procs = os.getProcesses(5, OperatingSystem.ProcessSort.CPU);

        for (int i = 0; i < procs.size(); i++) {
            OSProcess p = procs.get(i);
            valuesMem.add(String.format("%.0f \n", 100d * p.getResidentSetSize() / hal.getMemory().getTotal()));
        }

        return valuesMem;
    }

    public List<String> getNameProc() {
        List<String> valuesName = new ArrayList<>();

        List<OSProcess> procs = os.getProcesses(5, OperatingSystem.ProcessSort.CPU);

        for (int i = 0; i < procs.size(); i++) {
            OSProcess p = procs.get(i);
            valuesName.add(String.format("%s \n", p.getName()));
        }

        return valuesName;
    }

    public String dateNow() {
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDate = myDateObj.format(myFormatObj);
        return formattedDate;
    }

}
