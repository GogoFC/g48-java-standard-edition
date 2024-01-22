package se.lexicon;

import se.lexicon.db.MySQLConnection;
import se.lexicon.model.Student;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JDBCExample {

    public static void main(String[] args) {
        ex2();
    }

    // get All student data
    public static void ex1() {

        List<Student> students = new ArrayList<>();

        try {
            Connection connection = MySQLConnection.getConnection();

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM students");

            while (resultSet.next()) {
                //ColumnLabel
                int student_id = resultSet.getInt("student_id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                int age = resultSet.getInt("age");
                String email = resultSet.getString("email");
                LocalDate createDate = resultSet.getDate("create_date").toLocalDate();

                Student student = new Student(student_id, firstName, lastName, age, email, createDate);
                students.add(student);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        students.forEach(System.out::println);
    }


    //Get Student by Student_id
    public static void ex2() {
        // Step 1 : Create DB Connection
        // Step 2 : Create a PreparedStatement
        // Step 3 : Execute The Query
        // Step 4 : Get Data From ResultSet and convert data to student Object.
        // Step 5 : Close all the resources (try-with-recourse)

        int findStudentById = 3;
        Student student = null;

        try (
                Connection connection = MySQLConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM students WHERE student_id = ?");
        ) {

            preparedStatement.setInt(1, findStudentById);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {

                if (resultSet.next()) {
                    int student_id = resultSet.getInt("student_id");
                    String firstName = resultSet.getString("first_name");
                    String lastName = resultSet.getString("last_name");
                    int age = resultSet.getInt("age");
                    String email = resultSet.getString("email");
                    LocalDate createDate = resultSet.getDate("create_date").toLocalDate();

                    student = new Student(student_id, firstName, lastName, age, email, createDate);
                }

            }

        } catch (SQLException e) {
            e.printStackTrace();
        } // Will Close All Resources -> ResultSet, PreparedStatement, connection

        System.out.println(student);

    }
}
