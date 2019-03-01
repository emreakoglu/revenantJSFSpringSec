package com.example.primefaces;

import java.io.Serializable;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ComponentSystemEvent;

import org.springframework.stereotype.Controller;

@Controller(value = "GrowlCtrl")
public class GrowlCtrl implements Serializable {

	public void preRender(ComponentSystemEvent cse) throws AbortProcessingException {
		Map<String, Object> atributos = cse.getComponent().getAttributes();
		String error = (String) atributos.get("error");
		if (error != null && error.equals("Bad credentials")) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage("", new FacesMessage("Kullanıcı adı veya şifre hatalıdır"));
		}
	}

}
