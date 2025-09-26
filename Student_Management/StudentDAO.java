package Student_Management;
import java.sql.*;
//import java.util.*;

public class StudentDAO {

	public void addStudent(Student s1){
		try (Connection con = DBconnect.getConnection()){
			String sql = "INSERT INTO Students(name,course,marks)Values(?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,s1.name);
			ps.setString(2, s1.course);
			ps.setDouble(3, s1.marks);
			ps.executeUpdate();
			System.out.println("Student added successfully");
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}
	
	public void viewStudents() throws SQLException {
		try (Connection con = DBconnect.getConnection()){
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT* FROM students");
			System.out.println("\n Student List:");
			while (rs.next()) {
				System.out.println(rs.getString("name")+"|"+rs.getString("course")+"|"+rs.getDouble("marks"));
				
			}
			}catch(Exception e) {
				System.out.println(e);
		}
	}
	public void updateStudent(int id,Student s1) throws SQLException{
		try (Connection con = DBconnect.getConnection()){
			String sql = "UPDATE Students SET name?,course=?,marks=?WHERE id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, s1.name);
			ps.setString(2, s1.course);
			ps.setDouble(3, s1.marks);
			ps.setInt(4, id);
			int rows =ps.executeUpdate();
			System.out.println(rows>0?"Student updated":"student not found");
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
	}
	public void deleteStudent(int id) throws SQLException {
		try(Connection con = DBconnect.getConnection()){
			String sql = "DELETE FROM students WHERE id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			int rows = ps.executeUpdate();
			System.out.println(rows>0 ? "Student deleted":"Student not found");
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	}

	

