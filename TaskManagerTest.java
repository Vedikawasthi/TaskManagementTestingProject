import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class TaskManagerTest {
    private TaskManager taskManager;

    @Before
    public void setUp() {
        taskManager = new TaskManager();
    }

    @Test
    public void testAddTask() {
        Task task = new Task("Test Task", "Test Description", "2025-04-15", "High");
        taskManager.addTask(task);
        List<Task> tasks = taskManager.getTasks();
        assertEquals(1, tasks.size());
        assertEquals("Test Task", tasks.get(0).getTitle());
    }

    @Test
    public void testEditTask() {
        Task task = new Task("Old Title", "Old Desc", "2025-04-15", "Medium");
        taskManager.addTask(task);
        Task updatedTask = new Task("New Title", "New Desc", "2025-04-20", "High");
        taskManager.editTask(0, updatedTask);
        Task t = taskManager.getTasks().get(0);
        assertEquals("New Title", t.getTitle());
        assertEquals("New Desc", t.getDescription());
    }

    @Test
    public void testDeleteTask() {
        Task task1 = new Task("Task 1", "Desc", "2025-04-10", "Low");
        taskManager.addTask(task1);
        taskManager.deleteTask(0);
        assertTrue(taskManager.getTasks().isEmpty());
    }

    @Test
    public void testMarkTaskAsComplete() {
        Task task = new Task("Complete Me", "Testing", "2025-04-12", "High");
        taskManager.addTask(task);
        taskManager.markTaskAsComplete(0);
        assertTrue(taskManager.getTasks().get(0).isCompleted());
    }

    @Test
    public void testViewTasksOutput() {
        Task task = new Task("View Test", "Desc", "2025-04-11", "Medium");
        taskManager.addTask(task);
        String output = task.toString();
        assertTrue(output.contains("Title: View Test"));
        assertTrue(output.contains("Priority: Medium"));
    }

    @Test
    public void testInvalidIndexEdit() {
        Task updatedTask = new Task("Title", "Desc", "2025-04-11", "Low");
        taskManager.editTask(5, updatedTask); // should not crash
        assertTrue(taskManager.getTasks().isEmpty());
    }

    @Test
    public void testInvalidIndexDelete() {
        taskManager.deleteTask(3); // no task to delete
        assertTrue(taskManager.getTasks().isEmpty());
    }

    @Test
    public void testInvalidIndexMarkComplete() {
        taskManager.markTaskAsComplete(1); // should handle gracefully
        assertTrue(taskManager.getTasks().isEmpty());
    }

    @Test
    public void testSetPriorityEdgeCase() {
        Task task = new Task("Edge Case", "Desc", "2025-04-13", "High");
        task.setPriority("Low");
        assertEquals("Low", task.getPriority());
    }
}
