package com.arbetsprov.stugbokning.service;

import java.security.Principal;
import java.util.List;

import com.arbetsprov.stugbokning.model.Reservation;
import com.arbetsprov.stugbokning.web.dto.ReservationDto;
import com.arbetsprov.stugbokning.web.dto.ReservationListDto;

public interface ReservationService {
	void createReservation(Reservation reservation);
	List<Reservation> getReservationListByUserId(Long userId);
	List<Reservation> findAllReservations();
	List<ReservationListDto> getReservationListDtosByCabinId();
	List<ReservationDto> mapReservationDto(Principal principal);
}
