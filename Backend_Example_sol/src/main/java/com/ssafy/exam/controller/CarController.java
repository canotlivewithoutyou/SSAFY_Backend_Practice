package com.ssafy.exam.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ssafy.exam.model.dto.Member;
import com.ssafy.exam.model.dto.Car;
import com.ssafy.exam.model.service.CarServiceImpl;
import com.ssafy.exam.model.service.CarService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet({ "/member", "/car" })
public class CarController extends HttpServlet implements ControllerHelper {

	private final CarService mService = CarServiceImpl.getService();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = getActionParameter(request, response);
		switch (action) {
		case "index" -> redirect(request, response, "/index.jsp");
		case "login-form" -> forward(request, response, "/login-form.jsp");
		case "logout" -> logout(request, response);
		case "regist-form" -> forward(request, response, "/car/regist.jsp");
		case "car-list" -> list(request, response);
		default -> response.sendError(HttpServletResponse.SC_NOT_FOUND); // 404 처리
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = getActionParameter(request, response);
		switch (action) {
		case "index" -> redirect(request, response, "/index.jsp");
		case "login" -> login(request, response);
		case "regist" -> regist(request, response);
		default -> response.sendError(HttpServletResponse.SC_NOT_FOUND); // 404 처리
		}
	}

	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		String rememberMe = request.getParameter("remember-me");
		Member member = mService.login(email, pass);
		System.out.println(member);
		if (member != null) {
			request.getSession().setAttribute("loginUser", member);
			request.getSession().removeAttribute("alertMsg");

			if (rememberMe == null) {
				setupCookie("rememberMe", "bye", 0, null, response);
			} else {
				setupCookie("rememberMe", email, 60 * 60 * 24 * 365, null, response);
			}
			redirect(request, response, "/");
		} else {
			request.setAttribute("alertMsg", "로그인에 실패했습니다. 아이디와 비밀번호를 확인해주세요.");
			forward(request, response, "/login-form.jsp");
		}
	}

	private void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().invalidate();
		redirect(request, response, "/");
	}

	private void regist(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String code = request.getParameter("code");
		String model = request.getParameter("model");
		int price = Integer.parseInt(request.getParameter("price"));
		String vendor = request.getParameter("vendor");
		String size = request.getParameter("size");
		Car car = new Car(code, model, price, vendor, size);

		System.out.println("등록 제품:" + car);

		mService.insert(car);

		response.sendRedirect(request.getContextPath() + "/car?action=car-list");
	}

	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Car> carList = mService.selectAll();

		request.setAttribute("list", carList);
		request.getRequestDispatcher("car/list.jsp").forward(request, response);
	}



}
