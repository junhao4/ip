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

    private static void handleMark() {
        taskList.mark(msg.substring(5));
    }

    private static void handleUnmark() {
        taskList.unmark(msg.substring(7));
    }

    private static void handleTodo() {
        taskList.addTodo(msg.substring(5));
    }

    private static void handleDeadline() {
        String[] parts = msg.substring(9).split("/by ", 2);
        taskList.addDeadline(parts[0].trim(), parts[1]);
    }

    private static void handleEvent() {
        String[] parts = msg.substring(6).split("/from ", 2);
        String[] dates = parts[1].split("/to ", 2);
        taskList.addEvent(parts[0].trim(), dates[0].trim(), dates[1]);
    }

    private static void handleBye() {
        Message.bye();
        System.exit(0);
    }

    private static void handleList() {
        taskList.list();
    }


}
