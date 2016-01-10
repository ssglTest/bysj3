package com.techjoy.bysj.jpaRepository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.techjoy.bysj.domain.Student;

public interface MyRepository<T,ID extends Serializable> extends JpaRepository<T,ID>,JpaSpecificationExecutor<T> {
	public T merge(T entity);
}
