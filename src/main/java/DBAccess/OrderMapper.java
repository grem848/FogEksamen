package DBAccess;

import FunctionLayer.OrderBOM;
import FunctionLayer.OrderBuilderException;
import FunctionLayer.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OrderMapper
{

    public static boolean OrderToDB(OrderBOM orderBOM) throws OrderBuilderException
    {
        try
        {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO orders (id, length, width, height, sent) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, orderBOM.getId());
            ps.setInt(2, orderBOM.getLength());
            ps.setInt(3, orderBOM.getWidth());
            ps.setInt(4, orderBOM.getHeight());
            ps.setBoolean(5, orderBOM.isSent());
            ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException ex)
        {
            throw new OrderBuilderException(ex.getMessage());
        }

        return false;
    }

    public static List<OrderBOM> getAllUserOrders(User user) throws OrderBuilderException
    {
        List<OrderBOM> orderList;
        try
        {
            Connection connection = Connector.connection();
            String SQL = "SELECT * FROM useradmin.orders WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(SQL);

            statement.setInt(1, user.getId());
            ResultSet rs = statement.executeQuery();

            orderList = new ArrayList<>();

            while (rs.next())
            {
                int orderid = rs.getInt("orderid");
                int id = rs.getInt("id");
                int length = rs.getInt("length");
                int width = rs.getInt("width");
                int height = rs.getInt("height");
                boolean sent = rs.getBoolean("sent");

                orderList.add(new OrderBOM(orderid, id, length, width, height, sent));
            }

            return orderList;
        } catch (ClassNotFoundException | SQLException ex)
        {
            throw new OrderBuilderException(ex.getMessage());
        }
    }
    
     public static List<OrderBOM> getAllOrders() throws OrderBuilderException
    {
        List<OrderBOM> orderList;
        try
        {
            Connection connection = Connector.connection();
            String SQL = "SELECT * FROM orders";
            PreparedStatement statement = connection.prepareStatement(SQL);

            ResultSet rs = statement.executeQuery();

            orderList = new ArrayList<>();

            while (rs.next())
            {
                int orderid = rs.getInt("orderid");
                int id = rs.getInt("id");
                int length = rs.getInt("length");
                int width = rs.getInt("width");
                int height = rs.getInt("height");
                boolean sent = rs.getBoolean("sent");

                orderList.add(new OrderBOM(orderid, id, length, width, height, sent));
            }

            return orderList;
        } catch (ClassNotFoundException | SQLException ex)
        {
            throw new OrderBuilderException(ex.getMessage());
        }
    }
     
         public static void sentOrder(int id) throws OrderBuilderException {
        try {
            Connection con = Connector.connection();
            String SQL = " SELECT * FROM orders WHERE orderid="+ id + ";";
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                
                String nextSQL = "UPDATE orders SET sent='1' WHERE orderid =" + id + ";";
                ps.execute(nextSQL);
                
            } else {
                throw new OrderBuilderException("Could not validate Order");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            throw new OrderBuilderException(ex.getMessage());
        }
    }

}
