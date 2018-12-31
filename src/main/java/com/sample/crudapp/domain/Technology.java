package com.sample.crudapp.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 
 * @author Khanh
 *
 */
@Entity
@Table(name = "TECHNOLOGY")
public class Technology {
	@Id
	@GeneratedValue
	private long techId;
	private String name;
	private boolean isActive;

	@OneToMany(cascade = CascadeType.ALL, mappedBy="tech")
	@JsonIgnore
	private Set<UserTech> userTeches;
	
	public Technology() {
		userTeches = new HashSet<>();
	}

	public long getTechId() {
		return techId;
	}

	public void setTechId(long techId) {
		this.techId = techId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Set<UserTech> getUserTeches() {
		return userTeches;
	}

	public void setUserTeches(Set<UserTech> userTeches) {
		this.userTeches = userTeches;
	}
}
