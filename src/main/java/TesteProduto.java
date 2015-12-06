import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.pedidovenda.model.Cliente;
import com.pedidovenda.model.EnderecoEntrega;
import com.pedidovenda.model.FormaPagamento;
import com.pedidovenda.model.ItemPedido;
import com.pedidovenda.model.Pedido;
import com.pedidovenda.model.Produto;
import com.pedidovenda.model.StatusPedido;
import com.pedidovenda.model.Usuario;


public class TesteProduto {
	
	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("PedidoPU");
		EntityManager manager = factory.createEntityManager();
		
		EntityTransaction trx = manager.getTransaction();
		
		trx.begin();
		/*
		Cliente cliente = manager.find(Cliente.class, 1L);
		Produto produto = manager.find(Produto.class, 1L);
		Usuario vendedor = manager.find(Usuario.class, 1L);
		
		EnderecoEntrega enderecoEntrega = new EnderecoEntrega();
		enderecoEntrega.setLogradouro("Rua dos Mercados");
		enderecoEntrega.setNumero("225");
		enderecoEntrega.setCidade("Uberlândia");
		enderecoEntrega.setUf("MG");
		enderecoEntrega.setCep("38048-75");
		
		Pedido pedido = new Pedido();
		pedido.setCliente(cliente);
		pedido.setDataCriacao(new Date());
		pedido.setDataEntrega(new Date());
		pedido.setFormaPagamento(FormaPagamento.CARTAO_CREDITO);
		pedido.setObservacao("Pedido aberto das 08 as 18h");
		pedido.setStatus(StatusPedido.ORCAMENTO);
		pedido.setValorDesconto(BigDecimal.ZERO);
		pedido.setValorFrete(BigDecimal.ZERO);
		pedido.setValorTotal(new BigDecimal(23.3));
		pedido.setVendedor(vendedor);
		pedido.setEnderecoEntrega(enderecoEntrega);
		
		ItemPedido itemPedido = new ItemPedido();
		
		itemPedido.setProduto(produto);
		itemPedido.setQuantidade(10);
		itemPedido.setValorUnitario(new BigDecimal(2.32));
		itemPedido.setPedido(pedido);
		
		pedido.getItemPedido().add(itemPedido);
		
		manager.persist(pedido);*/
		
		trx.commit();
		
	}
}
