package br.com.projeto.cadastrocliente.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import br.com.projeto.cadastrocliente.domain.dto.request.CidadeRequest;
import br.com.projeto.cadastrocliente.domain.dto.response.CidadeResponse;
import br.com.projeto.cadastrocliente.exception.CidadeExistenteException;
import br.com.projeto.cadastrocliente.exception.CidadeResourceNotFoundException;
import br.com.projeto.cadastrocliente.feature.CidadeScenarioFactory;
import br.com.projeto.cadastrocliente.repository.CidadeRepository;

@RunWith(MockitoJUnitRunner.class)
public class CidadeServiceTest {

	@InjectMocks
	private CidadeService service;

	@Mock
	private CidadeRepository repository;

	@Test
	public void listar_WhenListIsValid_ExpectedOK() {

		when(repository.findAllCidade()).thenReturn(CidadeScenarioFactory.LIST_ALL);

		// given(repository.findAllCidade()).willReturn(CidadeScenarioFactory.LIST_ALL);

		List<CidadeResponse> listar = service.listar();

		assertNotNull(listar);

		verify(repository, times(1)).findAllCidade();
	}

	@Test
	public void buscarPorNome_WhenNameIsValid_ExpectedOk() {

		when(this.repository.findByNomeCidade("Rio de Janeiro"))
				.thenReturn(Optional.of(CidadeScenarioFactory.FIND_NOMECITY_EXISTING));

		CidadeResponse cidade = this.service.buscarNomeDaCidade(CidadeScenarioFactory.findCityName());

		assertNotNull(cidade);

	}

	@Test(expected = CidadeResourceNotFoundException.class)
	public void buscarPorNome_WhenNameIsInvalid_ExpectedException() {

		when(this.repository.findByNomeCidade("Candeias")).thenReturn(Optional.empty());

		this.service.buscarNomeDaCidade(CidadeScenarioFactory.findCityNotExisting());

	}

	@Test
	public void buscarPorEstado_WhenEstateIsValid_ExpectedOK() {
		when(this.repository.findByEstado("RS")).thenReturn(CidadeScenarioFactory.LIST_ESTATOS);

		List<CidadeResponse> listar = this.service.buscarNomeEstado("RS");

		assertNotNull(listar);

	}

	@Test
	public void salvarCidade_WhenCidadeIsValid_ExpectedOk() {

		when(this.repository.findByNomeCidade("Anchieta")).thenReturn(Optional.empty());

		CidadeResponse cidade = this.service.save(CidadeScenarioFactory.cidadeSave());

		assertNotNull(cidade);
	}

	@Test(expected = CidadeExistenteException.class)
	public void salvarCidade_WhenCidadeIsInValid_ExpectedException() {

		when(this.repository.findByNomeCidade("Madureira"))
				.thenReturn(Optional.of(CidadeScenarioFactory.FIND_NOMECITY_EXISTING));

		this.service.save(new CidadeRequest("Madureira", "RJ"));

	}
	
	@Test(expected = CidadeExistenteException.class)
	public void updateCidade_WhenCidadeIsInValid_ExpectedException() {
		when(this.repository.findById(3L)).thenReturn(Optional.empty());
		
		this.service.update( new CidadeRequest("PE", "Pina"),3L);
	}
	
	@Test
	public void updateCidade_WhenCidadeIsValid_ExpectedOK() {
		when(this.repository.findById(1L)).thenReturn(Optional.of(CidadeScenarioFactory.SAVE_CITY));
		
		assertNotNull(this.service.update(CidadeScenarioFactory.cidadeAtualizar(), 1L));
	}
	
	


}
