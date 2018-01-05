/**
 * 
 */
package com.altimetrik.manch.usecase.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.altimetrik.manch.usecase.models.LoginDetails;

/**
 * @author sghosh
 *
 */
@Repository
public interface LoginDetailsRepository extends JpaRepository<LoginDetails, Long> {

	LoginDetails findAllByEmail(String email);

}
