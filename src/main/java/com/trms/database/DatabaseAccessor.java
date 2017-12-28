package com.trms.database;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.trms.database.ConnectionUtil;
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
        String sql = "SELECT * FROM Employee where EMAIL  ='?';";
        Employee employee = new Employee();
        try {
            PreparedStatement prepareStatment = connection.prepareStatement(sql);
            prepareStatment.setString(1, email);
            ResultSet resultSet = prepareStatment.executeQuery();
            while (resultSet.next()) {
                employee.setEmployeeId(resultSet.getInt(1));

            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return employee;

    }
}
