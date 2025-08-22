package ContactService;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {

    private ContactService service;

    // Set up a new service with one contact before each test
    @BeforeEach
    public void setUp() {
        service = new ContactService();
        Contact initial = new Contact("001", "Alice", "Smith", "1234567890", "100 Main St");
        service.addContact(initial);
    }

    // Test adding a new contact
    @Test
    public void testAddContact() {
        Contact newContact = new Contact("002", "Bob", "Brown", "0987654321", "200 Oak St");
        service.addContact(newContact);
        assertEquals("Bob", service.getContact("002").getFirstName());
    }

    // Test that adding a contact with an existing ID throws an error
    @Test
    public void testAddDuplicateContact() {
        Contact duplicate = new Contact("001", "Tom", "White", "9999999999", "300 Pine St");
        assertThrows(IllegalArgumentException.class, () -> {
            service.addContact(duplicate);
        });
    }

    // Test deleting an existing contact
    @Test
    public void testDeleteContact() {
        service.deleteContact("001");
        assertNull(service.getContact("001"));
    }

    // Test that deleting a non-existent contact throws an error
    @Test
    public void testDeleteNonExistentContact() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.deleteContact("999");
        });
    }

    // Test updating the first name of a contact
    @Test
    public void testUpdateFirstName() {
        service.updateFirstName("001", "Eve");
        assertEquals("Eve", service.getContact("001").getFirstName());
    }

    // Test updating the last name of a contact
    @Test
    public void testUpdateLastName() {
        service.updateLastName("001", "Johnson");
        assertEquals("Johnson", service.getContact("001").getLastName());
    }

    // Test updating the phone number of a contact
    @Test
    public void testUpdatePhone() {
        service.updatePhone("001", "1112223333");
        assertEquals("1112223333", service.getContact("001").getNumber());
    }

    // Test updating the address of a contact
    @Test
    public void testUpdateAddress() {
        service.updateAddress("001", "555 Maple Ave");
        assertEquals("555 Maple Ave", service.getContact("001").getAddress());
    }

    // Test updating a contact that doesn't exist
    @Test
    public void testUpdateNonExistentContact() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.updateFirstName("999", "Ghost");
        });
    }

    // Test invalid phone update (too short)
    @Test
    public void testUpdatePhoneInvalid() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.updatePhone("001", "123");
        });
    }
}