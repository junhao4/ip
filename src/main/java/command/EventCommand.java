package command;

import exceptions.EmptyDescriptionException;
import exceptions.InvalidArgumentException;
import exceptions.InvalidDateException;
import exceptions.MarkExceptions;
import task.TaskList;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class EventCommand extends Command {

    public EventCommand(String arg, TaskList tasklist) {
        super(arg, tasklist);
    }

    /**
     * Adds a new event task to the <code>TaskList</code>.
     *
     * @throws EmptyDescriptionException if the event description is empty
     * @throws InvalidArgumentException if the event date is not given
     * @throws InvalidDateException if the date format is wrong
     */
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

        try {
            LocalDate from = LocalDate.parse(dates[0].trim());
            LocalDate to = LocalDate.parse(dates[1]);
            taskList.addEvent(parts[0].trim(), from, to);
        } catch (DateTimeParseException e) {
            throw new InvalidDateException();
        }

    }
}
