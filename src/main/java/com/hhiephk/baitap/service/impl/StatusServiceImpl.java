package com.hhiephk.baitap.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hhiephk.baitap.model.entity.Status;
import com.hhiephk.baitap.repository.StatusRepository;
import com.hhiephk.baitap.service.StatusService;

@Service
public class StatusServiceImpl implements StatusService{

	@Autowired
	private StatusRepository statusRepository;


	@Override
	public List<Status> findAll() {
		return statusRepository.findAll();
	}
	
	
	
}
