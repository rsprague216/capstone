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
public class CharSkillManager extends DBManager {
    private final DataSource dataSource;
    
    public CharSkillManager(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    
    private Skill skillFromDB(ResultSet resultSet) throws SQLException {
        return new Skill(
                resultSet.getInt("ID"),
                resultSet.getString("SKILL"),
                resultSet.getString("PATH"),
                resultSet.getString("EFFECT"),
                resultSet.getString("CHARCLASS"),
                resultSet.getInt("LEVEL"),
                resultSet.getInt("CHARID")
        );
    }
    
    public Skill skillByID(int id) {
        Skill skill = null;
        
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        
        try {
            connection = dataSource.getConnection();
            statement = connection.prepareStatement("SELECT * FROM SKILLS WHERE ID=?");
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                skill = skillFromDB(resultSet);
            }
        } catch(SQLException ex) {
            ex.printStackTrace();
        } finally {
            close(resultSet);
            close(statement);
            close(connection);
        }
        return skill;
    }
    
    public List<Skill> allSkillFromCharacter(int charId) {
        ArrayList<Skill> skills = new ArrayList<>();
        
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        
        try {
            connection = dataSource.getConnection();
            statement = connection.prepareStatement("SELECT * FROM SKILLS WHERE CHARID=?");
            statement.setInt(1, charId);
            resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                skills.add(skillFromDB(resultSet));
            }
        } catch(SQLException ex) {
            ex.printStackTrace();
        } finally {
            close(resultSet);
            close(statement);
            close(connection);
        }
        return skills;
    }
    
    void addSkill(Skill skill, int charId) {
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            connection = dataSource.getConnection();
            statement = connection.prepareStatement("INSERT INTO SKILLS (SKILL, PATH, EFFECT, CHARCLASS, LEVEL, CHARID) VALUES (?, ?, ?, ?, ?, ?)");
            statement.setString(1, skill.getSkillName());
            statement.setString(2, skill.getSkillPath());
            statement.setString(3, skill.getSkillEffect());
            statement.setString(4, skill.getSkillClass());
            statement.setInt(5, skill.getSkillLevel());
            statement.setInt(6, charId);
            
            boolean ok = statement.execute();
            System.out.println("Skill added ok?" + ok);
        } catch(SQLException ex) {
            ex.printStackTrace();
        } finally {
            close(statement);
            close(connection);
        }
    }
}
