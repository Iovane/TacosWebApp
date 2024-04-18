package com.example.TacosWebApp.web;

import com.example.TacosWebApp.data.UserDao;
import com.example.TacosWebApp.entities.User;
import com.example.TacosWebApp.security.RegistrationForm;
import com.example.TacosWebApp.service.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.logging.Logger;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    private static final org.slf4j.Logger log = LoggerFactory.getLogger(RegistrationController.class);
    private Logger logger = Logger.getLogger(getClass().getName());

    private UserService userService;



    public RegistrationController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping
    public String registerForm(){
        return "registration";
    }

    @PostMapping
    public String processRegistration(@Valid @ModelAttribute("userForm") RegistrationForm userForm,
                                      BindingResult theBindingResult,
                                      HttpSession theSession,
                                      Model theModel){


        String userName = userForm.getUsername();
        logger.info("Processing registration form for: " + userName);

        // form validation
        if (theBindingResult.hasErrors()){
            // Add userForm and theBindingResult to model
            theModel.addAttribute("userForm", new RegistrationForm());
            theModel.addAttribute("bindingResult", theBindingResult);
            return "registration";
        }

        // check the database if user already exists
        User existing = userService.findByUserName(userName);
        if (existing != null){
            theModel.addAttribute("userForm", new RegistrationForm());
            theModel.addAttribute("registrationError", "User name already exists.");

            logger.warning("User name already exists.");
            return "registration";
        }

        userService.save(userForm);

        return "redirect:/login";
    }
}
