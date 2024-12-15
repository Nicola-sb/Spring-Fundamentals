package bg.softuni.mobilelelethymeleaf.model;

import bg.softuni.mobilelelethymeleaf.model.enums.EngineTypeEnum;

public record OfferSummaryDTO(Long id,
                              String description,
                              Integer mileage,
                              EngineTypeEnum engineType) {
}
