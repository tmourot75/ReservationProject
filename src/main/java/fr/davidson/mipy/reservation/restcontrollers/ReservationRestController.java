package fr.davidson.mipy.reservation.restcontrollers;

import fr.davidson.mipy.reservation.dto.ReservationDto;
import fr.davidson.mipy.reservation.services.ReservationServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/reservation")
@CrossOrigin
public class ReservationRestController {

    @Autowired
    ReservationServiceInterface reservationService;

    @RequestMapping(method = RequestMethod.GET)
    public List<ReservationDto> getAllReservations() {
        return reservationService.getAllReservations();
    }
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ReservationDto getReservationById(@PathVariable("id") Long id) {
        return reservationService.getReservation(id);
    }
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void deleteReservationById(@PathVariable("id") Long id) {
        reservationService.deleteReservationbyId(id);
    }
    @RequestMapping(method = RequestMethod.POST)
    public ReservationDto saveReservation(@RequestBody ReservationDto reservationDto) {
        return reservationService.saveReservation(reservationDto);
    }
    @RequestMapping(method = RequestMethod.PUT)
    public ReservationDto updateReservation(@RequestBody ReservationDto reservationDto) {
        return reservationService.updateReservation(reservationDto);
    }

}