package fr.davidson.mipy.reservation.repositories;

import fr.davidson.mipy.reservation.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path = "rest")
public interface RoomRepositoryInterface extends JpaRepository<Room, Long> {

    List<Room> findByRoomNameContains(String name);

}