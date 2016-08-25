package com.epam.polovnev;


import static org.junit.Assert.*;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nl.captcha.Captcha;

import org.junit.Test;
import org.mockito.Mockito;

import com.epam.polovnev.excepption.CaptchaNotCorrectException;
import com.epam.polovnev.servlet.Registration;

public class TestRegistration extends Mockito {


	private HttpServletRequest request = mock(HttpServletRequest.class);
	private HttpServletResponse response = mock(HttpServletResponse.class);

	@Test(expected=CaptchaNotCorrectException.class)
	public void checkCaptchaTest() throws IOException, ServletException {
		Registration registration = new Registration() {
			@Override
			public void doGet(HttpServletRequest request,
					HttpServletResponse response) throws ServletException,
					IOException {
			}
		};
		String captchaResponse = "123";
		Captcha captcha = mock(Captcha.class);
		when(captcha.isCorrect(captchaResponse)).thenReturn(false);
		registration.checkCaptcha(captcha, captchaResponse, response, request);

	}

}
