import org.mindrot.jbcrypt.BCrypt;

public class Encryption {

    public String encryptPassword(String password)
    {
        return BCrypt.hashpw(password, BCrypt.gensalt(12));

    }

    public boolean checkPassword(String plainPassword, String encryptedPassword)
    {
        return BCrypt.checkpw(plainPassword, encryptedPassword);
    }
}
