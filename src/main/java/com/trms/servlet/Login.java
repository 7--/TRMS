package com.trms.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.trms.database.DatabaseAccessor;
import com.trms.database.dao.Employee;

/**
 * Servlet implementation class Login TODO implement log4j, create DAOs for
 * datasets, get/post employee
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        System.out.println("Request email: " + email);
        DatabaseAccessor databaseAccessor = new DatabaseAccessor();
        Employee employee = databaseAccessor.getEmployee(email);
        ObjectMapper mapper = new ObjectMapper();
        String employeeJson = mapper.writeValueAsString(employee);

        response.getWriter().write(employeeJson);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
