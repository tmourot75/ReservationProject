package fr.davidson.mipy.reservation.dto;

import fr.davidson.mipy.reservation.entities.Reservation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoomDto {

    private Long roomId;
    private String roomName;
    private String roomDescription;
    private boolean reserved;
    private Reservation[] reservations;

}