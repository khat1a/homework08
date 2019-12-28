import java.util.ArrayList;
import java.util.List;

public class StudentFilter {
    public static List<Student> filter(List<Student> students) {
        List<Student> filtStud = new ArrayList<>();
        for (Student st: students) {
            if (st.getAge() != 70) {
                filtStud.add(st);
            }
        }
        return filtStud;
    }
}
