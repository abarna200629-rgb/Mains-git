import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        StudentController controller =
                new StudentController(10);

        StudentView view = new StudentView();

        while (true) {

            System.out.println("\n--- Student Menu ---");
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Mark");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");

            System.out.print("Enter Choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();

                    sc.nextLine();

                    String name;

                    while (true) {

                        System.out.print("Enter Name: ");
                        name = sc.nextLine();

                        if (name.matches("[a-zA-Z ]+")) {
                            break;
                        }
                        else {
                            System.out.println(
                              "Invalid Name! Only letters allowed.");
                        }
                    }

                    int mark;

                    while (true) {

                        System.out.print("Enter Mark: ");

                        if (sc.hasNextInt()) {

                            mark = sc.nextInt();
                            break;
                        }
                        else {

                            System.out.println(
                              "Invalid Mark! Only integer allowed.");

                            sc.next();
                        }
                    }

                    controller.addStudent(id, name, mark);

                    System.out.println(
                      "Student Added Successfully");

                    break;

                case 2:

                    view.displayStudents(
                            controller.getStudents(),
                            controller.getCount());

                    break;

                case 3:

                    sc.nextLine();

                    System.out.print("Enter Student Name: ");
                    String search = sc.nextLine();

                    if (controller.searchStudent(search) != null)
                        System.out.println("Student Found");
                    else
                        System.out.println("Student Not Found");

                    break;

                case 4:

                    sc.nextLine();

                    System.out.print("Enter Student Name: ");
                    String update = sc.nextLine();

                    int newMark;

                    while (true) {

                        System.out.print("Enter New Mark: ");

                        if (sc.hasNextInt()) {

                            newMark = sc.nextInt();
                            break;
                        }
                        else {

                            System.out.println(
                              "Invalid Mark! Only integer allowed.");

                            sc.next();
                        }
                    }

                    System.out.println(
                            controller.updateMark(update, newMark));

                    break;

                case 5:

                    sc.nextLine();

                    System.out.print("Enter Student Name: ");
                    String delete = sc.nextLine();

                    System.out.println(
                            controller.deleteStudent(delete));

                    break;

                case 6:

                    System.out.println("Exiting...");
                    return;

                default:

                    System.out.println("Invalid Choice");
            }
        }
    }
}