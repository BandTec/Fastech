package fastech.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
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

    public Integer getPing() throws IOException, IOException {
//        Process p = Runtime.getRuntime().exec("curl https://api.hackertarget.com/nping/?q=8.8.8.8");
//        BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
//
//        String lineOut;
//        String resultCmd = "";
//        while ((lineOut = input.readLine()) != null) {
//            resultCmd += lineOut;
//        }
//        
//        
//        String[] avgCmdArray = resultCmd.split("Avg rtt:");
//        String[] pingCmdArray = avgCmdArray[1].split("ms");
//        Double pingDouble = Double.valueOf(pingCmdArray[0].trim());

        Integer ranPing = ThreadLocalRandom.current().nextInt(50, 75);

        return ranPing;
    }

    public String dateNow() {
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDate = myDateObj.format(myFormatObj);
        return formattedDate;
    }
    
    // Ajustar o formato da hora by Carroça Gabriel
    
//    public PrintWriter gerarLogs() throws IOException {;
//        LocalDate localDate = LocalDate.now();
//        Integer ano = localDate.getYear();
//        Integer mes = localDate.getMonthValue();
//        Integer dia = localDate.getDayOfMonth();
//        String data = ano + "-" + mes + "-" + dia;
//        FileWriter  arq = new FileWriter("d:\\log " + data + ".txt",true);
//
//        SystemInfo si = new SystemInfo();
//        OperatingSystem os = si.getOperatingSystem();
//
//        PrintWriter gravarArq = new PrintWriter(arq);
//
//        //testes:
//        gravarArq.printf("\nLog session: ");
//        gravarArq.printf("\nVersão da aplicação: v1.0");
//        gravarArq.printf("\nSistema Operacional: " + os);
//        System.out.println("gerando log....");
//
//        gravarArq.printf("\nretornando informações do SO\n");
//        gravarArq.append("oi");
//        arq.close();
//        return gravarArq;

}
