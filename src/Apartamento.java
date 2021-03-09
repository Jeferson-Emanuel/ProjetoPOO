
import java.util.List;

@Entity
public class Apartamento {
	
	private int bloco;
	@Id
	private int numero;
	
	public Apartamento() {
	}
//CONSTRUTOR
	public Apartamento(int bloco, int numero) {
		this.bloco=bloco;
		this.numero=numero;
	}

//GET's
	public int getBloco() {
		return bloco;
	}
	
	public int getNumero() {
		return numero;
	}
	
//SET's
	public void setBloco(int bloco) {
		this.bloco=bloco;
	}
	
	public void setNumero(int numero) {
		this.numero=numero;
	}
	
	public interface ApartamentoDAO {
		
		void salva(Apartamento ap);
		List<Apartamento> lista();
	}
	
	public class JPAApartamentoDAO implements ApartamentoDAO {
		
		public void salva(Apartamento ap) {
			EntityManager em =  abreConexao();
			em.getTransaction().begin();
			
			em.persist(ap);
			
			em.getTransaction().commit();
			em.close();
		}
		
		public List<Apartamento> lista() {
			EntityManager em = abreConexao();
			
			List<Apartamento> apartamento = em.createQuery("select a from Apartamento ap").getResultList();
			
			em.close();
			
			return apartamento;
		}
		
	}
}
