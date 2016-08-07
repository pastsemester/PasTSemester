package com.pastsemester.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Adisor on 8/6/2016.
 */
@ControllerAdvice
public class AdviceController {

    @RequestMapping(value = {"/404"}, method = RequestMethod.GET)
    public String NotFoudPage() {
        return "error";
    }

    @ExceptionHandler({Exception.class})
    public String anyError() {
        return "error";
    }
}