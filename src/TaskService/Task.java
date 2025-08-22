package TaskService;

public class Task {
    // Required unique task ID - cannot be changed after initialization
    private final String taskID;
    
    // Task name - can be updated later
    private String name;
    
    // Task description - can be updated later
    private String description;

    // Constructor to initialize the Task object with validation
    public Task(String taskID, String name, String description) {
        // Validate and assign task ID
        if (taskID == null || taskID.length() > 10) {
            throw new IllegalArgumentException("Task ID must not be null and must be 10 characters or less.");
        }
        this.taskID = taskID;

        // Validate and assign name
        setName(name);

        // Validate and assign description
        setDescription(description);
    }

    // Getter for task ID (not updatable)
    public String getTaskID() {
        return taskID;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name with validation
    public void setName(String name) {
        if (name == null || name.length() > 20) {
            throw new IllegalArgumentException("Name must not be null and must be 20 characters or less.");
        }
        this.name = name;
    }

    // Getter for description
    public String getDescription() {
        return description;
    }

    // Setter for description with validation
    public void setDescription(String description) {
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Description must not be null and must be 50 characters or less.");
        }
        this.description = description;
    }
}