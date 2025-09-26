package Student_Management;
import java.sql.SQLException;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		StudentDAO dao = new StudentDAO();
		while(true) {
			System.out.println("\n STUDENT MANAGEMENT SYSTEM");
			System.out.println("1.Add Student");
			System.out.println("2.View Student");
			System.out.println("3.Update Student");
			System.out.println("4.Delete Student");
			System.out.println("5.Exit");
			System.out.println("Enter Choice");
			int choice = sc.nextInt();
			sc.nextLine();
			
			switch(choice) {
			case 1:
				System.out.print("Enter Name:");
				String name =  sc.nextLine();
				System.out.print("Enter course");
				String course = sc.nextLine();
				System.out.println("Enter marks:");
				double marks = sc.nextDouble();
				dao.addStudent(new Student(0,name,course,marks));
				break;
			case 2:
				dao.viewStudents();
				break;
			case 3:
				System.out.println("Enter Student id to Update:");
				int uid =sc.nextInt();
				sc.nextLine();
				System.out.println("New Name:");
				String uname = sc.nextLine();
				System.out.println("new Course");
				String ucourse = sc.nextLine();
				System.out.println("New Marks");
				double umarks = sc.nextDouble();
				
			 dao.updateStudent(uid,new Student (uid,uname,ucourse,umarks));
				break;
			case 4:
				System.out.println("Enter student id to Delete:");
				int did = sc.nextInt();
				dao.deleteStudent(did);
				break;
			case 5:
				System.out.println("Exiting...");
				System.exit(0);
				default:
					System.out.println("invalid choice");
					
				
				
						
			}
			
		}

	}

}
