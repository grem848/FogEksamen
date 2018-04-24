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
        commands.put("order", new Order());
        commands.put("orderlist", new Orderlist());
        commands.put("employeeOrderList", new EmployeeOrderList());
        commands.put("orderSent", new OrderSent());
        commands.put("customer", new Forwarder());
        commands.put("employee", new Forwarder());
        commands.put("logout", new Logout());
        

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
