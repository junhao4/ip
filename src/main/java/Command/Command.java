package Command;

import Exceptions.MarkExceptions;
import Task.TaskList;
import Storage.Storage;

public abstract class Command {
    String arg;
    TaskList taskList;

    public Command(String arg, TaskList tasklist) {
        this.arg = arg;
        this.taskList = tasklist;
    }

    public void executeAndSave(Storage storage) throws MarkExceptions {
        this.execute();
        storage.save(taskList);
    }

    public abstract void execute() throws MarkExceptions;
}
