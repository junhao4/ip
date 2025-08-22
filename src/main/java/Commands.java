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

    public void createAndExecute(String arg, TaskList taskList) throws MarkExceptions {
        this.cmdBuilder.create(arg, taskList).execute();
    }
}
