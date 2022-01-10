package br.com.projeto.cadastrocliente.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.projeto.cadastrocliente.domain.Cliente;
import br.com.projeto.cadastrocliente.domain.dto.response.ClienteResponse;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	
	@Query("select new br.com.projeto.cadastrocliente.domain.dto.response.ClienteResponse(c.id,c.nomeCompleto,c.sexo, c.dataNascimento, c.idade, c.cidade.id, c.cidade.nomeCidade, c.cidade.estado)From Cliente c where c.nomeCompleto=:nomeCompleto")
	Optional<ClienteResponse> findByNomeCompleto(@Param("nomeCompleto")String nomeCompleto);
	
	@Query("select new br.com.projeto.cadastrocliente.domain.dto.response.ClienteResponse(c.id,c.nomeCompleto,c.sexo, c.dataNascimento, c.idade, c.cidade.id, c.cidade.nomeCidade, c.cidade.estado ) From Cliente c")
	List<ClienteResponse> findAllCliente();
	

}
