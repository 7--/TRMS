package com.trms.database;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.trms.database.dao.Employee;

public class DatabaseAccessor {

    private Connection connection;

    public DatabaseAccessor() {
        try {
            connection = ConnectionUtil.getConnection();
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    public Employee getEmployee(String email) {
        String sql = "SELECT * FROM Employee where EMAIL = ?";
        Employee employee = new Employee();
        try {
            PreparedStatement prepareStatment = connection.prepareStatement(sql);
            prepareStatment.setString(1, email);

            ResultSet resultSet = prepareStatment.executeQuery();
            while (resultSet.next()) {
                employee.setEmployeeId(resultSet.getInt(1));
                employee.setLastName(resultSet.getString(2));
                employee.setFirstName(resultSet.getString(3));
                employee.setSupervisor(resultSet.getInt(4));
                employee.setDepartment(resultSet.getInt(5));
                employee.setBenefitCoodinator(resultSet.getBoolean(6));
                employee.setEmail(resultSet.getString(7));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;

    }

    public boolean insertEducationRequest(com.trms.database.dao.EducationRequest educationRequest) {
        // create a Statement from the connection
        Statement statement;
        try {
            statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO Customers " + "VALUES (1001, 'Simpson', 'Mr.', 'Springfield', 2001)");

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        // insert the data
        return true;
    }

    public Employee getEducationRequests(int employeeId) {

        return null;
    }

}
