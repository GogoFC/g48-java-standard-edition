package se.lexicon.view;

import se.lexicon.model.Meeting;
import se.lexicon.model.MeetingCalendar;
import se.lexicon.model.User;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class CalenderConsoleUI implements CalendarView {

    @Override
    public void displayUser(User user) {
        System.out.println(user.UserInfo());
        System.out.println("------------------------");
    }

    @Override
    public void displayCalendar(MeetingCalendar meetingCalendar) {
        System.out.println(meetingCalendar.MeetingCalendarInfo());

    }

    @Override
    public void displayMeetings(List<Meeting> meetingList) {
        if (meetingList.isEmpty()) {
            System.out.println("Mo Meeting in this Calendar");
        } else {
            System.out.println("Meetings in this calendar");
            meetingList.forEach(meeting -> {
                System.out.println(meeting.MeetingInfo());
                System.out.println();
            });
        }
    }

    @Override
    public String promoteString() {
        Scanner scanner = new Scanner(System.in);
        String option = scanner.nextLine();
        return option;
    }

    @Override
    public Meeting promoteMeetingForm() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a Title: ");
        String title = scanner.nextLine();

        System.out.println("Enter a Start date & time (yyyy-MM-dd HH:mm): ");
        String start = scanner.nextLine();
        System.out.println("Enter a End date & time (yyyy-MM-dd HH:mm): ");
        String end = scanner.nextLine();

        System.out.println("Enter a Meeting Description : ");
        String description = scanner.nextLine();

        LocalDateTime startDateTime = LocalDateTime.parse(start, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        LocalDateTime endDateTime = LocalDateTime.parse(end, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        return new Meeting(title, startDateTime, endDateTime, description);
    }

    @Override
    public String promoteCalenderForm() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a title: ");
        String title = scanner.nextLine();
        return title;
    }

    @Override
    public User promoteUserFormSignIn() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a username: ");
        String username = scanner.nextLine();
        System.out.println("Enter a password: ");
        String password = scanner.nextLine();
        return new User(username, password);
    }

    @Override
    public String promoteUserFormRegister() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a username: ");
        String username = scanner.nextLine();
        return username;
    }
}
