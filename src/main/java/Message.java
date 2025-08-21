public class Message {
    private final static String LINE = "    ____________________________________________________________\n";

    public static String line(String msg) {
        return LINE + msg + LINE;
    }

    public static void intro() {
        System.out.println(
            Message.line(
            "     Hello! I'm Mark\n" +
                 "     What can I do for you?\n"
            )
        );
    }

    public static void bye() {
        System.out.println(
                Message.line("     Bye. Hope to see you again soon!\n")
        );
    }

    public static void error() {
        Message.println("OOPS!!! I'm sorry, but I don't know what that means :-(");
    }


    public static void println(String msg) {
        System.out.println(
                Message.line("     " + msg + "\n")
        );
    }

    public static void print(String msg) {
        System.out.println(
                Message.line(msg)
        );
    }
}
