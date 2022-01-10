package br.com.projeto.cadastrocliente.feature;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.projeto.cadastrocliente.domain.Cidade;
import br.com.projeto.cadastrocliente.domain.Cliente;
import br.com.projeto.cadastrocliente.domain.dto.request.CidadeRequest;
import br.com.projeto.cadastrocliente.domain.dto.request.ClienteRequest;
import br.com.projeto.cadastrocliente.domain.dto.request.ClienteUpdateRequest;
import br.com.projeto.cadastrocliente.domain.dto.response.CidadeResponse;
import br.com.projeto.cadastrocliente.domain.dto.response.ClienteResponse;

public class ClienteScenarioFacoty {

	public static  ClienteResponse FIND_NAME_EXISTING_CONTROLLER = loadClienteExistingController();
	public static List<ClienteResponse> LIST_ALL = loadClientes();
	public static Cliente SAVE_CLIENTE = saveCliente();
	public static ClienteResponse SAVE_CLIENTE_EXISTING = saveClienteExisting();
	public static ClienteResponse FIND_NAME = loadNameCliente();
	public static ClienteResponse FIND_NAME_CONTROLLER = loadNameClienteController();
	public static ClienteRequest SAVE_CLIENTE_REQUEST = saveRequest();
	public static ClienteResponse DELETE =  deleteCliente();
	public static Cliente CIDADE_BDD=loadCidadeBdd();

	private static List<ClienteResponse> loadClientes() {

		ClienteResponse cliente = new ClienteResponse();
		List<ClienteResponse> list = new ArrayList<>();
		cliente.getCidade();
		cliente.getNomeCompleto();
		cliente.getSexo();
		cliente.getDataNascimento();
		cliente.getIdade();
		cliente.getCidade();
		list.add(cliente);

		return list;
	}
	
	private static Cliente loadCidadeBdd() {
		return Cliente.builder().clienteId(4L).nomeCompleto("Teste BDD").idade(22).sexo("M").dataNascimento(new Date()).cidade(new Cidade(1L,"Recife", "PE")).build();
	}

	private static ClienteResponse deleteCliente() {
		ClienteResponse response = new ClienteResponse();
		response.setClienteId(1L);
		response.setNomeCompleto("Mari Cardoso");
		response.setDataNascimento(new Date());
		response.setIdade(22);
		response.setSexo("M");
		response.setCidade(new CidadeResponse(1L, "Boa Viagem", "PE"));
		return response;
	}

	private static ClienteRequest saveRequest() {
		ClienteRequest cliente = new ClienteRequest();
		cliente.setNomeCompleto("Adriano Cardoso");
		cliente.setDataNascimento(new Date());
		cliente.setIdade(22);
		cliente.setSexo("M");
		cliente.setCidade(new CidadeRequest("Recife", "PE"));
		return cliente;
	}

	private static ClienteResponse loadClienteExistingController() {
		ClienteResponse response = new ClienteResponse();
		response.setClienteId(2L);
		response.setNomeCompleto("Adriano Cardoso");
		response.setDataNascimento(new Date());
		response.setIdade(22);
		response.setSexo("M");
		response.setCidade(new CidadeResponse(1L, "Boa Viagem", "PE"));
		return response;
	}

	private static ClienteResponse loadNameClienteController() {
		ClienteResponse response = new ClienteResponse();
		response.setClienteId(2L);
		response.setNomeCompleto("Mariana Emilly");
		response.setDataNascimento(new Date());
		response.setIdade(22);
		response.setSexo("M");
		response.setCidade(new CidadeResponse(1L, "Boa Viagem", "PE"));
		return response;
	}


	private static ClienteResponse loadNameCliente() {
		ClienteResponse response = new ClienteResponse();
		response.setNomeCompleto("Mariana Cardoso");
		return response;
	}

	private static ClienteResponse saveClienteExisting() {
		ClienteResponse response = new ClienteResponse();
		response.setNomeCompleto("Adriano Santos");
		return response;
	}

	private static Cliente saveCliente() {
		Cliente cliente = new Cliente();
		cliente.setClienteId(2L);
		cliente.setNomeCompleto("Adriano Santos");
		cliente.setDataNascimento(new Date());
		cliente.setIdade(22);
		cliente.setSexo("M");
		cliente.setCidade(new Cidade(1L,"Recife", "PE"));
		return cliente;
	}
	
	

	public static ClienteUpdateRequest atualizarCliente() {
		ClienteUpdateRequest request = new ClienteUpdateRequest();
		request.setNomeCompleto("Mariana Cardoso");
		return request;
	}

	public static ClienteRequest clienteSaveRequest() throws Exception {
		ClienteRequest cliente = new ClienteRequest();
		cliente.setNomeCompleto("Adriano Santos");
		cliente.setDataNascimento(conversaoDataInsertExistente());
		cliente.setIdade(22);
		cliente.setSexo("M");
		cliente.setCidade(new CidadeRequest("Recife", "PE"));
		return cliente;
	}

	public static Cliente clienteSave() {
		Cliente cliente = new Cliente();
		return cliente;
	}

	private static Date conversaoDataInsertExistente() throws Exception {

		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		Date data = formato.parse("1998-09-10");
		return data;
	}


}
