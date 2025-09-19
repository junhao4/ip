package ui;

public class Message {
    public enum Type { NORMAL, ERROR, INFO, SUCCESS, WARNING }

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

    public static Message info(String message) {
        return new Message(Type.INFO, message);
    }

    public static Message success(String message) {
        return new Message(Type.SUCCESS, message);
    }

    public static Message warning(String message) {
        return new Message(Type.WARNING, message);
    }

    public String getMessage() {
        return message;
    }

    public Type getType() {
        return type;
    }
}
