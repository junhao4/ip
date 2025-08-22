

public class InputHandler {

    public static void handle(String msg, TaskList taskList) throws MarkExceptions {
        String[] stringParts = msg.trim().split(" ", 2);
        String command = stringParts[0].toUpperCase();
        String arg = stringParts.length > 1 ? stringParts[1] : "";

        try {
            Commands.valueOf(command).createAndExecute(arg, taskList);
        } catch (IllegalArgumentException e) {
            throw new UnknownCommandException();
        }
    }

}
