package com.quanlydoanhthu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quanlydoanhthu.entity.NhanVienEntity;

public interface NhanVienRepository extends JpaRepository<NhanVienEntity, Long>{
	NhanVienEntity findById(Long idLong);
}
