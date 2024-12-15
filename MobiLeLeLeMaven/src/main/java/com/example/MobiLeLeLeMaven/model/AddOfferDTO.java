package com.example.MobiLeLeLeMaven.model;

import com.example.MobiLeLeLeMaven.model.enums.EngineTypeEnum;

public record AddOfferDTO(
        String description,
        EngineTypeEnum engineType) {


    public static AddOfferDTO empty(){
        return new AddOfferDTO(null,null);
    }

//    @Override
//    public String description() {
//        return description;
//    }
//
//    @Override
//    public EngineTypeEnum engineType() {
//        return engineType;
//    }


}
