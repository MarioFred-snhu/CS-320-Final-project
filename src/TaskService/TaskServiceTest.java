package TaskService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaskServiceTest {

    private TaskService taskService;

    // Run before each test to reset the task service
    @BeforeEach
    public void setUp() {
        taskService = new TaskService();
    }

    // Test adding a task successfully
    @Test
    public void testAddTaskSuccess() {
        taskService.addTask("1", "Homework", "Finish module 6 assignment");
        Task task = taskService.getTask("1");
        assertNotNull(task);
        assertEquals("Homework", task.getName());
        assertEquals("Finish module 6 assignment", task.getDescription());
    }

    // Test adding a task with a duplicate ID
    @Test
    public void testAddTaskDuplicateID() {
        taskService.addTask("1", "Task1", "First task");
        assertThrows(IllegalArgumentException.class, () -> {
            taskService.addTask("1", "Task2", "Second task");
        });
    }

    // Test deleting a task successfully
    @Test
    public void testDeleteTaskSuccess() {
        taskService.addTask("1", "Task to Delete", "Temporary task");
        taskService.deleteTask("1");
        assertNull(taskService.getTask("1"));
    }

    // Test deleting a task that doesn't exist
    @Test
    public void testDeleteTaskNotFound() {
        assertThrows(IllegalArgumentException.class, () -> {
            taskService.deleteTask("999");
        });
    }

    // Test updating task name successfully
    @Test
    public void testUpdateTaskNameSuccess() {
        taskService.addTask("1", "Old Name", "Description");
        taskService.updateTaskName("1", "New Name");
        assertEquals("New Name", taskService.getTask("1").getName());
    }

    // Test updating task name with invalid (too long) input
    @Test
    public void testUpdateTaskNameTooLong() {
        taskService.addTask("1", "Valid", "Description");
        assertThrows(IllegalArgumentException.class, () -> {
            taskService.updateTaskName("1", "This name is way too long to be accepted");
        });
    }

    // Test updating name on a non-existing task
    @Test
    public void testUpdateNameTaskNotFound() {
        assertThrows(IllegalArgumentException.class, () -> {
            taskService.updateTaskName("123", "New Name");
        });
    }

    // Test updating description successfully
    @Test
    public void testUpdateTaskDescriptionSuccess() {
        taskService.addTask("1", "Task", "Old Description");
        taskService.updateTaskDescription("1", "Updated Description");
        assertEquals("Updated Description", taskService.getTask("1").getDescription());
    }

    // Test updating description with invalid (too long) input
    @Test
    public void testUpdateTaskDescriptionTooLong() {
        taskService.addTask("1", "Task", "Description");
        assertThrows(IllegalArgumentException.class, () -> {
            taskService.updateTaskDescription("1", "This description is going to be way too long for the allowed 50 character limit.");
        });
    }

    // Test updating description on a non-existing task
    @Test
    public void testUpdateDescriptionTaskNotFound() {
        assertThrows(IllegalArgumentException.class, () -> {
            taskService.updateTaskDescription("123", "New Description");
        });
    }
}