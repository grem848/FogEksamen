package DBAccess;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class DataSource
{

    private MysqlDataSource dataSource = new MysqlDataSource();

    public DataSource()
    {
        dataSource.setServerName("159.89.109.181");
        dataSource.setPort(3306);
        dataSource.setDatabaseName("fogdb");
        dataSource.setUser("doorkeeper");
        dataSource.setPassword("bank3*andyouarein");
    }

    public MysqlDataSource getDataSource()
    {
        return dataSource;
    }
}
