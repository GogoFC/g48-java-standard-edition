package se.lexicon.model;

import java.time.LocalDateTime;

public class Meeting {

    private int id;
    private String title;
    private LocalDateTime startTime; // 2020-01-01 10:00
    private LocalDateTime endTime; // 2019-01-01 12:00
    private String description;
    private MeetingCalender calendar;

    // TODO Constructors - Chaining

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public String getDescription() {
        return description;
    }

    public MeetingCalender  getCalendar() {
        return calendar;
    }

    public void displayMeetingInfo(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Meeting Info:").append("\n");
        stringBuilder.append("Id ").append(id).append("\n");
        stringBuilder.append("Title ").append(title).append("\n");
        stringBuilder.append("StartTime ").append(startTime).append("\n");
        stringBuilder.append("EndTime ").append(endTime).append("\n");
        stringBuilder.append("Description ").append(description).append("\n");

        System.out.println(stringBuilder.toString());
    }


}
