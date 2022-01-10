package br.com.projeto.cadastrocliente.feature;

import java.util.ArrayList;
import java.util.List;

import br.com.projeto.cadastrocliente.domain.Cidade;
import br.com.projeto.cadastrocliente.domain.dto.request.CidadeRequest;
import br.com.projeto.cadastrocliente.domain.dto.response.CidadeResponse;

public class CidadeScenarioFactory {

	public static final List<CidadeResponse> LIST_ESTATOS_CONTROLLER = loadStatosController();
	public static CidadeResponse FIND_NOMECITY_NOTEXISTING = loadNotExistingNameCity();
	public static CidadeResponse FIND_NOMECITY_EXISTING = loadExistingNameCity();
	public static List<CidadeResponse> LIST_ALL = loadCidades();
	public static List<CidadeResponse> LIST_ESTATOS = loadEstados();
	public static Cidade SAVE_CITY = loadSalveCidade();
	public static CidadeResponse SAVE_CITY_CONTROLLER = saveCityController();
	public static CidadeResponse FIND_NOMECITY_EXISTING_CONTROLLER = loadCityNameController();
	public static CidadeRequest SAVE_CITY_REQUEST = saveCityControllerRequest();
	public static CidadeResponse ATUALIZAR = atualizar();
	public static CidadeRequest ATUALIZAR_CITY_REQUEST = atualizarCityControllerRequest();
	public static Cidade CIDADE_BDD=loadCidadeBdd();

	private static List<CidadeResponse> loadCidades() {

		CidadeResponse cidadeOne = new CidadeResponse(1L, "Porto Alegre", "RS");

		List<CidadeResponse> listCidade = new ArrayList<>();

		listCidade.add(cidadeOne);

		return listCidade;
	}



	private static Cidade loadCidadeBdd() {
		return Cidade.builder().cidadeId(3L).nomeCidade("TESTE BDD").estado("TESTE BDD ESTADO").build();
	}



	private static CidadeRequest atualizarCityControllerRequest() {
		CidadeRequest cidade = new CidadeRequest("Piedade", "RJ");
		return cidade;
	}



	private static CidadeResponse atualizar() {
		CidadeResponse cidade = new CidadeResponse();
		cidade.setEstado("RJ");
		cidade.setNomeCidade("Piedade");
		
		return cidade;
	}



	private static List<CidadeResponse> loadStatosController() {
		CidadeResponse response = new CidadeResponse();
		response.setCidadeId(2L);
		response.setNomeCidade("Piedade");
		response.setEstado("RJ");
		List<CidadeResponse> listaEstado = new ArrayList<>();
		listaEstado.add(response);

		return listaEstado;
	}



	private static CidadeRequest saveCityControllerRequest() {
		CidadeRequest cidade = new CidadeRequest("Rio de Janeiro", "RJ");
		return cidade;
	}



	private static CidadeResponse loadCityNameController() {
		CidadeResponse cidade = new CidadeResponse(3L, "Rio de Janeiro", "RJ");
		return cidade;
	}



	private static CidadeResponse saveCityController() {
		CidadeResponse response = new CidadeResponse();
		response.setCidadeId(2L);
		response.setNomeCidade("Piedade");
		response.setEstado("RJ");
		return response;
	}



	private static CidadeResponse loadNotExistingNameCity() {
		CidadeResponse cidade = new CidadeResponse();
		cidade.setNomeCidade("Anchieta");
		return cidade;
	}



	private static CidadeResponse loadExistingNameCity() {
		CidadeResponse cidade = new CidadeResponse();
		cidade.setNomeCidade("Rio de Janeiro");
		return cidade;
	}


	private static List<CidadeResponse> loadEstados() {

		CidadeResponse estado = new CidadeResponse(1L, "Porto Alegre", "RS");
		List<CidadeResponse> listaEstado = new ArrayList<>();
		estado.getEstado();
		listaEstado.add(estado);

		return listaEstado;

	}

	private static Cidade loadSalveCidade() {
		Cidade cidade = new Cidade();
		cidade.setCidadeId(2L);
		cidade.setEstado("RJ");
		cidade.setNomeCidade("Madureira");
		return cidade;
	}
	
	public static CidadeRequest cidadeAtualizar() {
		CidadeRequest cidade = new CidadeRequest();
		cidade.setNomeCidade("Anchiete");
		return cidade;
	}

	public static Cidade cidadeEntidade() {
		Cidade cidade = new Cidade();
		return cidade;
	}

	public static String findCityNotExisting() {
		String nomeCidade = "Candeias";
		return nomeCidade;
	}

	public static String findCityName() {
		String nomeCidade = "Rio de Janeiro";
		return nomeCidade;
	}



	public static CidadeRequest cidadeSave() {
		CidadeRequest request = new CidadeRequest("Anchieta", "RJ");
		return request;
	}
	
	public static CidadeRequest cidadeSaveController() {
		CidadeRequest request = new CidadeRequest("Piedade", "RJ");
		return request;
	}



	public static  CidadeRequest cidadeAtualizarController() {
		CidadeRequest cidade = new CidadeRequest();
		cidade.setNomeCidade("Piedade");
		return cidade;
	}



	

}
