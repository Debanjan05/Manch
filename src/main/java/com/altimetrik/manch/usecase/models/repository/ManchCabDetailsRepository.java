/**
 * 
 */
package com.altimetrik.manch.usecase.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.altimetrik.manch.usecase.models.ManchCabDetails;

/**
 * @author sghosh
 *
 */
@Repository
public interface ManchCabDetailsRepository  extends JpaRepository<ManchCabDetails, Long>{

}
