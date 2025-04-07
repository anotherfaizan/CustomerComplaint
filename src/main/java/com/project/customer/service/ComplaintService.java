package com.project.customer.service;

import com.project.customer.business.bean.ComplaintBean;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface ComplaintService {
    void registerComplaintDetails(ComplaintBean complaintBean) throws Exception;
    List<ComplaintBean> getComplaintDetailsByDate(Date fromDate, Date toDate);
    Map<Integer,String> getAllComplaintTypes();

}
