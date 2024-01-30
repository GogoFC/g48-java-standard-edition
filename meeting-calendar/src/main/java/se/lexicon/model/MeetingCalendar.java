package se.lexicon.model;

import java.util.ArrayList;
import java.util.List;

public class MeetingCalendar {
    private int id;
    private String username;
    private String title;
    private List<Meeting> meetings;


    // TODO Constructors

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getTitle() {
        return title;
    }

    public List<Meeting> getMeetings() {
        if (meetings == null) meetings = new ArrayList<>();
        return meetings;
    }

    public void addMeeting(Meeting meeting) {
        if (meetings == null) meetings = new ArrayList<>();
        meetings.add(meeting);
    }

    public void removeMeeting(Meeting meeting) {
        if (meetings == null) throw new IllegalArgumentException("Meeting list is null.");
        if (meeting == null) throw new IllegalArgumentException("Meeting Data is null.");
        meetings.remove(meeting);
    }

    public void displayMeetingCalendarInfo(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Calendar Info:").append("\n");
        stringBuilder.append("Id ").append(id).append("\n");
        stringBuilder.append("Title ").append(title).append("\n");
        stringBuilder.append("Username ").append(username).append("\n");

        System.out.println(stringBuilder.toString());
    }

}
