package com.booking.slotbooking.service.impl;

import com.booking.slotbooking.dto.PartnerRequestDTO;
import com.booking.slotbooking.entity.Partner;
import com.booking.slotbooking.repository.PartnerRepository;
import com.booking.slotbooking.service.PartnerService;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartnerServiceImpl implements PartnerService {

    private final PartnerRepository partnerRepository;

    public PartnerServiceImpl(PartnerRepository partnerRepository) {
        this.partnerRepository = partnerRepository;
    }

    @Override
    @Transactional
    public Partner createPartner(PartnerRequestDTO request) {

        Partner partner = new Partner();
        partner.setName(request.getName());
        partner.setCity(request.getCity());
        partner.setAvailable(request.getAvailable());

        return partnerRepository.save(partner);
    }

    @Override
    public List<Partner> getAvailablePartnersByCity(String city) {
        return partnerRepository.findByCityAndAvailable(city);
    }
}