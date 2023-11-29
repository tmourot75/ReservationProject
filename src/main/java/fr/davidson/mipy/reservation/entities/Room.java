package fr.davidson.mipy.reservation.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roomId;
    private String roomName;
    private String roomDescription;
    private boolean reserved;

    @JsonIgnore
    @OneToMany(mappedBy = "room")
    private List<Reservation> reservations;

    public Room(String name, String description, boolean reserved) {
        super();
        this.roomName = name;
        this.roomDescription = description;
        this.reserved = reserved;
    }

}