package com.booking.slotbooking.service;

import com.booking.slotbooking.dto.PaymentWebhookDTO;

/**
 * @Author Allan George
 */
public interface PaymentService {

	void handleWebhook(PaymentWebhookDTO request);
}