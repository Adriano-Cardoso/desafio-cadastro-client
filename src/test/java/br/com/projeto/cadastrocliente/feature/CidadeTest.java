package br.com.projeto.cadastrocliente.feature;

import java.util.List;

import org.springframework.http.ResponseEntity;

import br.com.projeto.cadastrocliente.domain.dto.request.CidadeRequest;
import br.com.projeto.cadastrocliente.domain.dto.response.CidadeResponse;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Quando;

public class CidadeTest extends AbstractSteps {

	private ResponseEntity<List<CidadeResponse>> response;
	private ResponseEntity<CidadeResponse> entityResponse;
	private String cidadeId;
	private String nomeCidade;
	

	@Dado("que irei realizar uma consulta de todas as cidades")
	public void dado_que_irei_realizar_uma_consulta_de_todas_as_cidades() throws Exception {
		response = listaCidade();
	}

	public String getNomeCidade() {
		return nomeCidade;
	}

	public void setNomeCidade(String nomeCidade) {
		this.nomeCidade = nomeCidade;
	}

	@Quando("eu realizar a consulta")
	public void quando_eu_realizar_a_consulta() {
		this.testContext().setResponse(response);
		this.testContext().set(HTTP_CODE_RESPONSE, response.getStatusCode().value());
	}

	
	@Dado("que irei realizar uma consulta de pelo nome da cidade {string}")
	public void dado_que_irei_realizar_uma_consulta_de_pelo_id_da_cidade(String string) throws Exception {
		entityResponse = procurarPeloNome(string);

	}

	@Quando("eu realizar a consulta pelo nome da cidade")
	public void quando_eu_realizar_a_consulta_pelo_id_da_cidade() {
		this.testContext().setResponse(entityResponse);
		this.testContext().set(HTTP_CODE_RESPONSE, entityResponse.getStatusCode().value());
	}

	@Dado("que irei realizar uma consulta de pelo nome do estado {string}")
	public void dado_que_irei_realizar_uma_consulta_de_pelo_nome_do_estado_estado(String string) throws Exception {
		this.response = procurarPeloEstado(string);
	}

	@Quando("eu realizar a consulta pelo nome do estado")
	public void quando_eu_realizar_a_consulta_pelo_nome_do_estado() {
		this.testContext().setResponse(response);
		this.testContext().set(HTTP_CODE_RESPONSE, response.getStatusCode().value());
	}
	
	@Dado("que irei consultar o  {string}")
	public void dado_que_irei_consultar_o(String string) throws Exception {
		this.cidadeId=string;
		
	}

	@Quando("eu realizar a consulta pelo id devera atualizar o nome da cidade {string},{string}")
	public void eu_realizar_a_consulta_pelo_id_devera_atualizar_o_nome_da_cidade(String string, String string2) throws Exception {
		CidadeRequest request = new  CidadeRequest(string,string2);
		this.entityResponse = atualizarCidade(cidadeId,request);
		this.testContext().setResponse(entityResponse);
		this.testContext().set(HTTP_CODE_RESPONSE, entityResponse.getStatusCode().value());
	}
	
	@Dado("que irei consultar o {string}")
	public void que_irei_consultar_o(String string) {
		this.setNomeCidade(string);
	}

	@Quando("eu realizar a consulta para verificar se o nome da cidade existe e cadastrar uma nova cidade {string},{string}")
	public void eu_realizar_a_consulta_para_verificar_se_o_nome_da_cidade_existe_e_cadastrar_uma_nova_cidade(String string, String string2) throws Exception {
		CidadeRequest request = new  CidadeRequest(string,string2);
		this.entityResponse = cadastrarNovaCidade(request);
		this.testContext().setResponse(entityResponse);
		this.testContext().set(HTTP_CODE_RESPONSE, entityResponse.getStatusCode().value());
	}
	
	

	
	
}
