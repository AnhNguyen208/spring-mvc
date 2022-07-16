package com.quanlydoanhthu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quanlydoanhthu.entity.LoaiSPEntity;

public interface LoaiSPRepository extends JpaRepository<LoaiSPEntity, Long>{
	LoaiSPEntity findOneByTenLoaiSPString(String tenLoaiSPString);
}
