import java.util.*;

class Student {
    private int id;
    private String fname;
    private double cgpa;

    public Student(int id, String fname, double cgpa) {
        this.id = id;
        this.fname = fname;
        this.cgpa = cgpa;
    }

    public int getId() {
        return id;
    }

    public String getFname() {
        return fname;
    }

    public double getCgpa() {
        return cgpa;
    }
}

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        List<Student> students = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int id = sc.nextInt();
            String fname = sc.next();
            double cgpa = sc.nextDouble();

            students.add(new Student(id, fname, cgpa));
        }

        Collections.sort(students, new Comparator<Student>() {

            @Override
            public int compare(Student a, Student b) {

                // 1. CGPA - decreasing order
                if (a.getCgpa() != b.getCgpa()) {
                    return Double.compare(b.getCgpa(), a.getCgpa());
                }

                // 2. First name - alphabetical order
                if (!a.getFname().equals(b.getFname())) {
                    return a.getFname().compareTo(b.getFname());
                }

                // 3. ID - ascending order
                return Integer.compare(a.getId(), b.getId());
            }
        });

        for (Student s : students) {
            System.out.println(s.getFname());
        }

        sc.close();
    }
}

