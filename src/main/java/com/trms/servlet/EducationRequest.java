package com.trms.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.trms.database.DatabaseAccessor;

@WebServlet(urlPatterns = "/EducationRequest")
public class EducationRequest extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("educatin request GET called");
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ObjectMapper mapper = new ObjectMapper();
        com.trms.database.dao.EducationRequest educationRequest = mapper.readValue(request.getInputStream(), com.trms.database.dao.EducationRequest.class);

        System.out.println("Edu req obj: " + educationRequest);
        DatabaseAccessor databaseAccessor = new DatabaseAccessor();
        databaseAccessor.insertEducationRequest(educationRequest);

    }

}
