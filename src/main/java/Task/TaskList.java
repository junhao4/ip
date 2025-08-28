package Task;

import Ui.Ui;

import java.time.LocalDate;
import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task> taskList;

    public TaskList() {
        this.taskList = new ArrayList<>();
    }

    public TaskList(ArrayList<Task> taskList) {
        this.taskList = taskList;
    }

    public boolean isValidIndex(int index) {
        return index <= taskList.size();
    }

    public void addTodo(String task) {
        Task newTask = new TodoTask(task);
        taskList.add(newTask);
        add(newTask);
    }

    public void addDeadline(String task, LocalDate deadline) {
        Task newTask = new DeadlineTask(task, deadline);
        taskList.add(newTask);
        add(newTask);
    }

    public void addEvent(String task, LocalDate from, LocalDate to) {
        Task newTask = new EventTask(task, from, to);
        taskList.add(newTask);
        add(newTask);
    }

    private void add(Task task) {
        Ui.print("     Got it. I've added this task:\n" +
                "       " + task.toString() + "\n" +
                "     Now you have " + taskCount() + " in the list.\n");
    }

    private String taskCount() {
        int count = taskList.size();
        if (count == 1) {
            return count + " task";
        } else {
            return count + " tasks";
        }
    }

    public void list() {
        if (taskList.isEmpty()) {
            Ui.println("Your list is empty.");
            return;
        }
        StringBuilder listMessage = new StringBuilder(
                "     Here are the tasks in your list:\n");
        for (int i = 0; i < taskList.size(); i++) {
            listMessage.append("     ")
                    .append(i + 1)
                    .append(".")
                    .append(taskList.get(i).toString())
                    .append("\n");
        }
        Ui.print(listMessage.toString());
    }

    public void mark(String indexString) {
        Task task = taskList.get(Integer.parseInt(indexString) - 1);
        task.mark();
        Ui.print("      Nice! I've marked this task as done:\n" +
                "       " + task.toString() + "\n");
    }

    public void unmark(String indexString) {
        Task task = taskList.get(Integer.parseInt(indexString) - 1);
        task.unmark();
        Ui.print("      OK, I've marked this task as not done yet:\n" +
                "       " + task.toString() + "\n");
    }

    public void delete(String indexString) {
        Task task = taskList.get(Integer.parseInt(indexString) - 1);
        taskList.remove(task);
        Ui.print("      OK, I've deleted this task:\n" +
                "       " + task.toString() + "\n");
    }

    public String save() {
        StringBuilder str = new StringBuilder();
        for (Task i : taskList) {
            str.append(i.save())
                    .append("\n");
        }
        return str.toString();
    }

}
