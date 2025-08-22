package TaskService;

import java.util.HashMap;
import java.util.Map;

public class TaskService {
    // Map to store tasks with taskID as the key
    private final Map<String, Task> taskMap = new HashMap<>();

    // Adds a new task to the taskMap
    public void addTask(String taskID, String name, String description) {
        // Check for null ID or duplicate task ID
        if (taskID == null || taskMap.containsKey(taskID)) {
            throw new IllegalArgumentException("Task ID must be unique and not null.");
        }

        // Create a new task and put it in the map
        Task newTask = new Task(taskID, name, description);
        taskMap.put(taskID, newTask);
    }

    // Deletes a task from the taskMap by taskID
    public void deleteTask(String taskID) {
        if (!taskMap.containsKey(taskID)) {
            throw new IllegalArgumentException("Task ID does not exist.");
        }

        taskMap.remove(taskID);
    }

    // Updates the name of a task by taskID
    public void updateTaskName(String taskID, String newName) {
        Task task = taskMap.get(taskID);
        if (task == null) {
            throw new IllegalArgumentException("Task ID does not exist.");
        }

        task.setName(newName); // Uses Task class validation
    }

    // Updates the description of a task by taskID
    public void updateTaskDescription(String taskID, String newDescription) {
        Task task = taskMap.get(taskID);
        if (task == null) {
            throw new IllegalArgumentException("Task ID does not exist.");
        }

        task.setDescription(newDescription); // Uses Task class validation
    }

    // Optional: Getter for testing or internal use
    public Task getTask(String taskID) {
        return taskMap.get(taskID);
    }
}