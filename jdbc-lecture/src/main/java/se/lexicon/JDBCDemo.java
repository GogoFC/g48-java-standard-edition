package se.lexicon;

import java.sql.*;

public class JDBCDemo {


    public static void main(String[] args) {

        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/school_db", "root", "1234");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT student_id, first_name, last_name FROM students");
            //executeQuery used for SELECT queries.
            // executeUpdate used for INSERT, DELETE, UPDATE
//            int rowsAffected = statement.executeUpdate

            while (resultSet.next()){
                //ColumnIndex
//                int student_id = resultSet.getInt(1);
//                String firstName = resultSet.getString(2);
//                String lastName = resultSet.getString(3);

                //ColumnLabel
                int student_id = resultSet.getInt("student_id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");

                System.out.print("student_id = " + student_id);
                System.out.print(", firstName = " + firstName);
                System.out.print(", lastName = " + lastName);
                System.out.println();
            }


        }catch (SQLException e){
            e.printStackTrace();
        }



    }
}
