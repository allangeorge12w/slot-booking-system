package com.booking.slotbooking.service;

import com.booking.slotbooking.dto.CancelBookingRequestDTO;


/**
 * @Author Allan George
 */
public interface BookingCancellationService {

    void cancelBooking(CancelBookingRequestDTO request);
}