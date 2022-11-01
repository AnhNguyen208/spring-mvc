package com.quanlydoanhthu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quanlydoanhthu.entity.SanPhamEntity;

public interface SanPhamRepository extends JpaRepository<SanPhamEntity, Long>{
    List<SanPhamEntity> findAllByTrangThai(int trangThai);
}
