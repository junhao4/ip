package inputhandler;

import command.Commands;
import command.Command;
import task.TaskList;
import exceptions.MarkExceptions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InputHandlerTest {

    @Test
    public void handle_todoInput_todoCommandCreated() throws MarkExceptions {
        String input = "todo buy books";
        Command command = InputHandler.handle(input, new TaskList());


        assertEquals(Commands.TODO.create("buy books", new TaskList()).getClass(), command.getClass());
        assertEquals(Commands.TODO.create("buy books", new TaskList()).toString(), command.toString());
    }
}
