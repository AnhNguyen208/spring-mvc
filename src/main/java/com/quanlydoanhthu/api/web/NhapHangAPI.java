package com.quanlydoanhthu.api.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.quanlydoanhthu.dto.NhapHangDTO;
import com.quanlydoanhthu.service.dao.INhapHangService;

@RestController(value = "nhapHangAPIOfWeb")
public class NhapHangAPI {
	@Autowired
	INhapHangService nhapHangService;

	@PostMapping("/api/nhaphang")
	public NhapHangDTO createNhapHang(@RequestBody String string) {
		Gson gson = new Gson();
		NhapHangDTO nhapHangDTO = gson.fromJson(string, NhapHangDTO.class);
		return nhapHangService.save1(nhapHangDTO);
	}

	@PutMapping("/api/nhaphang")
	public NhapHangDTO updateNhapHang(@RequestBody NhapHangDTO nhapHangDTO) {
		return nhapHangDTO;
	}

	@DeleteMapping("/api/nhaphang")
	public void deleteNhapHang(@RequestBody long[] ids) {
	}
}
