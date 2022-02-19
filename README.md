# Spring Boot - Pets API
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
    <li><b>Spring Boot:</b> É uma tecnologia Java open source, que tem por objetivo 
        facilitar os processos em aplicações Java, trazendo consigo mais agilidade e facilidade no processo de desenvolvimento.</li>
</ul>

<br/>

<ul>
 <li><b>Spring Security:</b> É um framework que emprega serviços de autenticação e autorização 
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
 <li><b>FlyWay:</b> É uma ferramenta que traz mais organização aos scripts SQL que serão executados no banco de dados, capaz de realizar migrations para controles de versões; sua utilização traz algumas vantagens como:
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
    <li><b>JWT (Json Web Token): </b> É um método <b>RCT 7519</b> padrão da indústria para realizar autenticação entre duas partes por meio de um token assinado que autentica uma requisição web. Esse token é um código em Base64 que armazena objetos JSON com os dados que permitem a autenticação da requisição.</li>
</ul>



# Segurança
<br/>
Para segurança da aplicação, utilizaremos o Spring Security e o JsonWebToken; para controle de acesso à aplicação, utilizaremos o método de autenticação de usuários baseados em uma tabela criada no banco de dados através do Docker-composer e com o auxílio do Flyway para criação da mesma quando a aplicação for iniciada. Essa tabela tem por objetivo conter os registros dos usuários que poderão posteriormente registrar o token para realizar as requisições.
<br/>
<b>Obs:</b> A aplicação possui um usuário e senha padrão com role de admin, que permitirá o acesso as demais URIs (inclusive a uri de criação de novos usuários), sendo ele:<br/>
<br/>
<b>Login:</b> defaultUser<br/>
<b>Password:</b> 123

<br/>
<br/>




# Inicializando Aplicação


<ul>
    <li><b>Docker: </b> Para subirmos a aplicação, iremos precisar que o Docker esteja instalado, para podermos executar o script <b>docker-compose.yml</b>. Para isso, deveremos ir a diretório da aplicação “read-xml”, e executar o seguinte comando:</li>
</ul>


<div align="center">
    <b> docker-compose up -d</b>
</div>
<br/>
Se tudo estiver correto, será apresentado a seguinte tela:
<br/>
<br />

<p align="center">
    <img src="https://user-images.githubusercontent.com/31626353/154786559-431c9bc2-fdca-450b-b0e8-e3079b4d7607.png" /><br/>
    <em>CMD docker-composer</em>
</p>
<br/>
<br/>

### Executando a Aplicação:

<br/>

<ul>
    <li><b>Spring Application: </b> Após executar o passo acima, podemos iniciar A aplicação e o flyway irá criar a tabela necessária para autenticação dos usuários. Faremos isso executando o arquivo <b>XmlApplication</b</li>
</ul>
<br/>
        
   <p align="center">
         <img src="https://user-images.githubusercontent.com/31626353/154786826-0a06c24e-a2b2-4c9e-848f-bcf33cbbbb0f.png" /><br/>
         <em>Configurando Aplicação</em>
    </p>     

<br/>    
<br/>    

        
### Acessando Aplicação:
     
        
<ul>
    <li> Após iniciar a aplicação, podemos acessar o Swagger ou uma API-Cliente como PostMan, Insomnia e etc, para ter acesso aos principais serviços da aplicação Porém a princípio, porém será necessário a autenticação dos usuário por meio do JWT</b></li>
</ul>
<br/>
<p align="center">
         <img src="https://user-images.githubusercontent.com/31626353/154786944-36f204c0-2e95-4571-9225-8bcc3772ad87.png" /><br/>
         <em>Swagger</em>
    </p>    
        
<br/>
</br>

Porém, iremos utilizar o PostMan para realizar as requisições, para isso iremos utilizar as credenciais default da aplicação, sendo elas: <br/>
<br/>
<b>Login:</b> defaultUser<br/>
<b>Password:</b> 123 <br/>
<br/>
Devemos primeiramente se autenticar com o usuário padrão para ter acesso aos demais serviços da aplicação, para isso, iremos realizar uma requisição POST na URI: https://localhost:8080/api/v1/user/auth passando o usuário informado acima para geração do Token (por padrão, o token tem validade de 30 minutos), podemos ver o exemplo abaixo:
<br/>
<br/>

<p align="center">
         <img src="https://user-images.githubusercontent.com/31626353/154787105-1f86e3c4-29c8-4fdc-b6a2-b1d2034a8925.png" /><br/>
         <em>Geração de Token</em>
    </p>    
        
<br/>
<br/>
Após ter gerado o Token, devemos configura-lo na API-Cliente desejada, neste caso, faremos a inserção do token no Header do postman conforme imagem abaixo: 
<br>
<br/>
<p align="center">
         <img src="https://user-images.githubusercontent.com/31626353/154787235-cefd2a58-0890-462f-b223-281f0ecd569a.png" /><br/>
         <em>Configuração de Token</em>
    </p>    

<br/>        
<br/>

Após a configuração, seremos capazes de acessar todos os serviços disponibilizados pela API, baseados na permissão do usuário, como exemplo, iremos fazer a inserção de um novo usuário, após isso, poderá ser gerado o token do mesmo conforme passo anterior, bastando passar os parâmetros no novo usuário:
<br/>
<p align="center">
         <img src="https://user-images.githubusercontent.com/31626353/154787300-ca8d42e3-1752-48b0-a12c-d02ed562d400.png" /><br/>
         <em>Criação de novo usuário</em>
    </p>    

<br/>
<br/>
Após isso poderemos acessar as URIs:
<br/>

  <ul><br/>
    
     <li>GET - http://localhost:8080/api/v1/pets </li>
     <li>GET - http://localhost:8080/api/v1/pets/{id_pet}</li>
    <li>POST - http://localhost:8080/api/v1/pets.</li>
     <li>PUT - http://localhost:8080/api/v1/pets/{id_pet}</li>
    <li>DELETE - http://localhost:8080/api/v1/pets/{id_pet}</li>
    <br/>
      <li>POST - http://localhost:8080/api/v1/users</li>
    <li>POST - http://localhost:8080/api/v1/users/auth</li>
 </ul>
