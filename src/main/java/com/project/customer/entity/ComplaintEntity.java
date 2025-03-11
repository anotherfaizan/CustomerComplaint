package com.project.customer.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Complaint")
public class ComplaintEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer complaintId;
    private String customerName;
    private String description;

    @Temporal(TemporalType.DATE)
    private Date dateOfIncidence;
    private Double amount;
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

    public Integer getComplaintTypeId() {
        return complaintTypeId;
    }

    public void setComplaintTypeId(Integer complaintTypeId) {
        this.complaintTypeId = complaintTypeId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getDateOfIncidence() {
        return dateOfIncidence;
    }

    public void setDateOfIncidence(Date dateOfIncidence) {
        this.dateOfIncidence = dateOfIncidence;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
