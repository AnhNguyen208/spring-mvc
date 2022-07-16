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

import com.quanlydoanhthu.dto.DonHangDTO;
import com.quanlydoanhthu.dto.NhanVienDTO;
import com.quanlydoanhthu.dto.SanPhamDTO;
import com.quanlydoanhthu.service.dao.IDonHangService;
import com.quanlydoanhthu.service.dao.INhanVienService;
import com.quanlydoanhthu.service.dao.ISanPhamService;
import com.quanlydoanhthu.util.MessageUtil;

@Controller (value = "donHangControllerOfUser")
public class DonHangController {
	@Autowired
	IDonHangService donHangService;
	@Autowired
	ISanPhamService sanPhamService;
	@Autowired
	INhanVienService nhanVienService;
	@Autowired
	private MessageUtil messageUtil;
	
	@RequestMapping(value = "/trang-chu/don-hang/danh-sach", method = RequestMethod.GET)
	public ModelAndView orderList(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("web/donhang/orderList");
		DonHangDTO donHangDTO = new DonHangDTO();
		donHangDTO.setListResult(donHangService.findAll());
		if (request.getParameter("message") != null) {
			Map<String, String> messageMap = messageUtil.getMessageMap(request.getParameter("message"));
			mav.addObject("message", messageMap.get("message"));
			mav.addObject("alert", messageMap.get("alert"));
		}
		mav.addObject("DonHang", donHangDTO);
		return mav;
	}
	
	@RequestMapping(value = "/trang-chu/don-hang/them", method = RequestMethod.GET)
	public ModelAndView addOrder() {
		ModelAndView mav = new ModelAndView("web/donhang/addOrder");
		DonHangDTO donHangDTO = new DonHangDTO();
		mav.addObject("model" ,donHangDTO);
		
		NhanVienDTO nhanVienDTO = new NhanVienDTO();
		nhanVienDTO.setListResult(nhanVienService.findNhanVienBanHang());
		mav.addObject("nv",nhanVienDTO);
		return mav;
	}
	
	@RequestMapping(value = "/trang-chu/don-hang/them-san-pham-cho-don-hang", method = RequestMethod.GET)
	public ModelAndView addProductOfOrder(@RequestParam("maNhanVien") Long maNhanVien, 
			@RequestParam("thongTinKH") String thongTinKH, @RequestParam("soLuong") int soLuong) {
		ModelAndView mav = new ModelAndView("web/donhang/addProductOfOrder");
		DonHangDTO donHangDTO = new DonHangDTO();
		donHangDTO.setThongTinKhachHangString(thongTinKH);
		donHangDTO.setIdNhanVienBanHang(maNhanVien);
		donHangDTO.setSoLuongSanPham(soLuong);
		java.util.List<SanPhamDTO> sanPhamDTOs = new ArrayList<SanPhamDTO>();
		for(int i = 0; i < soLuong; i++) {
			SanPhamDTO sanPhamDTO = new SanPhamDTO();
			sanPhamDTOs.add(sanPhamDTO);
		}
		donHangDTO.setThongTinDonHangDtos(sanPhamDTOs);
		mav.addObject("model" ,donHangDTO);
		
		SanPhamDTO sanPhamDTO = new SanPhamDTO();
		sanPhamDTO.setListResult(sanPhamService.findAll());
		mav.addObject("sp", sanPhamDTO);
		
		NhanVienDTO nhanVienDTO = new NhanVienDTO();
		nhanVienDTO.setListResult(nhanVienService.findNhanVienBanHang());
		mav.addObject("nv",nhanVienDTO);
		return mav;
	}
}
