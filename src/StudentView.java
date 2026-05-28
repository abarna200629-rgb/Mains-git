import java.util.Scanner;

public class StudentView {

    Scanner sc = new Scanner(System.in);

    public int menu() {

        System.out.println("\n===== Student Management System =====");

        System.out.println("1. Add Student");
        System.out.println("2. View Students");
        System.out.println("3. Update Student");
        System.out.println("4. Delete Student");
        System.out.println("5. Exit");

        System.out.print("Enter Choice : ");

        return sc.nextInt();
    }
}