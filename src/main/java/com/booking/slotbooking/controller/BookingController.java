package com.booking.slotbooking.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.booking.slotbooking.dto.BookingRequestDTO;
import com.booking.slotbooking.entity.Booking;
import com.booking.slotbooking.service.BookingService;


/**
 * @Author Allan George
 */
@RestController
@RequestMapping("/api/bookings")
public class BookingController {

	private final BookingService bookingService;

	public BookingController(BookingService bookingService) {
		this.bookingService = bookingService;
	}

	@PostMapping
	public Booking createBooking(@RequestBody BookingRequestDTO request) {
		return bookingService.createBooking(request);
	}
}