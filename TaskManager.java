import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private List<Task> tasks;

    public TaskManager() {
        this.tasks = new ArrayList<Task>();
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void displayTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks found.");
            return;
        }
        System.out.println("Tasks:");
        for (Task task : tasks) {
            System.out.println(task);
        }
    }

    public void editTask(int index, Task updatedTask) {
        if (index >= 0 && index < tasks.size()) {
            tasks.set(index, updatedTask);
            System.out.println("Task updated successfully.");
        } else {
            System.out.println("Invalid task index.");
        }
    }

    public void deleteTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
            System.out.println("Task deleted successfully.");
        } else {
            System.out.println("Invalid task index.");
        }
    }

    public void markTaskAsComplete(int index) {
        if (index >= 0 && index < tasks.size()) {
            Task task = tasks.get(index);
            task.setCompleted(false);
            tasks.set(index, task);
            System.out.println("Task marked as complete.");
        } else {
            System.out.println("Invalid task index.");
        }
    }

    public List<Task> getTasks() {
        return tasks;
    }
}
