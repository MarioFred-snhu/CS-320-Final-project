package ContactService;
import java.util.HashMap;
import java.util.Map;

public class ContactService {

    // Stores all contacts using their contactID as the key
    private final Map<String, Contact> contacts = new HashMap<>();

    /**
     * Adds a new contact to the service
     * Throws an error if the contact ID already exists
     */
    public void addContact(Contact contact) {
        if (contact == null) {
            throw new IllegalArgumentException("Contact cannot be null.");
        }
        String id = contact.getContactID();
        if (contacts.containsKey(id)) {
            throw new IllegalArgumentException("Contact ID already exists.");
        }
        contacts.put(id, contact);
    }

    /**
     * Deletes a contact using its contact ID
     */
    public void deleteContact(String contactID) {
        if (!contacts.containsKey(contactID)) {
            throw new IllegalArgumentException("Contact ID not found.");
        }
        contacts.remove(contactID);
    }

    /**
     * Updates the first name of a contact by ID
     */
    public void updateFirstName(String contactID, String newFirstName) {
        Contact contact = getContactById(contactID);
        contact.setFirstName(newFirstName);
    }

    /**
     * Updates the last name of a contact by ID
     */
    public void updateLastName(String contactID, String newLastName) {
        Contact contact = getContactById(contactID);
        contact.setLastName(newLastName);
    }

    /**
     * Updates the phone number of a contact by ID
     */
    public void updatePhone(String contactID, String newNumber) {
        Contact contact = getContactById(contactID);
        contact.setNumber(newNumber);
    }

    /**
     * Updates the address of a contact by ID
     */
    public void updateAddress(String contactID, String newAddress) {
        Contact contact = getContactById(contactID);
        contact.setAddress(newAddress);
    }

    /**
     * Helper method to safely retrieve a contact by ID
     */
    private Contact getContactById(String contactID) {
        Contact contact = contacts.get(contactID);
        if (contact == null) {
            throw new IllegalArgumentException("Contact ID not found.");
        }
        return contact;
    }

    /**
     * (Optional) Returns a contact for testing or display
     */
    public Contact getContact(String contactID) {
        return contacts.get(contactID);
    }
}