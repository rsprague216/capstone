package sprague.ryan.capstone;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.sql.DataSource;

/**
 * @author Ryan Sprague
 */
public class UserManager extends DBManager {
    private ArrayList<User> users = new ArrayList<>();
    private final DataSource dataSource;
    
    public UserManager(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    
    void addUser(User user) {
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            connection = dataSource.getConnection();
            statement = connection.prepareStatement("INSERT INTO USERS (FIRSTNAME, LASTNAME, EMAIL, USERNAME, PASSWORD, SALT) VALUES(?, ?, ?, ?, ?, ?)");
            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getLastName());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getUserName());
            statement.setString(5, user.getHashedPassword());
            statement.setBytes(6, user.getSalt());
            
            boolean ok = statement.execute();
            System.out.println("User ok? " + ok);
        } catch(SQLException ex) {
            ex.printStackTrace();
        } finally {
            close(statement);
            close(connection);
        }
        
    }
    
    private User userFromDB(ResultSet resultSet) throws SQLException {
        return new User(
                resultSet.getString("FIRSTNAME"),
                resultSet.getString("LASTNAME"),
                resultSet.getString("EMAIL"),
                resultSet.getString("USERNAME"),
                resultSet.getString("PASSWORD"),
                resultSet.getBytes("SALT"),
                resultSet.getInt("USERID"));
    }
    
    public User userByLogin(String username) {
        User user = null;
        
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        
        try {
            connection = dataSource.getConnection();
            statement = connection.prepareStatement("SELECT * FROM USERS WHERE USERNAME=?");
            statement.setString(1, username);
            
            resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                user = userFromDB(resultSet);
            }
        } catch(SQLException ex) {
            ex.printStackTrace();
        } finally {
            close(resultSet);
            close(statement);
            close(connection);
        }
        return user;
    }
}
