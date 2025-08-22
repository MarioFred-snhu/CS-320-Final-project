package AppointmentService;
import java.util.Date;

public class Appointment {
    // Final so it can't be changed once set
    private final String appointmentId;
    private final Date appointmentDate;
    private final String description;

    // Constructor with validation
    public Appointment(String appointmentId, Date appointmentDate, String description) {
        // Validate appointment ID
        if (appointmentId == null || appointmentId.length() > 10) {
            throw new IllegalArgumentException("Appointment ID must not be null and max 10 characters.");
        }

        // Validate appointment date
        if (appointmentDate == null || appointmentDate.before(new Date())) {
            throw new IllegalArgumentException("Appointment date must not be null or in the past.");
        }

        // Validate description
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Description must not be null and max 50 characters.");
        }

        this.appointmentId = appointmentId;
        this.appointmentDate = appointmentDate;
        this.description = description;
    }

    // Getters only — no setters to keep data safe and consistent
    public String getAppointmentId() {
        return appointmentId;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public String getDescription() {
        return description;
    }
}