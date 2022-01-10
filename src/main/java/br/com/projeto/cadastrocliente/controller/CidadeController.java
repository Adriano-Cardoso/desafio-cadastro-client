package br.com.projeto.cadastrocliente.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.cadastrocliente.domain.dto.request.CidadeRequest;
import br.com.projeto.cadastrocliente.domain.dto.response.CidadeResponse;
import br.com.projeto.cadastrocliente.service.CidadeService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/cidades")
public class CidadeController {

	private CidadeService cidadeService;

	@GetMapping("/{nomeCidade}")
	public ResponseEntity<CidadeResponse> consultarCidade(@PathVariable("nomeCidade") String nomeCidade) {
		return ResponseEntity.ok(this.cidadeService.buscarNomeDaCidade(nomeCidade));
	}

	@GetMapping("/estados/{estado}")
	public ResponseEntity<List<CidadeResponse>> consultarEstado(@PathVariable("estado") String estado) {
		return ResponseEntity.ok(this.cidadeService.buscarNomeEstado(estado));
	}

	@PutMapping("/{id}")
	public ResponseEntity<CidadeResponse> atualizar(@RequestBody CidadeRequest dto,@PathVariable("id") Long id) {
		return ResponseEntity.ok(this.cidadeService.update(dto,id));
	}

	@PostMapping
	public ResponseEntity<CidadeResponse> cadastrarCidade(@RequestBody CidadeRequest dto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(cidadeService.save(dto));
	}

	@GetMapping
	public ResponseEntity<List<CidadeResponse>> listaCidade() {
		return ResponseEntity.ok(this.cidadeService.listar());
	}

}
