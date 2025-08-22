package AppointmentService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

public class AppointmentServiceTest {

    private AppointmentService service;

    @BeforeEach
    void setUp() {
        // Create a new service before each test
        service = new AppointmentService();
    }

    @Test
    void addAppointmentSuccessfullyReturnsTrue() {
        Appointment appt = new Appointment("1", new Date(System.currentTimeMillis() + 1000), "Doctor Visit");
        boolean result = service.addAppointment(appt);
        assertTrue(result); // Appointment should be added
        assertEquals(appt, service.getAppointment("1")); // Check stored
    }

    @Test
    void addDuplicateAppointmentReturnsFalse() {
        Appointment appt1 = new Appointment("2", new Date(System.currentTimeMillis() + 1000), "Meeting");
        Appointment appt2 = new Appointment("2", new Date(System.currentTimeMillis() + 2000), "Lunch");
        assertTrue(service.addAppointment(appt1)); // First add should succeed
        assertFalse(service.addAppointment(appt2)); // Duplicate ID should fail
    }

    @Test
    void deleteAppointmentSuccessfullyReturnsTrue() {
        Appointment appt = new Appointment("3", new Date(System.currentTimeMillis() + 1000), "Workout");
        service.addAppointment(appt);
        boolean result = service.deleteAppointment("3");
        assertTrue(result); // Deletion should succeed
        assertNull(service.getAppointment("3")); // Should be removed
    }

    @Test
    void deleteNonexistentAppointmentReturnsFalse() {
        boolean result = service.deleteAppointment("doesNotExist");
        assertFalse(result); // Should return false for non-existent ID
    }

    @Test
    void getAppointmentReturnsCorrectAppointment() {
        Appointment appt = new Appointment("4", new Date(System.currentTimeMillis() + 1000), "Dentist");
        service.addAppointment(appt);
        Appointment retrieved = service.getAppointment("4");
        assertNotNull(retrieved);
        assertEquals("Dentist", retrieved.getDescription());
    }
}