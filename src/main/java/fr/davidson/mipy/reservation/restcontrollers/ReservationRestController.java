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
    public ReservationDto getReservation(@PathVariable("id") Long id) {
        return reservationService.getReservation(id);
    }


}