package Command;

import Exceptions.InvalidIndexException;
import Exceptions.MarkExceptions;
import Task.TaskList;

public class UnmarkCommand extends Command {

    public UnmarkCommand(String arg, TaskList tasklist) {
        super(arg, tasklist);
    }

    public void execute() throws MarkExceptions {
        try {
            if (!taskList.isValidIndex(Integer.parseInt(arg))) {
                throw new InvalidIndexException("This task does not exist!");
            }
        } catch (NumberFormatException e){
            throw new InvalidIndexException("unmark requires an index");
        }

        taskList.unmark(arg);
    }
}