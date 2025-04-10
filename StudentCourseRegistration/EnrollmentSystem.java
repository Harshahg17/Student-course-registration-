
import java.util.*;

public class EnrollmentSystem {
    static List<Student> students = new ArrayList<>();
    static List<Course> courses = new ArrayList<>();
    static Map<Integer, List<Integer>> enrollments = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n1. Add Student\n2. Add Course\n3. Enroll Student\n4. View Enrollments\n5. Exit");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    students.add(new Student(id, name));
                    System.out.println("Student added.");
                }
                case 2 -> {
                    System.out.print("Enter course ID: ");
                    int cid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter course name: ");
                    String cname = sc.nextLine();
                    courses.add(new Course(cid, cname));
                    System.out.println("Course added.");
                }
                case 3 -> {
                    System.out.print("Enter student ID: ");
                    int sid = sc.nextInt();
                    System.out.print("Enter course ID: ");
                    int cid = sc.nextInt();
                    enrollments.putIfAbsent(sid, new ArrayList<>());
                    enrollments.get(sid).add(cid);
                    System.out.println("Student enrolled.");
                }
                case 4 -> {
                    for (Map.Entry<Integer, List<Integer>> entry : enrollments.entrySet()) {
                        int sid = entry.getKey();
                        Student s = students.stream().filter(stu -> stu.getId() == sid).findFirst().orElse(null);
                        System.out.println("Student: " + (s != null ? s.getName() : "Unknown"));
                        for (int cid : entry.getValue()) {
                            Course c = courses.stream().filter(crs -> crs.getCourseId() == cid).findFirst().orElse(null);
                            System.out.println("   -> " + (c != null ? c.getCourseName() : "Unknown Course"));
                        }
                    }
                }
                case 5 -> {
                    System.out.println("Exiting...");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }
}
