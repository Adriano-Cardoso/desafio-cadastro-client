package br.com.projeto.cadastrocliente.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.projeto.cadastrocliente.domain.Cidade;
import br.com.projeto.cadastrocliente.domain.dto.response.CidadeResponse;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long> {

	@Query("select new br.com.projeto.cadastrocliente.domain.dto.response.CidadeResponse(c.id,c.nomeCidade,c.estado) From Cidade c where c.nomeCidade=:nomeCidade")
	Optional<CidadeResponse> findByNomeCidade(@Param("nomeCidade")String nomeCidade);

	@Query("select new br.com.projeto.cadastrocliente.domain.dto.response.CidadeResponse(c.id,c.nomeCidade,c.estado) From Cidade c Where c.estado=:estado")
	List<CidadeResponse> findByEstado(@Param("estado")String estado);

	@Query("select new br.com.projeto.cadastrocliente.domain.dto.response.CidadeResponse(c.id,c.nomeCidade,c.estado) From Cidade c")
	List<CidadeResponse> findAllCidade();
}
