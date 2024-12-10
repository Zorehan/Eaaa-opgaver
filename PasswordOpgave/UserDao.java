import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    private DatabaseConnector databaseConnector;

    public UserDao()
    {
        databaseConnector = new DatabaseConnector();

    }

    public List<User> getAllUsers() throws SQLException {
        ArrayList<User> allUsers = new ArrayList<>();
        try(Connection conn = databaseConnector.getConnection();
            Statement stmt = conn.createStatement())
        {
            String sql = "SELECT * FROM dbo.Users;";
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next())
            {
                String username = rs.getString("username");
                String password = rs.getString("password");

                User user = new User(username,password);
                allUsers.add(user);
            }
        }
        return allUsers;
    }

    public User createUser(User user) throws SQLException {
        String sql = "INSERT INTO dbo.Users (username, password) VALUES(?,?);";
        try(Connection conn = databaseConnector.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
        {
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());

            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();

            User createdUser = new User(user.getUsername(), user.getPassword());
            return createdUser;
        }
    }
}
