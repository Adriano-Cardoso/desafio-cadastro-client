package br.com.projeto.cadastrocliente.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.projeto.cadastrocliente.feature.CidadeScenarioFactory;
import br.com.projeto.cadastrocliente.service.CidadeService;

@WebMvcTest(CidadeController.class)
@RunWith(SpringRunner.class)
public class CidadeControllerTest {

	@MockBean
	private CidadeService service;

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void listarTodos_WhenListIsValid_ExpectedOk() throws Exception {

		when(this.service.listar()).thenReturn(CidadeScenarioFactory.LIST_ALL);
		this.mockMvc.perform(get("/cidades")).andExpect(status().isOk());
	}

	@Test
	public void cadastrarCidade_WhenSaveIsValid_ExpectedOk() throws Exception {

		when(this.service.save(any())).thenReturn(CidadeScenarioFactory.FIND_NOMECITY_EXISTING_CONTROLLER);
		this.mockMvc
				.perform(post("/cidades").contentType(MediaType.APPLICATION_JSON)
						.content(asJsonString(CidadeScenarioFactory.SAVE_CITY_REQUEST)))
				.andExpect(status().isCreated());

	}

	@Test
	public void buscarCidadePorNome_WhenFindNameCidade_ExpectedOk() throws Exception {

		when(this.service.buscarNomeDaCidade("Anchieta"))
				.thenReturn(CidadeScenarioFactory.FIND_NOMECITY_EXISTING_CONTROLLER);

		this.mockMvc.perform(get("/cidades/Anchieta")).andExpect(status().isOk());
	}

	@Test
	public void buscarEstado_WhenFindEstado_ExpectedOk() throws Exception {

		when(this.service.buscarNomeEstado("RS")).thenReturn(CidadeScenarioFactory.LIST_ESTATOS_CONTROLLER);

		this.mockMvc.perform(get("/cidades/estados/RS")).andExpect(status().isOk());
	}

	@Test
	public void atualizarCidade_WhenAtualizarCidade_ExpectedOk() throws Exception {

		when(this.service.update(CidadeScenarioFactory.cidadeAtualizarController(), 3L)).thenReturn(CidadeScenarioFactory.ATUALIZAR);

		this.mockMvc.perform(put("/cidades/3").contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(CidadeScenarioFactory.ATUALIZAR_CITY_REQUEST))).andExpect(status().isOk());
	}

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}