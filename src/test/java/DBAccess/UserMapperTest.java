//
//package DBAccess;
//
//import FunctionLayer.FogException;
//import FunctionLayer.OrderBuilderException;
//import FunctionLayer.User;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.sql.Statement;
//import org.junit.Test;
//import static org.junit.Assert.*;
//import org.junit.Before;
//
//public class UserMapperTest
//{
////    Test date in the UsersTest table
////    INSERT INTO `UsersTest` VALUES 
////    (1,'jens@somewhere.com','jensen','customer'),
////    (2,'ken@somewhere.com','kensen','customer'),
////    (3,'robin@somewhere.com','batman','employee'),
////    (4,'someone@nowhere.com','sesam','customer');
//
//    private static Connection testConnection;
//    private static String USERNAME = "doorkeeper";
//    private static String USERPW = "bank3*andyouarein";
//    private static String DBNAME = "useradmin";
//    private static String HOST = "localhost";
//
//    @Before
//    public void setUp()
//    {
//        try
//        {
//            // awoid making a new connection for each test
//            if (testConnection == null)
//            {
//                String url = String.format("jdbc:mysql://%s:3306/%s?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", HOST, DBNAME);
//                Class.forName("com.mysql.jdbc.Driver");
//
//                testConnection = DriverManager.getConnection(url, USERNAME, USERPW);
//                // Make mappers use test 
//                Connector.setConnection(testConnection);
//            }
//            // reset test database
//            try (Statement stmt = testConnection.createStatement())
//            {
//                stmt.execute("drop table if exists usersTest");
//                stmt.execute("create table usersTest like users");
//                stmt.execute("insert into usersTest select * from users");
//            }
//
//        } catch (ClassNotFoundException | SQLException ex)
//        {
//            testConnection = null;
//            System.out.println("Could not open connection to database: " + ex.getMessage());
//        }
//    }
//
//    @Test
//    public void testSetUpOK()
//    {
//        // Just check that we have a connection.
//        assertNotNull(testConnection);
//    }
//
//    @Test
//    public void testLogin() throws FogException
//    {
//        // Can we log in
//        User user = UserMapper.login("jens@somewhere.com", "jensen");
//        assertTrue(user != null);
//    }
//
//    @Test(expected = FogException.class)
//    public void testLogin02() throws FogException
//    {
//        // We should get an exception if we use the wrong password
//        User user = UserMapper.login("jens@somewhere.com", "larsen");
//    }
//
//    @Test
//    public void testLogin03() throws FogException
//    {
//        // Jens is supposed to be a customer
//        User user = UserMapper.login("jens@somewhere.com", "jensen");
//        assertEquals("customer", user.getRole());
//    }
//
//    @Test
//    public void testCreateUser() throws FogException
//    {
//        // Can we create a new user - Notice, if login fails, this will fail
//        // but so would login01, so this is OK
//        // will fail if king@kong.com exists
//        User original = new User("king@kong.com", "uhahvorhemmeligt", "konge");
//        UserMapper.createUser(original);
//        User retrieved = UserMapper.login("king@kong.com", "uhahvorhemmeligt");
//        assertEquals("konge", retrieved.getRole());
//    }
//}
