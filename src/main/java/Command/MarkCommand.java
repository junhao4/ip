package Command;

import Exceptions.InvalidIndexException;
import Exceptions.MarkExceptions;
import Task.TaskList;

public class MarkCommand extends Command {

    public MarkCommand(String arg, TaskList tasklist) {
        super(arg, tasklist);
    }

    public void execute() throws MarkExceptions {
        try {
            if (!taskList.isValidIndex(Integer.parseInt(arg))) {
                throw new InvalidIndexException("This task does not exist!");
            }
        } catch (NumberFormatException e){
            throw new InvalidIndexException("Mark requires an index");
        }

        taskList.mark(arg);
    }
}