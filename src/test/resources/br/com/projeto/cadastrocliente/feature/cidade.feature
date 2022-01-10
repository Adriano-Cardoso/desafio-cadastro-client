#language: pt

Funcionalidade: Listar,cadastrar,buscar cidades



Esquema do Cenário: Listar cidades

 Dado  que irei realizar uma consulta de todas as cidades
 Quando  eu realizar a consulta
 Entao Deve me retornar o código da operação <codigo_operacao> e os dados apresentados no corpo da solicitação conforme a pesquisa

 Exemplos:
 
   | codigo_operacao|
   |    '200'       |



Esquema do Cenário: Procurar cidade por nome da cidade

 Dado  que irei realizar uma consulta de pelo nome da cidade <nomeDaCidade>
 Quando  eu realizar a consulta pelo nome da cidade
 Entao Deve me retornar o código da operação <codigo_operacao> e os dados apresentados no corpo da solicitação conforme a pesquisa

 Exemplos:
  |nomeDaCidade      | codigo_operacao|
  |'Rio de Janeiro'  |    '200'       |
  |'-1'              |    '404'       |
  
  
  
Esquema do Cenário: Procurar cidade por nome do estado

 Dado  que irei realizar uma consulta de pelo nome do estado <estado>
 Quando  eu realizar a consulta pelo nome do estado
 Entao Deve me retornar o código da operação <codigo_operacao> e os dados apresentados no corpo da solicitação conforme a pesquisa

 Exemplos:
  |estado            | codigo_operacao|
  |'PE'              |    '200'       |
  
  
  
Esquema do Cenário: atualizar cidade 

 Dado que irei consultar o  <id> 
 Quando eu realizar a consulta pelo id devera atualizar o nome da cidade <nomeDaCidade>,<estado>
 Entao Deve me retornar o código da operação <codigo_operacao> e os dados apresentados no corpo da solicitação conforme a pesquisa

 Exemplos:
 |id	    |nomeDaCidade          |estado          | codigo_operacao|
 |'1'    	| 'Recife'             |'PE'            | '200'          |
 
 
 Esquema do Cenário: cadastrar cidade 

 Dado  que irei consultar o <nomeDaCidade>
 Quando  eu realizar a consulta para verificar se o nome da cidade existe e cadastrar uma nova cidade <nomeDaCidade>,<estado>
 Entao Deve me retornar o código da operação <codigo_operacao> e os dados apresentados no corpo da solicitação conforme a pesquisa

 Exemplos:
 |nomeDaCidade              |estado            | codigo_operacao|
 |'Abolicao'                |'RJ'              |    '201'       |
   
   
  