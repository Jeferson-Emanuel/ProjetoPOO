import java.util.List;

@Entity
public class Fornecedor {
	
	private String nome;
	private String tipo;
	private String endereco;
	@Id
	private String contato;
	
	public Fornecedor() {
	}
//CONSTRUTOR
	public Fornecedor(String nome, String tipo, String endereco, String contato) {
		this.nome=nome;
		this.tipo=tipo;
		this.endereco=endereco;
		this.contato=contato;
	}
	
//GET's
	public String getNome() {
		return nome;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public String getContato() {
		return contato;
	}
	
//SET's
	public void setNome(String nome) {
		this.nome=nome;
	}
	
	public void setTipo(String tipo) {
		this.tipo=tipo;
	}
	
	public void setEndereco(String endereco) {
		this.endereco=endereco;
	}
	
	public void setContato(String contato) {
		this.contato=contato;
	}
	
	public interface FornecedorDAO {
		
		void salva(Fornecedor f);
		List<Fornecedor> lista();
	}
	
	public class JPAFornecedorDAO implements FornecedorDAO {
		
		public void salva(Fornecedor f) {
			EntityManager em = abreConexao();
			em.getTransaction().begin();
			
			em.persist(f);
			
			em.getTransaction().commit();
			em.close();
		}
		
		public List<Fornecedor> lista() {
			EntityManager em = abreConexao();
			
			List<Fornecedor> fornecedor = em.createQuery("select a from Fornecedor f").getResultList();
			
			em.close();
			
			return fornecedor;
		}
	}
}
