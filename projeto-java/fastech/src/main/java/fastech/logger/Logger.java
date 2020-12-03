package fastech.logger;

import fastech.services.TakingDataServices;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author mmaia
 */
public class Logger {

    TakingDataServices dataServices = new TakingDataServices();
    private File file;

    public Logger() {
        file = new File("log.log");
    }

    public void loggingIn(String user) throws IOException {
        FileWriter insert = new FileWriter(file, true);
        insert.write("          STARTING REGISTRATION SESSION");
        insert.write("\n-----------------------------------------------");
        insert.write("\n-----------------------------------------------");
        insert.write(String.format("\nMachine processor: %s", dataServices.getNameProcessor()));
        insert.write(String.format("\nActive user: %s", user));
        insert.write(String.format("\nSession date: %s", dataServices.dateNow()));
        insert.write("\n-----------------------------------------------");

        insert.close();
    }

    public void registerLog(String type, String error) throws IOException {
        FileWriter insert = new FileWriter(file, true);
        insert.write(String.format("\n %s - %s - %s", dataServices.dateNow(), type, error));
        insert.close();
    }

}
