package Storage;

import Task.Task;
import Task.TaskList;
import Task.TodoTask;
import Task.DeadlineTask;
import Task.EventTask;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;

public class Storage {
    private String file;

    public Storage(String pathString, String file) {
        try {
            this.file = file;
            Path path = Path.of(pathString);
            Path filePath = Path.of(file);
            if (Files.notExists(path)) {
                Files.createDirectory(path);
            }
            if (Files.notExists(filePath)) {
                Files.createFile(filePath);
            }

        } catch (IOException e) {
            System.out.println(e.getMessage() + "ERROR");
        }
    }


    public ArrayList<Task> load() {
        try {
            ArrayList<Task> taskList = new ArrayList<>();
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;

            while ((line = reader.readLine()) != null) {
                String[] lengthPart = line.split("#", 2);
                int length = Integer.parseInt(lengthPart[0]);
                String name = lengthPart[1].substring(0, length);
                line = lengthPart[1].substring(length + 1);
                String[] parts = line.split("#");

                switch (parts[1]) {
                case "T":
                    taskList.add(new TodoTask(name, Boolean.parseBoolean(parts[0])));
                    break;
                case "D":
                    taskList.add(new DeadlineTask(name, Boolean.parseBoolean(parts[0]), LocalDate.parse(parts[2])));
                    break;
                case "E":
                    taskList.add(new EventTask(name, Boolean.parseBoolean(parts[0]), LocalDate.parse(parts[2]), LocalDate.parse(parts[3])));
                    break;
                }

            }
            return taskList;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void save(TaskList taskList) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(taskList.save());
            writer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
