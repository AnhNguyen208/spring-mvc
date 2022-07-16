package com.quanlydoanhthu.api.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.quanlydoanhthu.dto.NhanVienDTO;
import com.quanlydoanhthu.service.dao.INhanVienService;

@RestController(value = "nhanVienAPIOfAdmin")
public class NhanVienAPI {
	
	@Autowired
	private INhanVienService nhanVienService;
	
	@PostMapping("/api/nhanvien")
	public NhanVienDTO createNhanVien(@RequestBody String string) {
		Gson gson = new Gson();
		NhanVienDTO nhanVienDTO = gson.fromJson(string, NhanVienDTO.class);
		return nhanVienService.save(nhanVienDTO);
	}
	
	@PutMapping("/api/nhanvien")
	public NhanVienDTO updateNhanVien(@RequestBody String string) {
		Gson gson = new Gson();
		NhanVienDTO nhanVienDTO = gson.fromJson(string, NhanVienDTO.class);
		return nhanVienService.save(nhanVienDTO);
	}
	
	@DeleteMapping("/api/nhanvien")
	public void deleteNhanVien(@RequestBody long[] ids) {
		nhanVienService.delete(ids);
	}
}
