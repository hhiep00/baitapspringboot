package com.hhiephk.baitap.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hhiephk.baitap.model.entity.Status;
import com.hhiephk.baitap.repository.StatusRepository;
import com.hhiephk.baitap.service.StatusService;

@RestController
@RequestMapping("/api/status")
public class StatusController {
	
	
	@Autowired
	private StatusService statusService;
	
	@GetMapping("/allStatus")
	public List<Status> getAllStatus(){
		return statusService.findAll();
	}
}
