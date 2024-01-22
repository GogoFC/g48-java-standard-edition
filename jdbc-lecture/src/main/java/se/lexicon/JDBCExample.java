package se.lexicon;

import se.lexicon.model.Student;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JDBCExample {

    public static void main(String[] args) {
        ex1();
    }

    // get All student data
    public static void ex1(){

        List<Student> students = new ArrayList<>();

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/school_db", "root", "1234");

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM students");

            while(resultSet.next()){
                //ColumnLabel
                int student_id = resultSet.getInt("student_id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                int age = resultSet.getInt("age");
                String email = resultSet.getString("email");
                LocalDate createDate = resultSet.getDate("create_date").toLocalDate();

                Student student = new Student(student_id,firstName,lastName,age,email,createDate);
                students.add(student);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        students.forEach(System.out::println);
    }
}
