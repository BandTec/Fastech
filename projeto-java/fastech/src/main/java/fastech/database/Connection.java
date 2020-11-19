/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fastech.database;

import org.apache.commons.dbcp2.BasicDataSource;

/**
 *
 * @author Cliente
 */
public class Connection {
    
     private BasicDataSource datasource;

    public Connection(){
        this.datasource = new BasicDataSource();

        this.datasource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

        this.datasource.setUrl("jdbc:sqlserver://fastech.database.windows.net:1433;database=fastech;");

        this.datasource.setUsername("fastech_prod");

        this.datasource.setPassword("Fast_2810");
    }

    public BasicDataSource getDatasource() {
        return datasource;
    }
}
