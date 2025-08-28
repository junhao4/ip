package Command;

import Exceptions.MarkExceptions;
import Task.TaskList;
import Ui.Ui;

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
