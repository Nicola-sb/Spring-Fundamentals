package com.example.MobiLeLeLeMaven.repository;

import com.example.MobiLeLeLeMaven.model.entity.OfferEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferRepository extends JpaRepository<OfferEntity,Long> {

}
