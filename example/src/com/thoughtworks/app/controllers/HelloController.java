package com.thoughtworks.app.controllers;

import main.com.thoughtworks.annotation.Inject;
import main.com.thoughtworks.annotation.Named;
import main.com.thoughtworks.mvc.model.ModelAndView;

public class HelloController {

    public String getView() {
        return "hello.jsp";
    }

    public ModelAndView show() {
        ModelAndView mv = new ModelAndView();
        mv.addView("hello.jsp");
        return mv;
    }

    private String serviceName;

    public HelloController() {
    }

    public HelloController(@Named(value = "Controller Service") String serviceName) {
        this.serviceName = serviceName;
    }

    public void doSomething() {
        System.out.println(serviceName);
    }

    @Inject
    public void setServiceName(@Named(value = "hello world")String serviceName) {
        this.serviceName = serviceName;
    }
}
