package com.quanlydoanhthu.controller.admin;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.quanlydoanhthu.dto.DonHangDTO;
import com.quanlydoanhthu.dto.NhanVienDTO;
import com.quanlydoanhthu.service.dao.IDonHangService;
import com.quanlydoanhthu.service.dao.INhanVienService;
import com.quanlydoanhthu.service.dao.ISanPhamService;

@Controller(value = "thongKeControllerOfAdmin")
public class ThongKeController {
	@Autowired
	private INhanVienService nhanVienService;
	@Autowired
	private ISanPhamService sanPhamService;
	@Autowired
	private IDonHangService donHangService;
	
	@RequestMapping(value = "/quan-tri/trang-chu/thong-ke", method = RequestMethod.GET)
	public ModelAndView thongKePage(@RequestParam(value = "date1", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date1, 
			@RequestParam(value="date2", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date2) {
		ModelAndView mav = new ModelAndView("admin/thongke/statistical");
		
		NhanVienDTO nhanVienDTO = new NhanVienDTO();
		DonHangDTO donHangDTO = new DonHangDTO();
		
		if((date1 != null) && (date2 != null)) {
			nhanVienDTO.setListResult(nhanVienService.findNhanVienBanHang(date1, date2));
			//nhanVienDTO.setTotalItem(nhanVienService.getTotalItem());
			
			donHangDTO.setListResult(donHangService.findByCreatedDateBetween(date1, date2));
			//donHangDTO.setTotalItem(donHangService.getTotalItem());
		}
		else {
			nhanVienDTO.setListResult(nhanVienService.findNhanVienBanHang());
			//nhanVienDTO.setTotalItem(nhanVienService.getTotalItem());

			donHangDTO.setListResult(donHangService.findAll());
			//donHangDTO.setTotalItem(donHangService.getTotalItem());
		}
		
		
		mav.addObject("model", nhanVienDTO);
		mav.addObject("model2", donHangDTO);
		return mav;
		
	}
	
	
}
