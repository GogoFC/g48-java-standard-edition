package se.lexicon;

public class Customer {

    private String fullName;
    private String email;
    private String phoneNumber;

    //.. more fields


    public Customer (String fullName, String email, String phoneNumber){
        this.fullName = fullName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    //GETTERS & SETTERS

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        if (fullName == null) throw new IllegalArgumentException("FullName can not be null!");
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (fullName == null) throw new IllegalArgumentException("Name can not be null!");
        //Validate is it formatted as an Email?
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (fullName == null) throw new IllegalArgumentException("Name can not be null!");
        // Validate is it a real phone number?
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Customer{");
        sb.append("fullName='").append(fullName).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", phoneNumber='").append(phoneNumber).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
