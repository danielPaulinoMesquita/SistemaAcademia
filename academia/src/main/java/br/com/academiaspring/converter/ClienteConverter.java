package br.com.academiaspring.converter;


import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.academiaspring.modelo.Cliente;
import br.com.academiaspring.repository.ClienteRepository;

@Component
public class ClienteConverter implements Converter {

	@Autowired
	ClienteRepository clienteDao;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String matricula) {
		if (matricula.isEmpty()||matricula==null)
			return null;

		try {
			Cliente cliente = new Cliente();
			cliente = clienteDao.findOne(Long.parseLong(matricula));
			return cliente;
		} catch (Exception nm) {
			nm.printStackTrace();
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object cliente) {
	
		if(cliente instanceof Cliente) {
		return String.valueOf(((Cliente) cliente).getMatricula());
		
		}else {
		return "Erro na conversão do objeto para string";
		}
	}

}
