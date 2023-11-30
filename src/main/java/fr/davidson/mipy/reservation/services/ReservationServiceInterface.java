package fr.davidson.mipy.reservation.services;

import fr.davidson.mipy.reservation.dto.ReservationDto;
import fr.davidson.mipy.reservation.entities.Reservation;

import java.util.List;

public interface ReservationServiceInterface {

    List<ReservationDto> getAllReservations();
    ReservationDto getReservation(Long id);
    void deleteReservationbyId(Long id);
    ReservationDto saveReservation(ReservationDto reservationDto);
    ReservationDto updateReservation(ReservationDto reservationDto);
    ReservationDto convertEntityToDto(Reservation reservation);
    Reservation convertDtoToEntity(ReservationDto reservationDto);

}