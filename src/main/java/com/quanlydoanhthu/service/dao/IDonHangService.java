package com.quanlydoanhthu.service.dao;

import java.util.List;

import com.quanlydoanhthu.dto.DonHangDTO;

public interface IDonHangService {
	List<DonHangDTO> findAll();
	DonHangDTO findById(Long idLong);
	DonHangDTO save(DonHangDTO donHangDTO);
	DonHangDTO save1(DonHangDTO donHangDTO);
	int getTotalItem();
}
