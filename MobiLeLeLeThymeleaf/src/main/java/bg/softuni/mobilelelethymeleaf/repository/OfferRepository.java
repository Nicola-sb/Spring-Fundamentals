package bg.softuni.mobilelelethymeleaf.repository;

import bg.softuni.mobilelelethymeleaf.model.entity.OfferEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferRepository extends JpaRepository<OfferEntity,Long> {


}
