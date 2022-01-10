package br.com.projeto.cadastrocliente.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.cadastrocliente.domain.dto.request.ClienteRequest;
import br.com.projeto.cadastrocliente.domain.dto.request.ClienteUpdateRequest;
import br.com.projeto.cadastrocliente.domain.dto.response.ClienteResponse;
import br.com.projeto.cadastrocliente.service.ClienteService;
import lombok.AllArgsConstructor;


@AllArgsConstructor
@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	private ClienteService clienteService;

	@GetMapping({"/listartodos"})
	public ResponseEntity<List<ClienteResponse>> listaCliente() {
		return ResponseEntity.ok(this.clienteService.listar());
	}

	@GetMapping("/name/{nomeCompleto}")
	public ResponseEntity<ClienteResponse> listaNomeCliente(@PathVariable("nomeCompleto") String nomeCompleto) {
		return ResponseEntity.ok(this.clienteService.buscarPorNomeCompleto(nomeCompleto));

	}

	@GetMapping("/{id}")
	public ResponseEntity<ClienteResponse> consultarId(@PathVariable("id") Long id) {
		return ResponseEntity.ok(this.clienteService.findById(id));
	}

	@PostMapping
	public ResponseEntity<ClienteResponse> cadastrarCliente(@Valid @RequestBody ClienteRequest dto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.save(dto));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ClienteResponse> deletarIdCliente(@Valid @PathVariable("id") Long id) {
		this.clienteService.delete(id);
		return ResponseEntity.ok().build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<ClienteResponse> update(@RequestBody @Valid ClienteUpdateRequest dto, @PathVariable Long id) {
		return ResponseEntity.ok(this.clienteService.update(id, dto));
	}
}
