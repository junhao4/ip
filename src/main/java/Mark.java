import java.util.Scanner;

public class Mark {
    static TaskList taskList;

    public static void main(String[] args) {
        taskList = new TaskList();
        Scanner sc = new Scanner(System.in);
        Message.intro();

        while(true) {
            String msg = sc.nextLine();
            if (msg.startsWith("mark")) {
                taskList.mark(msg.substring(5));
                continue;
            } else if (msg.startsWith("unmark")) {
                taskList.unmark(msg.substring(7));
                continue;
            } else if (msg.startsWith("todo")) {
                taskList.addTodo(msg.substring(5));
                continue;
            } else if (msg.startsWith("deadline")) {
                String[] parts = msg.substring(9).split("/by ", 2);
                taskList.addDeadline(parts[0].trim(), parts[1]);
                continue;
            } else if (msg.startsWith("event")) {
                String[] parts = msg.substring(6).split("/from ", 2);
                String[] dates = parts[1].split("/to ", 2);
                taskList.addEvent(parts[0].trim(), dates[0].trim(), dates[1]);
                continue;
            }

            switch (msg) {
                case "bye":
                    Message.bye();
                    return;
                case "list":
                    taskList.list();
                    break;
                default:
                    Message.error();
                    break;
            }
        }
    }
}


