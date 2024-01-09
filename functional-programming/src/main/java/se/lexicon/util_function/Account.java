package se.lexicon.util_function;

import java.time.LocalDate;

public class Account {

    private String username;
    private String password;
    private Role role;
    private LocalDate registrationDate;
    private boolean status;

    public Account(String username, Role role) {
        this.username = username;
        this.role = role;
        this.status = false;
        this.registrationDate = LocalDate.now();
        //Todo SETPASSWORD
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public boolean isStatus() {
        return status;
    }

    public void activate() {
        this.status = true;
    }
    public void deactivate() {
        this.status = false;
    }

    @Override
    public String toString() {
        return "Account{" +
                "username='" + username + '\'' +
                ", role=" + role +
                ", registrationDate=" + registrationDate +
                ", status=" + status +
                '}';
    }
}
