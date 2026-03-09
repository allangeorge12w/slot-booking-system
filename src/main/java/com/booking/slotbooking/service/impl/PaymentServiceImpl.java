package com.booking.slotbooking.service.impl;

import com.booking.slotbooking.dto.PaymentWebhookDTO;
import com.booking.slotbooking.entity.Payment;
import com.booking.slotbooking.repository.BookingRepository;
import com.booking.slotbooking.repository.PaymentRepository;
import com.booking.slotbooking.service.PaymentService;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @Author Allan George
 */
@Service
public class PaymentServiceImpl implements PaymentService {

	private final PaymentRepository paymentRepository;
	private final BookingRepository bookingRepository;

	public PaymentServiceImpl(PaymentRepository paymentRepository, BookingRepository bookingRepository) {
		this.paymentRepository = paymentRepository;
		this.bookingRepository = bookingRepository;
	}

	@Override
	@Transactional
	public void handleWebhook(PaymentWebhookDTO request) {

		List<Payment> existing = paymentRepository.findByEventId(request.getEventId());

		if (!existing.isEmpty()) {
			return;
		}

		Payment payment = new Payment();
		payment.setBookingId(request.getBookingId());
		payment.setPaymentReference(request.getPaymentReference());
		payment.setAmount(request.getAmount());
		payment.setStatus(request.getStatus());
		payment.setEventId(request.getEventId());

		paymentRepository.save(payment);

		bookingRepository.updatePaymentStatus(request.getBookingId(), request.getStatus());
	}
}