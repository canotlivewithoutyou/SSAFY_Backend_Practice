package com.ssafy.live.controller;

import java.io.IOException;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddServlet
 */
@WebServlet("/add")
public class AddServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String num1 = request.getParameter("num1");
		String num2 = request.getParameter("num2");
		
		// 파라미터에 대한 logging 및 validation 로직 필요!
		int result = Integer.parseInt(num1) + Integer.parseInt(num2);
		
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().append("<html><body><span>더하기 결과는 <strong>" + result + "</strong></span></body></html>");
	}
	
}
