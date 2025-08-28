package Mark;

import Command.Command;
import Exceptions.MarkExceptions;
import InputHandler.InputHandler;
import Ui.Ui;
import Storage.Storage;
import Task.TaskList;

public class Mark {
    private TaskList taskList;
    private Storage storage;
    private Ui ui;

    public Mark() {
        ui = new Ui();
        storage = new Storage("./data", "./data/Mark.Mark.txt");
        taskList = new TaskList(storage.load());
    }

    public void run() {
        Ui.intro();

        boolean isExit = false;
        while(!isExit) {
            String msg = ui.readCommand();
            try {
                Command c = InputHandler.handle(msg, taskList);
                c.executeAndSave(storage);
                isExit = c.isExit();
            } catch (MarkExceptions e) {
                Ui.println(e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        new Mark().run();
    }

}


