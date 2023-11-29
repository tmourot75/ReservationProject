package fr.davidson.mipy.reservation;

import fr.davidson.mipy.reservation.entities.Room;
import fr.davidson.mipy.reservation.repositories.RoomRepositoryInterface;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
class ReservationApplicationTests {

	@Autowired
	private RoomRepositoryInterface roomRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void testCreateRoom() {
		Room room = new Room("Open Space", "réunion équipe", false);
		roomRepository.save(room);
	}

	@Test
	public void testDeleteRoom() {
		roomRepository.deleteById(2L);
	}

	@Test
	@Transactional
	public void testFindProduit() {
		Room room = roomRepository.findById(4L).get();
		System.out.println(room);
	}

	@Test
	@Transactional
	public void listAllRooms() {
		List<Room> rooms = roomRepository.findAll();
		for (Room room: rooms) {
			System.out.println(room);
		}
	}





}