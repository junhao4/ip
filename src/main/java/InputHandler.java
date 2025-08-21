

public class InputHandler {
    private static String msg;
    private static TaskList taskList;

    public static void handle(String msg, TaskList taskList) throws MarkExceptions {
        InputHandler.msg = msg;
        InputHandler.taskList = taskList;

        if (msg.startsWith("mark")) {
            handleMark();
        } else if (msg.startsWith("unmark")) {
            handleUnmark();
        } else if (msg.startsWith("delete")) {
            handleDelete();
        } else if (msg.startsWith("todo")) {
            handleTodo();
        } else if (msg.startsWith("deadline")) {
            handleDeadline();
        } else if (msg.startsWith("event")) {
            handleEvent();
        } else if (msg.equals("bye")) {
            handleBye();
        } else if (msg.equals("list")) {
            handleList();
        } else {
            throw new UnknownCommandException();
        }
    }

    private static void handleMark() throws MarkExceptions {
        if (msg.trim().equals("mark")) {
            throw new InvalidIndexException("Mark requires an index");
        }

        String index = msg.substring(5).trim();
        if (!taskList.isValidIndex(Integer.parseInt(index))) {
            throw new InvalidIndexException("This task does not exist!");
        }

        taskList.mark(index);
    }

    private static void handleUnmark() throws MarkExceptions {
        if (msg.trim().equals("unark")) {
            throw new InvalidIndexException("unmark requires an index");
        }

        String index = msg.substring(7).trim();
        if (!taskList.isValidIndex(Integer.parseInt(index))) {
            throw new InvalidIndexException("This task does not exist!");
        }

        taskList.unmark(index);
    }

    private static void handleTodo() throws MarkExceptions {
        if (msg.trim().equals("todo")) {
            throw new EmptyDescriptionException("todo");
        }
        String task = msg.substring(5);
        taskList.addTodo(task);
    }

    private static void handleDeadline() throws MarkExceptions {
        if (msg.trim().equals("deadline")) {
            throw new EmptyDescriptionException("deadline");
        } else if (!msg.contains("/by ")) {
            throw new InvalidArgumentException("Deadline task requires /by [DATE]");
        }

        String[] parts = msg.substring(9).split("/by ", 2);

        if (parts[0].trim().isEmpty()) {
            throw new EmptyDescriptionException("deadline");
        } else if (parts[1].trim().isEmpty()) {
            throw new InvalidArgumentException("Deadline task requires /by [DATE]");
        }

        taskList.addDeadline(parts[0].trim(), parts[1]);
    }

    private static void handleEvent() throws MarkExceptions {
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

    private static void handleBye() {
        Message.bye();
        System.exit(0);
    }

    private static void handleList() {
        taskList.list();
    }

    private static void handleDelete() throws MarkExceptions {
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
