import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentDAO {

    Connection con;

   public StudentDAO() {

    con = DBConnection.getConnection();

    if(con == null) {
        System.out.println("Connection Failed");
    }
    else {
        System.out.println("Connection Success");
    }
}
    // Add Student
    public void addStudent(Student s) {

        try {

            String query = "INSERT INTO students(name, department, marks) VALUES(?,?,?)";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, s.getName());
            ps.setString(2, s.getDepartment());
            ps.setDouble(3, s.getMarks());

            ps.executeUpdate();

            System.out.println("Student Added Successfully");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // View Students
    public void viewStudents() {

        try {

            String query = "SELECT * FROM students";

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {

                System.out.println("--------------------");
                System.out.println("ID : " + rs.getInt("id"));
                System.out.println("Name : " + rs.getString("name"));
                System.out.println("Department : " + rs.getString("department"));
                System.out.println("Marks : " + rs.getDouble("marks"));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // Update Student
    public void updateStudent(int id, double marks) {

        try {

            String query = "UPDATE students SET marks=? WHERE id=?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setDouble(1, marks);
            ps.setInt(2, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Student Updated Successfully");
            } else {
                System.out.println("Student Not Found");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // Delete Student
    public void deleteStudent(int id) {

        try {

            String query = "DELETE FROM students WHERE id=?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Student Deleted Successfully");
            } else {
                System.out.println("Student Not Found");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}