package com.quanlydoanhthu.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.quanlydoanhthu.dto.DonHangDTO;
import com.quanlydoanhthu.dto.NhanVienDTO;
import com.quanlydoanhthu.dto.SanPhamDTO;
import com.quanlydoanhthu.service.dao.IDonHangService;
import com.quanlydoanhthu.service.dao.INhanVienService;
import com.quanlydoanhthu.service.dao.ISanPhamService;

@Controller(value = "homeControllerOfAdmin")
public class HomeController {
	@Autowired
	private INhanVienService nhanVienService;
	@Autowired
	private ISanPhamService sanPhamService;
	@Autowired
	private IDonHangService donHangService;
	
	@RequestMapping(value = "/quan-tri/trang-chu", method = RequestMethod.GET)
	public ModelAndView homePage() {
		ModelAndView mav = new ModelAndView("admin/home");
		NhanVienDTO nhanVienDTO = new NhanVienDTO();
		SanPhamDTO sanPhamDTO = new SanPhamDTO();
		DonHangDTO donHangDTO = new DonHangDTO();
		Long tongDoanhThu = (long) 0;
		
		nhanVienDTO.setTotalItem(nhanVienService.getTotalItem());
		sanPhamDTO.setTotalItem(sanPhamService.getTotalItem());
		sanPhamDTO.setListResult(sanPhamService.findAll1());
		donHangDTO.setTotalItem(donHangService.getTotalItem());
		
		nhanVienDTO.setListResult(nhanVienService.findNhanVienBanHang());
		for(NhanVienDTO nhanVienDTO2:nhanVienDTO.getListResult()) {
			tongDoanhThu = tongDoanhThu + nhanVienDTO2.getDoanhThuLong();
		}
		
		mav.addObject("model", nhanVienDTO);
		mav.addObject("model1", sanPhamDTO);
		mav.addObject("model2", donHangDTO);
		mav.addObject("model3", tongDoanhThu);
		
		return mav;
	}
	
	
}
