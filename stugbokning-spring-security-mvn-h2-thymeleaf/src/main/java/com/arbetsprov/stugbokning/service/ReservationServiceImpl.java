package com.arbetsprov.stugbokning.service;

import java.security.Principal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.arbetsprov.stugbokning.model.Cabin;
import com.arbetsprov.stugbokning.model.Reservation;
import com.arbetsprov.stugbokning.model.User;
import com.arbetsprov.stugbokning.repository.ReservationRepository;
import com.arbetsprov.stugbokning.web.dto.ReservationDto;
import com.arbetsprov.stugbokning.web.dto.ReservationListDto;

@Service
public class ReservationServiceImpl implements ReservationService{
	
	private ReservationRepository reservationRepository;
	private CabinService cabinService;
	private UserService userService;

	public ReservationServiceImpl(ReservationRepository reservationRepository, CabinService cabinService,
			UserService userService) {
		super();
		this.reservationRepository = reservationRepository;
		this.cabinService = cabinService;
		this.userService = userService;
	}

	@Override
	public void createReservation(Reservation reservation) {
		
		reservationRepository.save(reservation);
	}

	@Override
	public List<Reservation> getReservationListByUserId(Long userId) {

		List<Reservation> reservationList = reservationRepository.findAll();
		List<Reservation> userReservations = new ArrayList<>();
		for(Reservation reservation : reservationList) {
			if(reservation.getUserId().toString().equals(userId.toString().toString())) {
				userReservations.add(reservation);
			}
		}
		
		return userReservations;
	}

	@Override
	public List<Reservation> findAllReservations() {
		
		return reservationRepository.findAll();
	}

	@Override
	public List<ReservationListDto> getReservationListDtosByCabinId() {
		
		List<Reservation> reservations = findAllReservations();
		
		List<Long> cabinIds = new ArrayList<>();
		
		for(Reservation reservation : reservations) {
			if(!cabinIds.contains(reservation.getCabinId())) {
				cabinIds.add(reservation.getCabinId());
			}
		}
		
		List<ReservationListDto> reservationListDtos = new ArrayList<>();
		
		for(Long cabinId : cabinIds) {
			List<Reservation> reservationsList = reservationRepository.findByCabinId(cabinId);
			Cabin cabin = cabinService.getCabinById(cabinId);
			if(cabin != null) {
				ReservationListDto reservationListDto = new ReservationListDto();
				reservationListDto.setTitle(cabin.getTitle());
				reservationListDto.setAddress(cabin.getAddress());
				reservationListDto.setImage(cabin.getImage());
				reservationListDto.setCabinId(cabin.getId());
				
				reservationListDto.setReservations(reservationsList);
				
				reservationListDtos.add(reservationListDto);
			}
		}
		
		return reservationListDtos;
	}

	@Override
	public List<ReservationDto> mapReservationDto(Principal principal) {
		
		User user = userService.findUserByEmail(principal.getName());
		List<Reservation> reservationsList = getReservationListByUserId(user.getId());
		
		List<ReservationDto> reservationDtos = new ArrayList<>();
		for(Reservation reervation : reservationsList) {
			Cabin cabin = cabinService.getCabinById(reervation.getCabinId());
			ReservationDto tempReservationDto = new ReservationDto();
			tempReservationDto.setTitle(cabin.getTitle());
			tempReservationDto.setAddress(cabin.getAddress());
			tempReservationDto.setCabinType(cabin.getCabinType());
			
			tempReservationDto.setParking(cabin.getParking());
			tempReservationDto.setImage(cabin.getImage());
			
			tempReservationDto.setUserId(reervation.getUserId());
			tempReservationDto.setCabinId(reervation.getCabinId());
			tempReservationDto.setFirstName(reervation.getFirstName());
			tempReservationDto.setLastName(reervation.getLastName());
			tempReservationDto.setNumberOfRooms(reervation.getNumberOfRooms());
			
			tempReservationDto.setNumberOfGuests(reervation.getNumberOfGuests()
					+ reervation.getNumberOfChildren());
			
			tempReservationDto.setFromDateTime(reervation.getFromDateTime());
			tempReservationDto.setEndDateTime(reervation.getEndDateTime());
						
			String fromDate = reervation.getFromDateTime().toString();
			String endDate = reervation.getEndDateTime().toString();
			String[] strDate = fromDate.split(" ");
			fromDate = strDate[0];
			strDate = endDate.split(" ");
			endDate = strDate[0];
			
			LocalDate arrival = LocalDate.parse(fromDate);
			LocalDate departure = LocalDate.parse(endDate);
			long diffInDays = ChronoUnit.DAYS.between(arrival, departure);
			System.out.println ("Days: " + diffInDays);
			
			tempReservationDto.setPrice(cabin.getPrice() * diffInDays);
			
			reservationDtos.add(tempReservationDto);
		}
		return reservationDtos;
	}

}
