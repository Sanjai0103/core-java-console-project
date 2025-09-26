package Student_Management;
import java.sql.Connection;
import java.sql.DriverManager;


public class DBconnect {

	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root","");
		}catch(Exception e) {
			System.out.println(e);
				
			}
		return con;
		}
		

	}


