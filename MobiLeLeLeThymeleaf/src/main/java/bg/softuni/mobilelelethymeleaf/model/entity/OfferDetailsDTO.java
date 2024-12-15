package bg.softuni.mobilelelethymeleaf.model.entity;

import bg.softuni.mobilelelethymeleaf.model.enums.EngineTypeEnum;

public record OfferDetailsDTO(Long id,
                              String description,
                              Integer mileage,
                              EngineTypeEnum engineType) {
}
