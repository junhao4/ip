import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Mark {
    static TaskList taskList;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Storage storage = new Storage("./data", "./data/Mark.txt");
        taskList = new TaskList(storage.load());

        Message.intro();


        while(sc.hasNext()) {
            String msg = sc.nextLine();

            try {
                Command c = InputHandler.handle(msg, taskList);
                c.executeAndSave(storage);
            } catch (MarkExceptions e) {
                Message.println(e.getMessage());
            }
        }
    }
}


