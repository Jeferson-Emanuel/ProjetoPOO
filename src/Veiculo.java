
import java.util.List;

@Entity
public class Veiculo {
	
	private String modelo;
	private String tipo;
	private String placa;
	private String cor;
	@Id
	private Morador dono;
	
	public Veiculo() {
	}
//CONSTRUTOR
	public Veiculo(String modelo, String tipo, String placa, String cor, Morador dono) {
		this.modelo=modelo;
		this.tipo=tipo;
		this.placa=placa;
		this.cor=cor;
		this.dono=dono;
	}
	
//GET's
	public String getModelo() {
		return modelo;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public String getPlaca() {
		return placa;
	}
	
	public String getCor() {
		return cor;
	}
	
	public Morador getDono() {
		return dono;
	}
	
//SET's
	public void setModelo(String modelo) {
		this.modelo=modelo;
	}
	
	public void setTipo(String tipo) {
		this.tipo=tipo;
	}
	
	public void setPlaca(String placa) {
		this.placa=placa;
	}
	
	public void setCor(String cor) {
		this.cor=cor;
	}
	
	public void setDono(String nome, int id, String tipo, Apartamento apt, Veiculo veiculo) {
		this.dono= new Morador(nome, id, tipo, apt, veiculo);
	}
	
	public interface VeiculoDAO {
		
		void salva(Veiculo v);
		List<Veiculo> lista();
	}
	
	public class JPAVeiculoDAO implements VeiculoDAO {
		
		public void salva(Veiculo v) {
			EntityManager em = abreConexao();
			em.getTransaction().begin();
			
			em.persist(v);
			
			em.getTransaction().commit();
			em.close();
		}
		
		public List<Veiculo> lista() {
			EntityManager em = abreConexao();
			
			List<Veiculo> veiculo = em.createQuery("select a from Veiculo v").getResultList();
			
			em.close();
			
			return veiculo;
		}
	}
}
