package com.trms.test;

import org.junit.Test;

import com.trms.database.DatabaseAccessor;
import com.trms.database.dao.Employee;

public class DataAccessorsTests {

    @Test
    public void test() {
        DatabaseAccessor databaseAccessor = new DatabaseAccessor();
        Employee employee = databaseAccessor.getEmployee("regop412@gmail.com");
        org.junit.Assert.assertTrue(employee.getEmployeeId() == 2);

    }

}
