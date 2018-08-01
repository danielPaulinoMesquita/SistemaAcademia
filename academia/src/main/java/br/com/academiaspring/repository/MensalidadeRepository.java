package br.com.academiaspring.repository;

import java.util.Calendar;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.academiaspring.modelo.Mensalidade;

@Repository
public interface MensalidadeRepository extends JpaRepository<Mensalidade, Long>{
	@Query("select m from Mensalidade m where m.id=:id") // Util para Fazer testes unitários
	public Mensalidade buscaUnica(@Param("id") Long id);
		
	@Query("select m from Mensalidade m where m.cliente.matricula=:id")
	public List<Mensalidade> buscaMensalidadesPorCliente(@Param("id") Long id);// id = cliente
	
	// Busca mensalidade
	@Query("select m from Mensalidade m where m.dataContrato=:c1 and m.cliente.matricula=:idcliente")
	public Mensalidade buscaUnicaPorContrato(@Param("c1")Calendar c1, @Param("idcliente") Long idcliente); 
}
