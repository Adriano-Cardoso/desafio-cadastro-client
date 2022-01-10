package br.com.projeto.cadastrocliente.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import br.com.projeto.cadastrocliente.domain.dto.response.ClienteResponse;
import br.com.projeto.cadastrocliente.exception.ClienteExistenteException;
import br.com.projeto.cadastrocliente.exception.ClienteResourceNotFoundException;
import br.com.projeto.cadastrocliente.feature.ClienteScenarioFacoty;
import br.com.projeto.cadastrocliente.repository.ClienteRepository;

@RunWith(MockitoJUnitRunner.class)
public class ClienteServiceTest {

	@InjectMocks
	private ClienteService service;

	@Mock
	private ClienteRepository repository;

	@Test
	public void listar_WhenListIsValid_ExpectedOK() {

		when(this.repository.findAllCliente()).thenReturn(ClienteScenarioFacoty.LIST_ALL);

		List<ClienteResponse> listar = service.listar();

		assertNotNull(listar);

	}

	@Test
	public void salvarCliente_WhenSaveValid_ExpectedOk() throws ClienteExistenteException, Exception {

		when(this.repository.findByNomeCompleto("Adriano Santos")).thenReturn(Optional.empty());

		ClienteResponse cliente = this.service.save(ClienteScenarioFacoty.clienteSaveRequest());

		assertNotNull(cliente);
	}

	@Test(expected = ClienteExistenteException.class)
	public void salvarCliente_WhenSaveClienteInValid_ExpectedException() throws ClienteExistenteException, Exception {

		when(this.repository.findByNomeCompleto("Adriano Santos"))
				.thenReturn(Optional.of(ClienteScenarioFacoty.SAVE_CLIENTE_EXISTING));

		this.service.save(ClienteScenarioFacoty.clienteSaveRequest());
	}

	@Test
	public void updateCliente_WhenUpdateClienteIsValid_ExpectedOk() {

		when(this.repository.findById(1L)).thenReturn(Optional.of(ClienteScenarioFacoty.SAVE_CLIENTE));

		assertNotNull(this.service.update(1L,ClienteScenarioFacoty.atualizarCliente()));

	}

	@Test(expected = ClienteResourceNotFoundException.class)
	public void updateCliente_WhenUpdateClienteIsInvalid_ExpectedException() {

		when(this.repository.findById(5L)).thenReturn(Optional.empty());

		this.service.update(5L, null);
	}
	@Test
	public void buscarNome_WhenClienteIsValid_ExpectedOk() {

		when(this.repository.findByNomeCompleto("Mariana Cardoso"))
				.thenReturn(Optional.of(ClienteScenarioFacoty.FIND_NAME));
		
		assertNotNull(this.service.buscarPorNomeCompleto("Mariana Cardoso"));
	}
	
	@Test(expected = ClienteExistenteException.class)
	public void buscarNome_WhenClienteIsInvalid_ExpectedException() {
		
		when(this.repository.findByNomeCompleto("Lucas Lucas")).thenReturn(Optional.empty());
		
		this.service.buscarPorNomeCompleto("Lucas Lucas");
		
	}
	@Test
	public void buscarId_WhenClienteIsValid_ExpectedOk() {
		
		when(this.repository.findById(2L)).thenReturn(Optional.of(ClienteScenarioFacoty.SAVE_CLIENTE));
		
		assertNotNull(this.service.findById(2L));
	}
	
	@Test(expected = ClienteResourceNotFoundException.class)
	public void buscarId_WhenClienteIsInValid_ExpectedException() {
		
		when(this.repository.findById(6L)).thenReturn(Optional.empty());
		
		this.service.findById(6L);
	}
	
	@Test
	public void deletarId_WhenClienteIsValid_ExpectedOk() {
		
		when(this.repository.findById(2L)).thenReturn(Optional.of(ClienteScenarioFacoty.SAVE_CLIENTE));
		
		this.service.delete(2L);
	}
	
	@Test(expected = ClienteResourceNotFoundException.class)
	public void deletarId_WhenClienteIsInValid_ExpectedException() {
		
		when(this.repository.findById(9L)).thenReturn(Optional.empty());
		
		this.service.delete(9L);
	}
	

}