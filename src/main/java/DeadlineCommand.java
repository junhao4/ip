public class DeadlineCommand extends Command {

    public DeadlineCommand(String arg, TaskList tasklist) {
        super(arg, tasklist);
    }

    public void execute() throws MarkExceptions {
        if (arg.isEmpty()) {
            throw new EmptyDescriptionException("deadline");
        } else if (!arg.contains("/by ")) {
            throw new InvalidArgumentException("Deadline task requires /by [DATE]");
        }

        String[] parts = arg.split("/by ", 2);

        if (parts[0].trim().isEmpty()) {
            throw new EmptyDescriptionException("deadline");
        } else if (parts[1].trim().isEmpty()) {
            throw new InvalidArgumentException("Deadline task requires /by [DATE]");
        }

        taskList.addDeadline(parts[0].trim(), parts[1]);
    }
}
