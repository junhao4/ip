package ui;

import java.util.Scanner;

public class Ui {
    private static final String LINE = "    ____________________________________________________________\n";
    private static Message message;
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
    }

    public static String introMessage() {
        return "Hello! I'm Mark\n"
                + "What can I do for you?\n";
    }

    /**
     * Prints the exit message when the program ends.
     */
    public static void bye() {
    }

    public static void error() {
        Ui.printWarning("OOPS!!! I'm sorry, but I don't know what that means :-(");
    }

    /**
     * Prints a formatted message with a newline after it.
     *
     * @param msg The message to print
     */
    public static void println(String msg) {
        message = Message.normal(msg);
    }

    /**
     * Prints a message with surrounding lines.
     *
     * @param msg The message to print
     */
    public static void print(String msg) {
        message = Message.normal(msg);
    }

    public static void printError(String msg) {
        message = Message.error(msg);
    }

    public static void printInfo(String msg) {
        message = Message.info(msg);
    }

    public static void printWarning(String msg) {
        message = Message.warning(msg);
    }

    public static void printSuccess(String msg) {
        message = Message.success(msg);
    }

    public static Message getMessage() {
        assert (message != null);
        return message;
    }
}
