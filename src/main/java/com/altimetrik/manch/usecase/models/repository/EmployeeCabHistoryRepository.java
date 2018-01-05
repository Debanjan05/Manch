/**
 * 
 */
package com.altimetrik.manch.usecase.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.altimetrik.manch.usecase.models.EmployeeCabHistory;

/**
 * @author sghosh
 *
 */
@Repository
public interface EmployeeCabHistoryRepository extends JpaRepository<EmployeeCabHistory,Long>{

}
