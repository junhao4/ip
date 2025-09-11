package task;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;

public abstract class Task {
    private String name;
    private boolean isCompleted;

    public Task(String name) {
        this.name = name;
        this.isCompleted = false;
    }

    public Task(String name, boolean isCompleted) {
        this.name = name;
        this.isCompleted = isCompleted;
    }

    public void mark() {
        this.isCompleted = true;
    }

    public void unmark() {
        this.isCompleted = false;
    }

    public String getName() {
        return this.name;
    }

    public boolean getIsCompleted() {
        return this.isCompleted;
    }

    public boolean isUpcoming(ChronoLocalDate today) {
        return false;
    }

    public String save() {
        assert(name != null);
        return this.name.length()
                + "#"
                + this.name
                + "#"
                + this.isCompleted
                + "#";
    }

    @Override
    public String toString() {
        String result = "";
        if (this.isCompleted) {
            result += "[x]";
        } else {
            result += "[ ]";
        }
        return result + " " + this.name;
    }

}
