package com.booking.slotbooking.service;

import com.booking.slotbooking.dto.PaymentWebhookDTO;

public interface PaymentService {

	void handleWebhook(PaymentWebhookDTO request);
}