Essa aplicação faz a consulta de um CEP em uma API externa e os dados retornados pela API são inseridos em um banco de dados MySQL.

O banco de dados é instalado facilmente através do docker-compose, via terminal Linux:
No diretório raíz do projeto, entrar na pasta docker-compose e digitar o comando: docker-compose up -d 
Exemplo:
~/BuscaCep cd docker-compose
~/BuscaCep/docker-compose docker-compose up -d 

As configurações de banco de dados estão no arquivo ~/BuscaCep/docker-compose/docker-compose.yml e são as mesmas configuradas na aplicação, no arquivo ~/BuscaCep/src/main/resources/application.properties. 
Se necessário, a senha do banco de dados deve ser alterada em ambos arquivos.

Java versão 11
Maven 3.9.8
Docker versão 20.10
MySQL versão 8

