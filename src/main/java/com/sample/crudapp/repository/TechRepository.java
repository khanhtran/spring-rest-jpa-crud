package com.sample.crudapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sample.crudapp.domain.Technology;

/**
 * 
 * @author Khanh
 *
 */
public interface TechRepository extends JpaRepository<Technology, Long> {

}
