package com.pets.readxml.controller;

import java.util.List;
import java.util.stream.Collectors;

import com.pets.readxml.dto.PetRequestDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.pets.readxml.dto.PetResponseDTO;
import com.pets.readxml.entity.Pet;
import com.pets.readxml.service.PetService;

@Api(tags = "Pet")
@RestController
@RequestMapping("/api/v1/pets")
public class PetController {

    @Autowired
    PetService petService;

    @ApiOperation(value = "Listar", nickname = "ListarTodosPets")
    @GetMapping
    public List<PetResponseDTO> listarTodosPets() {
        return petService.listarTodosPets().stream().map(pet -> PetResponseDTO.converterParaDto(pet))
                .collect(Collectors.toList());
    }

    @ApiOperation(value = "buscarPorId", nickname = "BuscarPetPorID")
    @GetMapping("/{id_pet}")
    ResponseEntity<PetResponseDTO> buscarPetPorId(@PathVariable String id_pet) {
        Pet petEncontrado = petService.buscarPetPorId(id_pet);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(PetResponseDTO.converterParaDto(petEncontrado));
    }

    @ApiOperation(value = "SalvarPet", nickname = "SalvarPet")
    @PostMapping
    ResponseEntity<PetResponseDTO> salvarPet(@RequestBody PetRequestDTO pet) {
        Pet petSalvar = petService.salvarPet(pet.converterParaEntidade());
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(PetResponseDTO.converterParaDto(petSalvar));
    }

    @ApiOperation(value = "AtualizarPet", nickname = "atualizar-pet")
    @PutMapping("/{id_pet}")
    ResponseEntity<PetResponseDTO> atualizarPet(@PathVariable String id_pet, @RequestBody PetRequestDTO pet) {
        Pet petAtualizado = petService.atualizarPet(id_pet, pet.converterParaEntidade());
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(PetResponseDTO.converterParaDto(petAtualizado));
    }

    @ApiOperation(value = "DeletarPet", nickname = "deletar-pet")
    @DeleteMapping("/{id_pet}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarPet(@PathVariable String id_pet) {
        petService.deletarPet(id_pet);
    }

}
