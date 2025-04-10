package com.project.customer.dao;

import com.project.customer.business.bean.ComplaintBean;
import com.project.customer.business.bean.ComplaintTypeBean;
import com.project.customer.entity.ComplaintEntity;
import com.project.customer.entity.ComplaintTypeEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
@Transactional(value = "txManager")
public class ComplaintDaoWrapper {

    @Autowired
    private ComplaintDao complaintDao;

    @Autowired
    private ComplaintTypeDao complaintTypeDao;

    @PersistenceContext
    private EntityManager manager;

    public void registerComplaintDetails(ComplaintBean complaintBean){
        ComplaintEntity complaintEntity = convertComplaintBeanToEntity(complaintBean);
        complaintDao.save(complaintEntity);
    }

    public List<ComplaintBean> getComplaintDetailsByDate(Date fromDate, Date toDate){
        List<ComplaintBean> complaintBeans = null;
        List<ComplaintEntity> complaintEntities = complaintDao.getComplaintDetailsByDate(fromDate, toDate);

        if(null != complaintEntities){
            complaintBeans = new ArrayList<ComplaintBean>();
            for(ComplaintEntity entity : complaintEntities){
                ComplaintBean bean = convertComplaintEntityToBean(entity);
                complaintBeans.add(bean);
            }
        }
        return complaintBeans;
    }

    public List<ComplaintTypeBean> getAllComplaintTypes(){
        List<ComplaintTypeBean> complaintTypeBeanList = null;
        List<ComplaintTypeEntity> complaintTypeEntityList = complaintTypeDao.findAll();

        if (null != complaintTypeEntityList) {
            complaintTypeBeanList = new ArrayList<ComplaintTypeBean>();
            for( ComplaintTypeEntity entity : complaintTypeEntityList){
                ComplaintTypeBean bean = convertComplaintTypeEntityToBean(entity);
                complaintTypeBeanList.add(bean);
            }
        }
        return complaintTypeBeanList;
    }

    public int getCustomerByComplaintType(String customerName, int complaintTypeId){
        ComplaintEntity complaintEntity = complaintDao.getCustomerByComplaintType(customerName, complaintTypeId);
        if( null != complaintEntity){
            return 1;
        }
        return 0;
    }


    public static ComplaintTypeBean convertComplaintTypeEntityToBean(ComplaintTypeEntity entity) {
        ComplaintTypeBean bean = new ComplaintTypeBean();
        BeanUtils.copyProperties(entity, bean);
        return bean;
    }

    public static ComplaintBean convertComplaintEntityToBean(ComplaintEntity entity) {
        ComplaintBean bean = new ComplaintBean();
        BeanUtils.copyProperties(entity,bean);
        return bean;
    }

    public static ComplaintEntity convertComplaintBeanToEntity(ComplaintBean bean) {
        ComplaintEntity entity = new ComplaintEntity();
        BeanUtils.copyProperties(bean, entity);
        return entity;
    }
}
