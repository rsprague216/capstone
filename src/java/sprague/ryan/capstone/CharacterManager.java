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
public class CharacterManager extends DBManager {
    private ArrayList<Character> characters = new ArrayList<>();
    private final DataSource dataSource;
    
    public CharacterManager(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    
    private Character charFromDB(ResultSet resultSet) throws SQLException {
        return new Character(
                resultSet.getInt("ID"),
                resultSet.getString("NAME"),
                resultSet.getString("GENDER"),
                resultSet.getString("RACE"),
                resultSet.getString("CHARCLASS"),
                resultSet.getString("ALIGNMENT"),
                resultSet.getInt("LEVEL"),
                resultSet.getInt("STRENGTH"),
                resultSet.getInt("DEXTERITY"),
                resultSet.getInt("CONSTITUTION"),
                resultSet.getInt("INTELLIGENCE"),
                resultSet.getInt("WISDOM"),
                resultSet.getInt("CHARISMA"),
                resultSet.getInt("HIT_DIE_NUM"),
                resultSet.getInt("HIT_DICE_SIDES"),
                resultSet.getInt("HEALTH"),
                resultSet.getInt("USERID"));
    }
    
    public Character charByID(int id) {
        Character character = null;
        
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        
        try {
            connection = dataSource.getConnection();
            statement = connection.prepareStatement("SELECT * FROM characters where id=?");
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                character = charFromDB(resultSet);
            }
        } catch(SQLException ex) {
            ex.printStackTrace();
        } finally {
            close(resultSet);
            close(statement);
            close(connection);
        }
        
        return character;
    }
    
    public Character charByName(String name) { // only for initial add of skills at level 1.
        Character character = null;
        
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        
        try {
            connection = dataSource.getConnection();
            statement = connection.prepareStatement("SELECT * FROM CHARACTERS WHERE NAME=?");
            statement.setString(1, name);
            resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                character = charFromDB(resultSet);
            }
        } catch(SQLException ex) {
            ex.printStackTrace();
        } finally {
            close(resultSet);
            close(statement);
            close(connection);
        }
        return character;
    }
    
    public List<Character> allCharsFromUser(int userID) {
        ArrayList<Character> characters = new ArrayList<>();
        
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        
        try {
            connection = dataSource.getConnection();
            statement = connection.prepareStatement("SELECT * FROM CHARACTERS WHERE USERID=?");
            statement.setInt(1, userID);
            resultSet = statement.executeQuery();
            
            while(resultSet.next()) {
                characters.add(charFromDB(resultSet));
            }
        } catch(SQLException ex) {
            ex.printStackTrace();
        } finally {
            close(resultSet);
            close(statement);
            close(connection);
        }
        
        return characters;
    }
//    public void addCharacter(Character newCharacter) {
//        for (Character character : characters) {
//            if (character.getName().equals(newCharacter.getName())) {
//                throw new IllegalArgumentException("duplicate character");
//            }
//        }
//        characters.add(newCharacter);
//    }
    
    void addCharacter(Character character, int userID) {
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            connection = dataSource.getConnection();
            statement = connection.prepareStatement("INSERT INTO CHARACTERS (NAME, RACE, GENDER, CHARCLASS, ALIGNMENT, LEVEL, HEALTH, HIT_DICE_SIDES, HIT_DIE_NUM, STRENGTH, DEXTERITY, CONSTITUTION, INTELLIGENCE, WISDOM, CHARISMA, USERID) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            
            statement.setString(1, character.getName());
            statement.setString(2, character.getRace());
            statement.setString(3, character.getGender());
            statement.setString(4, character.getCharClass());
            statement.setString(5, character.getAlignment());
            statement.setInt(6, character.getLevel());
            statement.setInt(7, character.getHitPoints());
            statement.setInt(8, character.getHitDiceSides());
            statement.setInt(9, character.getHitDiceNum());
            statement.setInt(10, character.getStrength());
            statement.setInt(11, character.getDexterity());
            statement.setInt(12, character.getConstitution());
            statement.setInt(13, character.getIntelligence());
            statement.setInt(14, character.getWisdom());
            statement.setInt(15, character.getCharisma());
            statement.setInt(16, userID);
            
            boolean ok = statement.execute();
            System.out.println("Ok? " + ok);
        } catch(SQLException ex) {
            ex.printStackTrace();
        } finally {
            close(statement);
            close(connection);
        }
    }
    
    public void deleteByID(int id) {
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            connection = dataSource.getConnection();
            statement = connection.prepareStatement("delete from characters where id=?");
            statement.setInt(1, id);
            
            boolean ok = statement.execute();
            System.out.println("DELETE OK? " + ok);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            close(statement);
            close(connection);
        }
    }
    
    public void updateChar(Character character) {
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            connection = dataSource.getConnection();
            statement = connection.prepareStatement("update characters set NAME=?, RACE=?, GENDER=?, CHARCLASS=?, ALIGNMENT=?, LEVEL=?, HEALTH=?, HIT_DICE_SIDES=?, HIT_DIE_NUM=?, STRENGTH=?, DEXTERITY=?, CONSTITUTION=?, INTELLIGENCE=?, WISDOM=?, CHARISMA=?, USERID=? WHERE ID=?");
            //statement.setInt(1, character.getId());
            statement.setString(1, character.getName());
            statement.setString(2, character.getRace());
            statement.setString(3, character.getGender());
            statement.setString(4, character.getCharClass());
            statement.setString(5, character.getAlignment());
            statement.setInt(6, character.getLevel());
            statement.setInt(7, character.getHitPoints());
            statement.setInt(8, character.getHitDiceSides());
            statement.setInt(9, character.getHitDiceNum());
            statement.setInt(10, character.getStrength());
            statement.setInt(11, character.getDexterity());
            statement.setInt(12, character.getConstitution());
            statement.setInt(13, character.getIntelligence());
            statement.setInt(14, character.getWisdom());
            statement.setInt(15, character.getCharisma());
            statement.setInt(16, character.getUserId());
            statement.setInt(17, character.getId());
            
            boolean ok = statement.execute();
            System.out.println("UPDATE OK? " + ok);
        } catch(SQLException ex) {
            ex.printStackTrace();
        } finally {
            close(statement);
            close(connection);
        }
    }
    
    public Character getCharacter(String name) {
        System.out.println("Characters is " + characters);
        Character foo = null;
        for (Character character : characters) {
            System.out.println("character is " + character.getName());
            if (character.getName().equals(name)) { foo = character; }
        }
        return foo;
    }
}
