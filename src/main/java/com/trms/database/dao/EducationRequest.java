package com.trms.database.dao;

import java.sql.Date;
import java.util.Calendar;

public class EducationRequest {
    private int educationRequestId;
    private int employeeId;
    private boolean supervisorApproval;
    private boolean departmentHeadApproval;
    private boolean benefitCoodinatorApproval;
    private Date startDate;
    private Date endDate;
    private int daysOff;
    private String location;
    private String justification;
    private int cost;

    @Override
    public String toString() {
        return "EducationRequest [educationRequestId=" + educationRequestId + ", employeeId=" + employeeId + ", supervisorApproval=" + supervisorApproval + ", departmentHeadApproval=" + departmentHeadApproval + ", benefitCoodinatorApproval=" + benefitCoodinatorApproval + ", startDate=" + startDate + ", endDate=" + endDate + ", daysOff=" + daysOff + ", location=" + location + ", justification=" + justification + ", cost=" + cost + ", presetationDocumentPath=" + presetationDocumentPath + ", reimbursmentPaid=" + reimbursmentPaid + ", type=" + type + "]";
    }

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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        // day is set a day behind for some reason, so I'm adding a day
        Calendar cal = Calendar.getInstance();
        cal.setTime(startDate);
        cal.add(Calendar.DAY_OF_YEAR, 1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        this.startDate = new java.sql.Date(cal.getTimeInMillis());

    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        // day is set a day behind for some reason, so I'm adding a day
        Calendar cal = Calendar.getInstance();
        cal.setTime(endDate);
        cal.add(Calendar.DAY_OF_YEAR, 1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        this.endDate = new java.sql.Date(cal.getTimeInMillis());
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
        return justification;
    }

    public void setJustification(String justification) {
        this.justification = justification;
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
