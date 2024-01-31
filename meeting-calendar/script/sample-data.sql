-- Insert statements for USERS
INSERT INTO USERS (USERNAME, _PASSWORD, EXPIRED)
VALUES
    ('John', '4f9s5f9s', 0),
    ('Jane', '6d8sh9ds', 0),
    ('Alice', '8d9sh9d8', 0),
    ('Bob', 'f98jh48d', 0),
    ('Charlie', 'ed8fh45d', 0);

-- Insert statements for MEETING_CALENDARS
INSERT INTO MEETING_CALENDARS (USERNAME, TITLE)
VALUES
    ('John', 'John\'s Calendar'),
    ('Jane', 'Jane\'s Calendar'),
    ('Alice', 'Alice\'s Calendar');

-- Insert statements for MEETINGS
INSERT INTO MEETINGS (TITLE, START_TIME, END_TIME, _DESCRIPTION, CALENDAR_ID)
VALUES
    ('Java Lesson', '2023-02-01 10:00:00', '2023-02-01 11:00:00', 'Initial session to discuss Java fundamentals', 3),
    ('Web Development Strategy', '2023-02-02 14:00:00', '2023-02-02 15:30:00', 'Review and discuss proposed HTML, CSS, JavaScript strategies for the upcoming week', 2),
    ('Monthly Project Review', '2023-02-03 09:00:00', '2023-02-03 10:00:00', 'Monthly project performance and result review', 1),
    ('Client Meet (Mock)', '2023-02-04 15:00:00', '2023-02-04 16:00:00','Mock meeting with client to discuss project requirements', 3),
    ('Team Study Session', '2023-02-05 11:00:00', '2023-02-05 12:00:00', 'Regular team meet to discuss study progress', 1);