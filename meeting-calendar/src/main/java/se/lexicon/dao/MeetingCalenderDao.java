package se.lexicon.dao;

import se.lexicon.model.MeetingCalendar;

import java.util.Collection;
import java.util.Optional;

public interface MeetingCalenderDao {

    MeetingCalendar createMeetingCalendar(String title, String username);

    Optional<MeetingCalendar> findById(int calenderId);

    Collection<MeetingCalendar> findByUsername(String username);

    Optional<MeetingCalendar> findByTitle(String title);

    boolean deleteCalendar(int calenderId);

    // Add methods for updating calendars as needed...


}
