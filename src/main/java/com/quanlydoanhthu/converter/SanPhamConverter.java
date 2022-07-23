package com.quanlydoanhthu.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.quanlydoanhthu.dto.SanPhamDTO;
import com.quanlydoanhthu.entity.SanPhamEntity;
import com.quanlydoanhthu.repository.HangRepository;
import com.quanlydoanhthu.repository.LoaiSPRepository;

@Component
public class SanPhamConverter {
	@Autowired
	LoaiSPRepository loaiSPRepository;
	@Autowired
	HangRepository hangRepository;
	
	public SanPhamDTO toDTO(SanPhamEntity sanPhamEntity) {
		SanPhamDTO sanPhamDTO = new SanPhamDTO();
		sanPhamDTO.setId(sanPhamEntity.getId());
		sanPhamDTO.setTenSanPhamString(sanPhamEntity.getTenSanPhamString());
		sanPhamDTO.setAnhDaiDienString(sanPhamEntity.getAnhDaiDienString());
		sanPhamDTO.setLoaiSanPhamString(sanPhamEntity.getLoaiSPEntity().getTenLoaiSPString());
		sanPhamDTO.setGiaBanLong(sanPhamEntity.getGiaBanLong());
		sanPhamDTO.setGiaNhapLong(sanPhamEntity.getGiaNhapLong());
		sanPhamDTO.setHangString(sanPhamEntity.getHangEntity().getTenHangString());
		sanPhamDTO.setMauSacString(sanPhamEntity.getMauSacString());
		sanPhamDTO.setKichCoString(sanPhamEntity.getKichCoString());
		sanPhamDTO.setLogoHangString(sanPhamEntity.getHangEntity().getAnhDaiDienString());
		if(sanPhamEntity.getSoLuongInteger() == null) {
			sanPhamDTO.setSoLuong(0);
		}
		else {
			sanPhamDTO.setSoLuong(sanPhamEntity.getSoLuongInteger());			
		}
		return sanPhamDTO;
	}
	
	public SanPhamEntity toEntity(SanPhamDTO sanPhamDTO) {
		SanPhamEntity sanPhamEntity = new SanPhamEntity();
		sanPhamEntity.setTenSanPhamString(sanPhamDTO.getTenSanPhamString());
		sanPhamEntity.setAnhDaiDienString(sanPhamDTO.getAnhDaiDienString());
		sanPhamEntity.setGiaBanLong(sanPhamDTO.getGiaBanLong());
		sanPhamEntity.setGiaNhapLong(sanPhamDTO.getGiaNhapLong());
		sanPhamEntity.setLoaiSPEntity(loaiSPRepository.findOneByTenLoaiSPString(sanPhamDTO.getLoaiSanPhamString()));
		sanPhamEntity.setHangEntity(hangRepository.findOneByTenHangString(sanPhamDTO.getHangString()));
		sanPhamEntity.setMauSacString(sanPhamDTO.getMauSacString());
		sanPhamEntity.setKichCoString(sanPhamDTO.getKichCoString());
		return sanPhamEntity;
	}
	
	public SanPhamEntity toEntity(SanPhamDTO sanPhamDTO, SanPhamEntity sanPhamEntity) {
		sanPhamEntity.setTenSanPhamString(sanPhamDTO.getTenSanPhamString());
		sanPhamEntity.setAnhDaiDienString(sanPhamDTO.getAnhDaiDienString());
		sanPhamEntity.setGiaBanLong(sanPhamDTO.getGiaBanLong());
		sanPhamEntity.setGiaNhapLong(sanPhamDTO.getGiaNhapLong());
		sanPhamEntity.setLoaiSPEntity(loaiSPRepository.findOneByTenLoaiSPString(sanPhamDTO.getLoaiSanPhamString()));
		sanPhamEntity.setHangEntity(hangRepository.findOneByTenHangString(sanPhamDTO.getHangString()));
		sanPhamEntity.setMauSacString(sanPhamDTO.getMauSacString());
		sanPhamEntity.setKichCoString(sanPhamDTO.getKichCoString());
		return sanPhamEntity;
	}
	
}
