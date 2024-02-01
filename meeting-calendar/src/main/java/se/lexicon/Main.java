package se.lexicon;

import se.lexicon.controller.CalendarController;
import se.lexicon.dao.MeetingCalendarDao;
import se.lexicon.dao.MeetingDao;
import se.lexicon.dao.UserDao;
import se.lexicon.dao.impl.MeetingCalendarDaoImpl;
import se.lexicon.dao.impl.MeetingDaoImpl;
import se.lexicon.dao.impl.UserDaoImpl;
import se.lexicon.dao.impl.db.MeetingCalendarMysqlConnection;
import se.lexicon.view.CalendarView;
import se.lexicon.view.CalenderConsoleUI;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {

        //Dependencies
        Connection connection = MeetingCalendarMysqlConnection.getConnection();
        UserDao userDao = new UserDaoImpl(connection);
        MeetingDao meetingDao = new MeetingDaoImpl(connection);
        MeetingCalendarDao meetingCalendarDao = new MeetingCalendarDaoImpl(connection);
        CalendarView calendarView = new CalenderConsoleUI();

        CalendarController controller = new CalendarController(calendarView, userDao, meetingCalendarDao);
        controller.run();




    }
}