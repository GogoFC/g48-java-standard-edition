package se.lexicon.controller;

import se.lexicon.dao.MeetingCalendarDao;
import se.lexicon.dao.UserDao;
import se.lexicon.exception.CalendarExceptionHandler;
import se.lexicon.model.MeetingCalendar;
import se.lexicon.model.User;
import se.lexicon.view.CalendarView;


public class CalendarController {
    private CalendarView view;
    private UserDao userDao;
    private MeetingCalendarDao meetingCalendarDao;

    private boolean isLoggedIn;
    private String username;

    public CalendarController(CalendarView view, UserDao userDao, MeetingCalendarDao meetingCalendarDao) {
        this.view = view;
        this.userDao = userDao;
        this.meetingCalendarDao = meetingCalendarDao;
    }

    public void run() {

        while (true) {
            view.displayMenu();
            int choice = Integer.parseInt(view.promoteString());

            switch (choice) {
                case 0:
                    register();
                    break;
                case 1:
                    login();
                    break;
                case 2:
                    createCalendar();
                    break;
                case 3:
                    //TODO - Add Meeting
                    break;
                case 4:
                    //TODO - Add Delete Meeting
                    break;
                case 5:
                    //TODO - Display Calendar Meeting
                    break;
                case 6:
                    //TODO - Logout
                    break;
                case 7:
                    System.exit(0);
                    break;
                default:
                    view.displayWarningMessage("Invalid choice. Please a select a valid Option");
            }

        }
    }

    private void register() {
        String username = view.promoteUserFormRegister();
        User createdUser = userDao.createUser(username);
        view.displayUser(createdUser);
    }

    private void login() {
        User user = view.promoteUserFormSignIn();

        try {
            isLoggedIn = userDao.authenticate(user);
            username = user.getUsername();
            view.displaySuccessMessage("Login Successful.");

        } catch (Exception e) {
            CalendarExceptionHandler.handleException(e);
        }
    }

    private void createCalendar() {
        if (!isLoggedIn) {
            view.displayWarningMessage("You need to login first");
        }

        String calendarTitle = view.promoteCalenderForm();
        MeetingCalendar meetingCalendar = meetingCalendarDao.createMeetingCalendar(calendarTitle, username);
        view.displaySuccessMessage("Calender created Successfully");
        view.displayCalendar(meetingCalendar);
    }
}
