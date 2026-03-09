package com.booking.slotbooking.service;

import com.booking.slotbooking.dto.BookingRequestDTO;
import com.booking.slotbooking.entity.Booking;


/**
 * @Author Allan George
 */
public interface BookingService {

    Booking createBooking(BookingRequestDTO request);
}