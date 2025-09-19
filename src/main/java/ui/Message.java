package ui;

public class Message {
    public enum Type { NORMAL, ERROR }

    private String message;
    private Type type;

    private Message(Type type, String message) {
        this.type = type;
        this.message = message;
    }

    public static Message normal(String message) {
        return new Message(Type.NORMAL, message);
    }

    public static Message error(String message) {
        return new Message(Type.ERROR, message);
    }

    public String getMessage() {
        return message;
    }

    public Type getType() {
        return type;
    }
}
