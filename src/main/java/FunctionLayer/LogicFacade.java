package FunctionLayer;

import DBAccess.OrderMapper;
import DBAccess.UserMapper;
import java.util.List;

public class LogicFacade
{

    public static User login(String email, String password) throws LoginSampleException
    {
        return UserMapper.login(email, password);
    }

    public static User createUser(String email, String password) throws LoginSampleException
    {
        User user = new User(email, password, "employee");
        UserMapper.createUser(user);
        return user;
    }

    public static Order createOrder(int tlf, String email, int length, int width, int height, int shedLength, int shedWidth, int slopedRoof) throws OrderBuilderException
    {
        Order order = new Order(tlf, email, length, height, width, shedLength, shedWidth, slopedRoof);
        OrderMapper.OrderToDB(order);

        return order;
    }

//    public static List<Order> getUserOrders(User user) throws OrderBuilderException
//    {
//        List<Order> orderList = OrderMapper.getAllUserOrders(user);
//        return orderList;
//    }

    public static List<Order> getOrderList() throws OrderBuilderException
    {
        List<Order> allOrders = OrderMapper.getAllOrders();

        return allOrders;

    }

    public static void deliverOrder(int id) throws OrderBuilderException
    {
        OrderMapper.sentOrder(id);
    }

}
