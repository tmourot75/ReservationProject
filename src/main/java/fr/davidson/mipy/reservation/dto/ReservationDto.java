package fr.davidson.mipy.reservation.dto;

import fr.davidson.mipy.reservation.entities.Room;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservationDto {

    private Long reservationId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String description;
    private Room room;

}