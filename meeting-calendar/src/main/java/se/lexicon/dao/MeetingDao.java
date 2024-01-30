package se.lexicon.dao;

import se.lexicon.model.Meeting;

import java.util.Collection;
import java.util.Optional;

public interface MeetingDao {


    //Meeting - Update, Delete, Create, Find

    Meeting createMeeting(Meeting meeting);

    Optional<Meeting> findById(int id);

    Collection<Meeting> findAllMeetingsByCalenderId(int calenderId);

    //More Find Methods

    // Add methods for updating meeting as needed...

    boolean deleteMeeting(int meetingId);


}
