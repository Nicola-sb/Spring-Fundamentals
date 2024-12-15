package com.example.MobiLeLeLeMaven.web;

import com.example.MobiLeLeLeMaven.model.AddOfferDTO;
import com.example.MobiLeLeLeMaven.model.enums.EngineTypeEnum;
import com.example.MobiLeLeLeMaven.service.OfferrService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class OfferController {

    private final OfferrService orderService;

    public OfferController(OfferrService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/offers/add")
    public String newOffer(Model model){

        if(!model.containsAttribute("addOfferDTO")){
            model.addAttribute("addOfferDTO",AddOfferDTO.empty());
        }

        model.addAttribute("allEngineTypes", EngineTypeEnum.values());

        return "offer-add";
    }

    @PostMapping("/offers/add")
    public String createOffer(AddOfferDTO addOfferDTO){

        orderService.createOrder(addOfferDTO); //идеята е че това нещо трябва да запише нашия ордер в базата данни
        //TODO
        return "offer-add";
    }
}
