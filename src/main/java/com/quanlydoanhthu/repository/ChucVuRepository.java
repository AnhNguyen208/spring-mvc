package com.quanlydoanhthu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quanlydoanhthu.entity.ChucVuEntity;

public interface ChucVuRepository extends JpaRepository<ChucVuEntity, Long>{
	ChucVuEntity findOneByMaChucVuString(String maChucVuString);
	
}
