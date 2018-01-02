package com.trms.database.dao;

import java.sql.Timestamp;

public class EducationRequest {
    private int educationRequestId;
    private int employeeId;
    private boolean supervisorApproval;
    private boolean departmentHeadApproval;
    private boolean benefitCoodinatorApproval;
    private Timestamp startDate;
    private Timestamp endDate;
    private int daysOff;
    private String location;
    private String Justification;
    private int cost;
    private String presetationDocumentPath;
    private boolean reimbursmentPaid;
    private int type;

    public int getEducationRequestId() {
        return educationRequestId;
    }

    public void setEducationRequestId(int educationRequestId) {
        this.educationRequestId = educationRequestId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public boolean isSupervisorApproval() {
        return supervisorApproval;
    }

    public void setSupervisorApproval(boolean supervisorApproval) {
        this.supervisorApproval = supervisorApproval;
    }

    public boolean isDepartmentHeadApproval() {
        return departmentHeadApproval;
    }

    public void setDepartmentHeadApproval(boolean departmentHeadApproval) {
        this.departmentHeadApproval = departmentHeadApproval;
    }

    public boolean isBenefitCoodinatorApproval() {
        return benefitCoodinatorApproval;
    }

    public void setBenefitCoodinatorApproval(boolean benefitCoodinatorApproval) {
        this.benefitCoodinatorApproval = benefitCoodinatorApproval;
    }

    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    public Timestamp getEndDate() {
        return endDate;
    }

    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }

    public int getDaysOff() {
        return daysOff;
    }

    public void setDaysOff(int daysOff) {
        this.daysOff = daysOff;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getJustification() {
        return Justification;
    }

    public void setJustification(String justification) {
        Justification = justification;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getPresetationDocumentPath() {
        return presetationDocumentPath;
    }

    public void setPresetationDocumentPath(String presetationDocumentPath) {
        this.presetationDocumentPath = presetationDocumentPath;
    }

    public boolean isReimbursmentPaid() {
        return reimbursmentPaid;
    }

    public void setReimbursmentPaid(boolean reimbursmentPaid) {
        this.reimbursmentPaid = reimbursmentPaid;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

}
