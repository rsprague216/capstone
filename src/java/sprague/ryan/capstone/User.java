package sprague.ryan.capstone;

import java.util.Random;

/**
 * @author Ryan Sprague
 */
public class User {
    private final String FIRSTNAME, LASTNAME, EMAIL, USERNAME, PASSWORD_HASH;
    private byte[] SALT = new byte[4];
    private int userID;
    
    public User(String fName, String lName, String email, String username, String password) {
        this.FIRSTNAME = fName;
        this.LASTNAME = lName;
        this.EMAIL = email;
        this.USERNAME = username;
        generateSalt();
        this.PASSWORD_HASH = PasswordHash.hashPassword(password, SALT);
    }
    
//    public User(String username, String password, int id) {
//        this.NAME = username;
//        generateSalt();
//        this.PASSWORD_HASH = PasswordHash.hashPassword(password, SALT);
//        this.userID = id;
//    }
    
    public User(String fName, String lName, String email, String username, String password, byte[] SALT, int id) {
        this.FIRSTNAME = fName;
        this.LASTNAME = lName;
        this.EMAIL = email;
        this.USERNAME = username;
        this.SALT = SALT;
        this.PASSWORD_HASH = password;
        this.userID = id;
    }
    
    public String getFirstName()      { return this.FIRSTNAME; }
    public String getLastName()       { return this.LASTNAME; }
    public String getEmail()          { return this.EMAIL; }
    public String getUserName()       { return this.USERNAME; }
    public String getHashedPassword() { return this.PASSWORD_HASH; }
    public byte[] getSalt()           { return this.SALT; }
    public int    getID()             { return this.userID; }
    
    public boolean checkPassword(String passwordToTest) {
        System.out.println(PasswordHash.hashPassword(passwordToTest, this.SALT));
        return this.PASSWORD_HASH.equals(PasswordHash.hashPassword(passwordToTest, this.SALT));
    }
    
    private byte[] generateSalt() {
        Random random = new Random();
        random.nextBytes(SALT);
        return SALT;
    }
}
