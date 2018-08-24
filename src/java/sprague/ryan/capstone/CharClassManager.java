package sprague.ryan.capstone;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

/**
 * @author Ryan Sprague
 */
public class CharClassManager extends DBManager {
    private DataSource dataSource;
    
    public CharClassManager(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    
    private CharacterClass classFromDB(ResultSet resultSet) throws SQLException {
        return new CharacterClass(
                resultSet.getInt("ID"),
                resultSet.getInt("CHARID"),
                resultSet.getString("CLASSNAME"),
                resultSet.getString("CLASSPATH"),
                resultSet.getInt("CLASSLEVEL"),
                resultSet.getInt("HITDIESIDES"));
    }
    
    public CharacterClass classByID(int id) {
        CharacterClass charClass = null;
        
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        
        try {
            connection = dataSource.getConnection();
            statement = connection.prepareStatement("SELECT * FROM CLASSES WHERE ID=?");
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                charClass = classFromDB(resultSet);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            close(resultSet);
            close(statement);
            close(connection);
        }
        return charClass;
    }
    
    public List<CharacterClass> allClassesForChar(int charId) {
        ArrayList<CharacterClass> classes = new ArrayList<>();
        
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        
        try {
            connection = dataSource.getConnection();
            statement = connection.prepareStatement("SELECT * FROM CLASSES WHERE CHARID=?");
            statement.setInt(1, charId);
            resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                classes.add(classFromDB(resultSet));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            close(resultSet);
            close(statement);
            close(connection);
        }
        return classes;
    }
    
    public CharacterClass classByNameAndId(String className, int charId) {
        CharacterClass charClass = null;
        
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        
        try {
            connection = dataSource.getConnection();
            statement = connection.prepareStatement("SELECT * FROM CLASSES WHERE CLASSNAME=? AND CHARID=?");
            statement.setString(1, className);
            statement.setInt(2, charId);
            resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                charClass = classFromDB(resultSet);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            close(resultSet);
            close(statement);
            close(connection);
        }
        return charClass;
    }
    
    public void addCharClass(CharacterClass charClass, int charId) {
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            connection = dataSource.getConnection();
            statement = connection.prepareStatement("INSERT INTO CLASSES (CLASSNAME, HITDIESIDES, CLASSPATH, CLASSLEVEL, CHARID) VALUES(?, ?, ?, ?, ?)");
            statement.setString(1, charClass.getClassName());
            statement.setInt(2, charClass.getHitDieSides());
            statement.setString(3, charClass.getClassPath());
            statement.setInt(4, charClass.getClassLevel());
            statement.setInt(5, charId);
            
            boolean ok = statement.execute();
            System.out.println("Class added ok? " + ok);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            close(statement);
            close(connection);
        }
    }
    
    public void updateClass(CharacterClass charClass) {
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            connection = dataSource.getConnection();
            statement = connection.prepareStatement("UPDATE CLASSES SET CLASSNAME=?, HITDIESIDES=?, CLASSPATH=?, CLASSLEVEL=? WHERE ID=?");
            statement.setString(1, charClass.getClassName());
            statement.setInt(2, charClass.getHitDieSides());
            statement.setString(3, charClass.getClassPath());
            statement.setInt(4, charClass.getClassLevel());
            statement.setInt(5, charClass.getCharId());
            
            boolean ok = statement.execute();
            System.out.println("Updated class ok? " + ok);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            close(statement);
            close(connection);
        }
    }
}
