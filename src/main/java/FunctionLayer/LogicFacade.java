package FunctionLayer;

import DBAccess.OrderMapper;
import DBAccess.UserMapper;
import java.sql.SQLException;
import java.util.List;

public class LogicFacade {

    public static User login(String email, String password) throws FogException {
        return UserMapper.login(email, password);
    }

    public static User createUser(String email, String password) throws FogException {
        User user = new User(email, password, "employee");
        UserMapper.createUser(user);
        return user;
    }

    public static Order createOrder(int tlf, String email, int length, int width, int height, int shedLength, int shedWidth, int slopedRoof) throws OrderBuilderException, SQLException {
        Order order = new Order(tlf, email, length, height, width, shedLength, shedWidth, slopedRoof);
        OrderMapper.OrderToDB(order);

        return order;
    }

//    public static List<Order> getUserOrders(User user) throws OrderBuilderException
//    {
//        List<Order> orderList = OrderMapper.getAllUserOrders(user);
//        return orderList;
//    }
    public static List<Order> getOrderList() throws OrderBuilderException {
        List<Order> allOrders = OrderMapper.getAllOrdersWhereStatusIsRequest();
        return allOrders;
    }

    public static List<Order> getStatusOrderList() throws OrderBuilderException {
        List<Order> allStatusOrders = OrderMapper.getAllOrdersWhereStatusIsOrder();
        return allStatusOrders;
    }

    public static void deliverOrder(int id) throws OrderBuilderException {
        OrderMapper.setStatusOrder(id);
    }

    public static void removeOrder(int id) throws OrderBuilderException {

        OrderMapper.setStatusDone(id);
    }
    public static void finishOrder(int id) throws OrderBuilderException {

        OrderMapper.setStatusDone(id);
    }

    public static Order getOneOrder(int id) throws OrderBuilderException {

        return OrderMapper.getOrder(id);
    }

    public static void editOrder(int id, int tlf, String email, int height, int length, int width, int shedLength, int shedWidth, int slopedRoof, int price) throws OrderBuilderException {

        OrderMapper.editOrder(id, tlf, email, height, length, width, shedLength, shedWidth, slopedRoof, price);
    }
    
    public static List<Product> getProductsFromDB() throws OrderBuilderException{
        
        return OrderMapper.getAllProducts();
    }

}
