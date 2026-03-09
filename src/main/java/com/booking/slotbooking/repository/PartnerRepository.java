package com.booking.slotbooking.repository;

import com.booking.slotbooking.entity.Partner;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * @Author Allan George
 */
@Repository
public class PartnerRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Partner save(Partner partner) {
        entityManager.persist(partner);
        return partner;
    }

    public List<Partner> findByCityAndAvailable(String city) {

        String jpql = "SELECT p FROM Partner p WHERE p.city = :city AND p.available = true";

        return entityManager.createQuery(jpql, Partner.class)
                .setParameter("city", city)
                .getResultList();
    }
}