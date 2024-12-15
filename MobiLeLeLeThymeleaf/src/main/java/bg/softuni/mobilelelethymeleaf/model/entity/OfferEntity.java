package bg.softuni.mobilelelethymeleaf.model.entity;

import bg.softuni.mobilelelethymeleaf.model.enums.EngineTypeEnum;
import jakarta.persistence.*;

@Entity
@Table(name = "offers")
public class OfferEntity extends BaseEntity{



    private String description;
    private Integer mileage;

    @Enumerated(EnumType.STRING)
    private EngineTypeEnum engine;



    public String getDescription() {
        return description;
    }

    public OfferEntity setDescription(String description) {
        this.description = description;
        return this;
    }

    public EngineTypeEnum getEngine() {
        return engine;
    }

    public OfferEntity setEngine(EngineTypeEnum engine) {
        this.engine = engine;
        return this;
    }

    public Integer getMileage() {
        return mileage;
    }

    public OfferEntity setMileage(Integer mileage) {
        this.mileage = mileage;
        return this;
    }
}
