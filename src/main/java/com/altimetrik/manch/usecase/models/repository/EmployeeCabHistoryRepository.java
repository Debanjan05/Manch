/**
 * 
 */
package com.altimetrik.manch.usecase.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.altimetrik.manch.usecase.models.EmployeeCabHistory;
import com.altimetrik.manch.usecase.models.EmployeeDetails;

/**
 * @author sghosh
 *
 */
@Repository
public interface EmployeeCabHistoryRepository extends JpaRepository<EmployeeCabHistory,Long>{
	List<EmployeeCabHistory> findAllByemployeeDetails(EmployeeDetails employeeDetails);
}
