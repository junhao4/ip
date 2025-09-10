package ui;

import java.util.Scanner;

public class Ui {
    private static final String LINE = "    ____________________________________________________________\n";
    private static String message;
    private Scanner sc;


    /**
     * Creates a new Ui object with a Scanner for reading user input.
     */
    public Ui() {
        this.sc = new Scanner(System.in);
    }

    /**
     * Reads a single line of input from the user.
     *
     * @return command entered by the user
     */
    public String readCommand() {
        return sc.nextLine();
    }

    /**
     * Formats a message by surrounding it with lines.
     *
     * @param msg The message to format
     * @return the formatted message string
     */
    public static String line(String msg) {
        return LINE + msg + LINE;
    }

    /**
     * Prints the program intro message.
     */
    public static void intro() {
        System.out.println(
            Ui.line(
            "     Hello! I'm Mark\n"
                    + "     What can I do for you?\n"
            )
        );
    }

    public static String introMessage() {
        return "Hello! I'm Mark\n"
                + "What can I do for you?\n";
    }

    /**
     * Prints the exit message when the program ends.
     */
    public static void bye() {
        System.out.println(
                Ui.line("     Bye. Hope to see you again soon!\n")
        );
    }

    public static void error() {
        Ui.println("OOPS!!! I'm sorry, but I don't know what that means :-(");
    }

    /**
     * Prints a formatted message with a newline after it.
     *
     * @param msg The message to print
     */
    public static void println(String msg) {
        System.out.println(
                Ui.line("     " + msg + "\n")
        );
        message = msg;
    }

    /**
     * Prints a message with surrounding lines.
     *
     * @param msg The message to print
     */
    public static void print(String msg) {
        System.out.println(
                Ui.line(msg)
        );
        message = msg;
    }

    public static String getMessage() {
        assert (message != null);
        return message;
    }
}
