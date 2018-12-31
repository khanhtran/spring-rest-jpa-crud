package com.sample.crudapp.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sample.crudapp.domain.User;

/**
 * 
 * @author Khanh
 *
 */
public interface UserRepository extends JpaRepository<User, Long> {

	@Query(value = "SELECT DISTINCT u.* FROM User u INNER JOIN User_Tech ut WHERE u.id = ut.user_id AND ut.tech_id=?1", nativeQuery = true)
	List<User> findByTechId(long techId);

	@Query(value = "SELECT * FROM User ORDER BY id", countQuery = "SELECT count(*) FROM Users", nativeQuery = true)
	Page<User> findAllUsersWithPagination(Pageable pageable);
}
