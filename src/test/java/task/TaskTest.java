package task;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskTest {

    @Test
    public void taskSave_nameWithDelimiter_canSave() {
        Task task = new TodoTask("hello##this#is a long compl#12309?>cated name");
        assertEquals("45#hello##this#is a long compl#12309?>cated name#false#T", task.save());
    }
}
