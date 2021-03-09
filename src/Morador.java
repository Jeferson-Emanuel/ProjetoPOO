import java.util.List;

@Entity
public class Morador {
	
	private String nome;
	@Id
	private int id;
	private String tipo;
	private Apartamento apt;
	private Veiculo veiculo;
	
	public Morador() {
	}
//CONSTRUTOR
	public Morador(String nome, int id, String tipo, Apartamento apt, Veiculo veiculo) {
		this.nome=nome;
		this.id=id;
		this.tipo=tipo;
		this.apt=apt;
		this.veiculo=veiculo;
	}
	
//GET's
	public String getNome() {
		return nome;
	}
	
	public int getId() {
		return id;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public Apartamento getApt() {
		return apt;
	}
	
	public Veiculo getVeiculo() {
		return veiculo;
	}
	
//SET's
	public void setNome(String nome) {
		this.nome=nome;
	}
	
	public void setId(int id) {
		this.id=id;
	}
	
	public void setTipo(String tipo) {
		this.tipo=tipo;
	}
	
	public void setApt(Apartamento apt) {
		this.apt=apt;
	}
	
	public void setVeiculo(Veiculo veiculo) {
		this.veiculo=veiculo;
	}
	
	public interface MoradorDAO {
		
		void salva(Morador m);
		List<Morador> lista();
	}
	
	public class JPAMoradorDAO implements MoradorDAO {
		
		public void salva(Morador m) {
			EntityManager em = abreConexao();
			em.getTransaction().begin();
			
			em.persist(m);
			
			em.getTransaction().commit();
			em.close();
		}
		
		public List<Morador> lista() {
			EntityManager em = abreConexao();
			
			List<Morador> morador = em.createQuery("select a from Morador m").getResultList();
			
			em.close();
			
			return morador;
		}
	}
}

