package DBAccess;

import FunctionLayer.FogException;
import FunctionLayer.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper
{

    private static DBConnector dbc = new DBConnector();

    public static void createUser(User user) throws FogException
    {
        try
        {
            dbc.setDataSource(new DataSource().getDataSource());
            dbc.open();
            String SQL = "INSERT INTO users (email, password, role) VALUES (?, ?, ?)";
            PreparedStatement ps = dbc.preparedStatement(SQL);
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getRole());
            ps.executeUpdate();
            dbc.close();
        } catch (SQLException ex)
        {
            throw new FogException(ex.getMessage());
        }
    }

    public static User login(String email, String password) throws FogException
    {
        try
        {
            dbc.setDataSource(new DataSource().getDataSource());
            dbc.open();
            String SQL = "SELECT id, role FROM users "
                    + "WHERE email=? AND password=?";
            PreparedStatement ps = dbc.preparedStatement(SQL);
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next())
            {
                String role = rs.getString("role");
                int id = rs.getInt("id");
                User user = new User(email, password, role);
                user.setId(id);
                dbc.close();
                return user;
            } else
            {
                dbc.close();
                throw new FogException("Could not validate user");
            }
        } catch (SQLException ex)
        {
            throw new FogException(ex.getMessage());
        }
    }

}
