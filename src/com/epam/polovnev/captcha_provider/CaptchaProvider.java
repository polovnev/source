package com.epam.polovnev.captcha_provider;

import static nl.captcha.Captcha.NAME;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import com.epam.polovnev.Constants;

import nl.captcha.Captcha;
import nl.captcha.backgrounds.FlatColorBackgroundProducer;
import nl.captcha.text.renderer.ColoredEdgesWordRenderer;

public class CaptchaProvider {

	private static final List<Color> COLORS = new ArrayList<Color>();
	private static final List<Font> FONTS = new ArrayList<Font>();

	static {
		COLORS.add(Color.BLACK);
		COLORS.add(Color.BLUE);
		COLORS.add(Color.RED);
		COLORS.add(Color.YELLOW);
		COLORS.add(Color.GREEN);
		
		FONTS.add(new Font("Geneva", Font.ITALIC, 48));
	}


	public Captcha getCatcha(HttpServletRequest request) {
		ColoredEdgesWordRenderer wordRenderer = new ColoredEdgesWordRenderer(
				COLORS, FONTS);
		Captcha captcha = new Captcha.Builder(180, 80)
				.addText(wordRenderer).gimp().addNoise()
				.addBackground(new FlatColorBackgroundProducer()).build();
		
		boolean isCaptchaStoredInSession = Boolean
				.parseBoolean(request.getServletContext().getInitParameter(
						"isCaptchaStoredInSession"));
		if (isCaptchaStoredInSession) {
			request.getSession().setAttribute(NAME, captcha);
		} else {
			String userID = getUserID(request);
			request.getServletContext().setAttribute(userID,
					captcha);
		}
		return captcha;
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
}
