package com.epam.polovnev.servlet;

import java.io.IOException;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nl.captcha.Captcha;

import nl.captcha.servlet.CaptchaServletUtil;


import com.epam.polovnev.captcha_provider.CaptchaProvider;


public class SimpleCaptchaServlet extends HttpServlet {
	
	private CaptchaProvider captchaProvider = new CaptchaProvider();

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("cookie") != null) {}

		Captcha captcha = captchaProvider.getCatcha(request);
		CaptchaServletUtil.writeImage(response, captcha.getImage());	
	}
}