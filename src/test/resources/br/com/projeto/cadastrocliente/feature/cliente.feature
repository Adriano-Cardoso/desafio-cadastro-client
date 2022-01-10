#language: pt

Funcionalidade: Listar,cadastrar,buscar clientes



Esquema do Cenário: Listar clientes

 Dado Dado que irei realizar uma consulta de todas os clientes
 Quando Quando eu realizar a consulta
 Entao Deve me retornar o código da operação <codigo_operacao> e os dados apresentados no corpo da solicitação conforme a pesquisas

 Exemplos:
 
   | codigo_operacao|
   |    '200'       |



Esquema do Cenário: Procurar cliente por nome

 Dado  que irei realizar uma consulta do cliente pelo nome <nomeCompleto>
 Quando  eu realizar a consulta pelo nome cliente
 Entao Deve me retornar o código da operação <codigo_operacao> e os dados apresentados no corpo da solicitação conforme a pesquisa

 Exemplos:
  |nomeCompleto      | codigo_operacao|
  |'Lucas da silva'  |    '200'       |
  |'-1'              |    '422'       |
 
 
Esquema do Cenário: Procurar cliente por id

 Dado  que irei realizar uma consulta do cliente pelo id <id>
 Quando  eu realizar a consulta pelo id cliente
 Entao Deve me retornar o código da operação <codigo_operacao> e os dados apresentados no corpo da solicitação conforme a pesquisa

 Exemplos:
  |id   | codigo_operacao|
  |'1'  |    '200'       |
  |'-1' |    '404'       |
  
  
  
Esquema do Cenário: deletar cliente por id

 Dado  que irei deletar um cliente pelo id <id>
 Quando  eu irei deletar um pelo id cliente
 Entao Deve me retornar o código da operação <codigo_operacao> e os dados apresentados no corpo da solicitação conforme a pesquisa

 Exemplos:
  |id   | codigo_operacao|
  |'2'  |    '200'       |
  

Esquema do Cenário: atualizar um cliente 

 Dado que irei consultar o id do cliente para atualizar o usuario <id> 
 Quando eu realizar a consulta pelo id devera atualizar o nome do cliente <nomeCompleto>
 Entao Deve me retornar o código da operação <codigo_operacao> e os dados apresentados no corpo da solicitação conforme a pesquisa

 Exemplos:
 |id	    |nomeCompleto             | codigo_operacao|
 |'1'    	|'Andre da silva'         | '200'          | 
 
 
   
  
Esquema do Cenário: cadastrar cliente 

 Dado  que irei consultar o cliente pelo nome <nomeCompleto>
 Quando  eu realizar a consulta pelo nome do cliente existe e cadastrar um novo <nomeCompleto>,<sexo>,<dataNascimento>,<idade>,<cidade>
 Entao Deve me retornar o código da operação <codigo_operacao> e os dados apresentados no corpo da solicitação conforme a pesquisa

 Exemplos:
	|nomeCompleto           |sexo             |dataNascimento             |idade    |cidade   | codigo_operacao|
	|'Marcos Pereira Luiz'  |'M'              |'1999-09-10'               |'21'     | '1'     |    '201'       |
  
      