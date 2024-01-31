package se.lexicon;

import se.lexicon.dao.UserDao;
import se.lexicon.dao.impl.UserDaoImpl;
import se.lexicon.dao.impl.db.MeetingCalendarMysqlConnection;
import se.lexicon.exception.AuthorizationFailedException;
import se.lexicon.exception.UserExpiredException;
import se.lexicon.model.User;

import java.sql.Connection;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {

        Connection connection = MeetingCalendarMysqlConnection.getConnection();

        UserDao userDao = new UserDaoImpl(connection);

//        User simon = userDao.createUser("simon-lexicon");
        Optional<User> simon = userDao.findByUsername("simon-lexicon");

        Optional<User> alice = userDao.findByUsername("Alice");

        simon.ifPresentOrElse(User::displayUserInfo,()-> System.out.println("There is no user found"));
        alice.ifPresentOrElse(User::displayUserInfo,()-> System.out.println("There is no user found"));

        try {
            boolean isAuthenticated = userDao.authenticate(alice.get());

            System.out.println(isAuthenticated);

        } catch (UserExpiredException | AuthorizationFailedException e) {
            throw new RuntimeException(e);
        }


    }
}