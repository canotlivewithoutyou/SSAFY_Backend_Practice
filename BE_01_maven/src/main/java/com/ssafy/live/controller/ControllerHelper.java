package com.ssafy.live.controller;

import java.io.IOException;
import java.util.Arrays;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface ControllerHelper {

    default String getActionParameter(HttpServletRequest request) {
        System.out.println("method: " + request.getMethod());
        System.out.println("경로: " + request.getRequestURI());

        request.getParameterMap().forEach((key, value) -> {
            System.out.println(key + ": " + Arrays.toString(value));
        });

        // action parameter 추출
        String action = request.getParameter("action");

        if (action == null || action.isBlank()) {
            action = "index";
        }

        return action;
    }

    default void responseHtml(String title, String content, HttpServletResponse resp) throws IOException {
        String html = "<html><body><h1>" + title + "</h1><div>" + content + "</div></body></html>";
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().write(html);
    }
}