import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.pedidovenda.model.Cliente;
import com.pedidovenda.model.Endereco;
import com.pedidovenda.model.TipoPessoa;


public class Teste {
	
	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("PedidoPU");
		EntityManager manager = factory.createEntityManager();
		
		EntityTransaction trx = manager.getTransaction();
		
		trx.begin();
		
		Cliente cliente = new Cliente();
		cliente.setNome("Gustavo");
		cliente.setEmail("fabinha@gmai.com");
		cliente.setDocumentoReceitaFederal("083120746-94");
		cliente.setTipo(TipoPessoa.FISICA);
		
		Endereco endereco = new Endereco();
		
		endereco.setLogradouro("Rua das palmeiras");
		endereco.setNumero("111");
		endereco.setCidade("Rio de Janeiro");
		endereco.setComplemento("apto 201");
		endereco.setUf("RJ");
		endereco.setCep("26115-580");
		endereco.setCliente(cliente);
		
		cliente.getEnderecos().add(endereco);
		
		manager.persist(cliente);
		
		trx.commit();
		
	}
}
