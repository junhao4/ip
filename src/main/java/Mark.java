import java.util.Scanner;

public class Mark {
    public static void main(String[] args) {

        String line = "    ____________________________________________________________\n";

        System.out.println(
            line +
            "    Hello! I'm Mark\n" +
            "    What can I do for you?\n" +
            line
        );

        while(true) {
            Scanner sc = new Scanner(System.in);
            String msg = sc.nextLine();
            if (msg.equals("bye")) {
                break;
            }
            System.out.println(
                line + "    " + msg + "\n" + line
            );
        }

        System.out.println(
            line +
            "    Bye. Hope to see you again soon!\n" +
            line
        );
    }
}
