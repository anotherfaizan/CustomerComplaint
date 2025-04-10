package com.project.customer.dao;

import com.project.customer.entity.ComplaintTypeEntity;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RepositoryDefinition(idClass = Integer.class, domainClass = ComplaintTypeEntity.class)
@Transactional(value = "txManager")
public interface ComplaintTypeDao {
    List<ComplaintTypeEntity> findAll();
}
