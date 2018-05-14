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
     *
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
     *
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
