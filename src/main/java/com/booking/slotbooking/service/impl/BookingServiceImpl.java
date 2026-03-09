package com.booking.slotbooking.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.booking.slotbooking.dto.BookingRequestDTO;
import com.booking.slotbooking.entity.Booking;
import com.booking.slotbooking.exception.SlotAlreadyBookedException;
import com.booking.slotbooking.repository.BookingRepository;
import com.booking.slotbooking.service.BookingService;

/**
 * @Author Allan George
 */
@Service
public class BookingServiceImpl implements BookingService {

	private final BookingRepository bookingRepository;

	public BookingServiceImpl(BookingRepository bookingRepository) {
		this.bookingRepository = bookingRepository;
	}

	@Override
	@Transactional
	public Booking createBooking(BookingRequestDTO request) {

		List<Booking> existing = bookingRepository.findByPartnerAndSlot(request.getPartnerId(), request.getSlotStart(),
				request.getSlotEnd());

		if (!existing.isEmpty()) {
			throw new SlotAlreadyBookedException("This slot is already booked for the partner.");
		}

		Booking booking = new Booking();
		booking.setPartnerId(request.getPartnerId());
		booking.setCustomerId(request.getCustomerId());
		booking.setSlotStart(request.getSlotStart());
		booking.setSlotEnd(request.getSlotEnd());
		booking.setBookingStatus("CREATED");
		booking.setPaymentStatus("PENDING");

		return bookingRepository.save(booking);
	}
}