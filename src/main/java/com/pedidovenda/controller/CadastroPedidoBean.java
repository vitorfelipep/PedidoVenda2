package com.pedidovenda.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.pedidovenda.model.Cliente;
import com.pedidovenda.model.EnderecoEntrega;
import com.pedidovenda.model.FormaPagamento;
import com.pedidovenda.model.Pedido;
import com.pedidovenda.model.Usuario;
import com.pedidovenda.repository.Clientes;
import com.pedidovenda.repository.Usuarios;
import com.pedidovenda.service.CadastroPedidoService;
import com.pedidovenda.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroPedidoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Usuarios usuarios;

	@Inject
	private Clientes clientes;

	@Inject
	private CadastroPedidoService cadastroPedidoService;

	private Pedido pedido;// Objeto pedido

	private List<Usuario> vendedores;

	public CadastroPedidoBean() {

		limpar();
	}

	public void inicializar() {
		if (FacesUtil.isNotPostBack()) {
			vendedores = usuarios.vendedores();
			
			this.recalcularPedido();
		}
	}

	private void limpar() {
		this.pedido = new Pedido();
		pedido.setEnderecoEntrega(new EnderecoEntrega());
	}

	public void salvar() {
		this.pedido = cadastroPedidoService.salvar(this.pedido);

		FacesUtil.addInfoMesage("Pedido salvo com sucesso!");
	}
	
	public void recalcularPedido(){
		if(this.pedido != null){
			this.pedido.recalcularValorTotal();
		}
	}

	// autoComplete do cliente
	public List<Cliente> completarCliente(String nome) {
		return this.clientes.porNome(nome);
	}

	public FormaPagamento[] getFormasPagamento() {
		return FormaPagamento.values();
	}

	public boolean isEditando() {
		return this.pedido.getId() != null;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public List<Usuario> getVendedores() {
		return vendedores;
	}

}
