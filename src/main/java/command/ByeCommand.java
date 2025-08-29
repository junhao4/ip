package command;

import exceptions.MarkExceptions;
import task.TaskList;
import ui.Ui;

public class ByeCommand extends Command {

    public ByeCommand(String arg, TaskList tasklist) {
        super(arg, tasklist);
    }

    public void execute() throws MarkExceptions {
        Ui.bye();
        System.exit(0);
    }

    @Override
    public boolean isExit() {
        return true;
    }
}
