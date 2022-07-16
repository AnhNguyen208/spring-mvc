package com.quanlydoanhthu.controller.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.quanlydoanhthu.dto.HangDTO;
import com.quanlydoanhthu.dto.LoaiSPDTO;
import com.quanlydoanhthu.dto.SanPhamDTO;
import com.quanlydoanhthu.service.dao.IHangService;
import com.quanlydoanhthu.service.dao.ILoaiSPService;
import com.quanlydoanhthu.service.dao.ISanPhamService;
import com.quanlydoanhthu.util.MessageUtil;

@Controller (value = "sanPhamControllerOfUser")
public class SanPhamController {
	@Autowired
	ISanPhamService sanPhamService;
	@Autowired
	IHangService hangService;
	@Autowired
	ILoaiSPService loaiSPService;
	@Autowired
	private MessageUtil messageUtil;
	
	@RequestMapping(value = "/trang-chu/san-pham/danh-sach", method = RequestMethod.GET)
	public ModelAndView productList(HttpServletRequest request) {
		SanPhamDTO sanPhamDTO = new SanPhamDTO();
		ModelAndView mav = new ModelAndView("web/sanpham/productList");
		sanPhamDTO.setListResult(sanPhamService.findAll());
		if (request.getParameter("message") != null) {
			Map<String, String> messageMap = messageUtil.getMessageMap(request.getParameter("message"));
			mav.addObject("message", messageMap.get("message"));
			mav.addObject("alert", messageMap.get("alert"));
		}
		mav.addObject("sanPham",sanPhamDTO);
		return mav;
	}
	
	@RequestMapping(value = "/trang-chu/san-pham/them", method = RequestMethod.GET)
	public ModelAndView addProduct() {
		SanPhamDTO sanPhamDTO = new SanPhamDTO();
		HangDTO hangDTO = new HangDTO();
		hangDTO.setListResult(hangService.findAll());
		LoaiSPDTO loaiSPDTO = new LoaiSPDTO();
		loaiSPDTO.setListResult(loaiSPService.findAll());
		ModelAndView mav = new ModelAndView("web/sanpham/addProduct");
		mav.addObject("loaiSP", loaiSPDTO);
		mav.addObject("hang", hangDTO);
		mav.addObject("sanPham",sanPhamDTO);
		return mav;
	}
	
	@RequestMapping(value = "/trang-chu/san-pham/chinh-sua", method = RequestMethod.GET)
	public ModelAndView editProduct(@RequestParam("id") Long idLong) {
		SanPhamDTO sanPhamDTO = sanPhamService.findById(idLong);
		ModelAndView mav = new ModelAndView("web/sanpham/editProduct");
		mav.addObject("sanPham",sanPhamDTO);
		return mav;
	}
}
