package com.quanlydoanhthu.service.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Pageable;

import com.quanlydoanhthu.dto.NhanVienDTO;

public interface INhanVienService {
	List<NhanVienDTO> findAll(Pageable pageable);

	List<NhanVienDTO> findAll();
	
	List<NhanVienDTO> findNhanVienBanHang();
	
	List<NhanVienDTO> findNhanVienBanHang(Date date1, Date date2);
	
	List<NhanVienDTO> findNhanVienQuanLiKho();
	
	NhanVienDTO findDoangThu(Long idLong);

	int getTotalItem();

	NhanVienDTO findById(long id);

	NhanVienDTO save(NhanVienDTO nhanVienDTO);

	void delete(long[] ids);
}
