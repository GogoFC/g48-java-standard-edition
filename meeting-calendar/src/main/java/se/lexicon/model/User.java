package se.lexicon.model;

import java.security.SecureRandom;
import java.util.Random;

public class User {

   private final String username;
   private String password;

    public User(String username) {
        this.username = username;
        newPassword();
    }


    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void newPassword(){
        this.password = generateRandomPassword();
    }

    private String generateRandomPassword(){
        String allowedCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        int passwordLength = 10;
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new SecureRandom();

        for (int i = 0; i < passwordLength; i++) {
            int randomIndex = random.nextInt(allowedCharacters.length());
            char randomChar = allowedCharacters.charAt(randomIndex);
            stringBuilder.append(randomChar);
        }

        return stringBuilder.toString();
    }

    public void displayUserInfo(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("User Info:").append("\n");
        stringBuilder.append("username ").append(username).append("\n");
        stringBuilder.append("password ").append(password).append("\n");

        System.out.println(stringBuilder.toString());
    }


}
