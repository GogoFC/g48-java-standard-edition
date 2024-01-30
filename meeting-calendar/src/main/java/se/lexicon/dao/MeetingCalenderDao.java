package se.lexicon.dao;

import se.lexicon.model.MeetingCalendar;

import java.util.Collection;
import java.util.Optional;

public interface MeetingCalenderDao {

    // TODO - Write Queries to perform the following behaviors
    //  Write SQL query to create a new meeting calendar in the database
    String CREATE_MEETING_CALENDAR_SQL = "";
    // TODO: Write SQL query to find a meeting calendar by its ID in the database
    String FIND_BY_ID_SQL = "";

    // TODO: Write SQL query to find all meeting calendars belonging to a specific username in the database
    String FIND_BY_USERNAME_SQL = "";

    // TODO: Write SQL query to find a meeting calendar by its title in the database
    String FIND_BY_TITLE_SQL = "";

    // TODO: Write SQL query to delete a meeting calendar by its ID from the database
    String DELETE_CALENDAR_SQL = "";


    MeetingCalendar createMeetingCalendar(String title, String username);

    Optional<MeetingCalendar> findById(int calenderId);

    Collection<MeetingCalendar> findByUsername(String username);

    Optional<MeetingCalendar> findByTitle(String title);

    boolean deleteCalendar(int calenderId);

    // Add methods for updating calendars as needed...


}
