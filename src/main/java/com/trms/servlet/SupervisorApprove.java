package com.trms.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.trms.database.DatabaseAccessor;

/**
 * Servlet implementation class SupervisorApprove
 */
@WebServlet("/SupervisorApprove")
public class SupervisorApprove extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupervisorApprove() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String employeeId = request.getParameter("employee_id");
        ArrayList<com.trms.database.dao.EducationRequest> educationRequestList = new ArrayList<com.trms.database.dao.EducationRequest>();
        if (employeeId != null) {
            int employeeIdInt = Integer.parseInt(employeeId);
            System.out.println("employee id: " + employeeId);
            DatabaseAccessor databaseAccessor = new DatabaseAccessor();
            educationRequestList = databaseAccessor.getRequestsSupervisorApprove(employeeIdInt);
        }
        for (com.trms.database.dao.EducationRequest educationRequest : educationRequestList) {
            System.out.println("Supervisor Approve EdReq toString: " + educationRequest.toString());
        }
        ObjectMapper mapper = new ObjectMapper();
        String employeeJson = mapper.writeValueAsString(educationRequestList);

        response.getWriter().write(employeeJson);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String supAprReqId = request.getParameter("sup_apr_req_id");
        if (supAprReqId != null) {
            int supAprReqIdInt = Integer.parseInt(supAprReqId);
            System.out.println("supAprReqId id: " + supAprReqId);
            DatabaseAccessor databaseAccessor = new DatabaseAccessor();
            boolean supr_appr_add = databaseAccessor.SupApr(supAprReqIdInt);
        }

    }

}
