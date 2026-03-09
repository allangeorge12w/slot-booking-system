package com.booking.slotbooking.service.impl;

import com.booking.slotbooking.dto.CancelBookingRequestDTO;
import com.booking.slotbooking.entity.Booking;
import com.booking.slotbooking.entity.Payment;
import com.booking.slotbooking.repository.BookingRepository;
import com.booking.slotbooking.repository.PaymentRepository;
import com.booking.slotbooking.service.BookingCancellationService;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class BookingCancellationServiceImpl implements BookingCancellationService {

    private final BookingRepository bookingRepository;
    private final PaymentRepository paymentRepository;

    public BookingCancellationServiceImpl(BookingRepository bookingRepository,
                                          PaymentRepository paymentRepository) {
        this.bookingRepository = bookingRepository;
        this.paymentRepository = paymentRepository;
    }

    @Override
    @Transactional
    public void cancelBooking(CancelBookingRequestDTO request) {

        Booking booking = bookingRepository.findById(request.getBookingId());

        if (booking == null) {
            throw new RuntimeException("Booking not found");
        }

        Payment payment = paymentRepository.findByBookingId(booking.getId());

        double refundAmount = 0;
        String refundStatus;

        if ("CREATED".equals(booking.getBookingStatus())) {

            refundAmount = payment.getAmount().doubleValue();
            refundStatus = "FULL_REFUND";

        } else if ("ASSIGNED".equals(booking.getBookingStatus())) {

            refundAmount = payment.getAmount().doubleValue() * 0.8;
            refundStatus = "PARTIAL_REFUND";

        } else if ("COMPLETED".equals(booking.getBookingStatus())) {

            throw new RuntimeException("Booking already completed. No refund allowed.");

        } else {
            refundStatus = "NOT_REFUNDED";
        }

        paymentRepository.updateRefund(payment.getId(), refundAmount, refundStatus);

        bookingRepository.updateBookingStatus(booking.getId(), "CANCELLED");
    }
}