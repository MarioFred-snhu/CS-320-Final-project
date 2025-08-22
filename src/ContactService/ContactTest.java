package ContactService;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ContactTest {

    // Test that a valid Contact object is created successfully
    @Test
    public void testValidContactCreation() {
        Contact contact = new Contact("001", "John", "Doe", "1234567890", "123 Main Street");
        assertEquals("001", contact.getContactID());
        assertEquals("John", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("1234567890", contact.getNumber());
        assertEquals("123 Main Street", contact.getAddress());
    }

    // Test that null contact ID throws an exception
    @Test
    public void testNullContactID() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "Jane", "Smith", "1234567890", "123 Main Street");
        });
    }

    // Test that too-long first name throws an exception
    @Test
    public void testTooLongFirstName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("002", "ThisNameIsWayTooLong", "Smith", "1234567890", "123 Main Street");
        });
    }

    // Test that null phone number throws an exception
    @Test
    public void testNullPhoneNumber() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("003", "Jane", "Smith", null, "123 Main Street");
        });
    }

    // Test that invalid phone number (not 10 digits) throws an exception
    @Test
    public void testInvalidPhoneNumber() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("004", "Jane", "Smith", "123", "123 Main Street");
        });
    }

    // Test that too-long address throws an exception
    @Test
    public void testTooLongAddress() {
        String longAddress = "1234567890123456789012345678901"; // 31 characters
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("005", "Jane", "Smith", "1234567890", longAddress);
        });
    }

    // Test the setters and that updates are saved correctly
    @Test
    public void testSettersWorkCorrectly() {
        Contact contact = new Contact("006", "Jane", "Doe", "1234567890", "Old Address");

        contact.setFirstName("Anna");
        contact.setLastName("Taylor");
        contact.setNumber("0987654321");
        contact.setAddress("New Address");

        assertEquals("Anna", contact.getFirstName());
        assertEquals("Taylor", contact.getLastName());
        assertEquals("0987654321", contact.getNumber());
        assertEquals("New Address", contact.getAddress());
    }

    // Test that setting a null first name throws an exception
    @Test
    public void testSetFirstNameToNull() {
        Contact contact = new Contact("007", "John", "Doe", "1234567890", "Somewhere");
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setFirstName(null);
        });
    }
}