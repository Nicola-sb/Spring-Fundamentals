package com.example.MobiLeLeLeMaven.model.entity;

import com.example.MobiLeLeLeMaven.model.enums.EngineTypeEnum;
import jakarta.persistence.*;

@Entity
@Table(name = "offers")
public class OfferEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    @Enumerated(EnumType.STRING)
    private EngineTypeEnum engine;

    public Long getId() {
        return id;
    }

    public OfferEntity setId(Long id) {
        this.id = id;
        return this;
//        this.id = id;
//        return this; // Връща текущия обект
    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public EngineTypeEnum getEngine() {
//        return engine;
//    }
//
//    public void setEngine(EngineTypeEnum engine) {
//        this.engine = engine;
//    }


    public String getDescription() {
    return description;
    }

    public OfferEntity setDescription(String description) {
        this.description = description;
        return this; // Връща текущия обект
    }

    public EngineTypeEnum getEngine() {
        return engine;
    }

    public OfferEntity setEngine(EngineTypeEnum engine) {
        this.engine = engine;
        return this; // Връща текущия обект
    }
}