package com.quanlydoanhthu.api.web;

import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;

import org.apache.tomcat.util.buf.Utf8Decoder;
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
import com.quanlydoanhthu.dto.DonHangDTO2;
import com.quanlydoanhthu.service.dao.IDonHangService;

@RestController(value = "donHangAPIOfWeb")
public class DonHangAPI {
	@Autowired
	IDonHangService donHangService;

	@PostMapping("/api/donhang")
	public DonHangDTO createDonHang(@RequestBody String string) {
		Gson gson = new Gson();
		DonHangDTO donHangDTO = new DonHangDTO();
		DonHangDTO2 donHangDTO2 = gson.fromJson(string, DonHangDTO2.class);
		donHangDTO.setIdNhanVienBanHang(donHangDTO2.getIdNhanVienBanHang());
		donHangDTO.setIdSanPhamList(donHangDTO2.getIdSanPhamList());
		donHangDTO.setSoLuongBanList(donHangDTO2.getSoLuongBanList());
		donHangDTO.setSoLuongSanPham(donHangDTO2.getSoLuongSanPham());
		donHangDTO.setThongTinKhachHangString(donHangDTO2.getThongTinKhachHangString());
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
		Utf8Decoder decoder = new Utf8Decoder();
		try {
			string = decoder.decode(ByteBuffer.wrap(string.getBytes())).toString();
		} catch (CharacterCodingException e) {
			e.printStackTrace();
		}
		String string2 = new String(string.getBytes(), Charset.forName("UTF-8"));
		System.out.println(string);
		System.out.println(string2);
		
	}

}
