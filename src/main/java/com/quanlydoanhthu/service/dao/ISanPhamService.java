package com.quanlydoanhthu.service.dao;

import java.util.List;

import com.quanlydoanhthu.dto.SanPhamDTO;

public interface ISanPhamService {
	List<SanPhamDTO> findAll();
	List<SanPhamDTO> findAll1();
	SanPhamDTO findById(Long idLong);
	int getTotalItem();
	SanPhamDTO save(SanPhamDTO sanPhamDTO);
	SanPhamDTO update(SanPhamDTO sanPhamDTO);
	SanPhamDTO delete(Long idLong);
}
