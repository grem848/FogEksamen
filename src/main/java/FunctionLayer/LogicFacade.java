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
        User user = new User(email, password, "customer");
        UserMapper.createUser(user);
        return user;
    }

    public static OrderBOM createOrder(int id, int length, int width, int height, boolean sent) throws OrderBuilderException
    {
        OrderBOM orderBOM = new OrderBOM(id, length, width, height, sent);
        OrderMapper.OrderToDB(orderBOM);

        return orderBOM;
    }

    public static List<OrderBOM> getUserOrders(User user) throws OrderBuilderException
    {
        List<OrderBOM> orderList = OrderMapper.getAllUserOrders(user);
        return orderList;
    }

    public static List<OrderBOM> getOrderList() throws OrderBuilderException
    {
        List<OrderBOM> allOrders = OrderMapper.getAllOrders();

        return allOrders;

    }

    public static void deliverOrder(int id) throws OrderBuilderException
    {
        OrderMapper.sentOrder(id);
    }

}
