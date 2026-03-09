package com.booking.slotbooking.repository;

import com.booking.slotbooking.entity.Payment;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * @Author Allan George
 */
@Repository
public class PaymentRepository {

	@PersistenceContext
	private EntityManager entityManager;

	public List<Payment> findByEventId(String eventId) {

		String jpql = "SELECT p FROM Payment p WHERE p.eventId = :eventId";

		return entityManager.createQuery(jpql, Payment.class).setParameter("eventId", eventId).getResultList();
	}

	@Transactional
	public Payment save(Payment payment) {
		entityManager.persist(payment);
		return payment;
	}

	public Payment findByBookingId(Long bookingId) {

		String jpql = "SELECT p FROM Payment p WHERE p.bookingId = :bookingId";

		return entityManager.createQuery(jpql, Payment.class).setParameter("bookingId", bookingId).getSingleResult();
	}

	@Transactional
	public void updateRefund(Long paymentId, double refundAmount, String refundStatus) {

		String jpql = "UPDATE Payment p SET p.refundAmount = :amount, p.refundStatus = :status WHERE p.id = :id";

		entityManager.createQuery(jpql).setParameter("amount", refundAmount).setParameter("status", refundStatus)
				.setParameter("id", paymentId).executeUpdate();
	}
}