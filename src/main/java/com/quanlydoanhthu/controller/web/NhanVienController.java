package com.quanlydoanhthu.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.quanlydoanhthu.dto.ChucVuDTO;
import com.quanlydoanhthu.dto.NhanVienDTO;
import com.quanlydoanhthu.service.dao.INhanVienService;
import com.quanlydoanhthu.util.SecurityUtils;

@Controller(value = "nhanVienControllerOfUser")
public class NhanVienController {
	@Autowired
	INhanVienService nhanVienService;
	
	@RequestMapping(value = "/trang-chu/thong-tin", method = RequestMethod.GET)
	public ModelAndView profile() {
		ModelAndView mav = new ModelAndView("web/profile");
		NhanVienDTO nhanVienDTO = nhanVienService.findDoangThu(SecurityUtils.getPrincipal().getNhanVienDTO().getId()); 
		ChucVuDTO chucVuDTO = nhanVienDTO.getChucVuDTO();
		mav.addObject("model", nhanVienDTO);
		mav.addObject("model1", chucVuDTO);
		return mav;
	}
}
