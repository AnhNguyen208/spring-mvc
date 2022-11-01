package com.quanlydoanhthu.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quanlydoanhthu.converter.SanPhamConverter;
import com.quanlydoanhthu.dto.SanPhamDTO;
import com.quanlydoanhthu.entity.DonHangSanPhamEntity;
import com.quanlydoanhthu.entity.NhapHangSanPhamEntity;
import com.quanlydoanhthu.entity.SanPhamEntity;
import com.quanlydoanhthu.repository.DonHangSanPhamRepository;
import com.quanlydoanhthu.repository.NhapHangSanPhamRepository;
import com.quanlydoanhthu.repository.SanPhamRepository;
import com.quanlydoanhthu.service.dao.ISanPhamService;

@Service
public class SanPhamService implements ISanPhamService {
	@Autowired
	private SanPhamRepository sanPhamRepository;

	@Autowired
	private SanPhamConverter sanPhamConverter;

	@Autowired
	private DonHangSanPhamRepository donHangSanPhamRepository;
	
	@Autowired 
	private NhapHangSanPhamRepository nhapHangSanPhamRepository;

	@Override
	public List<SanPhamDTO> findAll() {
		List<SanPhamDTO> sanPhamDTOs = new ArrayList<SanPhamDTO>();
		List<SanPhamEntity> sanPhamEntities = sanPhamRepository.findAllByTrangThai(1);
		SanPhamDTO sanPhamDTO = new SanPhamDTO();
		for (SanPhamEntity sanPhamEntity : sanPhamEntities) {
			sanPhamDTO = sanPhamConverter.toDTO(sanPhamEntity);
			sanPhamDTOs.add(sanPhamDTO);
		}
		return sanPhamDTOs;
	}

	@Override
	public int getTotalItem() {
		return (int) sanPhamRepository.count();
	}

	@Override
	public SanPhamDTO findById(Long idLong) {
		SanPhamEntity sanPhamEntity = sanPhamRepository.findOne(idLong);
		return sanPhamConverter.toDTO(sanPhamEntity);
	}

	@Override
	public SanPhamDTO save(SanPhamDTO sanPhamDTO) {
		SanPhamEntity sanPhamEntity = new SanPhamEntity();
		sanPhamEntity = sanPhamConverter.toEntity(sanPhamDTO);
		return sanPhamConverter.toDTO(sanPhamRepository.save(sanPhamEntity));
	}

	@Override
	public SanPhamDTO update(SanPhamDTO sanPhamDTO) {
		SanPhamEntity sanPhamEntity = sanPhamRepository.findOne(sanPhamDTO.getId());
		sanPhamEntity = sanPhamConverter.toEntity(sanPhamDTO, sanPhamEntity);
		return sanPhamConverter.toDTO(sanPhamRepository.save(sanPhamEntity));
	}

	@Override
	public SanPhamDTO delete(Long idLong) {
	    SanPhamEntity sanPhamEntity = sanPhamRepository.findOne(idLong);
        sanPhamEntity.setTrangThai(0);
        return sanPhamConverter.toDTO(sanPhamRepository.save(sanPhamEntity));

	}

	@Override
	public List<SanPhamDTO> findAll1() {
		List<SanPhamDTO> sanPhamDTOs = new ArrayList<SanPhamDTO>();
		List<SanPhamEntity> sanPhamEntities = sanPhamRepository.findAll();
		SanPhamDTO sanPhamDTO = new SanPhamDTO();
		List<DonHangSanPhamEntity> donHangSanPhamEntities = donHangSanPhamRepository.findAll();
		List<NhapHangSanPhamEntity> nhapHangSanPhamEntities = nhapHangSanPhamRepository.findAll();
		for (SanPhamEntity sanPhamEntity : sanPhamEntities) {
			sanPhamDTO = sanPhamConverter.toDTO(sanPhamEntity);
			for(DonHangSanPhamEntity donHangSanPhamEntity: donHangSanPhamEntities) {
				if(donHangSanPhamEntity.getSanPhamEntity().getId() == sanPhamDTO.getId()) {
					sanPhamDTO.setSoLuongBan(sanPhamDTO.getSoLuongBan() + donHangSanPhamEntity.getSoLuongInteger());
				}
			}
			for(NhapHangSanPhamEntity nhapHangSanPhamEntity: nhapHangSanPhamEntities) {
				if(nhapHangSanPhamEntity.getSanPhamEntity().getId() == sanPhamDTO.getId()) {
					sanPhamDTO.setSoLuongNhap(sanPhamDTO.getSoLuongNhap() + nhapHangSanPhamEntity.getSoLuongInteger());
				}
			}
			sanPhamDTOs.add(sanPhamDTO);
		}
		return sanPhamDTOs;
	}

}
