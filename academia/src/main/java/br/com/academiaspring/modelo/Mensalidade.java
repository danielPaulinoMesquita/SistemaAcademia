package br.com.academiaspring.modelo;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;


@Entity
public class Mensalidade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Calendar dataContrato;
	private boolean pago = false;
	
	@Transient
	private String dataContratoTexto;

	@ManyToOne
	@JoinColumn
	private Cliente cliente;

	public Mensalidade() {

	}

	public Mensalidade(Calendar dataContrato, boolean pago, Cliente cliente) {
		this.dataContrato = dataContrato;
		this.pago = pago;
		this.cliente = cliente;
	}

	public void mesesContratado(int mes, boolean pagamento, Cliente clienteEmQuestao) {
		Calendar dataRecebida; // Data para adicionar meses do contrato
		this.dataContrato = Calendar.getInstance();// Settando o dia e mês inicial contratado

		
		dataRecebida = dataContrato;
		if(mes>0)
		dataRecebida.add(Calendar.MONTH, mes);

		setCliente(clienteEmQuestao);
		setDataContrato(dataContrato);

		setPago(pagamento);// Settando a situação de pagamento do mês vigente

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Calendar getDataContrato() {
		return dataContrato;
	}

	@Transient
	public void setDataContrato(Calendar dataContrato) {
		this.dataContrato = dataContrato;
	}
//	public String getDataContratoTexto() {
//		int ano = this.dataContrato.get(Calendar.YEAR);
//		int dia = this.dataContrato.get(Calendar.DAY_OF_MONTH);
//		int mes = this.dataContrato.get(Calendar.MONTH);
//		
//		this.dataContratoTexto = dia + "/" + mes + "/" + ano;//Concatenando inteiros para Apresentar na JSF
//		return dataContratoTexto;
//	}


	public String getDataContratoTexto() {
		int ano = this.dataContrato.get(Calendar.YEAR);
		int dia = this.dataContrato.get(Calendar.DAY_OF_MONTH);
		int mes = this.dataContrato.get(Calendar.MONTH);
		
		this.dataContratoTexto = dia + "/" + mes + "/" + ano;//Concatenando inteiros para Apresentar na JSF
		return dataContratoTexto;
	}

	public void setDataContratoTexto(String dataContratoTexto) {
		this.dataContratoTexto = dataContratoTexto;
	}

	public boolean isPago() {
		return pago;
	}

	public void setPago(boolean pago) {
		this.pago = pago;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
