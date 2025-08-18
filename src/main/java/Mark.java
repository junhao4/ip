import java.util.Scanner;

public class Mark {
    public static void main(String[] args) {

        Message.intro();

        while(true) {
            Scanner sc = new Scanner(System.in);
            String msg = sc.nextLine();
            if (msg.equals("bye")) {
                break;
            }
            Message.print(msg);
        }

        Message.bye();
    }
}


