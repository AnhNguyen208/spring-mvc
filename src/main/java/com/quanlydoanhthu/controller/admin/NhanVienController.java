package com.quanlydoanhthu.controller.admin;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.quanlydoanhthu.dto.NhanVienDTO;
import com.quanlydoanhthu.service.dao.IChucVuService;
import com.quanlydoanhthu.service.dao.INhanVienService;
import com.quanlydoanhthu.util.MessageUtil;

@Controller(value = "nhanVienControllerOfAdmin")
public class NhanVienController {
	@Autowired
	private INhanVienService nhanVienService;
	@Autowired
	private IChucVuService chucVuService;
	@Autowired
	private MessageUtil messageUtil;
	
	@RequestMapping(value = "/quan-tri/nhan-vien/danh-sach", method = RequestMethod.GET)
	public ModelAndView showList(@RequestParam("page") int page, 
			@RequestParam("limit") int limit, HttpServletRequest request) {
		NhanVienDTO model = new NhanVienDTO();
		model.setPage(page);
		model.setLimit(limit);
		ModelAndView mav = new ModelAndView("admin/nhanvien/list");
		Pageable pageable = new PageRequest(page - 1, limit);
		model.setListResult(nhanVienService.findAll(pageable));
		model.setTotalItem(nhanVienService.getTotalItem());
		model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getLimit()));
		if (request.getParameter("message") != null) {
			Map<String, String> messageMap = messageUtil.getMessageMap(request.getParameter("message"));
			mav.addObject("message", messageMap.get("message"));
			mav.addObject("alert", messageMap.get("alert"));
		}
		mav.addObject("model", model);
		return mav;
	}
	
	@RequestMapping(value = "/quan-tri/nhan-vien/chinh-sua", method = RequestMethod.GET)
	public ModelAndView edit(@RequestParam(value = "id", required = false) Long idLong, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("admin/nhanvien/edit");
		NhanVienDTO model = new NhanVienDTO();
		if(idLong != null) {
			model = nhanVienService.findById(idLong);
		}
		if (request.getParameter("message") != null) {
			Map<String, String> messageMap = messageUtil.getMessageMap(request.getParameter("message"));messageUtil.getMessageMap(request.getParameter("message"));
			mav.addObject("message", messageMap.get("message"));
			mav.addObject("alert", messageMap.get("alert"));
		}
		mav.addObject("chucvu", chucVuService.findAll());
		mav.addObject("model", model);
		return mav;
	}
}
