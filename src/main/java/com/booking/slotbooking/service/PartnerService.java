package com.booking.slotbooking.service;

import com.booking.slotbooking.dto.PartnerRequestDTO;
import com.booking.slotbooking.entity.Partner;

import java.util.List;


/**
 * @Author Allan George
 */
public interface PartnerService {

    Partner createPartner(PartnerRequestDTO request);

    List<Partner> getAvailablePartnersByCity(String city);
}