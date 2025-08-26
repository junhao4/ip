public class EventTask extends Task {

    private String from;
    private String to;

    public EventTask(String name, String from, String to) {
        super(name);
        this.from = from;
        this.to = to;
    }

    public EventTask(String name, boolean isCompleted, String from, String to) {
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
        return "[E]" + super.toString() + " (from: " + from + " to: " + to + ")";
    }
}
