package br.com.academiaspring.repository;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import br.com.academiaspring.modelo.Cliente;
import br.com.academiaspring.modelo.Mensalidade;

@RunWith(SpringRunner.class)//Qual console irá rodar(no caso spring)
@DataJpaTest//Definindo a classe como teste
@AutoConfigureTestDatabase(replace= Replace.NONE)
public class TestMensalidadeRepository {
	
	@Autowired
	MensalidadeRepository mensalidadeDao;
	
	@Autowired
	ClienteRepository clienteDao;
	
	@Test
	public void testeSalvaMensalidade() {
		Calendar c1= Calendar.getInstance();
		c1.add(Calendar.MONTH, 3);
		
		
		Cliente cli= new Cliente("DanTeste", "daniel-paulino@Teste.com", 33,"M","1231313","2313131");
		clienteDao.save(cli);
		
		Mensalidade m1= new Mensalidade(c1, false, cli);
		mensalidadeDao.save(m1);
		
		Assert.notNull(mensalidadeDao.findOne(m1.getId()));
	}
	@Test
	public void buscarMensalidade() {
		Calendar c1= Calendar.getInstance();
		c1.add(Calendar.MONTH, 3);
		
		Calendar c5= Calendar.getInstance();
		
		
		Calendar c3= Calendar.getInstance();
		c3.add(Calendar.DAY_OF_WEEK, 4);
		
		Calendar c4= Calendar.getInstance();
		
		Cliente cli= new Cliente("DanTeste", "daniel-paulino@Teste.com", 45,"M","1231313","2313131");
		clienteDao.save(cli);
		
		Mensalidade m2= new Mensalidade(c1, false, cli);
		Mensalidade m3= new Mensalidade(c3, true, cli);
		
		
		//TESTE COM SETTERS NO CALENDAR
		c4.set(2022, 8, 21, 03, 45);
		
		//TESTANDO BUSCA DE MENSALIDADE PELO CLIENTE E CALENDÁRIO
		c5.set(2068, 2, 20, 06, 20);
		Mensalidade mensa= new Mensalidade(c5,false,cli);
		mensalidadeDao.save(mensa);
		
		//Mensalidade mensalidadeEncontrada=mensalidadeDao.buscaUnicaPorContrato(c5, cli.getMatricula());
		
		
		
		mensalidadeDao.save(m2);
		mensalidadeDao.save(m3);
		
		Mensalidade m2Banco= mensalidadeDao.buscaUnica(m2.getId());
		Mensalidade m3Banco= mensalidadeDao.buscaUnica(m3.getId());
		
		
		
		assertNotNull(m3Banco);
		assertNotNull(m2Banco);
		assertTrue(m3Banco.isPago());
		Assert.isTrue(!m2Banco.isPago());
		//assertNotNull(mensalidadeEncontrada);		
		//Assert.isTrue(m3Banco.getDataContrato()==c3);
		
		//testar a data com sets
		assertTrue(c4.getWeekYear()==2022&&c4.get(Calendar.MONTH)==8);

	}
}
