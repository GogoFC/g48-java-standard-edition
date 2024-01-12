package se.lexicon;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class ExceptionDemo {

    //NOT ALLOWED TO ADD THROW CLAUSE ON MAIN METHOD
    public static void main(String[] args) {

        //Checked Exception
        /*Path filepath = Paths.get("folder/lastnames.txt");
        BufferedReader reader = Files.newBufferedReader(filepath);*/

        //Unchecked Exception
        /*int[] numbers = {1,2,3,4,5};
        System.out.println(numbers[10]);*/


/*        try {
            ex6();
        } catch (InsufficientFundsException e) {
            throw new RuntimeException(e);
        }*/


        ex10();

    }

    //Runtime Exception
    //Catching an un-checked-exception
    public static void ex1() {
        while (true) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter a Number: ");

            try {
                int number = Integer.parseInt(scanner.nextLine());

                if (number <= 0) {
                    System.out.println("try again - number should not be zero or a negative number");
                } else {
                    System.out.println("Entered number: " + number);
                }

            } catch (NumberFormatException e) {
                System.out.println("Try again - Number is not valid");
            }
        }
    }

    //Catching an unchecked exception
    public static void ex2() {

        while (true) {
            Scanner scanner = new Scanner(System.in);

            try {
                System.out.println("Enter your birthdate: "); //YYYY-MM-DD
                LocalDate date = LocalDate.parse(scanner.nextLine());
                System.out.println("Your birthdate is: " + date);

            } catch (DateTimeParseException e) {
                System.out.println("Try Again - Date Format is not valid - You entered: " + e.getParsedString());
            }
        }


    }

    //Compile time Exceptions
    //Catching checked-exceptions + Read File using NIO
    public static void ex3() {
        Path filePath = Paths.get("exceptions-files-lecture/folder/lastnames.txt");

        try {
            BufferedReader reader = Files.newBufferedReader(filePath);

//            List<String> names = reader.lines().toList();
//            names.forEach(System.out::println);

            Stream<String> lines = Files.lines(filePath);

            lines.forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // Catching Checked Exceptions with multiple catch Blocks.
    //Copy an Image to another folder using NIO
    public static void ex4() {

        Path sourceFile = Paths.get("exceptions-files-lecture/source/Java-Development-Kit-Horizontal.png");
        Path destinationPath = Paths.get("exceptions-files-lecture/destination");

        try {
            Files.copy(

                    sourceFile,
                    destinationPath.resolve(sourceFile.getFileName()),
                    StandardCopyOption.REPLACE_EXISTING);


        } catch (NoSuchFileException e) {
            System.out.println("File Path does not exist");
        } catch (FileAlreadyExistsException e) {
            System.out.println("File Already Exists");
        } catch (IOException e) {
            System.out.println("IOException: " + e);
        }
        System.out.println("DONE");

    }


    //Throw an exception by using the ´throw´ keyword
    public static void ex5() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number 1 : ");
        int number1 = scanner.nextInt();
        System.out.println("Enter number 2 : ");
        int number2 = scanner.nextInt();

        if (number2 == 0) {
            //Throw Exception
            throw new ArithmeticException("number 2 should not be Zero.");
        }

        int result = number1 / number2;
        System.out.println("result = " + result);

    }

    //Throw our own  Runtime-exception
    public static void ex6() throws InsufficientFundsException {

        double balance = 100;
        double amount = 25;
        System.out.println("Operation - Withdraw");
        System.out.println("Current balance: " + balance);
        System.out.println("Amount: " + amount);

        if (amount > balance) {
            throw new InsufficientFundsException(balance, amount, "Balance is insufficient... 😢");
        }

        balance = balance - amount;


        System.out.println("Current balance is: " + balance);

    }

    // throw: is used to throw an exception or exceptional event(propagate the exception to a higher-lever).
    // throws: is used to indicate that a method might throw one or more exceptions

    public static void ex7() {
        BufferedWriter writer = null;
        try {
            writer = Files.newBufferedWriter(
                    Path.of("exceptions-files-lecture/folder/TextHere.txt"),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND
            );

            writer.append("Hello Again");
            writer.newLine();

        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            //finally-block is always executed.
            try {
                writer.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void ex8() {
        try (
                BufferedWriter writer = Files.newBufferedWriter(
                        Path.of("exceptions-files-lecture/folder/TextHere.txt"),
                        StandardOpenOption.CREATE,
                        StandardOpenOption.APPEND)
        ) {

            writer.append("Will close after.");
            writer.newLine();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }//it will close the resources for us.

    }


    //JSON File (Read / Write JSON file using Jackson)
    public static void ex9(){

        List<Person> people = new ArrayList<>();
        people.add(new Person("Alice", 30));
        people.add(new Person("Bob", 25));
        people.add(new Person("Charles", 35));

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        //Do more configurations here...

        File file = new File("exceptions-files-lecture/folder/people.json");

        try {
            // Serialize the list to JSON File
            objectMapper.writeValue(file,people);
            System.out.println("People data saved to the file.");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void ex10(){
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File("exceptions-files-lecture/folder/people.json");

        List<Person> personList = null;
        try {
            // Deserialize the JSON file to List of Person
            personList = objectMapper.readValue(file, new TypeReference<List<Person>>() {
            });
            System.out.println("People data read from the file.");

            personList.forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}