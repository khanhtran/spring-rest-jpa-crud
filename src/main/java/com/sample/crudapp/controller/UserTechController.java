package com.sample.crudapp.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sample.crudapp.domain.Technology;
import com.sample.crudapp.domain.User;
import com.sample.crudapp.domain.UserTech;
import com.sample.crudapp.error.TechNotFoundException;
import com.sample.crudapp.error.UserNotFoundException;
import com.sample.crudapp.error.UserTechNotFoundException;
import com.sample.crudapp.repository.TechRepository;
import com.sample.crudapp.repository.UserRepository;
import com.sample.crudapp.repository.UserTechRepository;

/**
 * 
 * @author Khanh
 *
 */
@RestController
@RequestMapping("/api/user-tech")
public class UserTechController {

	private final UserRepository userRepository;
	private final UserTechRepository userTechRepository;
	private final TechRepository techRepository;

	public UserTechController(UserRepository userRepository, TechRepository techRepository,
			UserTechRepository userTechRepository) {
		this.techRepository = techRepository;
		this.userRepository = userRepository;
		this.userTechRepository = userTechRepository;
	}

	@PostMapping
	public UserTech newUserTechnology(@RequestParam(name = "userId") long userId,
			@RequestParam(name = "technologyId") long technologyId) {
		User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException(userId));
		Technology technology = techRepository.findById(technologyId)
				.orElseThrow(() -> new TechNotFoundException(technologyId));

		UserTech userTech = new UserTech();
		userTech.setUser(user);
		userTech.setTech(technology);
		return userTechRepository.save(userTech);
	}

	@PutMapping("/{id}")
	public UserTech modifyUserTechnology(@PathVariable long id, @RequestParam(name = "userId") long userId,
			@RequestParam(name = "technologyId") long technologyId) {

		UserTech userTech = userTechRepository.findById(id).orElseThrow(() -> new UserTechNotFoundException(id));

		User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException(userId));
		Technology technology = techRepository.findById(technologyId)
				.orElseThrow(() -> new TechNotFoundException(technologyId));
		userTech.setUser(user);
		userTech.setTech(technology);
		return userTechRepository.save(userTech);
	}

	@DeleteMapping("/{id}")
	public void deleteUserTechnology(@PathVariable long id) {
		UserTech userTech = userTechRepository.findById(id).orElseThrow(() -> new UserTechNotFoundException(id));
		userTechRepository.delete(userTech);
	}

}
