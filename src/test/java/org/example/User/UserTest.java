package org.example.User;

import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    public void testUserCreation() throws NoSuchAlgorithmException {
        String name = "John Doe";
        String email = "john.doe@example.com";
        String password = "secret";

        User user = new User(name, email, password);

        assertEquals(name, user.getName());
        assertEquals(email, user.getEmail());
        assertNotNull(user.getPassword());
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "   "})
    public void testUserCreationWithNameError(String invalidName) {
        String email = "john.doe@example.com";
        String password = "secret";

        assertThrows(IllegalArgumentException.class, () -> new User(invalidName, email, password));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "   "})
    public void testUserCreationWithEmailError(String invalidEmail) {
        String name = "John Doe";
        String password = "secret";

        assertThrows(IllegalArgumentException.class, () -> new User(name, invalidEmail, password));
    }

    @Test
    public void testPasswordHashing() throws NoSuchAlgorithmException {
        String password = "secret";
        User user = new User("John Doe", "john.doe@example.com", password);

        assertNotEquals(password, new String(user.getPassword(), StandardCharsets.UTF_8));
    }

    @Test
    public void testGetterAndSetters() throws NoSuchAlgorithmException {
        String name = "Jane Doe";
        String email = "jane.doe@example.com";
        String password = "secret";

        User user = new User(name, email, password);

        String newName = "New Name";
        String newEmail = "new.email@example.com";

        user.setName(newName);
        user.setEmail(newEmail);

        assertEquals(newName, user.getName());
        assertEquals(newEmail, user.getEmail());
    }

    @Test
    public void testGetPassword_ReturnsCopy() throws NoSuchAlgorithmException {
        String password = "secret";
        User user = new User("John Doe", "john.doe@example.com", password);

        byte[] passwordHash = user.getPassword();
        passwordHash[0] = (byte) 123;

        assertNotEquals(passwordHash[0], user.getPassword()[0]);
    }

    @Test
    void testGetPasswordReturnsHashedValue() throws NoSuchAlgorithmException {
        String password = "secret";
        User user = new User("John Doe", "test@example.com", password);

        assertNotEquals(password, new String(user.getPassword(), StandardCharsets.UTF_8));
    }
}