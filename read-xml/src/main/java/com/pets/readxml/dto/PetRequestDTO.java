package com.pets.readxml.dto;

import com.pets.readxml.entity.Category;
import com.pets.readxml.entity.Pet;
import com.sun.istack.NotNull;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@ApiModel("Pet Request DTO")
public class PetRequestDTO {
    @ApiModelProperty(value = "id")
    @NotBlank(message = "id")
    public String id;

    @ApiModelProperty(value = "name")
    @NotBlank(message = "name")
    public String name;

    @ApiModelProperty(value = "status")
    @NotBlank(message = "status")
    public String status;

    @ApiModelProperty(value = "categoryDto")
    @Valid
    public CategoryRequestDTO categoryDto;

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

    public CategoryRequestDTO getCategoryDto() {
        return categoryDto;
    }

    public void setCategoryDto(CategoryRequestDTO categoryDto) {
        this.categoryDto = categoryDto;
    }

    // Metodo para conversão do DTO para PET - POST
    public Pet converterParaEntidade(){
        Category category = new Category(categoryDto.getId(), categoryDto.getName());
        return new Pet(id, name, status, category);
    }

    //Metodo para conversão do DTO para PET - POST (onde o id será passado via PATH)
    public Pet converterParaEntidade(String id){
        Category category = new Category(categoryDto.getId(), categoryDto.getName());
        return new Pet(id, name, status, category);
    }

}
