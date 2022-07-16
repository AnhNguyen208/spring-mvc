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

@Controller(value = "thongKeControllerOfAdmin")
public class ThongKeController {
	@Autowired
	INhanVienService nhanVienService;
	@Autowired
	ISanPhamService sanPhamService;
	@Autowired
	IDonHangService donHangService;
	
	@RequestMapping(value = "/quan-tri/trang-chu/thong-ke", method = RequestMethod.GET)
	public ModelAndView thongKePage() {
		ModelAndView mav = new ModelAndView("admin/thongke/statistical");
		
		NhanVienDTO nhanVienDTO = new NhanVienDTO();
		nhanVienDTO.setListResult(nhanVienService.findNhanVienBanHang());
		nhanVienDTO.setTotalItem(nhanVienService.getTotalItem());
		
		SanPhamDTO sanPhamDTO = new SanPhamDTO();
		sanPhamDTO.setListResult(sanPhamService.findAll1());
		sanPhamDTO.setTotalItem(sanPhamService.getTotalItem());
		
		DonHangDTO donHangDTO = new DonHangDTO();
		donHangDTO.setListResult(donHangService.findAll());
		donHangDTO.setTotalItem(donHangService.getTotalItem());
		
		
		
		mav.addObject("model", nhanVienDTO);
		mav.addObject("model1", sanPhamDTO);
		mav.addObject("model2", donHangDTO);
		return mav;
		
	}
	
	
}
