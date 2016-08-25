package com.epam.polovnev.captcha;

import nl.captcha.Captcha;

public class CaptchaInfo {
	private Captcha captcha;
	private String userID;
	
	public CaptchaInfo(Captcha captcha, String userID) {
		super();
		this.captcha = captcha;
		this.userID = userID;
	}

	public Captcha getCaptcha() {
		return captcha;
	}

	public void setCaptcha(Captcha captcha) {
		this.captcha = captcha;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}
}
