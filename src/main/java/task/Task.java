package task;

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

    public String getIsCompleted() {
        return ((Boolean)this.isCompleted).toString();
    }

    public String save() {
        return this.name.length() +
                "#" +
                this.name +
                "#" +
                this.isCompleted +
                "#";
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
