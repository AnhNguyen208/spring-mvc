package com.quanlydoanhthu.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quanlydoanhthu.entity.DonHangEntity;
import com.quanlydoanhthu.entity.NhanVienEntity;

public interface DonHangRepository extends JpaRepository<DonHangEntity, Long>{
	List<DonHangEntity> findByNhanVienEntity(NhanVienEntity nhanVienEntity);
	List<DonHangEntity> findByNhanVienEntityAndCreatedDateBetween(NhanVienEntity nhanVienEntity, Date date1, Date date2);
	List<DonHangEntity> findByCreatedDateBetween(Date date1, Date date2);
}
