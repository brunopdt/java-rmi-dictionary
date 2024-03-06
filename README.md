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

## Funcionamento
O projeto RMI em Java consiste em quatro componentes principais:

1. **Servidor (DictionaryServer):** Fornecer os serviços do dicionário para os clientes. Ele registra um objeto remoto no registro RMI para que os clientes possam acessá-lo e executa as operações do dicionário solicitadas pelos clientes.

2. **Cliente (DictionaryClient):** Interagir com o servidor para acessar os serviços do dicionário. O cliente se conecta ao servidor remoto, chama os métodos do dicionário remoto para realizar operações como pesquisa, adição e remoção de palavras, e exibe os resultados para o usuário.

3. **Interface (Dictionary):** Define os métodos que podem ser invocados remotamente no objeto do dicionário. Inclui operações como pesquisa (`lookup`), adição (`add`) e remoção (`remove`) de palavras.

4. **Implementação do Servidor (DictionaryServant):** Fornece a lógica de negócios para as operações do dicionário. Implementa a interface `IDictionary` e define os métodos para realizar as operações correspondentes. Vale ressaltar que os dados são salvos em um arquivo ```dictionary.ser```, por meio do Java Serialization Object.

Esses componentes trabalham juntos para fornecer um sistema de dicionário distribuído e persistente, permitindo que os clientes acessem os serviços do dicionário de forma transparente, sem se preocupar com os detalhes da comunicação remota.