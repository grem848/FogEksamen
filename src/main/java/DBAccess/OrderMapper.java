package DBAccess;

import FunctionLayer.Order;
import FunctionLayer.OrderBuilderException;
import FunctionLayer.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderMapper
{

    /**
     * Takes an Order object and retrieves the attributes for a SQL
     * preparedstatement that inserts the Order attributes into to the order DB.
     * <p>
     * Used to create orders
     *
     * @param order
     * @return
     * @throws OrderBuilderException
     * @throws SQLException
     */
    public static boolean RequestToDB(Order order) throws OrderBuilderException, SQLException
    {
        try
        {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO orders (tlf, email, length, width, height, shedLength, shedWidth, slopedRoof) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, order.getTlf());
            ps.setString(2, order.getEmail());
            ps.setInt(3, order.getLength());
            ps.setInt(4, order.getWidth());
            ps.setInt(5, order.getHeight());
            ps.setInt(6, order.getShedLength());
            ps.setInt(7, order.getShedWidth());
            ps.setInt(8, order.getSlopedRoof());
            ps.executeUpdate();

        } catch (SQLException | ClassNotFoundException ex)
        {
            throw new OrderBuilderException(ex.getMessage());
        }
        return false;
    }

    /**
     * Uses a SQL preparedstatement to get all Orders from the DB with status as
     * 'request', and adds them to a List of Orders.
     * <p>
     * Used to get a list of requests from customers.
     *
     * @return
     * @throws OrderBuilderException
     */
    public static List<Order> getAllOrdersWhereStatusIsRequest() throws OrderBuilderException
    {
        List<Order> requestList;
        try
        {
            Connection connection = Connector.connection();
            String SQL = "SELECT * FROM orders WHERE status='request'";
            PreparedStatement statement = connection.prepareStatement(SQL);

            ResultSet rs = statement.executeQuery();

            requestList = new ArrayList<>();

            while (rs.next())
            {
                int id = rs.getInt("id");
                int tlf = rs.getInt("tlf");
                String email = rs.getString("email");
                int height = rs.getInt("height");
                int length = rs.getInt("length");
                int width = rs.getInt("width");
                int shedLength = rs.getInt("shedLength");
                int shedWidth = rs.getInt("shedWidth");
                int slopedRoof = rs.getInt("slopedRoof");
                int price = rs.getInt("price");
                String status = rs.getString("status");
                requestList.add(new Order(id, tlf, email, length, height, width, shedLength, shedWidth, slopedRoof, price, status));
            }
            return requestList;
        } catch (SQLException | ClassNotFoundException ex)
        {
            throw new OrderBuilderException(ex.getMessage());
        }
    }

    /**
     * Uses a SQL preparedstatement to set the status of an Order with the id
     * from the parameter, to 'order'.
     * <p>
     * Used to set the status of an Order to 'order'.
     *
     * @param id
     * @throws OrderBuilderException
     */
    public static void setStatusOrder(int id) throws OrderBuilderException
    {
        try
        {
            Connection con = Connector.connection();
            String SQL = "UPDATE orders SET status='order' WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (ClassNotFoundException | SQLException ex)
        {
            throw new OrderBuilderException(ex.getMessage());
        }
    }

    /**
     * Uses a SQL preparedstatement to set the status of an Order with the id
     * from the parameter, to 'finished'.
     * <p>
     * Used to set the status of an Order to 'finished'.
     *
     * @param id
     * @throws OrderBuilderException
     */
    public static void setStatusFinished(int id) throws OrderBuilderException
    {
        try
        {
            Connection con = Connector.connection();
            String SQL = "UPDATE orders SET status='finished' WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (ClassNotFoundException | SQLException ex)
        {
            throw new OrderBuilderException(ex.getMessage());
        }
    }

    /**
     * Uses a SQL preparedstatement to get all Orders from the DB with status as
     * 'order', and adds them to a List.
     * <p>
     * Used to get a list of Orders from customers.
     *
     * @return
     * @throws OrderBuilderException
     */
    public static List<Order> getAllOrdersWhereStatusIsOrder() throws OrderBuilderException
    {
        List<Order> statusOrderList;
        try
        {
            Connection connection = Connector.connection();
            String SQL = "SELECT * FROM orders WHERE status='order';";
            PreparedStatement statement = connection.prepareStatement(SQL);

            ResultSet rs = statement.executeQuery();

            statusOrderList = new ArrayList<>();

            while (rs.next())
            {
                int id = rs.getInt("id");
                int tlf = rs.getInt("tlf");
                String email = rs.getString("email");
                int height = rs.getInt("height");
                int length = rs.getInt("length");
                int width = rs.getInt("width");
                int shedLength = rs.getInt("shedLength");
                int shedWidth = rs.getInt("shedWidth");
                int slopedRoof = rs.getInt("slopedRoof");
                int price = rs.getInt("price");
                String status = rs.getString("status");
                statusOrderList.add(new Order(id, tlf, email, length, height, width, shedLength, shedWidth, slopedRoof, price, status));
            }

            return statusOrderList;
        } catch (ClassNotFoundException | SQLException ex)
        {
            throw new OrderBuilderException(ex.getMessage());
        }
    }

    /**
     * Uses a SQL preparedstatement to get an Order from the DB with the id from
     * the parameter.
     * <p>
     * Used to get one Order for the edit page.
     *
     * @param id
     * @return
     * @throws OrderBuilderException
     */
    public static Order getOrder(int id) throws OrderBuilderException
    {
        try
        {
            Connection connection = Connector.connection();
            String SQL = "SELECT * FROM orders WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(SQL);
            statement.setInt(1, id);

            ResultSet rs = statement.executeQuery();

            Order o = null;

            while (rs.next())
            {
                int id2 = rs.getInt("id");
                int tlf = rs.getInt("tlf");
                String email = rs.getString("email");
                int height = rs.getInt("height");
                int length = rs.getInt("length");
                int width = rs.getInt("width");
                int shedLength = rs.getInt("shedLength");
                int shedWidth = rs.getInt("shedWidth");
                int slopedRoof = rs.getInt("slopedRoof");
                int price = rs.getInt("price");
                String status = rs.getString("status");
                o = new Order(id2, tlf, email, length, height, width, shedLength, shedWidth, slopedRoof, price, status);
            }

            return o;
        } catch (ClassNotFoundException | SQLException ex)
        {
            throw new OrderBuilderException(ex.getMessage());
        }
    }

    /**
     * Uses a SQL preparedstatement to update the attributes of an order in the
     * DB, with new values from the parameters.
     * <p>
     * Used to edit an Order and ready it for the customer.
     *
     * @param id
     * @param tlf
     * @param email
     * @param height
     * @param length
     * @param width
     * @param shedLength
     * @param shedWidth
     * @param slopedRoof
     * @param price
     * @throws OrderBuilderException
     */
    public static void editOrder(int id, int tlf, String email, int height, int length, int width, int shedLength, int shedWidth, int slopedRoof, int price) throws OrderBuilderException
    {
        try
        {
            Connection con = Connector.connection();
            String SQL = "UPDATE orders SET tlf = ?, email = ?, height = ?, length = ?, width = ?, shedLength = ?, shedWidth = ?, slopedRoof = ?, price = ? WHERE id = ?;";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, tlf);
            ps.setString(2, email);
            ps.setInt(3, height);
            ps.setInt(4, length);
            ps.setInt(5, width);
            ps.setInt(6, shedLength);
            ps.setInt(7, shedWidth);
            ps.setInt(8, slopedRoof);
            ps.setInt(9, price);
            ps.setInt(10, id);
            ps.executeUpdate();

        } catch (ClassNotFoundException | SQLException ex)
        {
            throw new OrderBuilderException(ex.getMessage());
        }

    }

    /**
     * Uses a SQL preparedstatement to get all Products from the bracketsScrews
     * DB, and adds them to a List of Products.
     * <p>
     * Used to make the Bill of Materials, to get the brackets and screws and
     * other small materials.
     *
     * @return
     * @throws OrderBuilderException
     */
    public static List<Product> getAllBracketsScrews() throws OrderBuilderException
    {
        List<Product> productList;
        try
        {
            Connection con = Connector.connection();
            String SQL = "SELECT * FROM bracketsScrews";
            PreparedStatement statement = con.prepareStatement(SQL);

            ResultSet rs = statement.executeQuery();

            productList = new ArrayList<>();

            while (rs.next())
            {
                String ratio = rs.getString("ratio");
                int priceforeach = rs.getInt("priceforeach");
                String productname = rs.getString("productname");

                productList.add(new Product(productname, ratio, priceforeach));

            }

            return productList;
        } catch (SQLException | ClassNotFoundException ex)
        {
            throw new OrderBuilderException(ex.getMessage());
        }
    }

    /**
     * Uses a SQL preparedstatement to get all Products from the woodEaves DB,
     * and adds them to a List of Products.
     * <p>
     * Used to make the Bill of Materials, to get the larger materials like wood
     * for walls and roof materials.
     *
     * @return
     * @throws OrderBuilderException
     */
    public static List<Product> getAllWoodEaves() throws OrderBuilderException
    {
        List<Product> productList;
        try
        {

            Connection con = Connector.connection();
            String SQL = "SELECT * FROM woodEaves";
            PreparedStatement statement = con.prepareStatement(SQL);

            ResultSet rs = statement.executeQuery();

            productList = new ArrayList<>();

            while (rs.next())
            {
                int priceforeach = rs.getInt("priceforeach");
                String productname = rs.getString("product");

                productList.add(new Product(productname, priceforeach));

            }

            return productList;
        } catch (SQLException | ClassNotFoundException ex)
        {
            throw new OrderBuilderException(ex.getMessage());
        }
    }

    /**
     * Uses a SQL preparedstatement to get all Orders from the DB with status as
     * 'finished', and adds them to a List.
     * <p>
     * Used to get a list of Finished orders from customers.
     * Currently not used.
     *
     * @return
     * @throws OrderBuilderException
     */
    public static List<Order> getAllOrdersWhereStatusIsFinished() throws OrderBuilderException
    {
        List<Order> statusFinishedList;
        try
        {
            Connection connection = Connector.connection();
            String SQL = "SELECT * FROM orders WHERE status='finished';";
            PreparedStatement statement = connection.prepareStatement(SQL);

            ResultSet rs = statement.executeQuery();

            statusFinishedList = new ArrayList<>();

            while (rs.next())
            {
                int id = rs.getInt("id");
                int tlf = rs.getInt("tlf");
                String email = rs.getString("email");
                int height = rs.getInt("height");
                int length = rs.getInt("length");
                int width = rs.getInt("width");
                int shedLength = rs.getInt("shedLength");
                int shedWidth = rs.getInt("shedWidth");
                int slopedRoof = rs.getInt("slopedRoof");
                int price = rs.getInt("price");
                String status = rs.getString("status");
                statusFinishedList.add(new Order(id, tlf, email, length, height, width, shedLength, shedWidth, slopedRoof, price, status));
            }

            return statusFinishedList;
        } catch (ClassNotFoundException | SQLException ex)
        {
            throw new OrderBuilderException(ex.getMessage());
        }
    }
}
