//package DBAccess;
//
//import FunctionLayer.FogException;
//import FunctionLayer.Order;
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
//
//    private static Connection testConnection;
//    private static String USERNAME = "doorkeeper";
//    private static String USERPW = "bank3*andyouarein";
//    private static String DBNAME = "fogdbtest";
//    private static String HOST = "159.89.109.181";
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
//                stmt.execute("drop table if exists users");
//                stmt.execute("drop table if exists orders");
//                stmt.execute("drop table if exists products");
//
//                stmt.execute("create table users like fogdb.users");
//                stmt.execute("insert into users select * from fogdb.users");
//
//                stmt.execute("create table orders like fogdb.orders");
//                stmt.execute("insert into orders select * from fogdb.orders");
//
//                stmt.execute("create table products like fogdb.products");
//                stmt.execute("insert into products select * from fogdb.products");
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
//    public void testLogin01() throws FogException
//    {
//        // Can we log in
//        User user = UserMapper.login("jens@somewhere.com", "jensen");
//        assertTrue(user != null);
//    }
//
//    @Test
//    public void testLogin02() throws FogException
//    {
//        // We should get an exception if we use the wrong password
////        User user = UserMapper.login("jens@somewhere.com", "larsen");
////        assertEquals("customer", user.getRole());
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
//    public void testCreateUser01() throws FogException
//    {
//        // Can we create a new user - Notice, if login fails, this will fail
//        // but so would login01, so this is OK
//        User original = new User("king@kong.com", "uhahvorhemmeligt", "konge");
//        UserMapper.createUser(original);
//        User retrieved = UserMapper.login("king@kong.com", "uhahvorhemmeligt");
//        assertEquals("konge", retrieved.getRole());
//    }
//
//    @Test
//    public void testOrder() throws OrderBuilderException, SQLException
//    {
//
////        Order original = new Order(1234, "hej@email", 1, 2, 3, 4, 5, 6);
////        OrderMapper.OrderToDB(original);
////        Order get = (Order) OrderMapper.getAllOrdersWhereStatusIsOrder();
////        assertNotNull(get);
//    }
//}
