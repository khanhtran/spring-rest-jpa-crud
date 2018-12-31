package com.sample.crudapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sample.crudapp.domain.UserTech;

/**
 * 
 * @author Khanh
 *
 */
public interface UserTechRepository extends JpaRepository<UserTech, Long> {

}
