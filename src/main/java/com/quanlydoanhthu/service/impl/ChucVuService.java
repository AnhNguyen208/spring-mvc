package com.quanlydoanhthu.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quanlydoanhthu.entity.ChucVuEntity;
import com.quanlydoanhthu.repository.ChucVuRepository;
import com.quanlydoanhthu.service.dao.IChucVuService;

@Service
public class ChucVuService implements IChucVuService{
	@Autowired
	private ChucVuRepository chucVuRepository;
	
	@Override
	public Map<String, String> findAll() {
		Map<String, String> dtoMap = new HashMap<String, String>();
		List<ChucVuEntity> entities = chucVuRepository.findAll();
		for(ChucVuEntity itemChucVuEntity: entities) {
			dtoMap.put(itemChucVuEntity.getMaChucVuString(), itemChucVuEntity.getTenChucVuString());
		}
		return dtoMap;
	}
}
