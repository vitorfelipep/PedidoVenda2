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


public class TestePedido {
	
	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("PedidoPU");
		EntityManager manager = factory.createEntityManager();
		
		EntityTransaction trx = manager.getTransaction();
		
		trx.begin();
		
		Cliente cliente = manager.find(Cliente.class, 2L);
		Produto produto = manager.find(Produto.class, 1L);
		Produto produto2 = manager.find(Produto.class, 2L);
		Usuario vendedor = manager.find(Usuario.class, 1L);
		
		EnderecoEntrega enderecoEntrega = new EnderecoEntrega();
		enderecoEntrega.setLogradouro("Rua dos Mercados");
		enderecoEntrega.setNumero("680");
		enderecoEntrega.setCidade("Uberlândia");
		enderecoEntrega.setUf("MG");
		enderecoEntrega.setCep("38048-75");
		
		Pedido pedido = new Pedido();
		pedido.setCliente(cliente);
		pedido.setDataCriacao(new Date());
		pedido.setDataEntrega(new Date());
		pedido.setFormaPagamento(FormaPagamento.BOLETO_BANCARIO);
		pedido.setObservacao("aberto das 08 as 18h");
		pedido.setStatus(StatusPedido.ORCAMENTO);
		pedido.setValorDesconto(BigDecimal.ZERO);
		pedido.setValorFrete(BigDecimal.ZERO);
		pedido.setValorTotal(new BigDecimal(1820.3));
		pedido.setVendedor(vendedor);
		pedido.setEnderecoEntrega(enderecoEntrega);
		
		ItemPedido itemPedido = new ItemPedido();
		ItemPedido itemPedido2 = new ItemPedido();
		itemPedido.setProduto(produto);
		itemPedido.setQuantidade(5);
		itemPedido.setValorUnitario(new BigDecimal(2.32));
		itemPedido.setPedido(pedido);
		
		itemPedido2.setProduto(produto2);
		itemPedido2.setQuantidade(300);
		itemPedido2.setValorUnitario(new BigDecimal(5.99));
		itemPedido2.setPedido(pedido);
		
		pedido.getItemPedido().add(itemPedido);
		pedido.getItemPedido().add(itemPedido2);
		
		manager.persist(pedido);
		
		trx.commit();
		
	}
}
