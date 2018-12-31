package com.sample.crudapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sample.crudapp.domain.User;
import com.sample.crudapp.error.UserNotFoundException;
import com.sample.crudapp.repository.UserRepository;

/**
 * 
 * @author Khanh
 *
 */
@RestController
@RequestMapping("/api/user")
public class UserController {

	private final UserRepository userRepository;

	public UserController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@PostMapping
	public User newUser(@RequestBody User newUser) {
		return userRepository.save(newUser);
	}

	@PutMapping("/{userId}")
	public User modifyUser(@RequestBody User newUser, @PathVariable("userId") long userId) {
		User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException(userId));
		user.setCity(newUser.getCity());
		user.setEmail(newUser.getEmail());
		user.setName(newUser.getName());
		user.setPhone(newUser.getPhone());
		return userRepository.save(user);
	}

	@DeleteMapping("/{userId}")
	public void deleteUserCascade(@PathVariable("userId") long userId) {
		User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException(userId));
		userRepository.delete(user);
	}

	@GetMapping("/{userId}")
	public User getUser(@PathVariable("userId") long userId) {
		User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException(userId));
		return user;
	}

//	fetch users based on technology
	@GetMapping("/fetchUsers")
	public List<User> fetchUsers(@RequestParam("techId") long techId) {
		return userRepository.findByTechId(techId);
	}

	@GetMapping("/getusers")
	public List<User> getUsers(@RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize) {
		if (pageNum >= 1) {
			PageRequest pageRequest = PageRequest.of(pageNum - 1, pageSize);
			return userRepository.findAll(pageRequest).getContent();
		} else {
			return new ArrayList<>();
		}
	}
}
