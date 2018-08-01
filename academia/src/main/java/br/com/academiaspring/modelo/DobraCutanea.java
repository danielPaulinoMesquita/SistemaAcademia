package br.com.academiaspring.modelo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;


@Entity
public class DobraCutanea implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;

	private double tricipital;
	private double bicipital;
	private double subescapular;
	private double toracica;
	private double axilarMedia;
	private double supraIliaca;
	private double abdominal;
	private double coxa;
	
	@ManyToOne
	@JoinColumn
	private Cliente cliente;
	
	@Transient
	private double idealMinimo, idealMaximo, alvo, atual;
	
	public DobraCutanea() {
		
	}

	public DobraCutanea(double tricipital, double bicipital, double subescapular, double toracica, double axilarMedia,
			double supraIliaca, double abdominal, double coxa, Cliente cliente) {
		this.tricipital = tricipital;
		this.bicipital = bicipital;
		this.subescapular = subescapular;
		this.toracica = toracica;
		this.axilarMedia = axilarMedia;
		this.supraIliaca = supraIliaca;
		this.abdominal = abdominal;
		this.coxa = coxa;
		this.cliente = cliente;
		
	}



	/*
	 * % de Gordura Corporal  = (0.29288 x soma das dobras cutâneas) – (0.0005 x quadrado da soma das dobras cutâneas) +
 		(0.15845 x idade) – 5.76377, 
		em que os locais para medir as dobras cutâneas  (medidos em mm) são o abdómen, tríceps, coxa e suprailíaco
	 */

	public void calcularGordura(int idade) {
		double somaDobras= (tricipital+bicipital+subescapular+toracica+axilarMedia+supraIliaca+abdominal+coxa);
		this.atual=(0.29288 * somaDobras)-(0.0005*(somaDobras*somaDobras))+(0.15845*idade)-5.76377;
		
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getTricipital() {
		return tricipital;
	}

	public void setTricipital(double tricipital) {
		this.tricipital = tricipital;
	}

	public double getBicipital() {
		return bicipital;
	}

	public void setBicipital(double bicipital) {
		this.bicipital = bicipital;
	}

	public double getSubescapular() {
		return subescapular;
	}

	public void setSubescapular(double subescapular) {
		this.subescapular = subescapular;
	}

	public double getToracica() {
		return toracica;
	}

	public void setToracica(double toracica) {
		this.toracica = toracica;
	}

	public double getAxilarMedia() {
		return axilarMedia;
	}

	public void setAxilarMedia(double axilarMedia) {
		this.axilarMedia = axilarMedia;
	}

	public double getSupraIliaca() {
		return supraIliaca;
	}

	public void setSupraIliaca(double supraIliaca) {
		this.supraIliaca = supraIliaca;
	}

	public double getAbdominal() {
		return abdominal;
	}

	public void setAbdominal(double abdominal) {
		this.abdominal = abdominal;
	}

	public double getCoxa() {
		return coxa;
	}

	public void setCoxa(double coxa) {
		this.coxa = coxa;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public double getAtual() {
		return atual;
	}

	public void setAtual(double atual) {
		this.atual = atual;
	}

	
}
