package Command;

import Exceptions.MarkExceptions;
import Task.TaskList;
import Message.Message;

public class ByeCommand extends Command {

    public ByeCommand(String arg, TaskList tasklist) {
        super(arg, tasklist);
    }

    public void execute() throws MarkExceptions {
        Message.bye();
        System.exit(0);
    }
}
