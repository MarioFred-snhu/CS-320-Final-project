package TaskService;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskTest {

    // Test valid task creation
    @Test
    public void testValidTaskCreation() {
        Task task = new Task("12345", "Grocery Run", "Buy food for the week");
        assertEquals("12345", task.getTaskID());
        assertEquals("Grocery Run", task.getName());
        assertEquals("Buy food for the week", task.getDescription());
    }

    // Test invalid taskID (null)
    @Test
    public void testNullTaskID() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task(null, "Test Task", "Description");
        });
    }

    // Test taskID too long
    @Test
    public void testLongTaskID() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("12345678901", "Test Task", "Description");
        });
    }

    // Test name is null
    @Test
    public void testNullName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("123", null, "Description");
        });
    }

    // Test name too long
    @Test
    public void testLongName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("123", "This name is way too long", "Description");
        });
    }

    // Test description is null
    @Test
    public void testNullDescription() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("123", "Task Name", null);
        });
    }

    // Test description too long
    @Test
    public void testLongDescription() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("123", "Task Name", "This description is way too long to be accepted as it exceeds the 50 characters limit.");
        });
    }

    // Test updating name with valid value
    @Test
    public void testSetNameValid() {
        Task task = new Task("123", "Old Name", "Desc");
        task.setName("New Name");
        assertEquals("New Name", task.getName());
    }

    // Test updating name with invalid (too long)
    @Test
    public void testSetNameTooLong() {
        Task task = new Task("123", "Name", "Desc");
        assertThrows(IllegalArgumentException.class, () -> {
            task.setName("This name is definitely more than twenty characters");
        });
    }

    // Test updating description with valid value
    @Test
    public void testSetDescriptionValid() {
        Task task = new Task("123", "Task", "Old Desc");
        task.setDescription("New valid description.");
        assertEquals("New valid description.", task.getDescription());
    }

    // Test updating description with invalid (too long)
    @Test
    public void testSetDescriptionTooLong() {
        Task task = new Task("123", "Task", "Desc");
        assertThrows(IllegalArgumentException.class, () -> {
            task.setDescription("This is a very long description that should throw an exception because it exceeds fifty characters.");
        });
    }
}