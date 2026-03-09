package com.booking.slotbooking.repository;

import com.booking.slotbooking.entity.Booking;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;


/**
 * @Author Allan George
 */
@Repository
public class BookingRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public Booking save(Booking booking) {
		entityManager.persist(booking);
		return booking;
	}

	public List<Booking> findByPartnerAndSlot(Long partnerId, LocalDateTime slotStart, LocalDateTime slotEnd) {

		String jpql = "SELECT b FROM Booking b WHERE b.partnerId = :partnerId "
				+ "AND b.slotStart = :slotStart AND b.slotEnd = :slotEnd";

		return entityManager.createQuery(jpql, Booking.class).setParameter("partnerId", partnerId)
				.setParameter("slotStart", slotStart).setParameter("slotEnd", slotEnd).getResultList();
	}

	@Transactional
	public void updatePaymentStatus(Long bookingId, String status) {

		String jpql = "UPDATE Booking b SET b.paymentStatus = :status WHERE b.id = :bookingId";

		entityManager.createQuery(jpql).setParameter("status", status).setParameter("bookingId", bookingId)
				.executeUpdate();
	}

	public Booking findById(Long id) {

		return entityManager.find(Booking.class, id);
	}

	@Transactional
	public void updateBookingStatus(Long bookingId, String status) {

		String jpql = "UPDATE Booking b SET b.bookingStatus = :status WHERE b.id = :id";

		entityManager.createQuery(jpql).setParameter("status", status).setParameter("id", bookingId).executeUpdate();
	}
}