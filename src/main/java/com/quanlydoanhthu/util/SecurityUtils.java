package com.quanlydoanhthu.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import com.quanlydoanhthu.dto.MyUser;

public class SecurityUtils {
	
	public static MyUser getPrincipal() {
		MyUser myUser = (MyUser) (SecurityContextHolder.getContext()).getAuthentication().getPrincipal();
        return myUser;
    }
	
	@SuppressWarnings("unchecked")
	public static List<String> getAuthorities() {
		List<String> resultStrings = new ArrayList<>();
		List<GrantedAuthority> authorities = (List<GrantedAuthority>) (SecurityContextHolder.getContext()
				.getAuthentication().getAuthorities());
		for (GrantedAuthority authority : authorities) {
			resultStrings.add(authority.getAuthority());
		}
		return resultStrings;
	}
	
	
}
