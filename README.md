# Spring-Pets
O objetivo da aplicação é consumir uma API existente, para aplicação dos métodos HTTPs. Os dados disponibilizados pela API estão no formato XML, para isso, utilizaremos uma uma classe utilitária chamada <b>RestTemplate</b> para mapear a URI do serviço, e realizar a leitura e requisições e disponibilizar os dados no formato JSON; também iremos utilizar o Spring Security juntamente com o JWT para aplicar as políticas de segurança.
O serviço que será consumido, poderá ser encontrado no 
link: https://petstore.swagger.io/v2/pet/findByStatus?status=available.
