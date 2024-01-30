package se.lexicon.dao;

import se.lexicon.exception.AuthorizationFailedException;
import se.lexicon.exception.UserExpiredException;
import se.lexicon.model.User;

import java.util.Optional;

public interface UserDao {

    // TODO: Implement SQL query to insert a new user into the database
    String CREATE_USER_SQL = "";

    // TODO: Implement SQL query to find a user by username in the database
    String FIND_BY_USERNAME_SQL = "";

    // TODO: Implement SQL query to find User by username and password in database
    String FIND_BY_USERNAME_AND_PASSWORD = "";


    User createUser(String username);

    Optional<User> findByUsername(String username);

    boolean authenticate(User user) throws AuthorizationFailedException, UserExpiredException;

    // Add methods for updating password as needed...


}
