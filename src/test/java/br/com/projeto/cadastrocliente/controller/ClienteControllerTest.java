package br.com.projeto.cadastrocliente.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import br.com.projeto.cadastrocliente.feature.ClienteScenarioFacoty;
import br.com.projeto.cadastrocliente.service.ClienteService;

@RunWith(SpringRunner.class)
@WebMvcTest(ClienteController.class)

public class ClienteControllerTest {

	@MockBean
	private ClienteService service;

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void listarTodos_WhenListIsValid_ExpectedOk() throws Exception {
		when(this.service.listar()).thenReturn(ClienteScenarioFacoty.LIST_ALL);
		this.mockMvc.perform(get("/clientes/listartodos")).andExpect(status().isOk());
	}

	@Test
	public void buscarPorNome_WhenNomeIsValid_ExpectedOk() throws Exception {
		when(this.service.buscarPorNomeCompleto("Adriano Cardoso"))
				.thenReturn(ClienteScenarioFacoty.FIND_NAME_EXISTING_CONTROLLER);

		this.mockMvc.perform(get("/clientes/name/Adriano Cardoso")).andExpect(status().isOk());
	}

	@Test
	public void buscarId_WheIdIsValid_ExpectedOk() throws Exception {
		when(this.service.findById(2L)).thenReturn(ClienteScenarioFacoty.FIND_NAME_EXISTING_CONTROLLER);

		this.mockMvc.perform(get("/clientes/2")).andExpect(status().isOk());
	}
	@Test
	public void saveCliente_WhenNameIsValid_ExpectedOk() throws Exception {
		when(this.service.save(any())).thenReturn(ClienteScenarioFacoty.FIND_NAME_EXISTING_CONTROLLER);
		this.mockMvc
				.perform(post("/clientes").contentType(MediaType.APPLICATION_JSON)
						.content(asJsonString(ClienteScenarioFacoty.SAVE_CLIENTE_REQUEST)))
				.andExpect(status().isCreated());
	}
	@Test
	public void deleteIdCliente_WhenIdDeleteIsValid_ExpectedOk() throws Exception {
		this.service.delete(1L);
		
		this.mockMvc.perform(delete("/clientes/1")).andExpect(status().isOk());
	}
	
	@Test
	public void atualizarCliente_WhenClienteIsValid_ExpectedOk() throws Exception {
		when(this.service.update(2L, ClienteScenarioFacoty.atualizarCliente())).thenReturn(ClienteScenarioFacoty.FIND_NAME);
		
		this.mockMvc.perform(put("/clientes/2").contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(ClienteScenarioFacoty.SAVE_CLIENTE_REQUEST))).andExpect(status().isOk());
	}

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
