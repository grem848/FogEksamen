//package DBAccess;
//
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//import java.sql.Statement;
//import static javafx.css.StyleOrigin.USER;
//import static javax.ws.rs.core.HttpHeaders.HOST;
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
//    private static DBConnector testConnection;
//    private static String USERNAME = "doorkeeper";
//    private static String USERPW = "bank3*andyouarein";
//    private static String DBNAME = "useradmin";
//    private static String HOST = "localhost";
//    
//
//    @Before
//    public void setUp()
//    {
//        try
//        {
//            // awoid making a new connection for each test
//            if (testConnection == null)
//            {
//                String url = String.format("jdbc:mysql://%s:3306/%suseradmin?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", HOST, DBNAME);
//                Class.forName("com.mysql.jdbc.Driver");
//
//                testConnection = DriverManager.getConnection(url, USERNAME, USERPW);
//                // Make mappers use test 
//                Connector.setConnection(testConnection);
//            }
//            // reset test database
//            try (Statement stmt = testConnection.preparedStatement(HOST))
//            {
//                stmt.execute("drop table if exists Users");
//                stmt.execute("create table Users like UsersTest");
//                stmt.execute("insert into Users select * from UsersTest");
//            }
//
//        } catch (ClassNotFoundException | SQLException ex)
//        {
//            testConnection = null;
//            System.out.println("Could not open connection to database: " + ex.getMessage());
//        }
//            
//        
////        
////        testConnection.setDataSource(new DataSource().getTestDataSource());
////            testConnection.open();
////            // awoid making a new connection for each test
////
////            // reset test database
////            String SQL = "drop table if exists Users";
////            String SQL2 = "create table Users like UsersTest";
////            String SQL3 = "insert into Users select * from UsersTest";
////            
////            PreparedStatement ps = testConnection.preparedStatement(SQL);       
////            PreparedStatement ps2 = testConnection.preparedStatement(SQL2); 
////            PreparedStatement ps3 = testConnection.preparedStatement(SQL3);
////            
////            ps.executeUpdate();
////            ps2.executeUpdate();
////            ps3.executeUpdate();
////
////        } catch (SQLException ex)
////        {
////            System.out.println("Could not open connection to database: " + ex.getMessage());
////        }
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
//    public void testCreateUser() throws FogException, SQLException
//    {
//        // Can we create a new user - Notice, if login fails, this will fail
//        // but so would login01, so this is OK
//        // will fail if king@kong.com exists
//        User original = new User("king@kong.com", "uhahvorhemmeligt", "konge");
//        UserMapper.createUser(original);
//        User retrieved = UserMapper.login("king@kong.com", "uhahvorhemmeligt");
//        assertEquals("konge", retrieved.getRole());
//        testConnection.close();
//    }
//}
