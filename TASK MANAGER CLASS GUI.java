import java.util.ArrayList;
import java.io.*;

public class TaskManager {
    private ArrayList<Task> tasks;
    private final String FILE_NAME = "tasks.dat";

    public TaskManager() {
        tasks = new ArrayList<>();
        loadTasksFromFile();
    }

    // Add task
    public void addTask(Task task) {
        tasks.add(task);
        saveTasksToFile();
    }

    // Remove task
    public void removeTask(int index) {
        tasks.remove(index);
        saveTasksToFile();
    }

    // Get task list
    public ArrayList<Task> getTasks() {
        return tasks;
    }

    // Save tasks to file
    private void saveTasksToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(tasks);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Load tasks from file
    private void loadTasksFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            tasks = (ArrayList<Task>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("No previous tasks found.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}