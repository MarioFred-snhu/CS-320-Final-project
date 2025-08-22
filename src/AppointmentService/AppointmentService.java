package AppointmentService;

import java.util.HashMap;

public class AppointmentService {
    // In-memory storage using a HashMap for fast lookup by ID
    private final HashMap<String, Appointment> appointmentMap = new HashMap<>();

    // Add appointment if the ID is unique
    public boolean addAppointment(Appointment appointment) {
        // Check if the ID already exists
        if (appointmentMap.containsKey(appointment.getAppointmentId())) {
            return false; // ID exists, do not add
        }
        // Add the appointment and return true
        appointmentMap.put(appointment.getAppointmentId(), appointment);
        return true;
    }

    // Delete appointment by ID
    public boolean deleteAppointment(String appointmentId) {
        // Check if the ID exists before removing
        if (!appointmentMap.containsKey(appointmentId)) {
            return false; // Nothing to delete
        }
        appointmentMap.remove(appointmentId);
        return true;
    }

    // Optional helper: retrieve an appointment by ID
    public Appointment getAppointment(String appointmentId) {
        return appointmentMap.get(appointmentId);
    }
}