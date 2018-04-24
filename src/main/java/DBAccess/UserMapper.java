package DBAccess;

import FunctionLayer.LoginSampleException;
import FunctionLayer.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class UserMapper
{

    public static void createUser(User user) throws LoginSampleException
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
            throw new LoginSampleException(ex.getMessage());
        }
    }

    public static User login(String email, String password) throws LoginSampleException
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
                throw new LoginSampleException("Could not validate user");
            }
        } catch (ClassNotFoundException | SQLException ex)
        {
            throw new LoginSampleException(ex.getMessage());
        }
    }
    
            //PreparedStatement
//            String sql = "select * from user where username = ? and password = ?";
//            PreparedStatement preparedStatement = dbc.preparedStatement(sql);
//            preparedStatement.setString(1, username);
//            preparedStatement.setString(2, password);
//            ResultSet resultSet = preparedStatement.executeQuery();
}
