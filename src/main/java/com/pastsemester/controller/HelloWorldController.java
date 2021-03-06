package com.pastsemester.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import com.pastsemester.model.User;
import com.pastsemester.service.UserProfileService;
import com.pastsemester.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.NoHandlerFoundException;


// TODO: CONFIRM PASSWORD VALIDATION
// TODO: EMAIL VALIDATION
// TODO: REDESIGN DATABASE
// TODO: REDESIGN PAGE ACCESS
// TODO: ADD CAPTCHA TO LOGIN AND REGISTER
// TODO: ADD LOGGING
// TODO: ADD PASSWORD ENCRYPTION
// TODO: SEND EMAIL AFTER LOGIN FOR REGISTRATION
// TODO: SESSION MANAGEMENT
// TODO: REMEMBER ME FUNCTIONALITY
// TODO: CANNOT CREATE ACCOUNTS WITH THE SAME EMAIL, USERNAME
// TODO: NEED TO DO PROPER REGISTRATION VALIDATION
// TODO: ADD HTTPS
// TODO: CHANGE PAGE TO REFLECT SIGNIN
// TODO: ADD ACCOUNT MENU SETTINGS
// TODO: CUSTOM PAGE FOR ERRORS
@Controller
public class HelloWorldController {

    @Autowired
    UserService userService;

    @Autowired
    UserProfileService userProfileService;

    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String homePage(ModelMap model) {
        model.addAttribute("user", getPrincipal());
        return "index";
    }

//    @RequestMapping(value = "/admin", method = RequestMethod.GET)
//    public String adminPage(ModelMap model) {
//        model.addAttribute("user", getPrincipal());
//        return "/admin";
//    }
//
//    @RequestMapping(value = "/db", method = RequestMethod.GET)
//    public String dbaPage(ModelMap model) {
//        model.addAttribute("user", getPrincipal());
//        return "dba";
//    }

    @RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
    public String accessDeniedPage(ModelMap model) {
        model.addAttribute("user", getPrincipal());
        return "accessDenied";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage() {
        return "login";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerUser(@Valid @ModelAttribute("user") User user) throws Exception {
        userService.save(user);
        return "login";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerPage() {
        return "register";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout";
    }

    private String getPrincipal() {
        String userName;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userName = ((UserDetails) principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }
}