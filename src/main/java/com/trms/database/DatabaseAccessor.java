package com.trms.database;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.trms.database.dao.EducationRequest;
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

    public ArrayList<EducationRequest> getEducationRequests(int employeeId) {
        String sql = "SELECT * FROM EducationRequest where employeeid = ?";
        ArrayList<EducationRequest> educationRequestList = new ArrayList<EducationRequest>();
        try {
            PreparedStatement prepareStatment = connection.prepareStatement(sql);
            prepareStatment.setInt(1, employeeId);
            ResultSet resultSet = prepareStatment.executeQuery();

            while (resultSet.next()) {
                EducationRequest educationRequest = new EducationRequest();
                educationRequest.setEducationRequestId(resultSet.getInt(1));
                educationRequest.setEmployeeId(resultSet.getInt(2));
                educationRequest.setSupervisorApproval(resultSet.getBoolean(3));
                educationRequest.setDepartmentHeadApproval(resultSet.getBoolean(4));
                educationRequest.setBenefitCoodinatorApproval(resultSet.getBoolean(5));
                educationRequest.setStartDate(resultSet.getDate(6));
                educationRequest.setEndDate(resultSet.getDate(7));
                educationRequest.setDaysOff(resultSet.getInt(8));
                educationRequest.setLocation(resultSet.getString(9));
                educationRequest.setJustification(resultSet.getString(10));
                educationRequest.setCost(resultSet.getInt(11));
                educationRequest.setPresetationDocumentPath(resultSet.getString(12));
                educationRequest.setReimbursmentPaid(resultSet.getBoolean(13));
                educationRequest.setType(resultSet.getInt(14));

                educationRequestList.add(educationRequest);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return educationRequestList;
    }

}
