public class Task {
    private String name;
    private boolean completed;

    public Task(String name) {
        this.name = name;
        this.completed = false;
    }

    public void mark() {
        this.completed = true;
    }

    public void unmark() {
        this.completed = false;
    }

    @Override
    public String toString() {
        String result = "";
        if (this.completed) {
            result += "[x]";
        } else {
            result += "[ ]";
        }
        return result + " " + this.name;
    }

}
