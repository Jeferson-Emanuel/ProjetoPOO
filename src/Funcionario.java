
import java.util.List;

@Entity
public class Funcionario {
	
	private String nome;
	private String funcao;
	private String endereco;
	@Id
	private String contato;
	
	public Funcionario() {
	}
//CONSTRUTOR
	public Funcionario(String nome, String funcao, String endereco, String contato) {
		this.nome=nome;
		this.funcao=funcao;
		this.endereco=endereco;
		this.contato=contato;
	}
	
//GET's
	public String getNome() {
		return nome;
	}
	
	public String getFuncao() {
		return funcao;
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
	
	public void setFuncao(String funcao) {
		this.funcao=funcao;
	}
	
	public void setEndereco(String endereco) {
		this.endereco=endereco;
	}
	
	public void setContato(String contato) {
		this.contato=contato;
	}
	
	public interface FuncionarioDAO {
		
		void salva(Funcionario func);
		List<Funcionario> lista();
	}
	
	public class JPAFuncionarioDAO implements FuncionarioDAO {
		
		public void salva(Funcionario func) {
			EntityManager em = abreConexao();
			em.getTransaction().begin();
			
			em.persist(func);
			
			em.getTransaction().commit();
			em.close();
		}
		
		public List<Funcionario> lista() {
			EntityManager em = abreConexao();
			
			List<Funcionario> funcionario = em.createQuery("Select a from Funcionario func").getResultList();
			
			em.close();
			
			return funcionario;
		}
	}
}
