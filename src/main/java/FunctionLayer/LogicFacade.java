package FunctionLayer;

import DBAccess.OrderMapper;
import DBAccess.UserMapper;
import java.util.List;

public class LogicFacade {

    public static User login(String email, String password) throws LoginSampleException {
        return UserMapper.login(email, password);
    }

    public static User createUser(String email, String password) throws LoginSampleException {
        User user = new User(email, password, "employee");
        UserMapper.createUser(user);
        return user;
    }

    public static Order createOrder(int tlf, String email, int length, int width, int height, int shedLength, int shedWidth, int slopedRoof) throws OrderBuilderException {
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

    public static Order getOneOrder(int id) throws OrderBuilderException {

        return OrderMapper.getOrder(id);
    }

    public static void changeTlf(int id, int tlf) throws OrderBuilderException {

        OrderMapper.editTlf(id, tlf);;
    }

    public static void changeEmail(int id, String email) throws OrderBuilderException {

        OrderMapper.editEmail(id, email);;
    }

    public static void changeLength(int id, int length) throws OrderBuilderException {

        OrderMapper.editLength(id, length);;
    }

    public static void changeHeight(int id, int height) throws OrderBuilderException {

        OrderMapper.editHeight(id, height);;
    }

    public static void changeWidth(int id, int width) throws OrderBuilderException {

        OrderMapper.editWidth(id, width);;
    }

    public static void changeShedLength(int id, int shedLength) throws OrderBuilderException {

        OrderMapper.editShedLength(id, shedLength);;
    }
    
    public static void changeShedWidth(int id, int shedWidth) throws OrderBuilderException{
        
        OrderMapper.editShedWidth(id, shedWidth);
    }

    public static void changeSlopedRoof(int id, int slopedRoof) throws OrderBuilderException {

        OrderMapper.editSlope(id, slopedRoof);;
    }


}
