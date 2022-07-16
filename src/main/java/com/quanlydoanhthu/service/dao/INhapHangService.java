package com.quanlydoanhthu.service.dao;

import java.util.List;

import com.quanlydoanhthu.dto.NhapHangDTO;

public interface INhapHangService {
	List<NhapHangDTO> findAll();
	NhapHangDTO findById(Long idLong);
	NhapHangDTO save(NhapHangDTO nhapHangDTO);
	NhapHangDTO save1(NhapHangDTO nhapHangDTO);
}
