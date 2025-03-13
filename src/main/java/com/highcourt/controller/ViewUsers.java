package com.highcourt.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.highcourt.model.User;

/**
 * Servlet implementation class ViewUsers
 */
public class ViewUsers extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User u=new User();
		List<User> userList=u.viewUsers();
		HttpSession session=request.getSession();
		session.setAttribute("suserList", userList);
		response.sendRedirect("/Highcourt/view_users.jsp");
	}

}
