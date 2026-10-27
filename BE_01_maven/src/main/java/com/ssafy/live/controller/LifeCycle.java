package com.ssafy.live.controller;

import jakarta.servlet.http.HttpServlet;
import java.io.IOException;
import java.util.Arrays;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LifeCycle
 */
@WebServlet("/LifeCycle")
public class LifeCycle extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LifeCycle() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("초기화");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("자원 정리");
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.service(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("METHOD: " + request.getMethod());
		System.out.println("URI: " + request.getRequestURI());
		request.getParameterMap().forEach((k, v) -> {
			System.out.println("- " + k + ": " + Arrays.toString(v));
		});
		System.out.println("---------------------------------");
		String name = request.getParameter("name"); // 리턴값은 문자열
		System.out.println("전달된 Parameter: " + name);
		
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().append("<html><body><h1>안녕하세요 " + name + "님</h1></body></html>");
		// Servlet 단점: Business 로직과 Presentation 로직(HTML Code)가 섞여서 나타남
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
