package com.altimetrik.manch.usecase.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.altimetrik.manch.usecase.api.bean.EmployeeRequest;
import com.altimetrik.manch.usecase.models.EmployeeDetails;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeDetails,Long>{

	EmployeeDetails save(EmployeeRequest employeeRequest);

}
