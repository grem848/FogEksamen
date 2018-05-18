package DBAccess;

import FunctionLayer.FogException;
import FunctionLayer.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UserMapper
{

    /**
     * Takes an User object and retrieves the attributes for a SQL preparedstatement that inserts the User attributes into to the order DB.
     * <p>
     * Used to create Admin users, can also be used for customers, but SQL defaults role to employee.
     * @param user
     * @throws FogException
     */
    public static void createUser(User user) throws FogException
    {
        try
        {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO users (email, password, role) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getRole());
            ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException ex)
        {
            throw new FogException(ex.getMessage());
        }
    }

    /**
     * Takes the parameters and validates them by checking if they exist in the User DB.
     * <p>
     * Used to validate User login, if it succeeds it returns the user, to be used to add user to the session, and gets his role allowing multiple roles.
     * <p>
     * Used to validate User login, if it fails an exception is thrown to show that login failed.
     * @param email
     * @param password
     * @return
     * @throws FogException
     */
    public static User login(String email, String password) throws FogException
    {
        try
        {
            Connection con = Connector.connection();
            String SQL = "SELECT id, role FROM users "
                    + "WHERE email=? AND password=?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next())
            {
                String role = rs.getString("role");
                int id = rs.getInt("id");
                User user = new User(email, password, role);
                user.setId(id);
                return user;
            } else
            {
                throw new FogException("Could not validate user");
            }
        } catch (ClassNotFoundException | SQLException ex)
        {
            throw new FogException(ex.getMessage());
        }
    }

}
