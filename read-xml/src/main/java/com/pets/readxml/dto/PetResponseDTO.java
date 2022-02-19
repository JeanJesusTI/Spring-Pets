package com.pets.readxml.dto;

import com.pets.readxml.entity.Pet;

public class PetResponseDTO {
	public String id;
	public String name;
	public String status;
	
	public CategoryResponseDTO categoria;

	public PetResponseDTO() {
	}
	
	public PetResponseDTO(String id, String name, String status, CategoryResponseDTO categoria) {
		this.id = id;
		this.name = name;
		this.status = status;
		this.categoria = categoria;
	}
	
	public static PetResponseDTO converterParaDto(Pet pet) {
		CategoryResponseDTO categoria = new CategoryResponseDTO();
		
		if( pet.getCategory() == null ) {
			categoria.setId("0");
			categoria.setName("Not Found!");
		}else {
			categoria.setId(pet.getCategory().getId());
			categoria.setName(pet.getCategory().getName());
		}
		
		PetResponseDTO petDto =   new PetResponseDTO(pet.getId(), pet.getName(), pet.getStatus(), categoria);
		return petDto;
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

	public CategoryResponseDTO getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoryResponseDTO categoria) {
		this.categoria = categoria;
	}

		
}
