package com.quanlydoanhthu.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.quanlydoanhthu.dto.DonHangDTO;
import com.quanlydoanhthu.dto.SanPhamDTO;
import com.quanlydoanhthu.entity.CompositeKey;
import com.quanlydoanhthu.entity.DonHangEntity;
import com.quanlydoanhthu.entity.DonHangSanPhamEntity;
import com.quanlydoanhthu.entity.SanPhamEntity;
import com.quanlydoanhthu.repository.NhanVienRepository;
import com.quanlydoanhthu.repository.SanPhamRepository;

@Component
public class DonHangConverter {
	@Autowired
	private SanPhamConverter sanPhamConverter;
	@Autowired
	private SanPhamRepository sanPhamRepository;
	@Autowired
	private NhanVienRepository nhanVienRepository;

	public DonHangDTO toDTO(DonHangEntity donHangEntity) {
		DonHangDTO donHangDTO = new DonHangDTO();
		donHangDTO.setId(donHangEntity.getId());
		donHangDTO.setIdNhanVienBanHang(donHangEntity.getNhanVienEntity().getId());
		donHangDTO.setTenNhanVienString(donHangEntity.getNhanVienEntity().getHoVaTenString());
		donHangDTO.setThongTinKhachHangString(donHangEntity.getThongTinKhachHangString());
		donHangDTO.setCreateByString(donHangEntity.getCreatedByString());
		donHangDTO.setCreatedDateTimestamp(donHangEntity.getCreatedDate());
		List<SanPhamDTO> sanPhamDTOs = new ArrayList<SanPhamDTO>();
		SanPhamDTO sanPhamDTO = new SanPhamDTO();
		for (DonHangSanPhamEntity donHangSanPhamEntity : donHangEntity.getDonHangSanPhamEntities()) {
			SanPhamEntity sanPhamEntity = donHangSanPhamEntity.getSanPhamEntity();
			sanPhamDTO = sanPhamConverter.toDTO(sanPhamEntity);
			sanPhamDTO.setSoLuongBan(donHangSanPhamEntity.getSoLuongInteger());
			sanPhamDTO.setGiaBanLong1(donHangSanPhamEntity.getGiaLong());
			sanPhamDTOs.add(sanPhamDTO);
		}
		donHangDTO.setSoLuongSanPham(donHangEntity.getDonHangSanPhamEntities().size());
		donHangDTO.setThongTinDonHangDtos(sanPhamDTOs);
		donHangDTO.setChietKhauLong(donHangEntity.getChietKhauLong());
		donHangDTO.setTongTienDonHang(sanPhamDTOs);
		return donHangDTO;
	}

	public DonHangEntity toEntity(DonHangDTO donHangDTO) {
		DonHangEntity donHangEntity = new DonHangEntity();
		donHangEntity.setThongTinKhachHangString(donHangDTO.getThongTinKhachHangString());
		donHangEntity.setNhanVienEntity(nhanVienRepository.findById(donHangDTO.getIdNhanVienBanHang()));
		List<DonHangSanPhamEntity> donHangSanPhamEntities = new ArrayList<DonHangSanPhamEntity>();
		donHangEntity.setDonHangSanPhamEntities(donHangSanPhamEntities);
		return donHangEntity;
	}

	public DonHangEntity toEntity(DonHangDTO donHangDTO, DonHangEntity donHangEntity) {
		donHangEntity.setId(donHangDTO.getId());
		donHangEntity.setCreatedByString(donHangDTO.getCreateByString());
		donHangEntity.setCreatedDate(donHangDTO.getCreatedDateTimestamp());
		donHangEntity.setNhanVienEntity(nhanVienRepository.findById(donHangDTO.getIdNhanVienBanHang()));
		donHangEntity.setThongTinKhachHangString(donHangDTO.getThongTinKhachHangString());
		donHangEntity.setChietKhauLong(donHangDTO.getChietKhauLong());
		List<DonHangSanPhamEntity> donHangSanPhamEntities = new ArrayList<DonHangSanPhamEntity>();
		DonHangSanPhamEntity donHangSanPhamEntity = new DonHangSanPhamEntity();
		CompositeKey key = new CompositeKey();
		key.setIdDonHangLong(donHangDTO.getId());
		key.setIdSanPhamLong(donHangDTO.getIdSanPhamLong());
		donHangSanPhamEntity.setIdKey(key);
		donHangSanPhamEntity.setSoLuongInteger(donHangDTO.getSoLuongBan());
		SanPhamEntity sanPhamEntity = sanPhamRepository.findOne(donHangDTO.getIdSanPhamLong());
		sanPhamEntity.setSoLuongInteger(sanPhamEntity.getSoLuongInteger() - donHangDTO.getSoLuongBan());
		donHangSanPhamEntity.setSanPhamEntity(sanPhamRepository.save(sanPhamEntity));
		donHangSanPhamEntity.setGiaLong(sanPhamEntity.getGiaBanLong());
		donHangSanPhamEntities.add(donHangSanPhamEntity);
		donHangEntity.setDonHangSanPhamEntities(donHangSanPhamEntities);
		return donHangEntity;
	}

}
