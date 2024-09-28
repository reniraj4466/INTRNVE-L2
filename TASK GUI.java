import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TaskManagerGUI extends JFrame {
    private TaskManager taskManager;
    private DefaultListModel<Task> listModel;
    private JList<Task> taskList;

    public TaskManagerGUI() {
        taskManager = new TaskManager();
        listModel = new DefaultListModel<>();
        taskList = new JList<>(listModel);
        loadTasksIntoListModel();

        setTitle("Task Manager");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create task input field and add button
        JTextField taskInput = new JTextField();
        JButton addButton = new JButton("Add Task");

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String description = taskInput.getText();
                if (!description.isEmpty()) {
                    Task task = new Task(description);
                    taskManager.addTask(task);
                    listModel.addElement(task);
                    taskInput.setText("");
                }
            }
        });

        // Create delete button
        JButton deleteButton = new JButton("Delete Task");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = taskList.getSelectedIndex();
                if (selectedIndex != -1) {
                    taskManager.removeTask(selectedIndex);
                    listModel.remove(selectedIndex);
                }
            }
        });

        // Create panel for input
        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.add(taskInput, BorderLayout.CENTER);
        inputPanel.add(addButton, BorderLayout.EAST);

        // Create panel for buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(deleteButton);

        // Add components to frame
        add(inputPanel, BorderLayout.NORTH);
        add(new JScrollPane(taskList), BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void loadTasksIntoListModel() {
        for (Task task : taskManager.getTasks()) {
            listModel.addElement(task);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TaskManagerGUI gui = new TaskManagerGUI();
            gui.setVisible(true);
        });
    }
}