package fr.davidson.mipy.reservation.repositories;

import fr.davidson.mipy.reservation.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepositoryInterface extends JpaRepository<Reservation, Long> {
}