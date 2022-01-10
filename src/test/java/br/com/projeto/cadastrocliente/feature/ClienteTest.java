package br.com.projeto.cadastrocliente.feature;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.springframework.http.ResponseEntity;

import br.com.projeto.cadastrocliente.domain.dto.request.CidadeRequest;
import br.com.projeto.cadastrocliente.domain.dto.request.ClienteRequest;
import br.com.projeto.cadastrocliente.domain.dto.request.ClienteUpdateRequest;
import br.com.projeto.cadastrocliente.domain.dto.response.ClienteResponse;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class ClienteTest extends AbstractSteps {

	private ResponseEntity<List<ClienteResponse>> response;
	private ResponseEntity<ClienteResponse> entityResponse;
	private String clienteId;

	@Dado("Dado que irei realizar uma consulta de todas os clientes")
	public void dado_que_irei_realizar_uma_consulta_de_todas_os_clientes() throws Exception {
		this.response = listaCliente();
	}

	@Quando("Quando eu realizar a consulta")
	public void quando_eu_realizar_a_consulta() {
		this.testContext().setResponse(response);
		this.testContext().set(HTTP_CODE_RESPONSE, response.getStatusCode().value());
	}

	@Entao("Deve me retornar o c�digo da opera��o {string} e os dados apresentados no corpo da solicitacao conforme a pesquisas")
	public void deve_me_retornar_o_codigo_da_operacao_e_os_dados_apresentados_no_corpo_da_solicitacao_conforme_a_pesquisas(
			String status) {
		assertEquals(Integer.parseInt(status), this.testContext().getResponse().getStatusCodeValue());
	}

	@Dado("que irei realizar uma consulta do cliente pelo nome {string}")
	public void que_irei_realizar_uma_consulta_do_cliente_pelo_nome(String string) throws Exception {
		this.entityResponse = buscarPorNomeCliente(string);
	}

	@Quando("eu realizar a consulta pelo nome cliente")
	public void eu_realizar_a_consulta_pelo_nome_cliente() {
		this.testContext().setResponse(entityResponse);
		this.testContext().set(HTTP_CODE_RESPONSE, entityResponse.getStatusCode().value());
	}

	@Dado("que irei realizar uma consulta do cliente pelo id {string}")
	public void que_irei_realizar_uma_consulta_do_cliente_pelo_id(String string) throws Exception {
		this.entityResponse = buscarPorId(string);
	}

	@Quando("eu realizar a consulta pelo id cliente")
	public void eu_realizar_a_consulta_pelo_id_cliente() {
		this.testContext().setResponse(entityResponse);
		this.testContext().set(HTTP_CODE_RESPONSE, entityResponse.getStatusCode().value());
	}

	@Dado("que irei deletar um cliente pelo id {string}")
	public void que_irei_deletar_um_cliente_pelo_id(String string) throws Exception {
		this.entityResponse = deletarId(string);
	}

	@Quando("eu irei deletar um pelo id cliente")
	public void eu_irei_deletar_um_pelo_id_cliente() {
		this.testContext().setResponse(entityResponse);
		this.testContext().set(HTTP_CODE_RESPONSE, entityResponse.getStatusCode().value());
	}

	@Dado("que irei consultar o id do cliente para atualizar o usuario {string}")
	public void que_irei_consultar_o_id_do_cliente_para_atualizar_o_usuario(String string) {
		this.clienteId = string;
	}

	@Quando("eu realizar a consulta pelo id devera atualizar o nome do cliente {string}")
	public void eu_realizar_a_consulta_pelo_id_devera_atualizar_o_nome_do_cliente(String string) throws Exception {
		ClienteUpdateRequest request = new ClienteUpdateRequest(string);
		this.entityResponse = atualizarCliente(clienteId, request);
		this.testContext().setResponse(entityResponse);
		this.testContext().set(HTTP_CODE_RESPONSE, entityResponse.getStatusCode().value());

	}
	@Dado("que irei consultar o cliente pelo nome {string}")
	public void que_irei_consultar_o_cliente_pelo_nome(String string) {
		this.clienteId = string;
	}
	
	@Quando("eu realizar a consulta pelo nome do cliente existe e cadastrar um novo {string},{string},{string},{string},{string}")
	public void eu_realizar_a_consulta_pelo_nome_do_cliente_existe_e_cadastrar_um_novo(String string, String string2,
			String string3, String string4, String string5) throws Exception {
		ClienteRequest request = new ClienteRequest(string, string2, null, null, new CidadeRequest());
		this.entityResponse = cadastrarNovoCliente(request);
		this.testContext().setResponse(entityResponse);
		this.testContext().set(HTTP_CODE_RESPONSE, entityResponse.getStatusCode().value());
	}


}
