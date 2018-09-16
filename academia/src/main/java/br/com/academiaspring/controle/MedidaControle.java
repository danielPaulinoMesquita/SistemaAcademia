package br.com.academiaspring.controle;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.annotation.SessionScope;
import br.com.academiaspring.modelo.Medida;
import br.com.academiaspring.modelo.Cliente;
import br.com.academiaspring.repository.ClienteRepository;
import br.com.academiaspring.repository.MedidaRepository;

@Named
@SessionScope
public class MedidaControle {
	private Cliente cliente = new Cliente();
	private Medida medida = new Medida();
	private Medida medidaEscolhida = new Medida();
	private List<Medida> medidas;
	private List<Cliente> clientes;
	private boolean modoEdicao = false;
	private String mensagem= null;

	@Autowired
	MedidaRepository medidaDao;

	@Autowired
	ClienteRepository clienteDao;

	@PostConstruct
	public void init() {
		setMedidas(medidaDao.findAll());
		setClientes(clienteDao.findAll());

	}

	public void salvarMedida() {
		try {
			medidaDao.save(medida);
			if (!modoEdicao)
				this.medidas.add(medida);

			this.modoEdicao = false;
			medida = new Medida();
			setMensagem("Sucesso no salvamento");		
		} catch (Exception ex) {
			System.out.println("Erro ao salvar medida");
			this.modoEdicao = false;
			medida = new Medida();
			ex.printStackTrace();

		}
		
	}

	public void alterarMedida(Medida medidaAlterar) {
		setMensagem(null);
		setMedida(medidaAlterar);
		this.modoEdicao = true;
	}

	public void excluir(Medida medidaExcluir) {
		try {
			medidaDao.delete(medidaExcluir);
			medidas.remove(medidaExcluir);
			setMensagem("Sucesso na exclusão");

		} catch (Exception ex) {
			System.out.println("Erro ao excluir");

		}

	}
	public void cancelar() {
		this.medida = new Medida();
		this.modoEdicao = false;
	}
	
	// MÉTODO PARA BUSCAR MEDIDAS E RELATÓRIO
	public String relatorioCliente() {
		try {
			setMensagem(null);
			this.medidaEscolhida = medidaDao.buscarMedida(this.cliente.getMatricula());
			medidaEscolhida.calcularImc();
			medidaEscolhida.calcularMassa();
			return "avaliacaofisica";
		} catch (Exception ex) {
			setMensagem("ERROR!!Não encontrado as medidas de perimetro");
			return "medidas";
		}
	}

	public Medida getMedida() {
		return medida;
	}

	public void setMedida(Medida medida) {
		this.medida = medida;
	}

	public List<Medida> getMedidas() {
		return medidas;
	}

	public void setMedidas(List<Medida> medidas) {
		this.medidas = medidas;
	}

	public Medida getMedidaEscolhida() {
		return medidaEscolhida;
	}

	public void setMedidaEscolhida(Medida medidaEscolhida) {
		this.medidaEscolhida = medidaEscolhida;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public boolean isModoEdicao() {
		return modoEdicao;
	}

	public void setModoEdicao(boolean modoEdicao) {
		this.modoEdicao = modoEdicao;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	

}
