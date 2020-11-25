package fastech.services;

import static fastech.controller.fastechTakingData.oshi;
import java.util.List;
import oshi.SystemInfo;
import oshi.hardware.GlobalMemory;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.software.os.OSProcess;
import oshi.software.os.OperatingSystem;
import oshi.util.FormatUtil;

/**
 *
 * @author Jorge
 */
public class InfoListProcessors {
    
    SystemInfo si = new SystemInfo();
    OperatingSystem os = si.getOperatingSystem();
    HardwareAbstractionLayer hal = si.getHardware();
    
    public static void printProcesses(OperatingSystem os, GlobalMemory memory) {
        OSProcess myProc = os.getProcess(os.getProcessId());
        oshi.add(
                "My PID: " + myProc.getProcessID() + " with affinity " + Long.toBinaryString(myProc.getAffinityMask()));
        oshi.add("Processes: " + os.getProcessCount() + ", Threads: " + os.getThreadCount());
        // Sort by highest CPU
        List<OSProcess> procs = os.getProcesses(20, OperatingSystem.ProcessSort.CPU);
        oshi.add("   PID  %CPU %MEM       VSZ       RSS Name");
        for (int i = 0; i < procs.size() && i < 15; i++) {
            OSProcess p = procs.get(i);
            oshi.add(String.format(" %5d %5.1f %4.1f %9s %9s %s", p.getProcessID(),
                    100d * (p.getKernelTime() + p.getUserTime()) / p.getUpTime(),
                    100d * p.getResidentSetSize() / memory.getTotal(), FormatUtil.formatBytes(p.getVirtualSize()),
                    FormatUtil.formatBytes(p.getResidentSetSize()), p.getName()));
        }
    }
}
