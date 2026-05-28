import java.util.Scanner;

public class StudentController {

    StudentDAO dao = new StudentDAO();

    StudentView view = new StudentView();

    Scanner sc = new Scanner(System.in);

    public void start() {

        while (true) {

            int choice = view.menu();

            switch (choice) {

                case 1:

                    System.out.print("Enter Name : ");
                    String name = sc.next();

                    System.out.print("Enter Department : ");
                    String dept = sc.next();

                    System.out.print("Enter Marks : ");
                    double marks = sc.nextDouble();

                    Student s = new Student();

                    s.setName(name);
                    s.setDepartment(dept);
                    s.setMarks(marks);

                    dao.addStudent(s);

                    break;

                case 2:

                    dao.viewStudents();

                    break;

                case 3:

                    System.out.print("Enter Student ID : ");
                    int id = sc.nextInt();

                    System.out.print("Enter New Marks : ");
                    double newMarks = sc.nextDouble();

                    dao.updateStudent(id, newMarks);

                    break;

                case 4:

                    System.out.print("Enter Student ID : ");
                    int deleteId = sc.nextInt();

                    dao.deleteStudent(deleteId);

                    break;

                case 5:

                    System.out.println("Thank You");
                    System.exit(0);
                    break;

                default:

                    System.out.println("Invalid Choice");
            }
        }
    }
}