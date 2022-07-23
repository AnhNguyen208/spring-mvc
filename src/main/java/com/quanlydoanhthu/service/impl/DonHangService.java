package com.quanlydoanhthu.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quanlydoanhthu.converter.DonHangConverter;
import com.quanlydoanhthu.dto.DonHangDTO;
import com.quanlydoanhthu.entity.DonHangEntity;
import com.quanlydoanhthu.entity.DonHangSanPhamEntity;
import com.quanlydoanhthu.repository.DonHangRepository;
import com.quanlydoanhthu.repository.DonHangSanPhamRepository;
import com.quanlydoanhthu.repository.NhanVienRepository;
import com.quanlydoanhthu.service.dao.IDonHangService;

@Service
public class DonHangService implements IDonHangService {
	@Autowired
	DonHangRepository donHangRepository;
	@Autowired
	DonHangConverter donHangConverter;
	@Autowired
	DonHangSanPhamRepository donHangSanPhamRepository;
	@Autowired
	NhanVienRepository nhanVienRepository;

	@Override
	public List<DonHangDTO> findAll() {
		List<DonHangDTO> donHangDTOs = new ArrayList<DonHangDTO>();
		List<DonHangEntity> donHangEntities = donHangRepository.findAll();
		DonHangDTO donHangDTO = new DonHangDTO();

		for (DonHangEntity donHangEntity : donHangEntities) {
			donHangDTO = donHangConverter.toDTO(donHangEntity);
			donHangDTOs.add(donHangDTO);
		}
		return donHangDTOs;
	}

	@Override
	public DonHangDTO findById(Long idLong) {
		DonHangEntity donHangEntity = donHangRepository.findOne(idLong);
		return donHangConverter.toDTO(donHangEntity);
	}

	@Override
	public DonHangDTO save(DonHangDTO donHangDTO) {

		return donHangDTO;
	}

	@Override
	@Transactional
	public DonHangDTO save1(DonHangDTO donHangDTO) {
		DonHangEntity donHangEntity = new DonHangEntity();
		donHangEntity = donHangConverter.toEntity(donHangDTO);
		donHangEntity = donHangRepository.save(donHangEntity);
		String string = donHangEntity.getCreatedByString();
		Date date = donHangEntity.getCreatedDate();
		DonHangDTO donHangDTO2 = new DonHangDTO();
		donHangDTO2 = donHangDTO;
		donHangDTO2.setId(donHangEntity.getId());
		for (int i = 0; i < donHangDTO.getSoLuongSanPham(); i++) {
			DonHangEntity donHangEntity1 = new DonHangEntity();
			donHangDTO2.setSoLuongBan(donHangDTO.getSoLuongBanList().get(i));
			donHangDTO2.setIdSanPhamLong(donHangDTO.getIdSanPhamList().get(i));
			donHangEntity = donHangConverter.toEntity(donHangDTO2, donHangEntity1);
			donHangEntity.setCreatedByString(string);
			donHangEntity.setCreatedDate(date);
			for (DonHangSanPhamEntity donHangSanPhamEntity : donHangEntity.getDonHangSanPhamEntities()) {
				donHangSanPhamEntity.setDonHangEntity(donHangEntity);
				donHangSanPhamRepository.save(donHangSanPhamEntity);
			}
		}
		return donHangConverter.toDTO(donHangRepository.findOne(donHangEntity.getId()));
	}

	@Override
	public int getTotalItem() {
		return (int) donHangRepository.count();
	}

	@Override
	public List<DonHangDTO> findByCreatedDateBetween(Date date1, Date date2) {
		List<DonHangDTO> donHangDTOs = new ArrayList<DonHangDTO>();
		List<DonHangEntity> donHangEntities = donHangRepository.findByCreatedDateBetween(date1, date2);
		DonHangDTO donHangDTO = new DonHangDTO();
		for (DonHangEntity donHangEntity : donHangEntities) {
			donHangDTO = donHangConverter.toDTO(donHangEntity);
			donHangDTOs.add(donHangDTO);
		}
		return donHangDTOs;
	}

	@Override
	public List<DonHangDTO> findByNhanVien(Long idLong) {
		List<DonHangDTO> donHangDTOs = new ArrayList<DonHangDTO>();
		List<DonHangEntity> donHangEntities = donHangRepository.findByNhanVienEntity(nhanVienRepository.findById(idLong));
		DonHangDTO donHangDTO = new DonHangDTO();

		for (DonHangEntity donHangEntity : donHangEntities) {
			donHangDTO = donHangConverter.toDTO(donHangEntity);
			donHangDTOs.add(donHangDTO);
		}
		return donHangDTOs;
	}

}
