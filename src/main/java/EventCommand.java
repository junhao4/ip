public class EventCommand extends Command {

    public EventCommand(String arg, TaskList tasklist) {
        super(arg, tasklist);
    }

    public void execute() throws MarkExceptions {
        if (arg.isEmpty()) {
            throw new EmptyDescriptionException("event");
        } else if (!arg.contains("/from ")) {
            throw new InvalidArgumentException("Event task requires /from [DATE]");
        } else if (!arg.contains("/to ")) {
            throw new InvalidArgumentException("Event task requires /to [DATE]");
        }

        String[] parts = arg.split("/from ", 2);
        String[] dates = parts[1].split("/to ", 2);

        if (parts[0].trim().isEmpty()) {
            throw new EmptyDescriptionException("event");
        } else if (dates[0].trim().isEmpty()) {
            throw new InvalidArgumentException("Deadline task requires /from [DATE]");
        } else if (dates[1].trim().isEmpty()) {
            throw new InvalidArgumentException("Deadline task requires /to [DATE]");
        }

        taskList.addEvent(parts[0].trim(), dates[0].trim(), dates[1]);
    }
}
