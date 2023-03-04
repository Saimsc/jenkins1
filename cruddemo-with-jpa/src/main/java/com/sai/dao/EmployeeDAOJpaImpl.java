package com.sai.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.sai.entity.Employee;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

	
	private EntityManager entityManager ;
	
	public EmployeeDAOJpaImpl(EntityManager entityManager) {
		this.entityManager=entityManager;
	}
	@Override
	public List<Employee> findAll(){

		Query query = entityManager.createQuery("from Employee");
		
		List<Employee> employees = query.getResultList();
		return employees;
	}

	@Override
	public Employee findById(int id) {
		Employee employee = entityManager.find(Employee.class,id );
		return employee;
	}

	@Override
	public void save(Employee employee) {
		Employee dbEmployee = entityManager.merge(employee);
	
	employee.setId(dbEmployee.getId()); // newly gwnerated id set to the employee object in the postman
		   // and return the n=generated idin the database
	}

	@Override
	public void deleteById(int id) {

		Query query = entityManager.createQuery("delete from Employee where id =:employeeId");
		query.setParameter("employeeId", id);
		query.executeUpdate(); 
	}

}
