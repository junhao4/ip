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

    /**
     * Adds a new deadline task to the <code>TaskList</code>.
     *
     * @throws EmptyDescriptionException if the deadline description is empty
     * @throws InvalidArgumentException if the deadline date is not given
     * @throws InvalidDateException if the date format is wrong
     */
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
            assert(parts[1] != null);
            LocalDate deadline = LocalDate.parse(parts[1]);
            taskList.addDeadline(parts[0].trim(), deadline);
        } catch (DateTimeParseException e) {
            throw new InvalidDateException();
        }

    }
}
