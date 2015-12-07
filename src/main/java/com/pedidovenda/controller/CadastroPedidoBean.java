package com.pedidovenda.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.pedidovenda.model.EnderecoEntrega;
import com.pedidovenda.model.Pedido;

@Named
@RequestScoped
public class CadastroPedidoBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Pedido pedido;//Objeto pedido
	private  List<Integer> itens;//Lista de itens
	
	public CadastroPedidoBean() { 
		
		this.pedido = new Pedido();
		pedido.setEnderecoEntrega(new EnderecoEntrega());
		itens = new ArrayList<>();		
		itens.add(1);
	}
	
	public void salvar(){
		
	}
	
	public List<Integer> getItens() {
		return itens;
	}

	public Pedido getPedido() {
		return pedido;
	}
	
}
