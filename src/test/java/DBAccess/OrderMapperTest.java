package DBAccess;

import FunctionLayer.LogicFacade;
import FunctionLayer.Order;
import FunctionLayer.OrderBuilderException;
import FunctionLayer.Product;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class OrderMapperTest
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
                /* 
                Use these commands to delete and create the testdb
                 */
//                stmt.execute("drop table if exists orders");
//
//                stmt.execute("create table orders like fogdb.orders");
//                stmt.execute("insert into orders select * from fogdb.orders");

                /* 
                Use these commands to clone fogdb values into testdb - standard option
                 */
                stmt.execute("SELECT * FROM fogdb.orders\n"
                        + "UNION\n"
                        + "SELECT * FROM orders");

                stmt.execute("SELECT * FROM fogdb.bracketsScrews\n"
                        + "UNION\n"
                        + "SELECT * FROM bracketsScrews");

                stmt.execute("SELECT * FROM fogdb.woodEaves\n"
                        + "UNION\n"
                        + "SELECT * FROM woodEaves");
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
     * Test of requestToDB method, of class OrderMapper
     *
     * @throws OrderBuilderException
     * @throws java.sql.SQLException
     */
    @Test
    public void testRequestToDB() throws OrderBuilderException, SQLException
    {

        Order order = new Order(1234, "test@test.test", 240, 210, 240, 300, 330, 1);
        OrderMapper.RequestToDB(order);
        List<Order> orders = LogicFacade.getRequestList();
        Order order2 = orders.get(orders.size() - 1);

        assertEquals(new Order(order2.getId(), 1234, "test@test.test", 240, 210, 240, 300, 330, 1, 0, "request").toString(), order2.toString());

    }

    /**
     * Test of getAllOrdersWhereStatusIsRequest method, of class OrderMapper
     * <p>
     * Fails if testRequestToDB fails and db has no requests.
     *
     * @throws OrderBuilderException
     * @throws java.sql.SQLException
     */
    @Test
    public void testGetAllOrdersWhereStatusIsRequest() throws OrderBuilderException, SQLException
    {
        List<Order> requests = LogicFacade.getRequestList();
        if (!requests.isEmpty())
        {
            requests.get(0).getStatus();
            requests.get((requests.size() - 1)).getStatus();
        } else
        {
            System.out.println("\n"
                    + "Request list is empty!\n"
                    + "Request list is empty!\n"
                    + "Request list is empty!\n"
                    + "Request list is empty!\n");
        }
        assertEquals("request", requests.get(0).getStatus());
    }

    /**
     * Test of setStatusOrder method, of class OrderMapper
     *
     * @throws OrderBuilderException
     * @throws java.sql.SQLException
     */
    @Test
    public void testSetStatusOrder() throws OrderBuilderException, SQLException
    {
        // new request to db
        Order order = new Order(1234, "test@statusorder.statusorder", 240, 210, 240, 300, 330, 1);
        OrderMapper.RequestToDB(order);
        // gets request list and sets status of new request to order
        List<Order> requests = LogicFacade.getRequestList();
        OrderMapper.setStatusOrder(requests.get((requests.size() - 1)).getId());
        // gets order list and checks if last order has email of the request we test
        List<Order> orders = LogicFacade.getStatusOrderList();
        assertEquals("test@statusorder.statusorder", orders.get(orders.size() - 1).getEmail());

    }

    /**
     * Test of setStatusFinished method, of class OrderMapper
     *
     * @throws OrderBuilderException
     * @throws java.sql.SQLException
     */
    @Test
    public void testSetStatusFinished() throws OrderBuilderException, SQLException
    {
        // new request to db
        Order order = new Order(1234, "test@statusfinished.statusfinished", 240, 210, 240, 300, 330, 1);
        OrderMapper.RequestToDB(order);
        // gets request list and sets status of new request to finished
        List<Order> requests = LogicFacade.getRequestList();
        OrderMapper.setStatusFinished(requests.get((requests.size() - 1)).getId());
        // gets order list and checks if last order has email of the request we test
        List<Order> orders = LogicFacade.getStatusFinishedList();
        assertEquals("test@statusfinished.statusfinished", orders.get(orders.size() - 1).getEmail());
    }

    /**
     * Test of getAllOrdersWhereStatusIsOrder method, of class OrderMapper
     *
     * @throws OrderBuilderException
     * @throws java.sql.SQLException
     */
    @Test
    public void testGetAllOrdersWhereStatusIsOrder() throws OrderBuilderException, SQLException
    {
        List<Order> orders = LogicFacade.getStatusOrderList();
        if (!orders.isEmpty())
        {
            orders.get(0).getStatus();
            orders.get((orders.size() - 1)).getStatus();
        } else
        {
            System.out.println("\n"
                    + "Order list is empty!\n"
                    + "Order list is empty!\n"
                    + "Order list is empty!\n"
                    + "Order list is empty!\n");
        }
        assertEquals("order", orders.get(0).getStatus());
    }

    /**
     * Test of getOrder method, of class OrderMapper
     *
     * @throws OrderBuilderException
     */
    @Test
    public void testGetOrder() throws OrderBuilderException
    {
        String email = LogicFacade.getOneOrder(26).getEmail();
        assertEquals("something@something.dk", email);
    }

    /**
     * Test of editOrder method, of class OrderMapper
     *
     * @throws OrderBuilderException
     * @throws java.sql.SQLException
     */
    @Test
    public void testEditOrder() throws OrderBuilderException, SQLException
    {
        // new request to db
        Order order = new Order(1234, "test@editorder.editorder", 240, 210, 240, 300, 330, 1);
        OrderMapper.RequestToDB(order);
        // gets request list and sets status of new request to order
        List<Order> requests = LogicFacade.getRequestList();
        OrderMapper.setStatusOrder(requests.get((requests.size() - 1)).getId());
        // gets order list and checks if last order has email of the request we test
        List<Order> orders = LogicFacade.getStatusOrderList();

        int id = orders.get((orders.size() - 1)).getId();
        int tlf = 999;
        String email = orders.get((orders.size() - 1)).getEmail();
        int length = 999;
        int height = 999;
        int width = 999;
        int shedLength = 999;
        int shedWidth = 999;
        int slopedRoof = 999;
        int price = 999;

        LogicFacade.editOrder(id, tlf, email, height, length, width, shedLength, shedWidth, slopedRoof, price);

        List<Order> orders2 = LogicFacade.getStatusOrderList();

        Order order2 = orders2.get(orders2.size() - 1);

        assertEquals(new Order(id, tlf, email, length, height, width, shedLength, shedWidth, slopedRoof, price, "order").toString(), order2.toString());

    }

    /**
     * Test of getAllBracketsScrews method, of class OrderMapper
     *
     * @throws OrderBuilderException
     */
    @Test
    public void testGetAllBracketsScrews() throws OrderBuilderException
    {
        
    }

    /**
     * Test of getAllGetAllWoodEaves method, of class OrderMapper
     *
     * @throws OrderBuilderException
     */
    @Test
    public void testGetAllWoodEaves() throws OrderBuilderException
    {
        List<Product> l = OrderMapper.getAllWoodEaves();
        
        assertEquals("100x100mm wood for walls", l.get(0).getName());
        assertEquals(100, l.get(0).getPrice());
        assertNotEquals("45x195 mm. spærtræ ubh.", l.get(0).getName());
        assertEquals(100, l.get(3).getPrice());
    }

    /**
     * Test of getAllOrdersWhereStatusIsFinished method, of class OrderMapper.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testGetAllOrdersWhereStatusIsFinished() throws Exception
    {
        List<Order> finishedOrders = LogicFacade.getStatusFinishedList();
        if (!finishedOrders.isEmpty())
        {
            finishedOrders.get(0).getStatus();
            finishedOrders.get((finishedOrders.size() - 1)).getStatus();
        } else
        {
            System.out.println("\n"
                    + "Finished list is empty!\n"
                    + "Finished list is empty!\n"
                    + "Finished list is empty!\n"
                    + "Finished list is empty!\n");
        }
        assertEquals("finished", finishedOrders.get(0).getStatus());
        assertEquals("finished", finishedOrders.get((finishedOrders.size() - 1)).getStatus());

    }

}
