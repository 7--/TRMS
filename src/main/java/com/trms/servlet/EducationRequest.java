package com.trms.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

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
        // StringBuilder buffer = new StringBuilder();
        // BufferedReader reader = request.getReader();
        // String line;
        // while ((line = reader.readLine()) != null) {
        // buffer.append(line);
        // }
        // String data = buffer.toString();
        // System.out.println("its hit " + data);
        System.out.println("Edu req obj: " + educationRequest);
    }

}
