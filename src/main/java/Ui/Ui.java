package Ui;

import java.util.Scanner;

public class Ui {
    private Scanner sc;
    private final static String LINE = "    ____________________________________________________________\n";

    public Ui() {
        this.sc = new Scanner(System.in);
    }

    public String readCommand() {
        return sc.nextLine();
    }

    public static String line(String msg) {
        return LINE + msg + LINE;
    }

    public static void intro() {
        System.out.println(
            Ui.line(
            "     Hello! I'm Mark\n" +
                 "     What can I do for you?\n"
            )
        );
    }

    public static void bye() {
        System.out.println(
                Ui.line("     Bye. Hope to see you again soon!\n")
        );
    }

    public static void error() {
        Ui.println("OOPS!!! I'm sorry, but I don't know what that means :-(");
    }


    public static void println(String msg) {
        System.out.println(
                Ui.line("     " + msg + "\n")
        );
    }

    public static void print(String msg) {
        System.out.println(
                Ui.line(msg)
        );
    }
}
