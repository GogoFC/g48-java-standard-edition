package se.lexicon;

import se.lexicon.dao.UserDao;
import se.lexicon.dao.impl.UserDaoImpl;
import se.lexicon.dao.impl.db.MeetingCalendarMysqlConnection;
import se.lexicon.exception.CalendarExceptionHandler;
import se.lexicon.model.User;
import se.lexicon.view.CalendarView;
import se.lexicon.view.CalenderConsoleUI;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {

        Connection connection = MeetingCalendarMysqlConnection.getConnection();
        UserDao userDao = new UserDaoImpl(connection);
        CalendarView calendarView = new CalenderConsoleUI();

        User user = calendarView.promoteUserFormSignIn();

        try {
            boolean isAuthenticated = userDao.authenticate(user);

            if (isAuthenticated){
                calendarView.displaySuccessMessage("Login Success.");
            }

            calendarView.displayUser(user);


        } catch (Exception e) {
            CalendarExceptionHandler.handleException(e);
        }

    }
}