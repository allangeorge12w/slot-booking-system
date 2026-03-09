package com.booking.slotbooking.service;

import com.booking.slotbooking.dto.CancelBookingRequestDTO;

public interface BookingCancellationService {

    void cancelBooking(CancelBookingRequestDTO request);
}