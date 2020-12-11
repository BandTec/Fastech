package fastech.services;

import org.apache.commons.dbcp2.BasicDataSource;

/**
 *
 * @author Jorge
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
