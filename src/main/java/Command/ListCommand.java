package Command;

import Exceptions.MarkExceptions;
import Task.TaskList;

public class ListCommand extends Command {

    public ListCommand(String arg, TaskList tasklist) {
        super(arg, tasklist);
    }

    public void execute() throws MarkExceptions {
        taskList.list();
    }
}
