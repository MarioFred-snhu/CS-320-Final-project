package ContactService;

public class Contact {
	// Fields
    private final String contactID; // Cannot be changed after creation
    private String firstName;
    private String lastName;
    private String number;   // Phone number
    private String address;

    // Constructor with validation
    public Contact(String contactID, String firstName, String lastName, String number, String address) {

        // Contact ID: required, max 10 characters
        if (contactID == null || contactID.length() > 10) {
            throw new IllegalArgumentException("Contact ID is invalid: null or longer than 10 characters.");
        }

        // First name: required, max 10 characters
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("First name is invalid: null or longer than 10 characters.");
        }

        // Last name: required, max 10 characters
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Last name is invalid: null or longer than 10 characters.");
        }

        // Phone number: required, exactly 10 digits, must be numeric
        if (number == null || number.length() != 10 || !number.matches("\\d+")) {
            throw new IllegalArgumentException("Phone number must be exactly 10 digits.");
        }

        // Address: required, max 30 characters
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Address is invalid: null or longer than 30 characters.");
        }

        // Assign values if all validations pass
        this.contactID = contactID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.number = number;
        this.address = address;
    }

    // Getters
    public String getContactID() {
        return contactID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getNumber() {
        return number;
    }

    public String getAddress() {
        return address;
    }

    // Setters (only for fields that are allowed to be updated)
    public void setFirstName(String firstName) {
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("First name is invalid: null or longer than 10 characters.");
        }
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Last name is invalid: null or longer than 10 characters.");
        }
        this.lastName = lastName;
    }

    public void setNumber(String number) {
        if (number == null || number.length() != 10 || !number.matches("\\d+")) {
            throw new IllegalArgumentException("Phone number must be exactly 10 digits.");
        }
        this.number = number;
    }

    public void setAddress(String address) {
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Address is invalid: null or longer than 30 characters.");
        }
        this.address = address;
    }

}
