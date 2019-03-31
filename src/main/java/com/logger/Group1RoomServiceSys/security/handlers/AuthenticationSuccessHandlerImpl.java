package com.logger.Group1RoomServiceSys.security.handlers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.logger.Group1RoomServiceSys.beans.User;
import com.logger.Group1RoomServiceSys.security.SecurityUtil;

@Component
public class AuthenticationSuccessHandlerImpl extends SimpleUrlAuthenticationSuccessHandler {

//	@Override
//	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
//			Authentication authentication) throws IOException, ServletException {
//		SecurityUtil.sendResponse(response, HttpServletResponse.SC_OK, "Login successfully.", null);
//	}
	
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		SecurityUtil.sendAuthenticationSuccessResponse(response, HttpServletResponse.SC_OK, "Login successfully.", null, (User)authentication.getPrincipal());
	}
	
}
