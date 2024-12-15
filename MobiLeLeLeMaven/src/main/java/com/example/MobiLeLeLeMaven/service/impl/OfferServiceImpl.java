package com.example.MobiLeLeLeMaven.service.impl;

import com.example.MobiLeLeLeMaven.model.AddOfferDTO;
import com.example.MobiLeLeLeMaven.model.entity.OfferEntity;
import com.example.MobiLeLeLeMaven.repository.OfferRepository;
import com.example.MobiLeLeLeMaven.service.OfferrService;
import org.springframework.stereotype.Service;

@Service
public class OfferServiceImpl implements OfferrService {

    private final OfferRepository offerRepository;

    public OfferServiceImpl(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    @Override
    public void createOrder(AddOfferDTO addOfferDTO) {
       offerRepository.save(map(addOfferDTO));
    }

    private static OfferEntity map(AddOfferDTO addOfferDTO){
      return
      new OfferEntity()
              .setDescription(addOfferDTO.description())
               .setEngine(addOfferDTO.engineType());
    }
}
