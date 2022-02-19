package com.pets.readxml.dto;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;

public class CategoryRequestDTO {
        @ApiModelProperty(value = "id")
        @NotBlank(message = "id")
        public String id;

        @ApiModelProperty(value = "name")
        @NotBlank(message = "name")
        public String name;

        public CategoryRequestDTO() {
        }

        public CategoryRequestDTO(String id, String name) {
            this.id = id;
            this.name = name;
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

}
