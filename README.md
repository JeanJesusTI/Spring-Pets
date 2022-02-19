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

## Principais Dependências:
    •	spring-boot-starter-security
    •	io.jsonwebtoken
    •	flyway-core
    •	spring-boot-starter-data-jpa
    •	springfox-swagger2

<br/>

## Tecnologias

<ul>
    <li><b>Spring Boot</b> é uma tecnologia Java open source, que tem por objetivo 
        facilitar os processos em aplicações Java, trazendo consigo mais agilidade e facilidade no processo de desenvolvimento.</li>
</ul>

<br/>

<ul>
 <li><b>Spring Security:</b> é um framework que emprega serviços de autenticação e autorização 
de alto nível e customizável para aplicações, a utilização deste framework pode trazer
diversas vantagens como por exemplo:<br/>
      <ul><br/>
     <li>Sistema de autorização e autenticação.</li>
     <li>Intregração</li>
     <li>Proteção contra ataques.</li>
      <li>Facilidade de utilização.</li>
 </ul>
</li>
 </ul>
 
<br/>
<br/>


<ul>
 <li><b>FlyWay:</b> é uma ferramenta que traz mais organização aos scripts SQL que serão executados no banco de dados, capaz de realizar migrations para controles de versões; sua utilização traz algumas vantagens como:
      <ul><br/>
     <li>Automação das execuções dos scripts.</li>
     <li>Sincronização do Banco de dados</li>
     <li>Criação de um banco de dados do zero</li>
      <li>Permite saber os scripts que foram executados ou não</li>
 </ul>
</li>
 </ul>

<br/>
<br/>

<ul>
    <li><b>JWT (Json Web Token)</b> é um método <b>RCT 7519</b> padrão da indústria para realizar autenticação entre duas partes por meio de um token assinado que autentica uma requisição web. Esse token é um código em Base64 que armazena objetos JSON com os dados que permitem a autenticação da requisição.</li>
</ul>










    


