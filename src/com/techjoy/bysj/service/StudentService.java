package com.techjoy.bysj.service;

import javax.persistence.criteria.CriteriaBuilder;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.techjoy.bysj.dao.StudentDao;
import com.techjoy.bysj.domain.Student;

@Service("studentService")
public class StudentService {
	@Autowired
	private StudentDao studentDao;
	public StudentService(){}
	public void save(Student student){
		studentDao.save(student);
	}
	public Student find(Integer id){
		
		return studentDao.findOne(id);
	}
	public Student update(Student student){
		return studentDao.merge(student);
	}
	public Student findByName(String propertyName,String propertyValue){
		Student student=studentDao.findOne(new Specification<Student>(){

			@Override
			public Predicate toPredicate(Root<Student> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				// TODO Auto-generated method stub
				Predicate condition=cb.equal(root.get(propertyName).as(String.class), propertyValue);
				query.where(condition);
				return query.getRestriction();
			}
			
		});
		return student;
	}

}
