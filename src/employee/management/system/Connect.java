package employee.management.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Connect {

	Connection connection;

	Statement statement;

	public Connect() {
		try {
			String url = "jdbc:mysql://localhost:3306/employee_database?useSSL=false";
			String user = "root";
			String password = "123456";
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, user, password);
			statement = connection.createStatement();
//			String query = "SELECT * FROM employeemanagement.Login";
//			ResultSet result = statement.executeQuery(query);
//			while (result.next()) {
//				String name = result.getString("username").trim();
//				System.out.println(name);
//				for (int i = 1; i <= result.getMetaData().getColumnCount(); i++) {
//                    System.out.print(result.getString(i) + "\t");
//                }
//			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	public static void main(String[] args) {
//		new conn();
//	}

}
