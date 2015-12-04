package com.algaworks.pedidovenda.controller;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.pedidovenda.service.NegocioException;

@Named
@RequestScoped
public class CadastroPedidoBean {
	
	private  List<Integer> itens;
	
	public CadastroPedidoBean() { 
		
		itens = new ArrayList<>();
		for(int i = 0; i<50; i++){
			itens.add(i);
		}
	}
	
	public void salvar(){
		throw new NegocioException("Pedido não pode ser salvo, pois ainda não foi implementado!");
	}
	
	public List<Integer> getItens() {
		return itens;
	}
	
	
}
