package com.pedidovenda.util.jsf;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class FacesUtil {
	
	public static boolean isPostBack(){
		return FacesContext.getCurrentInstance().isPostback();
	}
	
	
	public static boolean isNotPostBack(){
		return !isPostBack();
	}
	
	public static void addErrorMesage(String message){
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message));
	}
	
	public static void addInfoMesage(String message){
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
	}
}
