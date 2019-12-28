import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StudentSort {
    public static List<Student> sort(List<Student> students) {
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                if (!s1.getName().equals(s2.getName())) {
                    return s1.getName().compareTo(s2.getName());
                }
                if (!s1.getSurName().equals(s2.getSurName())) {
                    return s1.getSurName().compareTo(s2.getSurName());
                }
                return s1.getAge() - s1.getAge();
            }
        });

        return students;
    }

}