import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static java.nio.file.Files.readAllLines;

public class StudentReader  {
    public static List<Student> load(String fileName) throws Exception {
        List<Student> students = new ArrayList<>();
        List<String> lines = readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
        for (String line:lines) {
            String[] stArr = line.split(" ");
            students.add(new Student(stArr[0], stArr[1], Integer.parseInt(stArr[2])));
        }
        return students;
    }
}