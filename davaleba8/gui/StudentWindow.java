import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class StudentWindow extends JFrame {

    private List<Student> students = new ArrayList();

    private JFrame frame;

    private JTextArea studentInfo;

    /**
     * GUI-ს შექმნა და ჩვენება.
     */
    public void createAndShowGUI() {
        JFrame.setDefaultLookAndFeelDecorated(true);
        frame = new JFrame("სტუდენტები");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createMenu();
        createLayout();
        frame.pack();
        frame.setVisible(true);
    }

    private void createLayout() {
        studentInfo = new JTextArea(20, 50);
        JScrollPane scrollPane = new JScrollPane(studentInfo);
        studentInfo.setEditable(false);
        frame.getContentPane().add(studentInfo);

    }

    private void createMenu() {
        JMenuBar mb = new JMenuBar();
        JMenu menuFile = new JMenu("File");
        JMenuItem miOpen = new JMenuItem("Open");
        JMenuItem select = new JMenuItem("select");

        miOpen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openFile();
            }
        });
        menuFile.add(miOpen);
        JMenuItem miFilter = new JMenuItem("Filter");
        miFilter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filter();
            }
        });
        menuFile.add(miFilter);

        JMenuItem miSort = new JMenuItem("Sort");
        miSort.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sort();
            }
        });
        menuFile.add(miSort);
        select.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                select();
            }
        });
        menuFile.add(select);

        mb.add(menuFile);
        frame.setJMenuBar(mb);
    }

    private void select(){
        System.out.println(studentInfo);

    }
    private void openFile() {
        try {
            students = StudentReader.load("C:/Users/Khatia/IdeaProjects/dav06/src/file.txt");
            showInfo();
        } catch (Exception ex) {
            System.out.println("ვერ მოხერხდა ფაილის გახსნა");
            ex.printStackTrace();
        }
    }

    private void filter() {
        students = StudentFilter.filter(students);
        showInfo();
    }

    private void sort() {
        students = StudentSort.sort(students);
        showInfo();
    }

    private void showInfo() {
        studentInfo.setText("");
        for (Student st: students) {
            studentInfo.append(st + "\n");
        }
    }

}
