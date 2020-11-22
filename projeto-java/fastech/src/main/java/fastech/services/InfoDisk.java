package fastech.services;

import static fastech.controller.fastechTakingData.oshi;
import java.util.List;
import oshi.SystemInfo;
import oshi.hardware.HWDiskStore;
import oshi.hardware.HWPartition;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.software.os.OperatingSystem;

/**
 *
 * @author Jorge
 */
public class InfoDisk {

    SystemInfo si = new SystemInfo();
    OperatingSystem os = si.getOperatingSystem();
    HardwareAbstractionLayer hal = si.getHardware();

    public static void printDisks(List<HWDiskStore> list) {
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
