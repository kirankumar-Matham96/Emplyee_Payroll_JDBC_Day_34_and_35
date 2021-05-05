package comPreparedStatementWithEmployeePayroll;

import java.sql.*;
import java.util.Enumeration;

/**
 * Section 3: JDBC with employee payroll problem
 */
public class EmployeePayrollServices {
    /**
     * UC1: Establishing connection with database
     * UC2: Getting data from the database
     */
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/employee_payroll_services";
        String userName = "root";
        String password = "Energy123@*/+";
        String query = "select * from employee_payroll";
        Connection connection;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");//loading driver
            System.out.println("Driver loaded!");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("Cannot find the driver in the classpath!", e);
        }
        /**
        * printing the drivers
        */
        listDrivers();

        try {
            System.out.println("Connecting to database: " + url);
            connection = DriverManager.getConnection(url, userName, password);//connecting to database
            System.out.println("Connection is successful! " + connection);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            System.out.println();
            while(resultSet.next()){
                System.out.println(
                        resultSet.getInt(1)+" "+
                        resultSet.getString("name")+" "+
                        resultSet.getString("phonenumber")+" "+
                        resultSet.getString("address")+" "+
                        resultSet.getString("department")+" "+
                        resultSet.getString("gender")+" "+
                        resultSet.getString("basic_pay")+" "+
                        resultSet.getString("deductions")+" "+
                        resultSet.getString("taxable_pay")+" "+
                        resultSet.getString("tax")+" "+
                        resultSet.getString("net_pay")+" "+
                        resultSet.getString("start_date"));
            }
        } catch (Exception e) {
            throw new SQLException();
        }
    }

    /**
     * gets the drivers that loaded
     */
    private static void listDrivers() {
        Enumeration<Driver> driverList = DriverManager.getDrivers();
        while (driverList.hasMoreElements()) {
            Driver driverClass = driverList.nextElement();
            System.out.println(" " + driverClass.getClass().getName());
        }
    }
}
