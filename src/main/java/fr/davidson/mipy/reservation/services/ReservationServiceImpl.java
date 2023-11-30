package fr.davidson.mipy.reservation.services;

import fr.davidson.mipy.reservation.dto.ReservationDto;
import fr.davidson.mipy.reservation.entities.Reservation;
import fr.davidson.mipy.reservation.repositories.ReservationRepositoryInterface;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class ReservationServiceImpl implements ReservationServiceInterface {

    @Autowired
    public ReservationRepositoryInterface reservationRepository;

    @Autowired
    public ModelMapper modelMapper;

    @Override
    public List<ReservationDto> getAllReservations() {
        return reservationRepository.findAll().stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }
    @Override
    public ReservationDto getReservation(Long id) {
        return convertEntityToDto(reservationRepository.findById(id).get());
    }
    @Override
    public void deleteReservationbyId(Long id) {
        reservationRepository.deleteById(id);
    }
    @Override
    public ReservationDto saveReservation(ReservationDto reservationDto) {
        return convertEntityToDto(reservationRepository.save(convertDtoToEntity(reservationDto)));
    }
    @Override
    public ReservationDto updateReservation(ReservationDto reservationDto) {
         return convertEntityToDto(reservationRepository.save(convertDtoToEntity(reservationDto)));
    }
    @Override
    public ReservationDto convertEntityToDto(Reservation reservation) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        return modelMapper.map(reservation, ReservationDto.class);
    }
    @Override
    public Reservation convertDtoToEntity(ReservationDto reservationDto) {
        return modelMapper.map(reservationDto, Reservation.class);
    }
}