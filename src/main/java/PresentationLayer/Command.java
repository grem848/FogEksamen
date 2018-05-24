package PresentationLayer;

import FunctionLayer.FogException;
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
        commands.put("employeeorderlist", new EmployeeOrderList());
        commands.put("requesttoorderpage", new RequestToOrder());
        commands.put("employee", new Forwarder());
        commands.put("logout", new Logout());
        commands.put("orderconfirmed", new OrderConfirmed());
        commands.put("createorderpage", new CreateOrder());
        commands.put("employeerequestpage", new RequestList());
        commands.put("orderremovedpage", new OrderRemoved());
        commands.put("employeeeditpage", new EmployeeEditOrder());
        commands.put("editorderpage", new EditOrder());
        commands.put("employeelogin", new EmployeeLogin());
        commands.put("update", new UpdateIndex());
        commands.put("sendrequestpage", new Visualization());
        commands.put("updateemployeecreateorder", new UpdateEmployeeCreateOrder());
        commands.put("sendorderpage", new OrderSend());
        
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
            throws FogException, OrderBuilderException;

    }


