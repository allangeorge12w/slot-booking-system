package com.booking.slotbooking.controller;

import com.booking.slotbooking.dto.CancelBookingRequestDTO;
import com.booking.slotbooking.service.BookingCancellationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bookings")
public class BookingCancellationController {

	private final BookingCancellationService cancellationService;

	public BookingCancellationController(BookingCancellationService cancellationService) {
		this.cancellationService = cancellationService;
	}

	@PostMapping("/cancel")
	public String cancelBooking(@RequestBody CancelBookingRequestDTO request) {

		cancellationService.cancelBooking(request);

		return "Booking cancelled successfully";
	}
}