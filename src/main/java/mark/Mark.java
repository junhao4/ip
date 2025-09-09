package mark;

import command.Command;
import exceptions.MarkExceptions;
import inputhandler.InputHandler;
import storage.Storage;
import task.TaskList;
import ui.Ui;


public class Mark {
    private TaskList taskList;
    private Storage storage;
    private Ui ui;

    public Mark() {
        ui = new Ui();
        storage = new Storage("./data", "./data/Mark.txt");
        taskList = new TaskList(storage.load());
    }

    public void run() {
        Ui.intro();

        boolean isExit = false;
        while (!isExit) {
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

    public String getResponse(String input) {
        try {
            Command c = InputHandler.handle(input, taskList);
            c.executeAndSave(storage);
            return Ui.getMessage();
        } catch (MarkExceptions e) {
            Ui.println(e.getMessage());
            return Ui.getMessage();
        }

    }

    public static void main(String[] args) {
        new Mark().run();
    }

}


