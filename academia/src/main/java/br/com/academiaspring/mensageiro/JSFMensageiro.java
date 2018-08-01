package br.com.academiaspring.mensageiro;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

public class JSFMensageiro {
	public static void info(String componente, String msgResumida, String msgDetalhada) {
		JSFMensageiro.informar(componente, msgResumida, msgDetalhada, FacesMessage.SEVERITY_INFO);
	}
	
	public static void info(String msgResumida, String msgDetalhada) {
		JSFMensageiro.informar(null, msgResumida, msgDetalhada, FacesMessage.SEVERITY_INFO);
	}
	
	public static void info(String msg) {
		JSFMensageiro.informar(null, msg, msg, FacesMessage.SEVERITY_INFO);
	}
	
	public static void warn(String componente, String msgResumida, String msgDetalhada) {
		JSFMensageiro.informar(componente, msgResumida, msgDetalhada, FacesMessage.SEVERITY_WARN);
	}
	
	public static void warn(String msgResumida, String msgDetalhada) {
		JSFMensageiro.informar(null, msgResumida, msgDetalhada, FacesMessage.SEVERITY_WARN);
	}
	
	public static void warn(String msg) {
		JSFMensageiro.informar(null, msg, msg, FacesMessage.SEVERITY_WARN);
	}
	
	public static void error(String componente, String msgResumida, String msgDetalhada) {
		JSFMensageiro.informar(componente, msgResumida, msgDetalhada, FacesMessage.SEVERITY_ERROR);
	}
	
	public static void error(String msgResumida, String msgDetalhada) {
		JSFMensageiro.informar(null, msgResumida, msgDetalhada, FacesMessage.SEVERITY_ERROR);
	}
	
	public static void error(String msg) {
		JSFMensageiro.informar(null, msg, msg, FacesMessage.SEVERITY_ERROR);
	}
	
	public static void fatal(String componente, String msgResumida, String msgDetalhada) {
		JSFMensageiro.informar(componente, msgResumida, msgDetalhada, FacesMessage.SEVERITY_FATAL);
	}
	
	public static void fatal(String msgResumida, String msgDetalhada) {
		JSFMensageiro.informar(null, msgResumida, msgDetalhada, FacesMessage.SEVERITY_FATAL);
	}
	
	public static void fatal(String msg) {
		JSFMensageiro.informar(null, msg, msg, FacesMessage.SEVERITY_FATAL);
	}
	
	private static void informar(String componente, String msgResumida, String msgDetalhada, Severity tipo) {
		FacesContext fc = FacesContext.getCurrentInstance();
		FacesMessage fm = new FacesMessage(tipo, msgResumida, msgDetalhada);
		fc.addMessage(componente, fm);
	}

}