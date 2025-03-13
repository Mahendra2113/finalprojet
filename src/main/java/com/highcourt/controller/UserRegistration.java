package com.highcourt.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.highcourt.model.User;

/**
 * Servlet implementation class UserRegistration
 */
public class UserRegistration extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
        String password = request.getParameter("password");
        String mobileno = request.getParameter("mobileno");
        String email = request.getParameter("email");

        int sectioncode = Integer.parseInt(request.getParameter("sectioncode"));
        int statecode = Integer.parseInt(request.getParameter("statecode"));
        int districtcode = Integer.parseInt(request.getParameter("districtcode"));
        int talukacode = Integer.parseInt(request.getParameter("talukacode"));
        User u = new User(username, mobileno, email, sectioncode, password, talukacode, talukacode, talukacode);
        int status=u.userRegister();
        if(status == 1) {
        	response.sendRedirect("/Highcourt/UserRegistrationSuccess.jsp");
        }
	}

}
