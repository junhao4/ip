//package Storage;
//
//import Task.DeadlineTask;
//import Task.EventTask;
//import Task.TodoTask;
//import Task.Task;
//import org.junit.jupiter.api.Test;
//
//import java.time.LocalDate;
//import java.util.ArrayList;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//public class StorageTest {
//    private final String testDir = ".";
//    private final String testFile = "StorageTestText.txt";
//
//    @Test
//    public void storage_loadFile_createArrayList () {
//        Storage storage = new Storage(testDir, testFile);
//        ArrayList<Task> tasks = new ArrayList<>();
//        tasks.add(new TodoTask("read book", false));
//        tasks.add(new DeadlineTask("return book", false, LocalDate.of(2019, 12, 1)));
//        tasks.add(new DeadlineTask("do ip", true, LocalDate.of(2025, 8, 28)));
//        tasks.add(new EventTask("go to school and study", true,
//                LocalDate.of(2025, 8, 28),
//                LocalDate.of(2025, 8, 28)));
//        tasks.add(new TodoTask("make cake", false));
//
//        ArrayList<Task> loadedTasks = storage.load();
//        assertEquals(tasks.size(), loadedTasks.size());
//        for (int i = 0; i < tasks.size(); i++) {
//            assertEquals(tasks.get(i).getName(), loadedTasks.get(i).getName());
//        }
//    }
//}
