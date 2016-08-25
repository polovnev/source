package com.epam.polovnev.servlet;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nl.captcha.Captcha;

import com.epam.polovnev.Constants;
import com.epam.polovnev.excepption.CaptchaNotCorrectException;
import com.epam.polovnev.service.Service;
import com.epam.polovnev.user.User;

/**
 * Servlet implementation class Registration
 */
@WebServlet("/registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Service service = new Service();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String userID = getUserID(request);
		request.setAttribute("userID", userID);
		request.setAttribute("user_name", request.getParameter("user_name"));
		request.setAttribute("surname", request.getParameter("surname"));
		request.setAttribute("email", request.getParameter("email"));
		request.setAttribute("pas", request.getParameter("pas"));
		request.setAttribute("r_pas", request.getParameter("r_pas"));
		request.setAttribute("isSend",
				request.getParameter("isSend") != null ? "checked" : null);

		long startTime = System.currentTimeMillis();
		request.getSession().setAttribute("startTime", startTime);

		String nextJSP = "/registration_JavaScript.jsp";
		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher(nextJSP);
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		long startTime = (Long) request.getSession().getAttribute("startTime");
		long endTime = System.currentTimeMillis();
		long timeBetween = endTime - startTime;

		if (!cheñkTime(timeBetween)) {
			request.setAttribute("error", "session is end");
			doGet(request, response);
		} else {
			String email = request.getParameter("email");
			if (service.checkEmail(email)) {
				Captcha captcha = getCaptcha(request);
				String captchaResponse = request
						.getParameter("captchaResponse");

				checkCaptcha(captcha, captchaResponse, response, request);

				String user_name = request.getParameter("user_name");
				String surname = request.getParameter("surname");
				String pas = request.getParameter("pas");
				boolean isSend = (request.getParameter("isSend") != null);
				User user = new User(user_name, surname, email,
						pas, isSend);
				service.addUser(user);
			} else {
				request.setAttribute("error", "email exist");
				System.out.println(request.getAttribute("error"));
				doGet(request, response);
			}
		}
	}

	public void checkCaptcha(Captcha captcha, String captchaResponse,
			HttpServletResponse response, HttpServletRequest request)
			throws IOException, ServletException, CaptchaNotCorrectException {
		if (captcha.isCorrect(captchaResponse)) {
			response.sendRedirect("ok.jsp");
		} else {
			request.setAttribute("error", "captcha not correct");
			doGet(request, response);
			throw new CaptchaNotCorrectException();
		}
	}


	private String getUserID(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals(Constants.CAPTCHA_ID_NAME)) {
				return cookie.getValue();
			}
		}
		return null;
	}

	private Captcha getCaptcha(HttpServletRequest request) {
		Captcha captcha = null;
		boolean isCaptchaStoredInSession = Boolean
				.parseBoolean(getServletContext().getInitParameter(
						"isCaptchaStoredInSession"));
		if (isCaptchaStoredInSession) {
			captcha = (Captcha) request.getSession().getAttribute(
					"simpleCaptcha");
		} else {
			ServletContext context = request.getServletContext();
			captcha = (Captcha) context.getAttribute(getUserID(request));
		}
		return captcha;
	}

	private boolean cheñkTime(long time) {
		long timeForSession = Long.parseLong(getServletContext()
				.getInitParameter("timeForSession"));
		return timeForSession > time;
	}
}
