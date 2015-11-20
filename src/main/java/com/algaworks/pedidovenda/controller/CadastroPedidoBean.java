package com.algaworks.pedidovenda.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class CadastroPedidoBean {
	
	private  List<Integer> itens;
	
	public CadastroPedidoBean() {
		
		itens = new ArrayList<>();
		for(int i = 0; i<50; i++){
			itens.add(i);
		}
	}

	public List<Integer> getItens() {
		return itens;
	}
}
