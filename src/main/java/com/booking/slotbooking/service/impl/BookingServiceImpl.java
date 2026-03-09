package com.booking.slotbooking.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.booking.slotbooking.dto.BookingRequestDTO;
import com.booking.slotbooking.entity.Booking;
import com.booking.slotbooking.repository.BookingRepository;
import com.booking.slotbooking.service.BookingService;

@Service
public class BookingServiceImpl implements BookingService {

	private final BookingRepository bookingRepository;

	public BookingServiceImpl(BookingRepository bookingRepository) {
		this.bookingRepository = bookingRepository;
	}

	@Override
	@Transactional
	public Booking createBooking(BookingRequestDTO request) {

		List<Booking> existingBookings = bookingRepository.findByPartnerAndSlot(request.getPartnerId(),
				request.getSlotStart(), request.getSlotEnd());

		if (!existingBookings.isEmpty()) {
			throw new RuntimeException("Slot already booked for this partner");
		}

		Booking booking = new Booking();
		booking.setPartnerId(request.getPartnerId());
		booking.setCustomerId(request.getCustomerId());
		booking.setSlotStart(request.getSlotStart());
		booking.setSlotEnd(request.getSlotEnd());
		booking.setStatus("CONFIRMED");

		return bookingRepository.save(booking);
	}
}