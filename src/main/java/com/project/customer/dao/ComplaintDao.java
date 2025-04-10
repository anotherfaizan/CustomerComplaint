package com.project.customer.dao;

import com.project.customer.entity.ComplaintEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@RepositoryDefinition(idClass = Integer.class, domainClass = ComplaintEntity.class)
@Transactional(value = "txManager")
public interface ComplaintDao {
    @Query(name = "getCustomerByComplaintType")
    ComplaintEntity getCustomerByComplaintType(String customerName, int complaintTypeId);
    ComplaintEntity save(ComplaintEntity complaintEntity);
    @Query(name = "getComplaintDetailsByDate")
    List<ComplaintEntity> getComplaintDetailsByDate(Date fromDate, Date toDate);
}
