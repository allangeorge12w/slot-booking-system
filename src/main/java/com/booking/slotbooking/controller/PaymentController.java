package com.booking.slotbooking.controller;

import com.booking.slotbooking.dto.PaymentWebhookDTO;
import com.booking.slotbooking.service.PaymentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/webhook")
    public String handleWebhook(@RequestBody PaymentWebhookDTO request) {

        paymentService.handleWebhook(request);

        return "Webhook processed";
    }
}