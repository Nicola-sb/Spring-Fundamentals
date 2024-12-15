package bg.softuni.mobilelelethymeleaf.web;

import bg.softuni.mobilelelethymeleaf.model.UserRegistrationDTO;
import bg.softuni.mobilelelethymeleaf.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class RegistrationController {


    private final UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }



    @GetMapping("/register")
    public String register(){
        return "auth-register";
    }


    @ModelAttribute("registerDTO")
    public UserRegistrationDTO registerDTO(){
        return new UserRegistrationDTO();
    }


    @PostMapping("/register")
    public String register(UserRegistrationDTO registerDTO){
        userService.registerUser(registerDTO);

//        return "index";
        return "redirect:/";
    }




//    @PostMapping("/register")
//    public String register(@ModelAttribute("registerDTO") UserRegistrationDTO registerDTO) {
//        userService.registerUser(registerDTO);
//        return "redirect:/";
//    }
}
