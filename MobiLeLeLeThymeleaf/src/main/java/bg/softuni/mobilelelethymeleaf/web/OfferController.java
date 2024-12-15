package bg.softuni.mobilelelethymeleaf.web;

import bg.softuni.mobilelelethymeleaf.model.AddOfferDTO;
import bg.softuni.mobilelelethymeleaf.model.enums.EngineTypeEnum;
import bg.softuni.mobilelelethymeleaf.service.OfferService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/offers")
public class OfferController {


    private final OfferService offerService;

    public OfferController(OfferService offerService) {
        this.offerService = offerService;
    }

    @GetMapping("/add")
    public String newOffer(Model model){

        if(!model.containsAttribute("addOfferDTO")){
            model.addAttribute("addOfferDTO",AddOfferDTO.empty());
        }

        model.addAttribute("allEngineTypes", EngineTypeEnum.values());
        //т.е. в модела добавяме атрибут, който се казва allEngineTypes и това нещо когато Спринг до докопа,
        //по-късно когато се парсва този темплийт ще вземе от модела всичко ще го сложи в thymeleaf contexta и ще парсне thymeleaf
        return "offer-add";
    }

    @PostMapping("/add")
    public String createOffer(
            @Valid AddOfferDTO addOfferDTO,
            BindingResult bindingResult,
            RedirectAttributes rAtt){

        if(bindingResult.hasErrors()){
            rAtt.addFlashAttribute("addOfferDTO",addOfferDTO);
            rAtt.addFlashAttribute(
                    "org.springframework.validation.BindingResult.addOfferDTO",bindingResult);
            return "redirect:/offers/add";

        }

        //TODO:
        long newOfferId = offerService.createOrder(addOfferDTO);

        return "redirect:/offers/" + newOfferId;

    }

    @GetMapping("/{id}")
    public String offerDetails(@PathVariable("id") Long id, Model model){
        model.addAttribute("offerDetails",offerService.getOfferDetails(id));


        return "details";
    }

    @DeleteMapping("/{id}")
    public String deleteOffer(@PathVariable("id") Long id){
        offerService.deleteOffer(id);

        return "redirect:/offers/all";
    }
}
