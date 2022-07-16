package com.quanlydoanhthu.security;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.quanlydoanhthu.util.SecurityUtils;

@Component
public class CustomSuccessHandler extends SimpleUrlAuthenticationSuccessHandler{
	
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException {
		String targetUrl = determineTargetUrl(authentication);
		if (response.isCommitted()) {
			return;
		}
		redirectStrategy.sendRedirect(request, response, targetUrl);
	}
	
	private String determineTargetUrl(Authentication authentication) {
		String url = "";
		List<String> phanquyenList = SecurityUtils.getAuthorities();
		if(isAdmin(phanquyenList)) {
			url = "/quan-tri/trang-chu";
		}
		else if (isUser1(phanquyenList)) {
			url = "/trang-chu";
		}
		else if (isUser2(phanquyenList)) {
			url = "/trang-chu";
		}
		return url;
	}
	
	public RedirectStrategy getRedirectStrategy() {
		return redirectStrategy;
	}

	public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
		this.redirectStrategy = redirectStrategy;
	}

	private boolean isAdmin(List<String> phanquyenList) {
		if (phanquyenList.contains("ADMIN")) {
			return true;
		}
		return false;
	}
	
	private boolean isUser1(List<String> phanquyenList) {
		if (phanquyenList.contains("USER1")) {
			return true;
		}
		return false;
	}
	
	private boolean isUser2(List<String> phanquyenList) {
		if (phanquyenList.contains("USER2")) {
			return true;
		}
		return false;
	}
}
