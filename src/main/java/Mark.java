import java.util.Scanner;

public class Mark {
    static TaskList taskList;

    public static void main(String[] args) {
        taskList = new TaskList();
        Scanner sc = new Scanner(System.in);
        Message.intro();

        while(sc.hasNext()) {
            String msg = sc.nextLine();

            try {
                InputHandler.handle(msg, taskList);
            } catch (MarkExceptions e) {
                Message.println(e.getMessage());
            }
        }
    }
}


