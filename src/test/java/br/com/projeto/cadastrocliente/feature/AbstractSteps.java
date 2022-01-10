package br.com.projeto.cadastrocliente.feature;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import br.com.projeto.cadastrocliente.domain.dto.request.CidadeRequest;
import br.com.projeto.cadastrocliente.domain.dto.request.ClienteRequest;
import br.com.projeto.cadastrocliente.domain.dto.request.ClienteUpdateRequest;
import br.com.projeto.cadastrocliente.domain.dto.response.CidadeResponse;
import br.com.projeto.cadastrocliente.domain.dto.response.ClienteResponse;

public class AbstractSteps {

	public static final String HTTP_CODE_RESPONSE = "httpCodeResponse";
	public static final String PARAM_ID = "id";

	@Autowired
	protected TestRestTemplate template;

	@LocalServerPort
	private int port;

	public String baseUrl() {
		return String.format("http://localhost:%d", port);
	}

	public TestContext testContext() {
		return TestContext.CONTEXT;
	}

	protected ResponseEntity<List<CidadeResponse>> listaCidade() throws Exception {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<List<CidadeResponse>> body = new HttpEntity<List<CidadeResponse>>(headers);
		String url = String.format("%s/cidades", baseUrl());
		return template.exchange(url, HttpMethod.GET, body, new ParameterizedTypeReference<List<CidadeResponse>>() {
		});
	}

	protected ResponseEntity<CidadeResponse> procurarPeloNome(String id) throws Exception {
		String url = String.format("%s/cidades/%s", baseUrl(), id);
		return template.exchange(url, HttpMethod.GET, null, CidadeResponse.class);
	}

	protected ResponseEntity<List<CidadeResponse>> procurarPeloEstado(String id) throws Exception {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<List<CidadeResponse>> body = new HttpEntity<List<CidadeResponse>>(headers);
		String url = String.format("%s/cidades/estados/%s", baseUrl(), id);
		return template.exchange(url, HttpMethod.GET, body, new ParameterizedTypeReference<List<CidadeResponse>>() {
		});
	}

	protected ResponseEntity<CidadeResponse> atualizarCidade(String id, CidadeRequest request) throws Exception {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<CidadeRequest> body = new HttpEntity<CidadeRequest>(request, headers);
		String url = String.format("%s/cidades/%s", baseUrl(), id);
		return template.exchange(url, HttpMethod.PUT, body, CidadeResponse.class);
	}

	protected ResponseEntity<CidadeResponse> cadastrarNovaCidade(CidadeRequest request) throws Exception {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<CidadeRequest> body = new HttpEntity<CidadeRequest>(request, headers);
		String url = String.format("%s/cidades", baseUrl());
		return template.exchange(url, HttpMethod.POST, body, CidadeResponse.class);
	}

	protected ResponseEntity<List<ClienteResponse>> listaCliente() throws Exception {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<List<ClienteRequest>> body = new HttpEntity<List<ClienteRequest>>(headers);
		String url = String.format("%s/clientes/listartodos", baseUrl());
		return template.exchange(url, HttpMethod.GET, body, new ParameterizedTypeReference<List<ClienteResponse>>() {
		});
	}

	protected ResponseEntity<ClienteResponse> buscarPorNomeCliente(String id) throws Exception {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<ClienteRequest> body = new HttpEntity<ClienteRequest>(headers);
		String url = String.format("%s/clientes/name/%s", baseUrl(), id);
		return template.exchange(url, HttpMethod.GET, body, ClienteResponse.class);
	}

	protected ResponseEntity<ClienteResponse> buscarPorId(String id) throws Exception {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<ClienteRequest> body = new HttpEntity<ClienteRequest>(headers);
		String url = String.format("%s/clientes/%s", baseUrl(), id);
		return template.exchange(url, HttpMethod.GET, body, ClienteResponse.class);
	}

	protected ResponseEntity<ClienteResponse> deletarId(String id) throws Exception {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<ClienteRequest> body = new HttpEntity<ClienteRequest>(headers);
		String url = String.format("%s/clientes/%s", baseUrl(), id);
		return template.exchange(url, HttpMethod.DELETE, body, ClienteResponse.class);
	}

	protected ResponseEntity<ClienteResponse> atualizarCliente(String id, ClienteUpdateRequest request)
			throws Exception {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<ClienteUpdateRequest> body = new HttpEntity<ClienteUpdateRequest>(request, headers);
		String url = String.format("%s/clientes/%s", baseUrl(), id);
		return template.exchange(url, HttpMethod.PUT, body, ClienteResponse.class);
	}

	protected ResponseEntity<ClienteResponse> cadastrarNovoCliente(ClienteRequest request) throws Exception {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<ClienteRequest> body = new HttpEntity<ClienteRequest>(request, headers);
		String url = String.format("%s/clientes", baseUrl());
		return template.exchange(url, HttpMethod.POST, body, ClienteResponse.class);
	}

}
