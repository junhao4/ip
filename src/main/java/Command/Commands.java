package Command;

import Task.TaskList;

public enum Commands {
    MARK(MarkCommand::new),
    UNMARK(UnmarkCommand::new),
    TODO(TodoCommand::new),
    DEADLINE(DeadlineCommand::new),
    EVENT(EventCommand::new),
    LIST(ListCommand::new),
    DELETE(DeleteCommand::new),
    BYE(ByeCommand::new);

    private final CommandBuilder cmdBuilder;

    Commands(CommandBuilder cmdBuilder) {
        this.cmdBuilder = cmdBuilder;
    }

    public Command create(String arg, TaskList taskList) {
        return this.cmdBuilder.build(arg, taskList);
    }
}
