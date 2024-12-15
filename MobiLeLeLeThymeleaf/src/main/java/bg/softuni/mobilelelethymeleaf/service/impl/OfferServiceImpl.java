package bg.softuni.mobilelelethymeleaf.service.impl;

import bg.softuni.mobilelelethymeleaf.model.AddOfferDTO;
import bg.softuni.mobilelelethymeleaf.model.OfferSummaryDTO;
import bg.softuni.mobilelelethymeleaf.model.entity.OfferDetailsDTO;
import bg.softuni.mobilelelethymeleaf.model.entity.OfferEntity;
import bg.softuni.mobilelelethymeleaf.repository.OfferRepository;
import bg.softuni.mobilelelethymeleaf.service.OfferService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;

    public OfferServiceImpl(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    @Override
    public long createOrder(AddOfferDTO addOfferDTO) {
      return offerRepository.save(map(addOfferDTO)).getId();
    }

    @Override
    public OfferDetailsDTO getOfferDetails(Long id) {
        return this.offerRepository
                .findById(id)
                .map(OfferServiceImpl::toOfferDetails)
                .orElseThrow();
    }

    @Override
    public List<OfferSummaryDTO> getAllOffersSummary() {
        return offerRepository.findAll().stream().map(OfferServiceImpl::toOffersSummary).toList();
    }

    @Override
    public void deleteOffer(long offerId) {
        offerRepository.deleteById(offerId);
    }

    private static OfferSummaryDTO toOffersSummary(OfferEntity offerEntity){

        return new OfferSummaryDTO(offerEntity.getId(), offerEntity.getDescription(),
                offerEntity.getMileage(),offerEntity.getEngine());
    }

    private static OfferDetailsDTO toOfferDetails(OfferEntity offerEntity){
        //todo using mapping library
        return new OfferDetailsDTO(offerEntity.getId(), offerEntity.getDescription(),
                offerEntity.getMileage(),offerEntity.getEngine());
    }

    private static OfferEntity map(AddOfferDTO addOfferDTO){
        return new OfferEntity()
                .setDescription(addOfferDTO.description())
                .setEngine(addOfferDTO.engineType())
                .setMileage(addOfferDTO.mileage());
    }
}
