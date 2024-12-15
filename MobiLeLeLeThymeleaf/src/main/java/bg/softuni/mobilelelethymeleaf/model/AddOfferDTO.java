package bg.softuni.mobilelelethymeleaf.model;

import bg.softuni.mobilelelethymeleaf.model.enums.EngineTypeEnum;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

public record AddOfferDTO(
        @NotEmpty(message = "{add.offer.description.not.empty}")
        @Size(message = "{add.offer.description.lenght}", min = 5, max = 500) String description,
                      @NotNull @PositiveOrZero Integer mileage,
                         @NotNull EngineTypeEnum engineType) {


    public static AddOfferDTO empty(){
        return new AddOfferDTO(null,null,null);
    }
}
