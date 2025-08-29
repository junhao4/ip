package command;

import exceptions.MarkExceptions;
import task.TaskList;

public class ListCommand extends Command {

    public ListCommand(String arg, TaskList tasklist) {
        super(arg, tasklist);
    }

    public void execute() throws MarkExceptions {
        taskList.list();
    }
}
