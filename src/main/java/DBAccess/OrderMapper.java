package DBAccess;

import FunctionLayer.Order;
import FunctionLayer.OrderBuilderException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderMapper
{

    private static DBConnector dbc = new DBConnector();

    public static boolean OrderToDB(Order order) throws OrderBuilderException, SQLException
    {
        try
        {
            dbc.setDataSource(new DataSource().getDataSource());
            dbc.open();
            String SQL = "INSERT INTO orders (tlf, email, length, width, height, shedLength, shedWidth, slopedRoof) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = dbc.preparedStatement(SQL);
            ps.setInt(1, order.getTlf());
            ps.setString(2, order.getEmail());
            ps.setInt(3, order.getLength());
            ps.setInt(4, order.getWidth());
            ps.setInt(5, order.getHeight());
            ps.setInt(6, order.getShedLength());
            ps.setInt(7, order.getShedWidth());
            ps.setInt(8, order.getSlopedRoof());
            ps.executeUpdate();
            dbc.close();

        } catch (SQLException ex)
        {
            throw new OrderBuilderException(ex.getMessage());
        }
        return false;
    }

//    public static List<OrderBOM> getAllUserOrders(User user) throws OrderBuilderException
//    {
//        List<OrderBOM> orderList;
//        try
//        {
//            Connection connection = Connector.connection();
//            String SQL = "SELECT * FROM useradmin.orders WHERE id = ?";
//            PreparedStatement statement = connection.prepareStatement(SQL);
//
//            statement.setInt(1, user.getId());
//            ResultSet rs = statement.executeQuery();
//
//            orderList = new ArrayList<>();
//
//            while (rs.next())
//            {
//                int orderid = rs.getInt("orderid");
//                int id = rs.getInt("id");
//                int length = rs.getInt("length");
//                int width = rs.getInt("width");
//                int height = rs.getInt("height");
//                boolean sent = rs.getBoolean("sent");
//
//                orderList.add(new OrderBOM(orderid, id, length, width, height, sent));
//            }
//
//            return orderList;
//        } catch (ClassNotFoundException | SQLException ex)
//        {
//            throw new OrderBuilderException(ex.getMessage());
//        }
//    }
    public static List<Order> getAllOrdersWhereStatusIsRequest() throws OrderBuilderException
    {
        List<Order> orderList;
        try
        {
            dbc.setDataSource(new DataSource().getDataSource());
            dbc.open();
            String SQL = "SELECT * FROM orders WHERE status='request'";
            PreparedStatement statement = dbc.preparedStatement(SQL);

            ResultSet rs = statement.executeQuery();

            orderList = new ArrayList<>();

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
                String status = rs.getString("status");
                orderList.add(new Order(id, tlf, email, length, height, width, shedLength, shedWidth, slopedRoof, status));
            }
            dbc.close();
            return orderList;
        } catch (SQLException ex)
        {
            throw new OrderBuilderException(ex.getMessage());
        }
    }

    public static void setStatusOrder(int id) throws OrderBuilderException
    {
        try
        {
            dbc.setDataSource(new DataSource().getDataSource());
            dbc.open();
            String SQL = "UPDATE orders SET status='order' WHERE id = ?";
            PreparedStatement ps = dbc.preparedStatement(SQL);
            ps.setInt(1, id);
            ps.executeUpdate();
            dbc.close();

        } catch (SQLException ex)
        {
            throw new OrderBuilderException(ex.getMessage());
        }
    }

    public static void setStatusDone(int id) throws OrderBuilderException
    {
        try
        {
            dbc.setDataSource(new DataSource().getDataSource());
            dbc.open();
            String SQL = "UPDATE orders SET status='done' WHERE id = ?";
            PreparedStatement ps = dbc.preparedStatement(SQL);
            ps.setInt(1, id);
            ps.executeUpdate();
            dbc.close();

        } catch (SQLException ex)
        {
            throw new OrderBuilderException(ex.getMessage());
        }
    }

    public static List<Order> getAllOrdersWhereStatusIsOrder() throws OrderBuilderException
    {
        List<Order> statusOrderList;
        try
        {
            dbc.setDataSource(new DataSource().getDataSource());
            dbc.open();
            String SQL = "SELECT * FROM orders WHERE status='order';";
            PreparedStatement statement = dbc.preparedStatement(SQL);

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
                String status = rs.getString("status");
                statusOrderList.add(new Order(id, tlf, email, length, height, width, shedLength, shedWidth, slopedRoof, status));
            }
            dbc.close();

            return statusOrderList;
        } catch (SQLException ex)
        {
            throw new OrderBuilderException(ex.getMessage());
        }
    }

    public static Order getOrder(int id) throws OrderBuilderException
    {

        try
        {
            dbc.setDataSource(new DataSource().getDataSource());
            dbc.open();
            String SQL = "SELECT * FROM orders WHERE id = ?";
            PreparedStatement statement = dbc.preparedStatement(SQL);
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
                String status = rs.getString("status");
                o = new Order(id2, tlf, email, length, height, width, shedLength, shedWidth, slopedRoof, status);
            }
            dbc.close();
            return o;
        } catch (SQLException ex)
        {
            throw new OrderBuilderException(ex.getMessage());
        }
    }

    public static void editOrder(int id, int tlf, String email, int height, int length, int width, int shedLength, int shedWidth, int slopedRoof) throws OrderBuilderException
    {
        try
        {
            dbc.setDataSource(new DataSource().getDataSource());
            dbc.open();
            String SQL = "UPDATE orders SET tlf = ?, email = ?, height = ?, length = ?, width = ?, shedLength = ?, shedWidth = ?, slopedRoof = ? WHERE id = ?;";
            PreparedStatement ps = dbc.preparedStatement(SQL);
            ps.setInt(1, tlf);
            ps.setString(2, email);
            ps.setInt(3, height);
            ps.setInt(4, length);
            ps.setInt(5, width);
            ps.setInt(6, shedLength);
            ps.setInt(7, shedWidth);
            ps.setInt(8, slopedRoof);
            ps.setInt(9, id);
            ps.executeUpdate();
            dbc.close();

        } catch (SQLException ex)
        {
            throw new OrderBuilderException(ex.getMessage());
        }

    }
}
