package com.trms.database;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
        String sql = "INSERT INTO EducationRequest(EmployeeId, startDate, endDate, daysOff, location, justification, cost, type)" + "values(?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement prepareStatment = connection.prepareStatement(sql);
            prepareStatment.setLong(1, educationRequest.getEmployeeId());
            prepareStatment.setDate(2, educationRequest.getStartDate());
            prepareStatment.setDate(3, educationRequest.getEndDate());
            prepareStatment.setLong(4, educationRequest.getDaysOff());
            prepareStatment.setString(5, educationRequest.getLocation());
            prepareStatment.setString(6, educationRequest.getJustification());
            prepareStatment.setLong(7, educationRequest.getCost());
            prepareStatment.setLong(8, educationRequest.getType());
            prepareStatment.executeUpdate();
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
