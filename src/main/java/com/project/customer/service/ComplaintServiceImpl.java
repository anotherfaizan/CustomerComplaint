package com.project.customer.service;

import com.project.customer.business.bean.ComplaintBean;
import com.project.customer.business.bean.ComplaintTypeBean;
import com.project.customer.dao.ComplaintDaoWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ComplaintServiceImpl implements ComplaintService{

    @Autowired
    ComplaintDaoWrapper complaintDaoWrapper;

    @Override
    public void registerComplaintDetails(ComplaintBean complaintBean) throws Exception {
        int status = complaintDaoWrapper.getCustomerByComplaintType(complaintBean.getCustomerName(), complaintBean.getComplaintTypeId());
        if(status == 1){
            throw new Exception("Hi " + complaintBean.getCustomerName() + " , you have already submitted a complaint with the same complaint type.");
        } else{
            complaintDaoWrapper.registerComplaintDetails(complaintBean);
        }

    }

    @Override
    public List<ComplaintBean> getComplaintDetailsByDate(Date fromDate, Date toDate) {
        List<ComplaintBean> complaintBeansList = complaintDaoWrapper.getComplaintDetailsByDate(fromDate, toDate);
        return complaintBeansList;
    }

    @Override
    public Map<Integer, String> getAllComplaintTypes() {
        Map<Integer, String> complaintTypesMap = new HashMap<Integer, String>();
        List<ComplaintTypeBean> complaintTypeList = complaintDaoWrapper.getAllComplaintTypes();
        for(ComplaintTypeBean bean : complaintTypeList){
            complaintTypesMap.put(bean.getComplaintTypeId(), bean.getComplaintTypeName());
        }
        return complaintTypesMap;
    }
}
