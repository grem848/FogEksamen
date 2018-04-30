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

public class OrderMapper {

    public static boolean OrderToDB(Order order) throws OrderBuilderException {
        try {
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

        } catch (SQLException | ClassNotFoundException ex) {
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
    public static List<Order> getAllOrders() throws OrderBuilderException {
        List<Order> orderList;
        try {
            Connection connection = Connector.connection();
            String SQL = "SELECT * FROM orders WHERE status='request';";
            PreparedStatement statement = connection.prepareStatement(SQL);

            ResultSet rs = statement.executeQuery();

            orderList = new ArrayList<>();

            while (rs.next()) {
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

            return orderList;
        } catch (ClassNotFoundException | SQLException ex) {
            throw new OrderBuilderException(ex.getMessage());
        }
    }

    public static void makeOrder(int id) throws OrderBuilderException {
        try {
            Connection con = Connector.connection();
            String SQL = " SELECT * FROM orders WHERE id=" + id + ";";
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {

                String nextSQL = "UPDATE orders SET status='order' WHERE id =" + id + ";";
                ps.execute(nextSQL);

            } else {
                throw new OrderBuilderException("Could not validate Order");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            throw new OrderBuilderException(ex.getMessage());
        }
    }

    public static void makeDone(int id) throws OrderBuilderException {
        try {
            Connection con = Connector.connection();
            String SQL = " SELECT * FROM orders WHERE id=" + id + ";";
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {

                String nextSQL = "UPDATE orders SET status='done' WHERE id =" + id + ";";
                ps.execute(nextSQL);

            } else {
                throw new OrderBuilderException("Could not validate Order");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            throw new OrderBuilderException(ex.getMessage());
        }
    }

    public static List<Order> getAllOrdersWhereStatusIsOrder() throws OrderBuilderException {
        List<Order> statusOrderList;
        try {
            Connection connection = Connector.connection();
            String SQL = "SELECT * FROM orders WHERE status='order';";
            PreparedStatement statement = connection.prepareStatement(SQL);

            ResultSet rs = statement.executeQuery();

            statusOrderList = new ArrayList<>();

            while (rs.next()) {
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

            return statusOrderList;
        } catch (ClassNotFoundException | SQLException ex) {
            throw new OrderBuilderException(ex.getMessage());
        }
    }

    public static Order getOrder(int id) throws OrderBuilderException {

        try {
            Connection connection = Connector.connection();
            String SQL = "SELECT * FROM orders WHERE id='" + id + "';";
            PreparedStatement statement = connection.prepareStatement(SQL);

            ResultSet rs = statement.executeQuery();

            Order o = null;

            while (rs.next()) {
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

            return o;
        } catch (ClassNotFoundException | SQLException ex) {
            throw new OrderBuilderException(ex.getMessage());
        }
    }

    public static void editTlf(int id, int number) throws OrderBuilderException {
        try {
            Connection con = Connector.connection();
            String SQL = " SELECT * FROM orders WHERE id=" + id + ";";
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {

                String nextSQL = "UPDATE orders SET tlf='" + number + "' WHERE id =" + id + ";";
                ps.execute(nextSQL);

            } else {
                throw new OrderBuilderException("Could not validate Order");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            throw new OrderBuilderException(ex.getMessage());
        }

    }

    public static void editEmail(int id, String email) throws OrderBuilderException {

        try {
            Connection con = Connector.connection();
            String SQL = " SELECT * FROM orders WHERE id=" + id + ";";
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {

                String nextSQL = "UPDATE orders SET email='" + email + "' WHERE id =" + id + ";";
                ps.execute(nextSQL);

            } else {
                throw new OrderBuilderException("Could not validate Order");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            throw new OrderBuilderException(ex.getMessage());
        }
    }

    public static void editLength(int id, int length) throws OrderBuilderException {

        try {
            Connection con = Connector.connection();
            String SQL = " SELECT * FROM orders WHERE id=" + id + ";";
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {

                String nextSQL = "UPDATE orders SET length='" + length + "' WHERE id =" + id + ";";
                ps.execute(nextSQL);

            } else {
                throw new OrderBuilderException("Could not validate Order");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            throw new OrderBuilderException(ex.getMessage());
        }
    }

    public static void editWidth(int id, int width) throws OrderBuilderException {

        try {
            Connection con = Connector.connection();
            String SQL = " SELECT * FROM orders WHERE id=" + id + ";";
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {

                String nextSQL = "UPDATE orders SET width='" + width + "' WHERE id =" + id + ";";
                ps.execute(nextSQL);

            } else {
                throw new OrderBuilderException("Could not validate Order");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            throw new OrderBuilderException(ex.getMessage());
        }
    }

    public static void editHeight(int id, int height) throws OrderBuilderException {

        try {
            Connection con = Connector.connection();
            String SQL = " SELECT * FROM orders WHERE id=" + id + ";";
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {

                String nextSQL = "UPDATE orders SET height='" + height + "' WHERE id =" + id + ";";
                ps.execute(nextSQL);

            } else {
                throw new OrderBuilderException("Could not validate Order");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            throw new OrderBuilderException(ex.getMessage());
        }
    }

    public static void editShedLength(int id, int shedLength) throws OrderBuilderException {

        try {
            Connection con = Connector.connection();
            String SQL = " SELECT * FROM orders WHERE id=" + id + ";";
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {

                String nextSQL = "UPDATE orders SET shedLength='" + shedLength + "' WHERE id =" + id + ";";
                ps.execute(nextSQL);

            } else {
                throw new OrderBuilderException("Could not validate Order");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            throw new OrderBuilderException(ex.getMessage());
        }
    }

    public static void editShedWidth(int id, int shedWidth) throws OrderBuilderException {

        try {
            Connection con = Connector.connection();
            String SQL = " SELECT * FROM orders WHERE id=" + id + ";";
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {

                String nextSQL = "UPDATE orders SET shedWidth='" + shedWidth + "' WHERE id =" + id + ";";
                ps.execute(nextSQL);

            } else {
                throw new OrderBuilderException("Could not validate Order");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            throw new OrderBuilderException(ex.getMessage());
        }
    }

    public static void editSlope(int id, int slope) throws OrderBuilderException {

        try {
            Connection con = Connector.connection();
            String SQL = " SELECT * FROM orders WHERE id=" + id + ";";
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {

                String nextSQL = "UPDATE orders SET slopedRoof='" + slope + "' WHERE id =" + id + ";";
                ps.execute(nextSQL);

            } else {
                throw new OrderBuilderException("Could not validate Order");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            throw new OrderBuilderException(ex.getMessage());
        }
    }
    
//        public static void orderFinished(int id) throws OrderBuilderException {
//
//        try {
//            Connection con = Connector.connection();
//            String SQL = " SELECT * FROM orders WHERE id=" + id + ";";
//            PreparedStatement ps = con.prepareStatement(SQL);
//            ResultSet rs = ps.executeQuery();
//            if (rs.next()) {
//
//                String nextSQL = "UPDATE orders SET status='done' WHERE id =" + id + ";";
//                ps.execute(nextSQL);
//
//            } else {
//                throw new OrderBuilderException("Could not validate Order");
//            }
//        } catch (ClassNotFoundException | SQLException ex) {
//            throw new OrderBuilderException(ex.getMessage());
//        }
    }

