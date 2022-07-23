package com.quanlydoanhthu.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quanlydoanhthu.converter.DonHangConverter;
import com.quanlydoanhthu.converter.NhanVienConverter;
import com.quanlydoanhthu.dto.DonHangDTO;
import com.quanlydoanhthu.dto.NhanVienDTO;
import com.quanlydoanhthu.entity.ChucVuEntity;
import com.quanlydoanhthu.entity.DonHangEntity;
import com.quanlydoanhthu.entity.NhanVienEntity;
import com.quanlydoanhthu.repository.ChucVuRepository;
import com.quanlydoanhthu.repository.DonHangRepository;
import com.quanlydoanhthu.repository.NhanVienRepository;
import com.quanlydoanhthu.service.dao.INhanVienService;

@Service
public class NhanVienService implements INhanVienService {
	@Autowired
	private NhanVienRepository nhanVienRepository;

	@Autowired
	private NhanVienConverter nhanVienConverter;

	@Autowired
	private ChucVuRepository chucVuRepository;

	@Autowired
	private DonHangRepository donHangRepository;

	@Autowired
	DonHangConverter donHangConverter;

	@Override
	public List<NhanVienDTO> findAll(Pageable pageable) {
		List<NhanVienDTO> nhanVienDTOs = new ArrayList<NhanVienDTO>();
		List<NhanVienEntity> nhanVienEntities = nhanVienRepository.findAll(pageable).getContent();
		for (NhanVienEntity item : nhanVienEntities) {
			NhanVienDTO nhanVienDTO = nhanVienConverter.toDTO(item);
			nhanVienDTOs.add(nhanVienDTO);
		}
		return nhanVienDTOs;
	}

	@Override
	public int getTotalItem() {
		return (int) nhanVienRepository.count();
	}

	@Override
	public NhanVienDTO findById(long id) {
		NhanVienEntity nhanVienEntity = nhanVienRepository.findOne(id);
		return nhanVienConverter.toDTO(nhanVienEntity);
	}

	@Override
	@Transactional
	public NhanVienDTO save(NhanVienDTO nhanVienDTO) {
		ChucVuEntity chucVuEntity = chucVuRepository.findOneByMaChucVuString(nhanVienDTO.getMaChucVuString());
		NhanVienEntity nhanVienEntity = new NhanVienEntity();
		if (nhanVienDTO.getId() != null) {
			NhanVienEntity oldEntity = nhanVienRepository.findOne(nhanVienDTO.getId());
			oldEntity.setChucVuEntity(chucVuEntity);
			nhanVienEntity = nhanVienConverter.toEntity(oldEntity, nhanVienDTO);
		} else {
			nhanVienEntity = nhanVienConverter.toEntity(nhanVienDTO);
			nhanVienEntity.setChucVuEntity(chucVuEntity);
		}
		return nhanVienConverter.toDTO(nhanVienRepository.save(nhanVienEntity));
	}

	@Transactional
	public void delete(long[] ids) {
		for (long id : ids) {
			nhanVienRepository.delete(id);
		}
	}

	@Override
	public List<NhanVienDTO> findAll() {
		List<NhanVienDTO> nhanVienDTOs = new ArrayList<NhanVienDTO>();
		List<NhanVienEntity> nhanVienEntities = nhanVienRepository.findAll();
		NhanVienDTO nhanVienDTO = new NhanVienDTO();
		for (NhanVienEntity nhanVienEntity : nhanVienEntities) {
			nhanVienDTO = nhanVienConverter.toDTO(nhanVienEntity);
			nhanVienDTOs.add(nhanVienDTO);
		}
		return nhanVienDTOs;
	}

	@Override
	public List<NhanVienDTO> findNhanVienBanHang() {
		List<NhanVienDTO> nhanVienDTOs = new ArrayList<NhanVienDTO>();
		List<NhanVienEntity> nhanVienEntities = nhanVienRepository.findAll();
		NhanVienDTO nhanVienDTO = new NhanVienDTO();
		for (NhanVienEntity nhanVienEntity : nhanVienEntities) {
			nhanVienDTO = nhanVienConverter.toDTO(nhanVienEntity);
			if (nhanVienDTO.getMaChucVuString().equals("BH")) {
				Long doanhThuLong = (long) 0;
				List<DonHangEntity> donHangEntities = donHangRepository.findByNhanVienEntity(nhanVienEntity);
				for (DonHangEntity donHangEntity : donHangEntities) {
					DonHangDTO donHangDTO = donHangConverter.toDTO(donHangEntity);
					doanhThuLong = doanhThuLong + donHangDTO.getTongTienDonHang();
				}
				nhanVienDTO.setDoanhThuLong(doanhThuLong);
				nhanVienDTO.setSoLuongDonHang(donHangEntities.size());
				nhanVienDTOs.add(nhanVienDTO);
			}
		}
		return nhanVienDTOs;
	}

	@Override
	public List<NhanVienDTO> findNhanVienQuanLiKho() {
		List<NhanVienDTO> nhanVienDTOs = new ArrayList<NhanVienDTO>();
		List<NhanVienEntity> nhanVienEntities = nhanVienRepository.findAll();
		NhanVienDTO nhanVienDTO = new NhanVienDTO();
		for (NhanVienEntity nhanVienEntity : nhanVienEntities) {
			nhanVienDTO = nhanVienConverter.toDTO(nhanVienEntity);
			if (nhanVienDTO.getMaChucVuString().equals("QLK")) {
				nhanVienDTOs.add(nhanVienDTO);
			}
		}
		return nhanVienDTOs;
	}

	@Override
	public List<NhanVienDTO> findNhanVienBanHang(Date date1, Date date2) {
		List<NhanVienDTO> nhanVienDTOs = new ArrayList<NhanVienDTO>();
		List<NhanVienEntity> nhanVienEntities = nhanVienRepository.findAll();
		NhanVienDTO nhanVienDTO = new NhanVienDTO();
		for (NhanVienEntity nhanVienEntity : nhanVienEntities) {
			nhanVienDTO = nhanVienConverter.toDTO(nhanVienEntity);
			if (nhanVienDTO.getMaChucVuString().equals("BH")) {
				Long doanhThuLong = (long) 0;
				List<DonHangEntity> donHangEntities = donHangRepository
						.findByNhanVienEntityAndCreatedDateBetween(nhanVienEntity, date1, date2);
				for (DonHangEntity donHangEntity : donHangEntities) {
					DonHangDTO donHangDTO = donHangConverter.toDTO(donHangEntity);
					doanhThuLong = doanhThuLong + donHangDTO.getTongTienDonHang();
				}
				nhanVienDTO.setDoanhThuLong(doanhThuLong);
				nhanVienDTO.setSoLuongDonHang(donHangEntities.size());
				nhanVienDTOs.add(nhanVienDTO);
			}
		}
		return nhanVienDTOs;
	}

	@Override
	public NhanVienDTO findDoangThu(Long idLong) {
		NhanVienDTO nhanVienDTO = new NhanVienDTO();
		nhanVienDTO = nhanVienConverter.toDTO(nhanVienRepository.findById(idLong));
		if (nhanVienDTO.getMaChucVuString().equals("BH")) {
			Long doanhThuLong = (long) 0;
			List<DonHangEntity> donHangEntities = donHangRepository.findByNhanVienEntity(nhanVienRepository.findById(idLong));
			for (DonHangEntity donHangEntity : donHangEntities) {
				DonHangDTO donHangDTO = donHangConverter.toDTO(donHangEntity);
				doanhThuLong = doanhThuLong + donHangDTO.getTongTienDonHang();
			}
			nhanVienDTO.setDoanhThuLong(doanhThuLong);
			nhanVienDTO.setSoLuongDonHang(donHangEntities.size());
		}

		return nhanVienDTO;
	}

}
