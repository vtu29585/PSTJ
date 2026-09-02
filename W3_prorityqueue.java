import java.util.*;

class Student {
    private int id;
    private String name;
    private double cgpa;

    public Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public int getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getCGPA() {
        return cgpa;
    }
}

class Priorities {

    public List<Student> getStudents(List<String> events) {

        PriorityQueue<Student> queue = new PriorityQueue<>(
            new Comparator<Student>() {
                @Override
                public int compare(Student a, Student b) {

                    // 1. Higher CGPA first
                    int cgpaCompare = Double.compare(
                        b.getCGPA(),
                        a.getCGPA()
                    );

                    if (cgpaCompare != 0) {
                        return cgpaCompare;
                    }

                    // 2. Name in alphabetical order
                    int nameCompare = a.getName().compareTo(b.getName());

                    if (nameCompare != 0) {
                        return nameCompare;
                    }

                    // 3. Smaller ID first
                    return Integer.compare(a.getID(), b.getID());
                }
            }
        );

        for (String event : events) {

            String[] parts = event.split(" ");

            if (parts[0].equals("ENTER")) {

                String name = parts[1];
                double cgpa = Double.parseDouble(parts[2]);
                int id = Integer.parseInt(parts[3]);

                queue.offer(new Student(id, name, cgpa));

            } else if (parts[0].equals("SERVED")) {

                if (!queue.isEmpty()) {
                    queue.poll();
                }
            }
        }

        List<Student> result = new ArrayList<>();

        while (!queue.isEmpty()) {
            result.add(queue.poll());
        }

        return result;
    }
}