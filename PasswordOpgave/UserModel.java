import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public class UserModel {
    private static UserModel instance;

    private UserDao userDao;

    private ObservableList<User> allUsers;

    private User user;

    public UserModel()
    {
        userDao = new UserDao();
        allUsers = FXCollections.observableArrayList();
        try {
            allUsers.addAll(userDao.getAllUsers());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static UserModel getinstance()
    {
        if(instance == null)
        {
            instance = new UserModel();
        }
        return instance;
    }

    public ObservableList<User> getObservableUsers()
    {
        return allUsers;
    }

    public User createUser(User NewUser)
    {
        User user = null;
        try {
            user = userDao.createUser(NewUser);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        allUsers.add(user);
        return user;
    }
}
