import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task> taskList;

    public TaskList() {
        this.taskList = new ArrayList<>();
    }

    public void add(String task) {
        taskList.add(new Task(task));
        Message.println("added: " + task);
    }


    public void list() {
        if (taskList.isEmpty()) {
            Message.println("Your list is empty.");
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
        Message.print(listMessage.toString());
    }

    public void mark(String indexString) {
        Task task = taskList.get(Integer.parseInt(indexString) - 1);
        task.mark();
        Message.print("      Nice! I've marked this task as done:\n" +
                "       " + task.toString() + "\n");
    }

    public void unmark(String indexString) {
        Task task = taskList.get(Integer.parseInt(indexString) - 1);
        task.unmark();
        Message.print("      OK, I've marked this task as not done yet:\n" +
                "       " + task.toString() + "\n");
    }

}
