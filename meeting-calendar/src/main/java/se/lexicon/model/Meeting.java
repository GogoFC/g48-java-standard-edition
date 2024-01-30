package se.lexicon.model;

public class Meeting {

    private int id;
    private String title;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String description;
    private MeetingCalendar calendar;

    public Meeting(String title, LocalDateTime startTime, LocalDateTime endTime, String description) {
                this.title = title;
        this.startTime = startTime;
        this.endTime = endTime;
        this.description = description;
        this.calendar = calendar;
        setId(id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
        // TODO implement sequential id
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

    public MeetingCalendar getCalendar() {
        return calendar;
    }
}
