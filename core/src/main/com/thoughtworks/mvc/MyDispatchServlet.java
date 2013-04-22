package main.com.thoughtworks.mvc;

import main.com.thoughtworks.FakeGuice;
import main.com.thoughtworks.Injector;
import main.com.thoughtworks.module.Module;
import main.com.thoughtworks.mvc.model.ModelAndView;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyDispatchServlet extends HttpServlet {

    private String view;
    private Injector injector = FakeGuice.createInjector(new Module());

    public String getView() {
        return view;
    }

    public void doGet(HttpServletRequest rqst, HttpServletResponse rsp) throws ServletException, IOException {

        String path = rqst.getPathInfo();
        String[] controllerAndMethod = path.split("/");
        String controllerName = "com.thoughtworks.app.controllers." + capitalize(controllerAndMethod[1]) + "Controller";
        String methodName = controllerAndMethod[2];

        try {
            Class controllerClass = Class.forName(controllerName);
            Object controller = injector.getInstance(controllerClass);
            ModelAndView mv = (ModelAndView)controller.getClass().getMethod(methodName).invoke(controller);
            view = mv.getViewName();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private String capitalize(String s) {
        return Character.toUpperCase(s.charAt(0)) + s.substring(1);
    }

}

