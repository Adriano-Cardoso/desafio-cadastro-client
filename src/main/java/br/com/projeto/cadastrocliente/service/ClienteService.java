package br.com.projeto.cadastrocliente.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import br.com.projeto.cadastrocliente.domain.Cliente;
import br.com.projeto.cadastrocliente.domain.dto.request.ClienteRequest;
import br.com.projeto.cadastrocliente.domain.dto.request.ClienteUpdateRequest;
import br.com.projeto.cadastrocliente.domain.dto.response.ClienteResponse;
import br.com.projeto.cadastrocliente.exception.ClienteExistenteException;
import br.com.projeto.cadastrocliente.exception.ClienteResourceNotFoundException;
import br.com.projeto.cadastrocliente.repository.ClienteRepository;
import br.com.projeto.cadastrocliente.validations.OnCreate;
import br.com.projeto.cadastrocliente.validations.OnUpdate;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Validated
@Service("ClienteService")
@Slf4j
public class ClienteService {

	private ClienteRepository repository;

	@Validated(OnCreate.class)
	public ClienteResponse save(@Valid ClienteRequest clienteDto) throws ClienteExistenteException {

		this.repository.findByNomeCompleto(clienteDto.getNomeCompleto()).ifPresent(m -> {
			throw new ClienteExistenteException("existing customer: " + clienteDto.getNomeCompleto());
		});

		Cliente cliente = Cliente.of(clienteDto);

		this.repository.save(cliente);

		log.info("method=save id={}", cliente.getCidade());

		return cliente.toDto();

	}

	@Transactional
	@Validated(OnUpdate.class)
	public ClienteResponse update(@Valid Long id, ClienteUpdateRequest dto) throws ClienteResourceNotFoundException {

		Cliente cliente = repository.findById(id)
				.orElseThrow(() -> new ClienteResourceNotFoundException("id not found: " + id));
		cliente.updateCliente(dto);

		log.info("method=update id={}", cliente.getCidade());

		return cliente.toDto();

	}

	public ClienteResponse buscarPorNomeCompleto(String nomeCompleto) throws ClienteResourceNotFoundException {
		log.info("method=buscarPorNomeCompleto nomeCompleto={}", nomeCompleto);

		return this.repository.findByNomeCompleto(nomeCompleto)
				.orElseThrow(() -> new ClienteExistenteException("Name not found: " + nomeCompleto));
	}

	public ClienteResponse findById(Long id) throws ClienteResourceNotFoundException {
		log.info("method=findById findById={}", id);

		Cliente cliente = this.repository.findById(id)
				.orElseThrow(() -> new ClienteResourceNotFoundException("id not found!  " + id));
		return cliente.toDto();
	}

	public void delete(Long id) throws ClienteResourceNotFoundException {
		log.info("method=delete delete={}", id);
		Cliente cliente = this.repository.findById(id).orElseThrow(() -> new ClienteResourceNotFoundException("id not found!  " + id));
		this.repository.delete(cliente);
	}

	public List<ClienteResponse> listar() {

		log.info("method=listar");

		return this.repository.findAllCliente();

	}

}
