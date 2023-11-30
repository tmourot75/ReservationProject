package fr.davidson.mipy.reservation.restcontrollers;

import fr.davidson.mipy.reservation.dto.RoomDto;
import fr.davidson.mipy.reservation.entities.Room;
import fr.davidson.mipy.reservation.services.RoomServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/room")
@CrossOrigin
public class RoomRestController {

    @Autowired
    RoomServiceInterface roomService;

    @RequestMapping(method = RequestMethod.GET)
    public List<RoomDto> getAllRooms() {
        return roomService.getAllRooms();
    }
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public RoomDto getRoomById(@PathVariable("id") Long id) {
        return roomService.getRoom(id);
    }
    @RequestMapping(method = RequestMethod.POST)
    public RoomDto saveRoom(@RequestBody RoomDto roomDto) {
        return roomService.saveRoom(roomDto);
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteRoomById(@PathVariable("id") Long id) {
        roomService.deleteRoomById(id);
    }
    @RequestMapping(method = RequestMethod.PUT)
    public RoomDto updateRoom(@RequestBody RoomDto roomDto) {
        return roomService.updateRoom(roomDto);
    }
    @RequestMapping(value = "roomsByName/{name}", method = RequestMethod.GET)
    public List<Room> findByNameRoomContains(@PathVariable("name") String name) {
        return roomService.findByNameRoomContains(name);
    }
}