package com.booking.slotbooking.dto;

import java.time.LocalDateTime;

public class BookingRequestDTO {

	private Long partnerId;
	private Long customerId;
	private LocalDateTime slotStart;
	private LocalDateTime slotEnd;

	public Long getPartnerId() {
		return partnerId;
	}

	public void setPartnerId(Long partnerId) {
		this.partnerId = partnerId;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public LocalDateTime getSlotStart() {
		return slotStart;
	}

	public void setSlotStart(LocalDateTime slotStart) {
		this.slotStart = slotStart;
	}

	public LocalDateTime getSlotEnd() {
		return slotEnd;
	}

	public void setSlotEnd(LocalDateTime slotEnd) {
		this.slotEnd = slotEnd;
	}

}