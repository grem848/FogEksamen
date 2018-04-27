package PresentationLayer;

import FunctionLayer.LoginSampleException;
import FunctionLayer.OrderBuilderException;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

abstract class Command
{

    private static HashMap<String, Command> commands;

    private static void initCommands()
    {
        commands = new HashMap<>();
        commands.put("login", new Login());
        commands.put("register", new Register());
        commands.put("help", new Help());
        commands.put("products", new Products());
        commands.put("bom", new BOM());
        commands.put("orderlist", new Orderlist());
        commands.put("employeeorderlist", new EmployeeOrderList());
        commands.put("ordersent", new OrderSent());
        commands.put("employee", new Forwarder());
        commands.put("logout", new Logout());
        commands.put("orderconfirmed", new OrderConfirmed());
        commands.put("createorderpage", new CreateOrder());
        commands.put("employeerequestpage", new RequestList());
        commands.put("orderfinishedpage", new OrderFinished());

    }

    static Command from(HttpServletRequest request)
    {
        String commandName = request.getParameter("command");
        if (commands == null)
        {
            initCommands();
        }
        return commands.getOrDefault(commandName, new UnknownCommand());
    }

    abstract String execute(HttpServletRequest request, HttpServletResponse response)
            throws LoginSampleException, OrderBuilderException;

}
