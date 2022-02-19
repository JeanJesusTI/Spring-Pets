package com.pets.readxml.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.pets.readxml.entity.Pet;
import com.pets.readxml.exception.RegraNegocioException;

@Service
public class PetService {
	
	public List<Pet> listarTodosPets(){
		String url = gerarUrl("GET");
		
		RestTemplate restTemplate = instanciarRestTemplate();		
		Pet[] pets = restTemplate.getForObject(url, Pet[].class);
		return Arrays.asList(pets);
	}
	
	public Pet buscarPetPorId(String id_pet) {
		String url = gerarUrl("GET_ID",id_pet);
		RestTemplate restTemplate = instanciarRestTemplate();
		Pet petEncontrado = restTemplate.getForObject(url, Pet.class);
		System.out.println(petEncontrado);
		return petEncontrado;
	}

	public Pet salvarPet(Pet pet){
		String url = gerarUrl("POST");
		RestTemplate restTemplate = instanciarRestTemplate();

		Pet petSalvo = restTemplate.postForObject(url, pet, Pet.class);

		return petSalvo;
	}

	public  Pet atualizarPet(String id_pet, Pet pet){
		String url = gerarUrl("PUT");
		RestTemplate restTemplate = instanciarRestTemplate();

		Pet petEncontrado = validarSePetExiste(id_pet);

		BeanUtils.copyProperties(pet, petEncontrado, "id");
		restTemplate.put(url, petEncontrado);

		return petEncontrado;
	}

	public void deletarPet(String id_pet){
		String url = gerarUrl("DELETE", id_pet);
		RestTemplate restTemplate = instanciarRestTemplate();
		restTemplate.delete(url);
	}

	// Como a exception do NotFound foi mapeada, caso o id passado não exista, será lançado uma mensagem padrão
	private Pet validarSePetExiste(String id_pet) {
		Pet petEncontrado = buscarPetPorId(id_pet);
		return petEncontrado;
	}


	// Metodo para geração de url que não precisam de parâmetros de uri
	public String gerarUrl(String metodo) {
		String url = "";
		if( metodo.equals("GET") ) {
			url = "https://petstore.swagger.io/v2/pet/findByStatus?status=available";
			return url;
		} else
			if (metodo.equals("POST") || metodo.equals("PUT")){
				url = "https://petstore.swagger.io/v2/pet";
				return url;
			}

		return url;
	}

	// Método utilizando sobrecarga para gerar url que necessitam de ID
	public String gerarUrl(String metodo, String pet_id) {
		if(metodo.equals("GET_ID") || metodo.equals("PUT") || metodo.equals("DELETE")) {
			String url = "https://petstore.swagger.io/v2/pet/";
			return url.concat(pet_id.toString());
		}
		return null;
	}


	
	public RestTemplate instanciarRestTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
		restTemplate = restTemplateBuilder.build();
		return restTemplate;
	}
}
