package br.com.academiaspring.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import javax.persistence.EntityManager;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.academiaspring.modelo.Cliente;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
//@AutoConfigureTestDatabase(connection= EmbeddedDatabaseConnection.H2, replace=Replace.ANY)
public class TestClienteRepository {

		@Autowired
		private ClienteRepository clienteRepository;
		
		@Autowired
		EntityManager en;
		
		@Test
		public void testeSalvar() {
			Cliente cli= new Cliente("Daniel Teste", "daniel-paulino@Teste.com", 27,"M","1231313","2313131");
			Cliente clisalvo= clienteRepository.save(cli);
			Assert.assertNotNull(clisalvo.getMatricula());
		}
		
		
		@Test
		public void testeBuscaEmail() {
			Cliente cliente2= new Cliente("DanieTesteEmail","dan@teste.com",44,"F","12313","3131313");
			en.persist(cliente2);
			
			//Testando Buscar pessoa por email
			Cliente clienteEncontrado= clienteRepository.buscaPorEmail(cliente2.getEmail());
			
			assertThat(clienteEncontrado.getNome()).isEqualTo(cliente2.getNome());
			assertThat(clienteEncontrado.getEmail()).isEqualTo(cliente2.getEmail());
		}
		
		@Test
		public void buscarTodos() {
			Cliente cli3= new Cliente("Teste 2", "test2@buscandotodos.com", 56,"F","1312313133","4244242");
			Cliente cli4= new Cliente("Teste 3", "test3@buscandotodos.com", 45,"M","23131313","31312313");
			en.persist(cli3);
			en.persist(cli4);
			
			//Testando buscarTodos
			
			List<Cliente> clientes= clienteRepository.buscarTodos();
			assertThat(clientes.get(2).getNome()).isEqualTo(cli3.getNome());
			assertThat(clientes.get(3).getNome()).isEqualTo(cli4.getNome());

			
			

		}
	
}
