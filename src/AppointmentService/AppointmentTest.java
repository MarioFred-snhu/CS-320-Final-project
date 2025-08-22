package AppointmentService;

import org.junit.jupiter.api.Test;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

public class AppointmentTest {

    @Test
    void validAppointmentCreatedSuccessfully() {
        Appointment appt = new Appointment("1234567890", new Date(System.currentTimeMillis() + 1000), "Test appointment");
        assertEquals("1234567890", appt.getAppointmentId());
        assertEquals("Test appointment", appt.getDescription());
        assertNotNull(appt.getAppointmentDate());
    }

    @Test
    void appointmentIdTooLongThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("12345678901", new Date(System.currentTimeMillis() + 1000), "Description");
        });
    }

    @Test
    void appointmentIdNullThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(null, new Date(System.currentTimeMillis() + 1000), "Description");
        });
    }

    @Test
    void pastDateThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("123", new Date(System.currentTimeMillis() - 100000), "Description");
        });
    }

    @Test
    void descriptionTooLongThrowsException() {
        String longDesc = "This description is definitely more than fifty characters long.";
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("123", new Date(System.currentTimeMillis() + 1000), longDesc);
        });
    }

    @Test
    void nullDescriptionThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("123", new Date(System.currentTimeMillis() + 1000), null);
        });
    }
}