package com.quanlydoanhthu.api.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.quanlydoanhthu.dto.DonHangDTO;
import com.quanlydoanhthu.service.dao.IDonHangService;

@RestController(value = "donHangAPIOfWeb")
public class DonHangAPI {
	@Autowired
	private IDonHangService donHangService;

	@PostMapping("/api/donhang")
	public DonHangDTO createDonHang(@RequestBody String string) {
		Gson gson = new Gson();
		DonHangDTO donHangDTO = gson.fromJson(string, DonHangDTO.class);
		return donHangService.save1(donHangDTO);
	}

	@PutMapping("/api/donhang")
	public DonHangDTO updateDonHang(@RequestBody DonHangDTO donHangDTO) {
		return donHangDTO;
	}

	@DeleteMapping("/api/donhang")
	public void deleteDonHang(@RequestBody long[] ids) {
	}

	@RequestMapping(value = "/j", method = RequestMethod.POST)
	public void posted(@RequestBody String string) {
		Gson gson = new Gson();
		DonHangDTO donHangDTO = gson.fromJson(string, DonHangDTO.class);
		System.out.println("OK" + donHangDTO);
	}

}
