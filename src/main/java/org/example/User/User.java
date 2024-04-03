package org.example.User;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class User {
    private String name;
    private String email;
    private final byte[] password;

    public User(String name, String email, String password) throws NoSuchAlgorithmException {
        if (name != null && !name.trim().isEmpty())
            this.name = name;
        else
            throw new IllegalArgumentException();

        if (email != null && !email.trim().isEmpty())
            this.email = email;
        else
            throw new IllegalArgumentException();

        MessageDigest md =  MessageDigest.getInstance("MD5");
        this.password = md.digest(password.getBytes(StandardCharsets.UTF_8));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public byte[] getPassword() {
        return password.clone();
    }
}
