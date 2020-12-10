package fastech.services;

import org.apache.commons.dbcp2.BasicDataSource;

/**
 *
 * @author Jorge
 */
public class ConnectionAwsDataBase {

    private BasicDataSource datasourceAws;

    public ConnectionAwsDataBase() {

        this.datasourceAws = new BasicDataSource();

        this.datasourceAws.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

        this.datasourceAws.setUrl("jdbc:sqlserver://fastechaws.ddns.net:1433;database=fastech;");

        this.datasourceAws.setUsername("SA");

        this.datasourceAws.setPassword("Fast_2810");
    }

    public BasicDataSource getDatasourceAws() {
        return datasourceAws;
    }

}
