package fr.davidson.mipy.reservation.services;

import fr.davidson.mipy.reservation.dto.RoomDto;
import fr.davidson.mipy.reservation.entities.Room;

import java.util.List;

public interface RoomServiceInterface {

    List<RoomDto> getAllRooms();
    RoomDto saveRoom(RoomDto roomDTO);

    RoomDto updateRoom(RoomDto roomDto);
    RoomDto getRoom(Long id);
    void deleteRoom(Room room);
    void deleteRoomById(Long id);

    List<Room> findByNameRoomContains(String name);

    RoomDto convertEntityToDto(Room room);

    Room convertDtoToEntity(RoomDto roomDTO);
}