/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fastech.database;

/**
 *
 * @author Cliente
 */
public class Database {

    private String host = "localhost";
    private Integer port = 1433;
    private String database = "master";
    private String user = "SA";
    private String password = "yourStrong(!)Password";
    private String connectionString;

    public String ConnectionDatabase() {
        connectionString = "jdbc:sqlserver://" + host + ":" + port + ";databaseName=" + database + ";user=" + user + ";password=" + password;
        return connectionString;
    }
}
