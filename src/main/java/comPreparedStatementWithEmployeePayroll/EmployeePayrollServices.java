package comPreparedStatementWithEmployeePayroll;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Enumeration;

/**
 * Section 3: JDBC with employee payroll problem
 */
public class EmployeePayrollServices {
    /**
     * UC1
     */
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/employee_payroll_services";
        String userName = "root";
        String password = "Energy123@*/+";
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
        } catch (Exception e) {
            e.printStackTrace();
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

    /**
     * UC2
     */

    /**
     * UC3
     */

    /**
     * UC4
     */
}
