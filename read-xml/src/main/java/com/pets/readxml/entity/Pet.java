package com.pets.readxml.entity;

import java.util.Objects;

import javax.persistence.Embedded;

public class Pet {
	public String id;
	public String name;
	public String status;
	
	@Embedded
	private Category category;
	
	public Pet() {
	}

	public Pet(String id, String name, String status, Category category) {
		this.id = id;
		this.name = name;
		this.status = status;
		this.category = category;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public int hashCode() {
		return Objects.hash(category, id, name, status);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Pet)) {
			return false;
		}
		Pet other = (Pet) obj;
		return Objects.equals(category, other.category) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name) && Objects.equals(status, other.status);
	}


	
	
}
