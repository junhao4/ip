package command;

import exceptions.EmptyDescriptionException;
import exceptions.InvalidArgumentException;
import exceptions.InvalidDateException;
import exceptions.MarkExceptions;
import task.TaskList;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

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

        try {
            LocalDate deadline = LocalDate.parse(parts[1]);
            taskList.addDeadline(parts[0].trim(), deadline);
        } catch (DateTimeParseException e) {
            throw new InvalidDateException();
        }

    }
}
