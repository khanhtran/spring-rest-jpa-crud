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
@Table(name = "USER")
public class User {
	@Id
	@GeneratedValue
	private long id;
	private String name;
	private String email;
	private String phone;
	private String city;

	@OneToMany(cascade = CascadeType.ALL, mappedBy="user")
	@JsonIgnore
	private Set<UserTech> userTeches;

	public User() {
		userTeches = new HashSet<>();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Set<UserTech> getUserTeches() {
		return userTeches;
	}

	public void setUserTeches(Set<UserTech> userTeches) {
		this.userTeches = userTeches;
	}
}
