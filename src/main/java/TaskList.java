import java.util.ArrayList;

public class TaskList {
    private ArrayList<String> taskList;

    public TaskList() {
        this.taskList = new ArrayList<>();
    }

    public void add(String task) {
        taskList.add(task);
        Message.println("added: " + task);
    }


    public void list() {
        if (taskList.isEmpty()) {
            Message.println("Your list is empty.");
            return;
        }
        StringBuilder listMessage = new StringBuilder();
        for (int i = 0; i < taskList.size(); i++) {
            listMessage.append("     ")
                    .append(i + 1)
                    .append(". ")
                    .append(taskList.get(i))
                    .append("\n");
        }
        Message.print(listMessage.toString());
    }

}
