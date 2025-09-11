package task;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.time.format.DateTimeFormatter;

public class DeadlineTask extends Task implements GetDateable{

    private LocalDate deadline;

    public DeadlineTask(String name, LocalDate deadline) {
        super(name);
        this.deadline = deadline;
    }

    public DeadlineTask(String name, boolean isCompleted, LocalDate deadline) {
        super(name, isCompleted);
        this.deadline = deadline;
    }

    @Override
    public LocalDate getDate() {
        return deadline;
    }

    @Override
    public String save() {
        assert(deadline != null);
        return super.save() + "D#" + this.deadline;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMM yyyy");
        return "[D]" + super.toString() + " (by: " + deadline.format(formatter) + ")";
    }

    @Override
    public boolean isUpcoming(ChronoLocalDate today) {
        return deadline.isAfter(today);
    }
}
