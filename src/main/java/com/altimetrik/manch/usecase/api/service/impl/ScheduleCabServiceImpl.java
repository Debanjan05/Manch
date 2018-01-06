/**
 * 
 */
package com.altimetrik.manch.usecase.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.altimetrik.manch.usecase.api.bean.ScheduleCabBean;
import com.altimetrik.manch.usecase.api.service.ScheduleCabService;
import com.altimetrik.manch.usecase.models.EmployeeCabHistory;
import com.altimetrik.manch.usecase.models.EmployeeDetails;
import com.altimetrik.manch.usecase.models.ManchCabDetails;
import com.altimetrik.manch.usecase.models.ManchRoutes;
import com.altimetrik.manch.usecase.models.repository.EmployeeCabHistoryRepository;
import com.altimetrik.manch.usecase.models.repository.EmployeeRepository;
import com.altimetrik.manch.usecase.models.repository.ManchCabDetailsRepository;
import com.altimetrik.manch.usecase.models.repository.ManchRoutesRepository;

/**
 * @author sghosh
 *
 */
@Service
public class ScheduleCabServiceImpl implements ScheduleCabService {

	@Autowired
	private ManchCabDetailsRepository cabDetailsRepo;
	@Autowired
	private ManchRoutesRepository routeRepo;
	@Autowired
	private EmployeeRepository empRepo;
	@Autowired
	private EmployeeCabHistoryRepository employeeCabHistoryRepo;
	@Autowired
	private EmployeeRepository employeeRepo;
	
	@Override
	public String scheduleCab(ScheduleCabBean scheduleRequest) {
		String returnValue=null;
		EmployeeCabHistory cabHistory=new EmployeeCabHistory();
		if(scheduleRequest!=null){
			ManchRoutes toRoutes=routeRepo.findOne(scheduleRequest.getToRouteId());
			ManchRoutes fromRoutes=routeRepo.findOne(scheduleRequest.getFromRouteId());
			EmployeeDetails empDetails=empRepo.findAllByEmpEmailId(scheduleRequest.getEmail());
			List<ManchCabDetails> cabDetails=cabDetailsRepo.findAll();
			for(ManchCabDetails cab:cabDetails){
				if(cab.getCabAvailablity() && (cab.getCurrentStatus().equals("AVAILABLE") || cab.getCurrentStatus().equals("VACANT")))
				{
					cabHistory.setManchCabDetails(cab);
					break;
				}
				else{
					returnValue="Seats are not available!";
				}
			}
			cabHistory.setEmployeeDetails(empDetails);
			cabHistory.setToRouoteId(toRoutes);
			cabHistory.setFromRouoteId(fromRoutes);
			cabHistory.setTravelDate(scheduleRequest.getTravelDate());
			cabHistory.setTravelStatus("REQUESTED");
			employeeCabHistoryRepo.save(cabHistory);
			returnValue="Cab Scheduled! Driver Name: "+cabHistory.getManchCabDetails().getDriverName()+"Cab-No: "+cabHistory.getManchCabDetails().getCabNo();
		}
		
		return returnValue;
	}

	@Override
	public List<EmployeeCabHistory> viewEmployeeCabHistory(Integer employeeId) {
		
		EmployeeDetails empDetails = employeeRepo.findByemployeeId(employeeId);
		List<EmployeeCabHistory> empCabHistoryList = employeeCabHistoryRepo.findAllByemployeeDetails(empDetails);
		return empCabHistoryList;
	}
	

}
