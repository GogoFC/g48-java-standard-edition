package se.lexicon.dao;

import se.lexicon.exception.AuthorizationFailedException;
import se.lexicon.exception.UserExpiredException;
import se.lexicon.model.User;

import java.util.Optional;

public interface UserDao {

    String CREATE_USER_SQL = "INSERT INTO USERS (USERNAME, _PASSWORD) VALUES(?, ?)";

    String FIND_BY_USERNAME_SQL = "SELECT * FROM USERS WHERE USERNAME = ?";

    String FIND_BY_USERNAME_AND_PASSWORD = "SELECT * FROM USERS WHERE USERNAME = ? AND _PASSWORD = ?";


    User createUser(String username);

    Optional<User> findByUsername(String username);

    boolean authenticate(User user) throws AuthorizationFailedException, UserExpiredException;

    // Add methods for updating password as needed...


}
