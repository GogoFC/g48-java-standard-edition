package se.lexicon.dao;

import se.lexicon.model.Meeting;

import java.util.Collection;
import java.util.Optional;

public interface MeetingDao {

    // TODO - Write Queries to perform the following behaviors
    //  Implement SQL query to insert a new meeting into the database
    String CREATE_MEETING_SQL = "INSERT INTO MEETINGS (TITLE, START_TIME, END_TIME, _DESCRIPTION) VALUES (?,?,?,?)";

    // TODO: Implement SQL query to find a meeting by its ID in the database
    String FIND_BY_ID_SQL = "SELECT * FROM MEETINGS WHERE ID = ?";

    // TODO: Implement SQL query to find all meetings by calendar ID in the database
    String FIND_ALL_BY_CALENDAR_ID_SQL = " SELECT * FROM MEETINGS WHERE CALENDAR_ID = ?";

    // TODO: Implement SQL query to delete a meeting by its ID from the database
    String DELETE_MEETING_SQL = "DELETE FROM MEETINGS WHERE ID = ?";


    Meeting createMeeting(Meeting meeting);

    Optional<Meeting> findById(int meetingId);

    Collection<Meeting> findAllMeetingsByCalenderId(int calenderId);

    //More Find Methods

    // Add methods for updating meeting as needed...

    boolean deleteMeeting(int meetingId);


}
