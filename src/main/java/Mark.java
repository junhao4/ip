import Command.Command;
import Exceptions.MarkExceptions;
import Message.Message;
import Storage.Storage;
import Task.TaskList;

import java.util.Scanner;

public class Mark {
    static TaskList taskList;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Storage storage = new Storage("./data", "./data/Mark.txt");
        taskList = new TaskList(storage.load());

        Message.intro();

        while(sc.hasNext()) {
            String msg = sc.nextLine();

            try {
                Command c = InputHandler.handle(msg, taskList);
                c.executeAndSave(storage);
            } catch (MarkExceptions e) {
                Message.println(e.getMessage());
            }
        }
    }
}


