/**
 * 
 */
package com.altimetrik.manch.usecase.api.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.altimetrik.manch.usecase.api.bean.ScheduleCabBean;
import com.altimetrik.manch.usecase.api.bean.ScheduleResponse;
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
	public ScheduleResponse scheduleCab(ScheduleCabBean scheduleRequest) {
		ScheduleResponse returnValue=new ScheduleResponse();
		EmployeeCabHistory cabHistory=new EmployeeCabHistory();
		if(scheduleRequest!=null){
			ManchRoutes toRoutes=routeRepo.findOne(scheduleRequest.getToRouteId());
			ManchRoutes fromRoutes=routeRepo.findOne(scheduleRequest.getFromRouteId());
			EmployeeDetails empDetails=empRepo.findAllByEmpEmailId(scheduleRequest.getEmail());
			List<ManchCabDetails> cabDetails=cabDetailsRepo.findAll();
			for(ManchCabDetails cab:cabDetails){
				Integer seats=cab.getSeatsRemaining();
				if(cab.getCabAvailablity() && !cab.getCurrentStatus().equals("FILLED") )
				{
					
					ManchCabDetails details=cabDetailsRepo.findOne(cab.getCabDetailsId());
					if(cab.getSeatsRemaining()>0 && cab.getSeatsRemaining()<=cab.getCabSeats()){
						details.setSeatsRemaining(seats-1);
						if(details.getSeatsRemaining()!=0)
							details.setCabAvailablity(true);
						else
							details.setCabAvailablity(false);
						details.setCurrentStatus("AVAIlABLE");
						cabHistory.setManchCabDetails(cab);
						cabDetailsRepo.save(details);
						cabHistory.setEmployeeDetails(empDetails);
						cabHistory.setToRouoteId(toRoutes);
						cabHistory.setFromRouoteId(fromRoutes);
						cabHistory.setTravelDate(new Date(scheduleRequest.getTravelDate()));
						cabHistory.setTravelStatus("REQUESTED");
						employeeCabHistoryRepo.save(cabHistory);
						returnValue.setMessage("Cab Scheduled! Driver Name: "+cabHistory.getManchCabDetails().getDriverName()+"Cab-No: "+cabHistory.getManchCabDetails().getCabNo());
						return  returnValue;
					}
					else{
						details.setCurrentStatus("FILLED");
						details.setCabAvailablity(false);
						cabDetailsRepo.save(details);
						
					}
					
					
					if(details.getCurrentStatus().equals("AVAILABLE") || details.getCurrentStatus().equals("VACANT"))
						break;
					else
						continue;
				}
				else{
					returnValue.setMessage("Seats are not available!");;
				}
			}
			
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
