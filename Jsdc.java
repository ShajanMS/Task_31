package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Jsdc {

	public static void main(String[] args) {

		try {
			
			// Load the JDBC driver (not necessary in newer versions of JDBC)
			
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection to the database
            
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cmp_db?user=root&password=Shajan97");
            
            // SQL query to insert data
    		
       		String sql = "INSERT INTO Employee (emp_code, emp_name, emp_age, e_salary) VALUES (?, ?, ?, ?)";
            
            // Create a PreparedStatement for the SQL query
            
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            

    		
         // Data to be inserted
            
            Object[][] data = {
            		
                {101, "Jenny", 25, 10000},
                {102, "Jacky", 30, 20000},
                {103, "Joe", 20, 40000},
                {104, "John", 40, 80000},
                {105, "Shameer", 25, 90000}
            };

            
         // Insert data using the PreparedStatement
            
            for (Object[] record : data) {
            	
                preparedStatement.setInt(1, (int) record[0]); // emp_code 
                
                preparedStatement.setString(2, (String) record[1]); // emp_name
                
                preparedStatement.setInt(3, (int) record[2]); // emp_age
                
                preparedStatement.setInt(4, (int) record[3]); // e_salary

                // Execute the SQL statement
                
                preparedStatement.executeUpdate();
            }

            
            // Close the statement and connection
            
            preparedStatement.close();
            
            connection.close();

            System.out.println("Data inserted successfully!");

		} catch (ClassNotFoundException e) {
			
			System.out.println("JDBC Driver not found.");
			
            e.printStackTrace();
            

		}
		
		catch (SQLException e) {
		
			System.out.println("Database connection failure");
			
            e.printStackTrace();
		}

	}

}
