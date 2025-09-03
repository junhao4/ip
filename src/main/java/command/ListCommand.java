package command;

import task.TaskList;

public class ListCommand extends Command {

    public ListCommand(String arg, TaskList tasklist) {
        super(arg, tasklist);
    }

    /**
     * List all the task in the <code>TaskList</code>
     */
    public void execute() {
        taskList.list();
    }
}
