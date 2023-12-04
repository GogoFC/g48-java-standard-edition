package se.lexicon;

public class Person {

    private String firstName;
    private String lastName;
    private String ssn;
    private int age;
    private boolean status;


    //Constructor
    // Purpose: is a special builder method
    // Used For: Initialize the object's state when an instance of a class is created.
    // Constructors ensure that objects are created in a consistent and valid initial state

    public Person (String firstName, String lastName, String ssn, int age, boolean status){
        this(firstName, lastName, ssn, age);
        this.status = status;

    }
    public Person (String firstName, String lastName, String ssn, int age){
        this(firstName, lastName, ssn);
        setAge(age);
    }
    public Person (String firstName, String lastName, String ssn){
        setFirstName(firstName);
        setLastName(lastName);
        setSsn(ssn);
    }



    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName == null) throw new IllegalArgumentException("FirstName was null!");
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName == null) throw new IllegalArgumentException("lastName was null!");
        this.lastName = lastName;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        if (ssn == null) throw new IllegalArgumentException("ssn was null!");
        //... YYYYMMDD-NNNN
        this.ssn = ssn;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isStatus() {
        return status;
    }

    public String getPersonInfo(){
        return "Person { Name: " + firstName + " " + lastName + ", SSN: " + ssn + ", Age: " + age + " }";
    }
}
