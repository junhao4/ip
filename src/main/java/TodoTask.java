public class TodoTask extends Task {

    public TodoTask(String name) {
        super(name);
    }

    @Override
    public void store() {
	StringBuilder taskString = new StringBuilder();
	taskString.append(this.name.length());

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }

}
