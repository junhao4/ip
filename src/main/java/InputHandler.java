

public class InputHandler {
    private static String msg;
    private static TaskList taskList;

    public static void handle(String msg, TaskList taskList) throws MarkExceptions {
        InputHandler.msg = msg.trim();
        InputHandler.taskList = taskList;

        String[] stringParts = msg.split(" ", 2);
        String command = stringParts[0];
        String arg = stringParts.length > 1 ? stringParts[1] : "";

        switch (command) {
            case "mark" -> handleMark(arg);
            case "unmark" -> handleUnmark(arg);
            case "todo" -> handleTodo(arg);
            case "deadline" -> handleDeadline(arg);
            case "event" -> handleEvent(arg);
            case "list" -> handleList(arg);
            case "delete" -> handleDelete(arg);
            case "bye" -> handleBye(arg);
            default -> throw new UnknownCommandException();

        }
    }

    private static void handleMark(String arg) throws MarkExceptions {

        try {
            if (!taskList.isValidIndex(Integer.parseInt(arg))) {
                throw new InvalidIndexException("This task does not exist!");
            }
        } catch (NumberFormatException e){
            throw new InvalidIndexException("Mark requires an index");
        }

        taskList.mark(arg);
    }

    private static void handleUnmark(String arg) throws MarkExceptions {

        try {
            if (!taskList.isValidIndex(Integer.parseInt(arg))) {
                throw new InvalidIndexException("This task does not exist!");
            }
        } catch (NumberFormatException e){
            throw new InvalidIndexException("unmark requires an index");
        }

        taskList.unmark(arg);
    }

    private static void handleTodo(String arg) throws MarkExceptions {
        if (arg.isEmpty()) {
            throw new EmptyDescriptionException("todo");
        }
        taskList.addTodo(arg);
    }

    private static void handleDeadline(String arg) throws MarkExceptions {
        if (arg.isEmpty()) {
            throw new EmptyDescriptionException("deadline");
        } else if (!msg.contains("/by ")) {
            throw new InvalidArgumentException("Deadline task requires /by [DATE]");
        }

        String[] parts = arg.split("/by ", 2);

        if (parts[0].trim().isEmpty()) {
            throw new EmptyDescriptionException("deadline");
        } else if (parts[1].trim().isEmpty()) {
            throw new InvalidArgumentException("Deadline task requires /by [DATE]");
        }

        taskList.addDeadline(parts[0].trim(), parts[1]);
    }

    private static void handleEvent(String arg) throws MarkExceptions {
        if (msg.trim().equals("event")) {
            throw new EmptyDescriptionException("event");
        } else if (!msg.contains("/from ")) {
            throw new InvalidArgumentException("Event task requires /from [DATE]");
        } else if (!msg.contains("/to ")) {
            throw new InvalidArgumentException("Event task requires /to [DATE]");
        }

        String[] parts = msg.substring(6).split("/from ", 2);
        String[] dates = parts[1].split("/to ", 2);

        if (parts[0].trim().isEmpty()) {
            throw new EmptyDescriptionException("event");
        } else if (dates[0].trim().isEmpty()) {
            throw new InvalidArgumentException("Deadline task requires /from [DATE]");
        } else if (dates[1].trim().isEmpty()) {
            throw new InvalidArgumentException("Deadline task requires /to [DATE]");
        }

        taskList.addEvent(parts[0].trim(), dates[0].trim(), dates[1]);
    }

    private static void handleBye(String arg) {
        Message.bye();
        System.exit(0);
    }

    private static void handleList(String arg) {
        taskList.list();
    }

    private static void handleDelete(String arg) throws MarkExceptions {
        if (msg.trim().equals("delete")) {
            throw new InvalidIndexException("delete requires an index");
        }

        String index = msg.substring(7).trim();
        if (!taskList.isValidIndex(Integer.parseInt(index))) {
            throw new InvalidIndexException("This task does not exist!");
        }

        taskList.delete(index);
    }


}
