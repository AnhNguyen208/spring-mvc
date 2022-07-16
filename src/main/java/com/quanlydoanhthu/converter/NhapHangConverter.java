package com.quanlydoanhthu.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.quanlydoanhthu.dto.NhapHangDTO;
import com.quanlydoanhthu.dto.SanPhamDTO;
import com.quanlydoanhthu.entity.CompositeKey2;
import com.quanlydoanhthu.entity.NhapHangEntity;
import com.quanlydoanhthu.entity.NhapHangSanPhamEntity;
import com.quanlydoanhthu.entity.SanPhamEntity;
import com.quanlydoanhthu.repository.NhanVienRepository;
import com.quanlydoanhthu.repository.SanPhamRepository;

@Component
public class NhapHangConverter {
	@Autowired
	SanPhamConverter sanPhamConverter;
	@Autowired
	SanPhamRepository sanPhamRepository;
	@Autowired
	NhanVienRepository nhanVienRepository;

	public NhapHangDTO toDTO(NhapHangEntity nhapHangEntity) {
		NhapHangDTO nhapHangDTO = new NhapHangDTO();
		nhapHangDTO.setId(nhapHangEntity.getId());
		nhapHangDTO.setIdNhanVienNhapHang(nhapHangEntity.getNhanVienEntity().getId());
		nhapHangDTO.setTenNhanVienString(nhapHangEntity.getNhanVienEntity().getHoVaTenString());
		nhapHangDTO.setCreateByString(nhapHangEntity.getCreatedByString());
		nhapHangDTO.setCreatedDateTimestamp(nhapHangEntity.getCreatedDate());
		List<SanPhamDTO> sanPhamDTOs = new ArrayList<SanPhamDTO>();
		SanPhamDTO sanPhamDTO = new SanPhamDTO();
		for (NhapHangSanPhamEntity nhapHangSanPhamEntity : nhapHangEntity.getNhapHangSanPhamEntities()) {
			SanPhamEntity sanPhamEntity = nhapHangSanPhamEntity.getSanPhamEntity();
			sanPhamDTO = sanPhamConverter.toDTO(sanPhamEntity);
			sanPhamDTO.setSoLuongNhap(nhapHangSanPhamEntity.getSoLuongInteger());
			sanPhamDTOs.add(sanPhamDTO);
		}
		nhapHangDTO.setSoLuongSanPham(nhapHangEntity.getNhapHangSanPhamEntities().size());
		nhapHangDTO.setThongTinNhapHangDtos(sanPhamDTOs);
		nhapHangDTO.setTongTienDonHang(sanPhamDTOs);
		return nhapHangDTO;
	}

	public NhapHangEntity toEntity(NhapHangDTO nhapHangDTO) {
		NhapHangEntity nhapHangEntity = new NhapHangEntity();
		nhapHangEntity.setNhanVienEntity(nhanVienRepository.findById(nhapHangDTO.getIdNhanVienNhapHang()));
		List<NhapHangSanPhamEntity> nhapHangSanPhamEntities = new ArrayList<NhapHangSanPhamEntity>();
		nhapHangEntity.setNhapHangSanPhamEntities(nhapHangSanPhamEntities);
		return nhapHangEntity;
	}

	public NhapHangEntity toEntity(NhapHangDTO nhapHangDTO, NhapHangEntity nhapHangEntity) {
		nhapHangEntity.setId(nhapHangDTO.getId());
		nhapHangEntity.setNhanVienEntity(nhanVienRepository.findById(nhapHangDTO.getIdNhanVienNhapHang()));
		List<NhapHangSanPhamEntity> nhapHangSanPhamEntities = new ArrayList<NhapHangSanPhamEntity>();
		NhapHangSanPhamEntity nhapHangSanPhamEntity = new NhapHangSanPhamEntity();
		CompositeKey2 key = new CompositeKey2();
		key.setIdNhapHangLong(nhapHangDTO.getId());
		key.setIdSanPhamLong(nhapHangDTO.getIdSanPhamLong());
		nhapHangSanPhamEntity.setIdKey(key);
		nhapHangSanPhamEntity.setSoLuongInteger(nhapHangDTO.getSoLuongNhap());
		SanPhamEntity sanPhamEntity = sanPhamRepository.findOne(nhapHangDTO.getIdSanPhamLong());
		if(sanPhamEntity.getSoLuongInteger() == null) {
			sanPhamEntity.setSoLuongInteger(0);
		}
		sanPhamEntity.setSoLuongInteger(sanPhamEntity.getSoLuongInteger() + nhapHangDTO.getSoLuongNhap());
		nhapHangSanPhamEntity.setSanPhamEntity(sanPhamRepository.save(sanPhamEntity));
		nhapHangSanPhamEntity.setGiaLong(sanPhamEntity.getGiaNhapLong());
		nhapHangSanPhamEntities.add(nhapHangSanPhamEntity);
		nhapHangEntity.setNhapHangSanPhamEntities(nhapHangSanPhamEntities);
		return nhapHangEntity;
	}

}
