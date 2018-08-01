package br.com.academiaspring.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity
public class Medida implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final int IMC_DESEJADO_M = 22;
	private static final int IMC_DESEJADO_F = 21;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable=true)
	private int estatura;
	private int massa;
	private int pescoco;
	private int torax;
	private int cintura;
	private int abdomen;
	private int quadril;
	
	@Column(nullable=true)
	private int coxaMediaEsquerda
	,coxaMediaDireita
	,panturrilhaDireita
	,panturrilhaEsquerda
	,bracoDireitoRelaxado
	,bracoEsquerdoRelaxado
	,bracoDireitoContraido
	,bracoEsquerdoContraido
	,antebracoDireito
	,antebracoEsquerdo;

	@Transient
	private double imc, massaMax, massaMin, massaAlvo, massaIdeal; //CALCULO DA MEDIA DO PESO E ETC.

	@ManyToOne
	@JoinColumn
	private Cliente cliente;

	public Medida() {

	}

	// MÉTODOS
	public void calcularImc() { // IMC- indice de massa corporal
		double alturaMetros = (double)this.estatura / 100;
		this.imc = this.massa / (alturaMetros * alturaMetros);
	}
	public void calcularMassa() { // Calcular o peso Ideal, Maximo, Minimo
		double alturaMetro= (double)this.estatura/100;
		
		if(cliente.getGenero().equalsIgnoreCase("M")||cliente.getGenero().equalsIgnoreCase("Masculino"))
			this.massaIdeal= IMC_DESEJADO_M * (alturaMetro*alturaMetro);
		if(cliente.getGenero().equalsIgnoreCase("F")||cliente.getGenero().equalsIgnoreCase("Feminino"))
			this.massaIdeal= IMC_DESEJADO_F * (alturaMetro*alturaMetro);
		
		this.massaMin= (alturaMetro*alturaMetro)*18.5;
		this.massaMax= (alturaMetro*alturaMetro)*24.99;
		
		
	}
	//GETTERS E SETTERS
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getPescoco() {
		return pescoco;
	}

	public void setPescoco(int pescoco) {
		this.pescoco = pescoco;
	}

	public int getTorax() {
		return torax;
	}

	public void setTorax(int torax) {
		this.torax = torax;
	}

	public int getCintura() {
		return cintura;
	}

	public void setCintura(int cintura) {
		this.cintura = cintura;
	}

	public int getAbdomen() {
		return abdomen;
	}

	public void setAbdomen(int abdomen) {
		this.abdomen = abdomen;
	}

	public int getQuadril() {
		return quadril;
	}

	public void setQuadril(int quadril) {
		this.quadril = quadril;
	}

	public int getCoxaMediaEsquerda() {
		return coxaMediaEsquerda;
	}

	public void setCoxaMediaEsquerda(int coxaMediaEsquerda) {
		this.coxaMediaEsquerda = coxaMediaEsquerda;
	}

	public int getCoxaMediaDireita() {
		return coxaMediaDireita;
	}

	public void setCoxaMediaDireita(int coxaMediaDireita) {
		this.coxaMediaDireita = coxaMediaDireita;
	}

	public int getPanturrilhaDireita() {
		return panturrilhaDireita;
	}

	public void setPanturrilhaDireita(int panturrilhaDireita) {
		this.panturrilhaDireita = panturrilhaDireita;
	}

	public int getPanturrilhaEsquerda() {
		return panturrilhaEsquerda;
	}

	public void setPanturrilhaEsquerda(int panturrilhaEsquerda) {
		this.panturrilhaEsquerda = panturrilhaEsquerda;
	}

	public int getBracoDireitoRelaxado() {
		return bracoDireitoRelaxado;
	}

	public void setBracoDireitoRelaxado(int bracoDireitoRelaxado) {
		this.bracoDireitoRelaxado = bracoDireitoRelaxado;
	}

	public int getBracoEsquerdoRelaxado() {
		return bracoEsquerdoRelaxado;
	}

	public void setBracoEsquerdoRelaxado(int bracoEsquerdoRelaxado) {
		this.bracoEsquerdoRelaxado = bracoEsquerdoRelaxado;
	}

	public int getBracoDireitoContraido() {
		return bracoDireitoContraido;
	}

	public void setBracoDireitoContraido(int bracoDireitoContraido) {
		this.bracoDireitoContraido = bracoDireitoContraido;
	}

	public int getBracoEsquerdoContraido() {
		return bracoEsquerdoContraido;
	}

	public void setBracoEsquerdoContraido(int bracoEsquerdoContraido) {
		this.bracoEsquerdoContraido = bracoEsquerdoContraido;
	}

	public int getAntebracoDireito() {
		return antebracoDireito;
	}

	public void setAntebracoDireito(int antebracoDireito) {
		this.antebracoDireito = antebracoDireito;
	}

	public int getAntebracoEsquerdo() {
		return antebracoEsquerdo;
	}

	public void setAntebracoEsquerdo(int antebracoEsquerdo) {
		this.antebracoEsquerdo = antebracoEsquerdo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public int getEstatura() {
		return estatura;
	}

	public void setEstatura(int estatura) {
		this.estatura = estatura;
	}

	public int getMassa() {
		return massa;
	}

	public void setMassa(int massa) {
		this.massa = massa;
	}

	public double getImc() {
		return imc;
	}

	public void setImc(double imc) {
		this.imc = imc;
	}

	public double getMassaMax() {
		return massaMax;
	}

	public void setMassaMax(double massaMax) {
		this.massaMax = massaMax;
	}

	public double getMassaMin() {
		return massaMin;
	}

	public void setMassaMin(double massaMin) {
		this.massaMin = massaMin;
	}

	public double getMassaAlvo() {
		return massaAlvo;
	}

	public void setMassaAlvo(double massaAlvo) {
		this.massaAlvo = massaAlvo;
	}

	public double getMassaIdeal() {
		return massaIdeal;
	}

	public void setMassaIdeal(double massaIdeal) {
		this.massaIdeal = massaIdeal;
	}
	// HASH CODE e EQUALS

	
	

}