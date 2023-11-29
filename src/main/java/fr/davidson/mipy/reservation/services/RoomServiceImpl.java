package fr.davidson.mipy.reservation.services;

import org.modelmapper.ModelMapper;
import fr.davidson.mipy.reservation.dto.RoomDto;
import fr.davidson.mipy.reservation.entities.Room;
import fr.davidson.mipy.reservation.repositories.RoomRepositoryInterface;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoomServiceImpl implements RoomServiceInterface {

    @Autowired
    RoomRepositoryInterface roomRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<RoomDto> getAllRooms() {
        return roomRepository.findAll().stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    public RoomDto saveRoom(RoomDto roomDTO) {
        return convertEntityToDto(roomRepository.save(convertDtoToEntity(roomDTO)));
    }

    @Override
    public RoomDto updateRoom(RoomDto roomDto) {
        return convertEntityToDto(roomRepository.save(convertDtoToEntity(roomDto)));
    }

    @Override
    public RoomDto getRoom(Long id) {
        return convertEntityToDto(roomRepository.findById(id).get());
    }

    @Override
    public void deleteRoom(Room room) {
        roomRepository.delete(room);
    }

    @Override
    public void deleteRoomById(Long id) {
        roomRepository.deleteById(id);
    }

    @Override
    public List<Room> findByNameRoomContains(String name) {
        return roomRepository.findByRoomNameContains(name);
    }

    @Override
    public RoomDto convertEntityToDto(Room room) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        return modelMapper.map(room, RoomDto.class);
    }

    @Override
    public Room convertDtoToEntity(RoomDto roomDTO) {
        return modelMapper.map(roomDTO, Room.class);
    }
}