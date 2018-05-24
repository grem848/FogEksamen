package DBAccess;

import FunctionLayer.FogException;
import FunctionLayer.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;


public class UserMapperTest
{

    private static Connection testConnection;
    private static String USERNAME = "doorkeeper";
    private static String USERPW = "bank3*andyouarein";
    private static String DBNAME = "fogdbtest";
    private static String HOST = "159.89.109.181";

    /**
     * Sets up connection to test db and copies the db to the test db.
     */
    @Before
    public void setUp()
    {
        try
        {
            // awoid making a new connection for each test
            if (testConnection == null)
            {
                String url = String.format("jdbc:mysql://%s:3306/%s?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", HOST, DBNAME);
                Class.forName("com.mysql.jdbc.Driver");

                testConnection = DriverManager.getConnection(url, USERNAME, USERPW);
                // Make mappers use test 
                Connector.setConnection(testConnection);
            }
            // reset test database
            try (Statement stmt = testConnection.createStatement())
            {
                stmt.execute("drop table if exists users");

                stmt.execute("create table users like fogdb.users");
                stmt.execute("insert into users select * from fogdb.users");
            }

        } catch (ClassNotFoundException | SQLException ex)
        {
            testConnection = null;
            System.out.println("Could not open connection to database: " + ex.getMessage());
        }
    }

    /**
     * Check if connection is not null.
     */
    @Test
    public void testSetUpOK()
    {
        // Just check that we have a connection.
        assertNotNull(testConnection);
    }

    /**
     * Tests of login works.
     * @throws FogException
     */
    @Test
    public void testLogin01() throws FogException
    {
        // Can we log in
        User user = UserMapper.login("jens@somewhere.com", "jensen");
        assertTrue(user != null);
    }

    /**
     * Tests if wrong password throws the expected exception.
     * @throws FogException
     */
    @Test
    public void testLogin02() throws FogException
    {
        // We should get an exception if we use the wrong password
        try
        {
            User user = UserMapper.login("jens@somewhere.com", "larsen");
            fail("Expected a FogException to be thrown");
        } catch (FogException fogException)
        {
            assertThat(fogException.getMessage(), is("Could not validate user"));
        }
    }

    /**
     * Tests if user role is correct for an employee.
     * @throws FogException
     */
    @Test
    public void testLogin03() throws FogException
    {
        // Jens is supposed to be an employee
        User user = UserMapper.login("jens@somewhere.com", "jensen");
        assertEquals("employee", user.getRole());
    }

    /**
     * Tests if a new user can be created, and if the user can login.
     * @throws FogException
     */
    @Test
    public void testCreateUser01() throws FogException
    {
        // Can we create a new user - Notice, if login fails, this will fail
        // but so would login01, so this is OK
        User original = new User("king@kong.com", "uhahvorhemmeligt", "konge");
        UserMapper.createUser(original);
        User retrieved = UserMapper.login("king@kong.com", "uhahvorhemmeligt");
        assertEquals("konge", retrieved.getRole());
    }

}
