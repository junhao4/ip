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
            }

            switch (msg) {
                case "bye":
                    Message.bye();
                    return;
                case "list":
                    taskList.list();
                    break;
                default:
                    taskList.add(msg);
                    break;
            }
        }
    }
}


