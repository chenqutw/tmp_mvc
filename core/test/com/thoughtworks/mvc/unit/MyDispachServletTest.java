package com.thoughtworks.mvc.unit;

import main.com.thoughtworks.mvc.MyDispatchServlet;
import main.com.thoughtworks.mvc.MyDispatchServlet;
import org.junit.Test;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Matchers.isNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MyDispachServletTest {
    @Test
    public void should_return_correct_view() throws ServletException, IOException {
        MyDispatchServlet dispachServlet = new MyDispatchServlet();
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        when(request.getPathInfo()).thenReturn("hello/show");
        dispachServlet.doGet(request,response);

        assertThat(dispachServlet.getView(), is("hello.jsp"));

        when(request.getPathInfo()).thenReturn("home/show");
        dispachServlet.doGet(request,response);

        assertThat(dispachServlet.getView(), is("home.ftl"));

    }
}
