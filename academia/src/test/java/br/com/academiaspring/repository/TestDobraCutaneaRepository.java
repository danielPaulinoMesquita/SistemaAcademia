package br.com.academiaspring.repository;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.academiaspring.modelo.Cliente;
import br.com.academiaspring.modelo.DobraCutanea;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class TestDobraCutaneaRepository {

	@Autowired
	DobraCutaneaRepository dobraDao;
	
	@Autowired
	ClienteRepository clienteDao;
	
	@Test
	public void testarBuscaDobra() {
		Cliente cliente= new Cliente("caraDoTeste","email@qualquer.com", 44, "Masculino", "32132132322", "43256544");
		clienteDao.save(cliente);
		
		
		DobraCutanea dobra= new DobraCutanea(12.2,22.2,33.3,44.0,44.8,34.5,77.6,32.4,cliente);
		dobraDao.save(dobra);
		
		DobraCutanea dobraResultado= new DobraCutanea();
		dobraResultado= dobraDao.buscaPorAluno(cliente.getMatricula());
		
		assertNotNull(dobraResultado);
		assertTrue(dobraResultado.getCliente().getMatricula()==cliente.getMatricula());
		assertTrue(dobraResultado.getCoxa()==32.4);
		assertTrue(dobraResultado.getCliente().getNome().equals("caraDoTeste"));
	}
	
	
}
