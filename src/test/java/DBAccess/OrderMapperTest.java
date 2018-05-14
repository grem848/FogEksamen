///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package DBAccess;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.sql.Statement;
//import org.junit.Test;
//import static org.junit.Assert.*;
//import org.junit.Before;
//
///**
// *
// * @author Andreas Heick Laptop
// */
//public class OrderMapperTest
//{
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
////                stmt.execute("drop table if exists usersTest");
////                stmt.execute("create table usersTest like users");
////                stmt.execute("insert into usersTest select * from users");
//            }
//
//        } catch (ClassNotFoundException | SQLException ex)
//        {
//            testConnection = null;
//            System.out.println("Could not open connection to database: " + ex.getMessage());
//        }
//    }
//    @Test
//    public void testOrderToDB() throws Exception
//    {
//    }
//
//    /**
//     * Test of getAllOrdersWhereStatusIsRequest method, of class OrderMapper.
//     */
//    @Test
//    public void testGetAllOrdersWhereStatusIsRequest() throws Exception
//    {
//    }
//
//    /**
//     * Test of setStatusOrder method, of class OrderMapper.
//     */
//    @Test
//    public void testSetStatusOrder() throws Exception
//    {
//    }
//
//    /**
//     * Test of setStatusDone method, of class OrderMapper.
//     */
//    @Test
//    public void testSetStatusDone() throws Exception
//    {
//    }
//
//    /**
//     * Test of getAllOrdersWhereStatusIsOrder method, of class OrderMapper.
//     */
//    @Test
//    public void testGetAllOrdersWhereStatusIsOrder() throws Exception
//    {
//    }
//
//    /**
//     * Test of getOrder method, of class OrderMapper.
//     */
//    @Test
//    public void testGetOrder() throws Exception
//    {
//    }
//
//    /**
//     * Test of editOrder method, of class OrderMapper.
//     */
//    @Test
//    public void testEditOrder() throws Exception
//    {
//    }
//
//    /**
//     * Test of getAllProducts method, of class OrderMapper.
//     */
//    @Test
//    public void testGetAllProducts() throws Exception
//    {
//    }
//    
//}
