package com.quanlydoanhthu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quanlydoanhthu.entity.NguoiDungEntity;

public interface NguoiDungRepository extends JpaRepository<NguoiDungEntity, Long>{
	NguoiDungEntity findOneByTenDangNhapStringAndTrangThai(String tenDangNhapString, int trangThai);
}
