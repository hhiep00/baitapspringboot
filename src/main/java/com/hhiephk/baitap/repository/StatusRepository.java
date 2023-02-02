package com.hhiephk.baitap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hhiephk.baitap.model.entity.Status;

@Repository
public interface StatusRepository extends JpaRepository<Status, Integer>{

}
