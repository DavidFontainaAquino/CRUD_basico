package com.dfont.crud.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class StudentDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private long id;
	private String name;
	private String last_name;
	private String email;

	public StudentDTO() {
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
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
