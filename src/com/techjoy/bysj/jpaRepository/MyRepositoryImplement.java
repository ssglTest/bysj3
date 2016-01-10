package com.techjoy.bysj.jpaRepository;

import java.io.Serializable;
import javax.persistence.EntityManager;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean //必须的
public class MyRepositoryImplement<T, ID extends Serializable> 
extends SimpleJpaRepository<T, ID> implements MyRepository<T, ID> {

	
@SuppressWarnings("unused")
private final EntityManager entityManager;


public MyRepositoryImplement(Class<T> domainClass, EntityManager em) {
		super(domainClass, em);
		// TODO Auto-generated constructor stub
		
		entityManager=em;
	}

public MyRepositoryImplement(final JpaEntityInformation<T, ?> entityInformation, final EntityManager entityManager) {
    super(entityInformation, entityManager);
    this.entityManager = entityManager;
}

@Override
public T merge(T entity) {
	// TODO Auto-generated method stub
	entityManager.merge(entity);
	entityManager.flush();
	return entity;
	
}


}