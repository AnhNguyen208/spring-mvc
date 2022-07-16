package com.quanlydoanhthu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quanlydoanhthu.entity.HangEntity;

public interface HangRepository extends JpaRepository<HangEntity, Long>{
	HangEntity findOneByTenHangString(String tenHangString);
}
