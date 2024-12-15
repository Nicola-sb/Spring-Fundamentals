package com.bonappetit.controller;

import com.bonappetit.config.UserSession;
import com.bonappetit.model.dto.UserLoginDto;
import com.bonappetit.model.dto.UserRegisterDto;
import com.bonappetit.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {


    private UserService userService;
    private final UserSession userSession;

    public UserController(UserService userService, UserSession userSession) {
        this.userService = userService;
        this.userSession = userSession;
    }

    @ModelAttribute("registerData")
    public UserRegisterDto registerDto(){
        return new UserRegisterDto();
    }

    @ModelAttribute("loginData")
    public UserLoginDto loginDto(){
        return new UserLoginDto();
    }

    @GetMapping("/register")
    public String register(){
        if(userSession.isLoggedIn()){
            return "redirect:/home";
        }

        return "register";
    }


    @PostMapping("/register")
    public String doRegister(
            @Valid UserRegisterDto data,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes
    ){
        if(userSession.isLoggedIn()){
            return "redirect:/home";
        }

        if(bindingResult.hasErrors() || !data.getPassword().equals(data.getConfirmPassword()) ){
            redirectAttributes.addFlashAttribute("registerData",data);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.registerData",bindingResult);
        }


       boolean success = userService.register(data);
        if(!success){
            return "redirect:/register";
        }

        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login(){
        if(userSession.isLoggedIn()){
            return "redirect:/home";
        }
        return "login";
    }

    @PostMapping("/login")
    public String doLogin(@Valid UserLoginDto data, BindingResult bindingResult, RedirectAttributes redirectAttributes){

        if(userSession.isLoggedIn()){
            return "redirect:/home";
        }
        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("loginData",data);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.loginData",bindingResult);

            return "redirect:/login";
        }

        boolean success = userService.login(data);

        if(!success){
            redirectAttributes.addFlashAttribute("loginError",true);

            return "redirect:/login";
        }

        return "redirect:/home";
    }

    @GetMapping("/logout")
    public String logout(){
        if(!userSession.isLoggedIn()){
            return "redirect:/";
        }

        userSession.logout();

        return "redirect:/";
    }
}