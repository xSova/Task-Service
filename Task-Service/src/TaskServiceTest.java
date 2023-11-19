import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class TaskServiceTest {
    private TaskService taskService;

    @BeforeEach
    void setUp() {
        taskService = new TaskService();
    }

    @Test
    void testAddTask() {
        taskService.addTask("1", "Task 1", "Description 1");
        Task result = taskService.getTask("1");

        Assertions.assertNotNull(result);
        Assertions.assertEquals("Task 1", result.getName());
        Assertions.assertEquals("Description 1", result.getDescription());
    }

    @Test
    void testAddTaskWithExistingID() {
        taskService.addTask("1", "Task 1", "Description 1");

        Assertions.assertThrows(IllegalArgumentException.class, () -> taskService.addTask("1", "Task 2", "Description 2"));
    }

    @Test
    void testDeleteTask() {
        taskService.addTask("1", "Task 1", "Description 1");
        taskService.deleteTask("1");

        Assertions.assertNull(taskService.getTask("1"));
    }

    @Test
    void testDeleteNonExistentTask() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            taskService.deleteTask("2"); // Assuming "2" does not exist
        });
    }

    @Test
    void testGetNonExistentTask() {
        Task result = taskService.getTask("1");
        Assertions.assertNull(result);
    }

    @Test
    void testUpdateExistingTask() {
        taskService.addTask("1", "Task 1", "Description 1");

        Map<String, String> updates = new HashMap<>();
        updates.put("name", "Updated Task 1");
        updates.put("description", "Updated Description 1");
        taskService.updateTaskFields("1", updates);

        Task updatedTask = taskService.getTask("1");
        Assertions.assertEquals("Updated Task 1", updatedTask.getName());
        Assertions.assertEquals("Updated Description 1", updatedTask.getDescription());
    }

    @Test
    void testUpdateNonExistentTask() {
        Map<String, String> updates = new HashMap<>();
        updates.put("name", "New Name");

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            taskService.updateTaskFields("2", updates); // Assuming "2" does not exist
        });
    }

    @Test
    void testUpdateWithInvalidFieldName() {
        taskService.addTask("1", "Task 1", "Description 1");

        Map<String, String> updates = new HashMap<>();
        updates.put("invalidField", "Some Value");

        Assertions.assertThrows(IllegalArgumentException.class, () -> taskService.updateTaskFields("1", updates));
    }

}
