package bg.softuni.mobilelelethymeleaf.service;

import bg.softuni.mobilelelethymeleaf.model.AddOfferDTO;
import bg.softuni.mobilelelethymeleaf.model.OfferSummaryDTO;
import bg.softuni.mobilelelethymeleaf.model.entity.OfferDetailsDTO;

import java.util.List;

public interface OfferService {


    long createOrder(AddOfferDTO addOfferDTO);

    OfferDetailsDTO getOfferDetails(Long id);

    List<OfferSummaryDTO> getAllOffersSummary();

    void deleteOffer(long offerId);
}
