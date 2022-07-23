package com.quanlydoanhthu.service.dao;

import java.util.Date;
import java.util.List;

import com.quanlydoanhthu.dto.DonHangDTO;

public interface IDonHangService {
	List<DonHangDTO> findAll();
	List<DonHangDTO> findByNhanVien(Long idLong);
	List<DonHangDTO> findByCreatedDateBetween(Date date1, Date date2);
	DonHangDTO findById(Long idLong);
	DonHangDTO save(DonHangDTO donHangDTO);
	DonHangDTO save1(DonHangDTO donHangDTO);
	int getTotalItem();
}
