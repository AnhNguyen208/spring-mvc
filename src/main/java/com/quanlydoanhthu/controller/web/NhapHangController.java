package com.quanlydoanhthu.controller.web;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.quanlydoanhthu.dto.NhanVienDTO;
import com.quanlydoanhthu.dto.NhapHangDTO;
import com.quanlydoanhthu.dto.SanPhamDTO;
import com.quanlydoanhthu.service.dao.INhanVienService;
import com.quanlydoanhthu.service.dao.INhapHangService;
import com.quanlydoanhthu.service.dao.ISanPhamService;
import com.quanlydoanhthu.util.MessageUtil;

@Controller (value = "nhapHangControllerOfUser")
public class NhapHangController {
	@Autowired
	INhapHangService nhapHangService;
	@Autowired
	INhanVienService nhanVienService;
	@Autowired
	ISanPhamService sanPhamService;
	@Autowired
	private MessageUtil messageUtil;
	
	@RequestMapping(value = "/trang-chu/nhap-hang/danh-sach", method = RequestMethod.GET)
	public ModelAndView importProductList(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("web/nhaphang/importProductList");
		NhapHangDTO nhapHangDTO = new NhapHangDTO();
		nhapHangDTO.setListResult(nhapHangService.findAll());
		if (request.getParameter("message") != null) {
			Map<String, String> messageMap = messageUtil.getMessageMap(request.getParameter("message"));
			mav.addObject("message", messageMap.get("message"));
			mav.addObject("alert", messageMap.get("alert"));
		}
		mav.addObject("NhapHang", nhapHangDTO);
		return mav;
	}
	
	
	@RequestMapping(value = "/trang-chu/nhap-hang/them", method = RequestMethod.GET)
	public ModelAndView add(@RequestParam(value = "soLuong",  required = false) Long soLuong) {
		ModelAndView mav = new ModelAndView("web/nhaphang/addOrderTest");
		NhapHangDTO nhapHangDTO = new NhapHangDTO();
		if(soLuong == null) {
			nhapHangDTO.setSoLuongSanPham(1);
			soLuong = (long) 1;
		}else {
			nhapHangDTO.setSoLuongSanPham(soLuong.intValue());
		}
		java.util.List<SanPhamDTO> sanPhamDTOs = new ArrayList<SanPhamDTO>();
		for(int i = 0; i < soLuong; i++) {
			SanPhamDTO sanPhamDTO = new SanPhamDTO();
			sanPhamDTOs.add(sanPhamDTO);
		}
		nhapHangDTO.setThongTinNhapHangDtos(sanPhamDTOs);
		mav.addObject("model" ,nhapHangDTO);
		
		NhanVienDTO nhanVienDTO = new NhanVienDTO();
		nhanVienDTO.setListResult(nhanVienService.findNhanVienQuanLiKho());
		mav.addObject("nv",nhanVienDTO);
		
		SanPhamDTO sanPhamDTO = new SanPhamDTO();
		sanPhamDTO.setListResult(sanPhamService.findAll());
		mav.addObject("sp", sanPhamDTO);
		return mav;
	}
	
	/*
	 * @RequestMapping(value =
	 * "/trang-chu/nhap-hang/them-san-pham-cho-don-nhap-hang", method =
	 * RequestMethod.GET) public ModelAndView addProduct(@RequestParam("maNhanVien")
	 * Long maNhanVien, @RequestParam("soLuong") int soLuong) { ModelAndView mav =
	 * new ModelAndView("web/nhaphang/addProduct"); NhapHangDTO nhapHangDTO = new
	 * NhapHangDTO(); nhapHangDTO.setIdNhanVienNhapHang(maNhanVien);
	 * nhapHangDTO.setSoLuongSanPham(soLuong); java.util.List<SanPhamDTO>
	 * sanPhamDTOs = new ArrayList<SanPhamDTO>(); for(int i = 0; i < soLuong; i++) {
	 * SanPhamDTO sanPhamDTO = new SanPhamDTO(); sanPhamDTOs.add(sanPhamDTO); }
	 * nhapHangDTO.setThongTinNhapHangDtos(sanPhamDTOs); mav.addObject("model"
	 * ,nhapHangDTO);
	 * 
	 * SanPhamDTO sanPhamDTO = new SanPhamDTO();
	 * sanPhamDTO.setListResult(sanPhamService.findAll()); mav.addObject("sp",
	 * sanPhamDTO);
	 * 
	 * NhanVienDTO nhanVienDTO = new NhanVienDTO();
	 * nhanVienDTO.setListResult(nhanVienService.findNhanVienQuanLiKho());
	 * mav.addObject("nv",nhanVienDTO); return mav; }
	 */
}
