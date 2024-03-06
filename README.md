# Java Remote Method Invocation - Dicionário
![project stack](https://skillicons.dev/icons?i=java&perline=1) <br />
Implementação de um sistema de dicionário distribuído, separado em classes de Cliente e Servidor, com invocação remota de código.


## Como executar?
1. Clone o projeto para seu local com 
```git clone https://github.com/brunopdt/java-rmi-dictionary.git``` (usando HTTPS) 
2. Abra um terminal na pasta bin e execute o comando ```rmiregistry``` 
3. Abra um novo terminal no mesmo diretório, sem fechar o anterior, e execute ```java -Djava.security.policy=rmi.policy DictionaryServer``` <br />
 3.1 - Você pode providenciar um argumento para o endereço que deseja executar o servidor. Caso não seja providenciado, ele abrirá no localhost
4. Abra um terceiro terminal, ainda no mesmo diretório e sem fechar os anteriores, e execute ```java -Djava.security.policy=rmi.policy DictionaryClient```<br />
  4.1 - Caso tenha providenciado um argumento para o endereço do servidor no passo anterior, providenciar o mesmo ao executar o client.

🚀 O projeto já estará executando. A partir de agora é só interagir com o sistema por meio do cliente.
