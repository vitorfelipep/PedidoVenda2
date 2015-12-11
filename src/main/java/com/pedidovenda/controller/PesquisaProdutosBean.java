package com.pedidovenda.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.pedidovenda.model.Produto;
import com.pedidovenda.repository.Produtos;
import com.pedidovenda.repository.filter.ProdutoFilter;

@Named
@SessionScoped
public class PesquisaProdutosBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Produto> produtosFiltrados;

	@Inject
	private Produtos produtos;

	private ProdutoFilter filtro;

	public PesquisaProdutosBean() {
		this.filtro = new ProdutoFilter();
	}

	public void pesquisar() {
		produtosFiltrados = produtos.filtrados(filtro);
	}

	public List<Produto> getProdutosFiltrados() {
		return produtosFiltrados;
	}

	public ProdutoFilter getFiltro() {
		return filtro;
	}

}
