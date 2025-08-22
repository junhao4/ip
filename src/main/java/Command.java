public abstract class Command {
    String arg;
    TaskList taskList;

    public Command(String arg, TaskList tasklist) {
        this.arg = arg;
        this.taskList = tasklist;
    }

    public abstract void execute() throws MarkExceptions;
}
