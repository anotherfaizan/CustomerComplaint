package com.project.customer.business.bean;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import jakarta.validation.constraints.NotNull;

public class ComplaintBean {

    private Integer complaintId;

    @NotBlank(message = "Please Enter Customer Name.")
    private String customerName;
    private String description;

    @NotNull(message = "Please Enter Date of Incidence.")
    @Past(message = "Date of Incidence must be past date.")
    @DateTimeFormat(pattern = "dd-MMM-yyyy")
    private Date dateOfIncidence;

    @NotNull(message = "Please mention total amount of loss you have suffered through this incident.")
    private Double amount;

    @NotNull(message = "Please Enter Customer Type.")
    private Integer complaintTypeId;

    public Integer getComplaintId() {
        return complaintId;
    }

    public void setComplaintId(Integer complaintId) {
        this.complaintId = complaintId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateOfIncidence() {
        return dateOfIncidence;
    }

    public void setDateOfIncidence(Date dateOfIncidence) {
        this.dateOfIncidence = dateOfIncidence;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Integer getComplaintTypeId() {
        return complaintTypeId;
    }

    public void setComplaintTypeId(Integer complaintTypeId) {
        this.complaintTypeId = complaintTypeId;
    }
}
