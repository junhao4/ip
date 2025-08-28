package Command;

import Exceptions.EmptyDescriptionException;
import Exceptions.MarkExceptions;
import Task.TaskList;

public class TodoCommand extends Command {

    public TodoCommand(String arg, TaskList tasklist) {
        super(arg, tasklist);
    }

    public void execute() throws MarkExceptions {
        if (arg.isEmpty()) {
            throw new EmptyDescriptionException("todo");
        }
        taskList.addTodo(arg);
    }
}
