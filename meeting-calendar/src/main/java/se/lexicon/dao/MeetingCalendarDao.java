package se.lexicon.dao;

import se.lexicon.model.MeetingCalendar;

import java.util.Collection;
import java.util.Optional;

public interface MeetingCalendarDao {

    String CREATE_MEETING_CALENDAR_SQL = "INSERT INTO meeting_calendars (USERNAME, TITLE) VALUES(?,?)";

    String FIND_BY_ID_SQL = "SELECT * FROM meeting_calendars WHERE ID=?";

    String FIND_BY_USERNAME_SQL ="SELECT * FROM meeting_calendars WHERE USERNAME = ?";

    String FIND_BY_TITLE_SQL = "SELECT * FROM meeting_calendars WHERE TITLE = ?";

    String DELETE_CALENDAR_SQL = "DELETE FROM meeting_calendars WHERE ID = ?";


    MeetingCalendar createMeetingCalendar(String title, String username);

    Optional<MeetingCalendar> findById(int calenderId);

    Collection<MeetingCalendar> findByUsername(String username);

    Optional<MeetingCalendar> findByTitle(String title);

    boolean deleteCalendar(int calenderId);

    // Add methods for updating calendars as needed...


}
