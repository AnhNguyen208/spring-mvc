package com.quanlydoanhthu.api.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.quanlydoanhthu.dto.NhapHangDTO;
import com.quanlydoanhthu.dto.NhapHangDTO2;
import com.quanlydoanhthu.service.dao.INhapHangService;

@RestController(value = "nhapHangAPIOfWeb")
public class NhapHangAPI {
	@Autowired
	INhapHangService nhapHangService;

	@PostMapping("/api/nhaphang")
	public NhapHangDTO createNhapHang(@RequestBody String string) {
		Gson gson = new Gson();
		NhapHangDTO nhapHangDTO = new NhapHangDTO();
		NhapHangDTO2 nhapHangDTO2 = gson.fromJson(string, NhapHangDTO2.class);
		nhapHangDTO.setIdNhanVienNhapHang(nhapHangDTO2.getIdNhanVienNhapHang());
		nhapHangDTO.setIdSanPhamList(nhapHangDTO2.getIdSanPhamList());
		nhapHangDTO.setSoLuongNhapList(nhapHangDTO2.getSoLuongNhapList());
		nhapHangDTO.setSoLuongSanPham(nhapHangDTO2.getSoLuongSanPham());
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
