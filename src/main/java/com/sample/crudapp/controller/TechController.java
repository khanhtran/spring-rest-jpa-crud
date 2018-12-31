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

import com.sample.crudapp.domain.Technology;
import com.sample.crudapp.error.TechNotFoundException;
import com.sample.crudapp.repository.TechRepository;

/**
 * 
 * @author Khanh
 *
 */
@RestController
@RequestMapping("/api/technology")
public class TechController {

	private final TechRepository technologyRepository;

	public TechController(TechRepository technologyRepository) {
		this.technologyRepository = technologyRepository;
	}

	@PostMapping
	public Technology newTechnology(@RequestBody Technology newTechnology) {
		return technologyRepository.save(newTechnology);
	}

	@PutMapping("/{technologyId}")
	public Technology modifyTechnology(@RequestBody Technology newTechnology, @PathVariable long technologyId) {
		Technology technology = technologyRepository.findById(technologyId)
				.orElseThrow(() -> new TechNotFoundException(technologyId));
		technology.setActive(newTechnology.isActive());
		technology.setName(newTechnology.getName());
		return technologyRepository.save(technology);
	}

	@DeleteMapping("/{technologyId}")
	public void deleteTechnologyCascade(@PathVariable long technologyId) {
		Technology technology = technologyRepository.findById(technologyId)
				.orElseThrow(() -> new TechNotFoundException(technologyId));
		technologyRepository.delete(technology);
	}

	@GetMapping("/{technologyId}")
	public Technology getTech(@PathVariable long technologyId) {
		Technology technology = technologyRepository.findById(technologyId)
				.orElseThrow(() -> new TechNotFoundException(technologyId));
		return technology;
	}

	@GetMapping("/gettechnologies")
	public List<Technology> getTech(@RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize) {
		if (pageNum >= 1) {
			PageRequest pageRequest = PageRequest.of(pageNum - 1, pageSize);
			return technologyRepository.findAll(pageRequest).getContent();
		} else {
			return new ArrayList<>();
		}
	}
}