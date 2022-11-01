package com.quanlydoanhthu.api.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.quanlydoanhthu.dto.SanPhamDTO;
import com.quanlydoanhthu.service.dao.ISanPhamService;

@RestController(value = "sanPhamAPIOfWeb")
public class SanPhamAPI {
	@Autowired
	private ISanPhamService sanPhamService;

	@PostMapping(value = "/api/sanpham", consumes="application/json")
	public SanPhamDTO createSanPham(@RequestBody String string) {
		Gson gson = new Gson();
		SanPhamDTO sanPhamDTO = gson.fromJson(string, SanPhamDTO.class);
		return sanPhamService.save(sanPhamDTO);
	}

	@PutMapping("/api/sanpham")
	public SanPhamDTO updateSanPham(@RequestBody String string) {
		Gson gson = new Gson();
		SanPhamDTO sanPhamDTO = gson.fromJson(string, SanPhamDTO.class);
		return sanPhamService.update(sanPhamDTO);
	}

	@DeleteMapping("/api/sanpham")
	public SanPhamDTO deleteSanPham(@RequestBody String id) {
		Long idLong  = Long.parseLong(id);
		return sanPhamService.delete(idLong);
	}
}
