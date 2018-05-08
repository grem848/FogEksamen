package DBAccess;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class DataSource
{

    private MysqlDataSource dataSource = new MysqlDataSource();
    private MysqlDataSource testDataSource = new MysqlDataSource();

    public DataSource()
    {
        dataSource.setServerName("159.89.109.181");
        dataSource.setPort(3306);
        dataSource.setDatabaseName("fogdb");
        dataSource.setUser("doorkeeper");
        dataSource.setPassword("bank3*andyouarein");
        
        // datasource for test
        testDataSource.setServerName("159.89.109.181");
        testDataSource.setPort(3306);
        testDataSource.setDatabaseName("fogdb");
        testDataSource.setUser("doorkeeper");
        testDataSource.setPassword("bank3*andyouarein");
    }

    public MysqlDataSource getDataSource()
    {
        return dataSource;
    }

    public MysqlDataSource getTestDataSource()
    {
        return testDataSource;
    }
}
