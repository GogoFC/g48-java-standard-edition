package se.lexicon.dao.impl;

import se.lexicon.dao.UserDao;
import se.lexicon.exception.AuthorizationFailedException;
import se.lexicon.exception.MySQLException;
import se.lexicon.exception.UserExpiredException;
import se.lexicon.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

//DAO FOR ACCESSING DATABASE
// DAO IS RESPONSIBLE FOR MANAGING DATA
// CREATE FINDING UPDATING DELETING (CRUD)
public class UserDaoImpl implements UserDao {

    Connection connection;


    public UserDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public User createUser(String username) {
        System.out.println("inside Create Method");


        //INSERT INTO USERS (USERNAME, _PASSWORD) VALUES(?, ?)
        try(PreparedStatement preparedStatement = connection.prepareStatement(UserDao.CREATE_USER_SQL)){

            User user = new User(username);
            preparedStatement.setString(1,user.getUsername());
            preparedStatement.setString(2,user.getPassword());
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected == 0){
                throw new MySQLException("Creating user Failed, no row Affected");
            }

            System.out.println("User Created Successfully");
            return user;

        }catch (SQLException e){
            throw new MySQLException("Error occurred while creating user: " + username, e);
        }
    }

    @Override
    public Optional<User> findByUsername(String username) {

        //SELECT * FROM USERS WHERE USERNAME = ?
        try(PreparedStatement preparedStatement = connection.prepareStatement(UserDao.FIND_BY_USERNAME_SQL)){

            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
                String foundUserName = resultSet.getString(1);
                String foundPassword = resultSet.getString(2);
                boolean foundExpired = resultSet.getBoolean(3);
//                                System.out.println(resultSet.getTimestamp(4).toString());

                User user = new User(foundUserName,foundPassword,foundExpired);
                return Optional.of(user);
            }

        }catch (SQLException e){
            throw new MySQLException("Error occurred while finding user by username: " + username, e);
        }
        return Optional.empty();
    }

    @Override
    public boolean authenticate(User user) throws AuthorizationFailedException, UserExpiredException {
//        SELECT * FROM USERS WHERE USERNAME = ? AND _PASSWORD = ?
        try(PreparedStatement preparedStatement = connection.prepareStatement(UserDao.FIND_BY_USERNAME_AND_PASSWORD)){

            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){

                boolean isExpired = resultSet.getBoolean("EXPIRED");
                if (isExpired){
                    throw new UserExpiredException("User is Expired.");
                }

            }else {
                throw new AuthorizationFailedException("Authorization Failed. Invalid Credentials");
            }

            return true;

        }catch (SQLException e){
            throw new MySQLException("Error occurred while authenticating user by username: " + user.getUsername(), e);
        }
    }
}
