package com.booking.slotbooking.controller;

import com.booking.slotbooking.dto.PartnerRequestDTO;
import com.booking.slotbooking.entity.Partner;
import com.booking.slotbooking.service.PartnerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/partners")
public class PartnerController {

    private final PartnerService partnerService;

    public PartnerController(PartnerService partnerService) {
        this.partnerService = partnerService;
    }

    @PostMapping
    public Partner createPartner(@RequestBody PartnerRequestDTO request) {
        return partnerService.createPartner(request);
    }

    @GetMapping("/city")
    public List<Partner> getPartnersByCity(@RequestParam String city) {
        return partnerService.getAvailablePartnersByCity(city);
    }
}