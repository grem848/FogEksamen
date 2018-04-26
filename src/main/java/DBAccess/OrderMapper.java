package DBAccess;

import FunctionLayer.Order;
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

    public static boolean OrderToDB(Order order) throws OrderBuilderException
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
    
     public static List<Order> getAllOrders() throws OrderBuilderException
    {
        List<Order> orderList;
        try
        {
            Connection connection = Connector.connection();
            String SQL = "SELECT * FROM orders WHERE status='request';";
            PreparedStatement statement = connection.prepareStatement(SQL);

            ResultSet rs = statement.executeQuery();

            orderList = new ArrayList<>();

            while (rs.next())
            {
                int id = rs.getInt( "id" );
                int tlf = rs.getInt( "tlf" );
                String email = rs.getString( "email" );
                int height = rs.getInt( "height" );
                int length = rs.getInt( "length" );
                int width = rs.getInt( "width" );
                int shedLength = rs.getInt( "shedLength" );
                int shedWidth = rs.getInt( "shedWidth" );
                int slopedRoof = rs.getInt( "slopedRoof" );
                String status = rs.getString( "status" );
                orderList.add(new Order(id, tlf, email, length, height, width, shedLength, shedWidth, slopedRoof, status));
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
         
         public static List<Order> getAllOrdersWhereStatusISSent() throws OrderBuilderException
    {
        List<Order> orderSentList;
        try
        {
            Connection connection = Connector.connection();
            String SQL = "SELECT * FROM orders WHERE status='sent';";
            PreparedStatement statement = connection.prepareStatement(SQL);

            ResultSet rs = statement.executeQuery();

            orderSentList = new ArrayList<>();

            while (rs.next())
            {
                int id = rs.getInt( "id" );
                int tlf = rs.getInt( "tlf" );
                String email = rs.getString( "email" );
                int height = rs.getInt( "height" );
                int length = rs.getInt( "length" );
                int width = rs.getInt( "width" );
                int shedLength = rs.getInt( "shedLength" );
                int shedWidth = rs.getInt( "shedWidth" );
                int slopedRoof = rs.getInt( "slopedRoof" );
                String status = rs.getString( "status" );
                orderSentList.add(new Order(id, tlf, email, length, height, width, shedLength, shedWidth, slopedRoof, status));
            }

            return orderSentList;
        } catch (ClassNotFoundException | SQLException ex)
        {
            throw new OrderBuilderException(ex.getMessage());
        }
    }
         
         
         
         

}
