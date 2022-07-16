package com.quanlydoanhthu.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class MessageUtil {
	public Map<String, String> getMessageMap(String messageString) {
		Map<String, String>  map = new HashMap<String, String>();
		if(messageString.equals("update_success")) {
			map.put("message", "Update Success");
			map.put("alert", "success");
		} else if (messageString.equals("insert_success")) {
			map.put("message", "Insert Success");
			map.put("alert", "success");
		}else if (messageString.equals("delete_success")) {
			map.put("message", "Delete Success");
			map.put("alert", "success");
		}else if (messageString.equals("error_system")) {
			map.put("message", "Error System");
			map.put("alert", "danger");
		} 
		return map;
	}
}
