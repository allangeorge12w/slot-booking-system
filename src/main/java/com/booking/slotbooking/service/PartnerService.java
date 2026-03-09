package com.booking.slotbooking.service;

import com.booking.slotbooking.dto.PartnerRequestDTO;
import com.booking.slotbooking.entity.Partner;

import java.util.List;

public interface PartnerService {

    Partner createPartner(PartnerRequestDTO request);

    List<Partner> getAvailablePartnersByCity(String city);
}