package com.ssafy.exam.controller;

import java.io.IOException;



import com.ssafy.exam.model.service.CarServiceImpl;
import com.ssafy.exam.model.service.CarService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet({"/member", "/car"}) // 기억할 것
public class CarController extends HttpServlet implements ControllerHelper {

	private final CarService mService = CarServiceImpl.getService();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
			String action = getActionParameter(request, response);
			
			switch(action) {
				case "index" -> redirect(request, response, "/index.jsp");
				case "login-form" -> forward(request, response, "/login-form.jsp");
				case "car-list" -> list(request, response);
				default -> response.sendError(HttpServletResponse.SC_NOT_FOUND);
			}
		}
	

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		String action = getActionParameter(request, response);
		
		switch(action) {
			case "index" -> redirect(request, response, "/index.jsp");
			case "login" -> login(request, response, "/login-form.jsp");
			default -> response.sendError(HttpServletResponse.SC_NOT_FOUND);
		}
	}
	
	private void login(HttpServletRequest request, HttpServletResponse response, String string) {
		// TODO DB에서 가져오기
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		// System.out.println(email + " " + pass);
		
	}
	
	private void logout(HttpServletRequest request, HttpServletResponse response, String string) {
		
		
	}


	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("car/list.jsp").forward(request, response);
	}



}
