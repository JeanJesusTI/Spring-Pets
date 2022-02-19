# Spring-Pets
O objetivo da aplicação é consumir uma API existente, para aplicação dos métodos HTTPs. Os dados disponibilizados pela API estão no formato XML, para isso, utilizaremos uma uma classe utilitária chamada <b>RestTemplate</b> para mapear a URI do serviço, e realizar a leitura e requisições e disponibilizar os dados no formato JSON; também iremos utilizar o Spring Security juntamente com o JWT para aplicar as políticas de segurança.
O serviço que será consumido, poderá ser encontrado no 
link: https://petstore.swagger.io/v2/pet/findByStatus?status=available.
<br/>
Iremos realizar uma filtragem básica para trazermos apenas os dados relevantes da aplicação, com isso, aplicação terá 2 (duas) entidades, sendo elas: Pet e Category. 
Os dados das entidades citadas acimas são disponibilizadas em uma mesma requisição, mas para fins de organização, iremos separar as informações utilizando a notação <b>@Embeded</b> do Spring para mapeá-las em classes diferentes.<br/><br/>


<p align="center">
    <img src="https://user-images.githubusercontent.com/31626353/154784060-670b577a-a130-429f-890d-a7dba784e654.png" /><br/>
    <em>Diagrama</em>
</p>

<br/>
<br/>


Sendo assim, a implementação ficará desta forma:<br>
<p align="center">
    <img src="https://user-images.githubusercontent.com/31626353/154784388-d0bbe7af-96d0-4c9f-bbeb-b6e3c7852bf0.png" /><br/>
    <em>Implementação das entidades Pet e Category</em>
</p>

## Principais Dependências:
    •	spring-boot-starter-security
    •	io.jsonwebtoken
    •	flyway-core
    •	spring-boot-starter-data-jpa
    •	springfox-swagger2
