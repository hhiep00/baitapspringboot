package com.hhiephk.baitap.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hhiephk.baitap.model.entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer>{
	Optional<Person> findByUsername(String username);
}
