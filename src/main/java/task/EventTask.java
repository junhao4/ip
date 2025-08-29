package task;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class EventTask extends Task {

    private LocalDate from;
    private LocalDate to;

    public EventTask(String name, LocalDate from, LocalDate to) {
        super(name);
        this.from = from;
        this.to = to;
    }

    public EventTask(String name, boolean isCompleted, LocalDate from, LocalDate to) {
        super(name, isCompleted);
        this.from = from;
        this.to = to;
    }

    @Override
    public String save() {
        return super.save() + "E#" + this.from + "#" + this.to;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMM yyyy");
        return "[E]" + super.toString() + " (from: " + from.format(formatter) + " to: " + to.format(formatter) + ")";
    }
}
