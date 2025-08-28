package Command;

import Task.TaskList;

public interface CommandBuilder {
    public Command build(String arg, TaskList taskList);
}
