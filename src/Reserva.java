import java.util.Calendar;
import java.util.List;

@Entity
public class Reserva {
	
	private String tipo_espaco;
	private Calendar horaIni;
	private Calendar horaFim;
	@Id
	private Calendar data;
	
	public Reserva() {
	}
//CONSTRUTOR
	public Reserva(String tipo_espaco, Calendar horaIni, Calendar horaFim, Calendar data) {
		this.tipo_espaco=tipo_espaco;
		this.horaIni=horaIni;
		this.horaFim=horaFim;
		this.data=data;
	}
	
//GET's
	public String getEspaco() {
		return tipo_espaco;
	}
	
	public Calendar getHoraIni() {
		return horaIni;
	}
	
	public Calendar getHoraFim() {
		return horaFim;
	}
	
	public Calendar getData() {
		return data;
	}
	
//SET's
	public void setEspaco(String tipo_espaco) {
		this.tipo_espaco=tipo_espaco;
	}
	
	public void setHoraIni(Calendar horaIni) {
		this.horaIni=horaIni;
	}
	
	public void setHoraFim(Calendar horaFim) {
		this.horaFim=horaFim;
	}
	
	public void setData(Calendar data) {
		this.data=data;
	}
	
	public interface ReservaDAO {
		
		void salva(Reserva r);
		List<Reserva> lista();
	}
	
	public class JPAReservaDAO implements ReservaDAO {
		
		public void salva(Reserva r) {
			EntityManager em = abreConexao();
			em.getTransaction().begin();
			
			em.persist(r);
			
			em.getTransaction().commit();
			em.close();
		}
		
		public List<Reserva> lista() {
			EntityManager em = abreConexao();
			
			List<Reserva> reserva = em.createQuery("select a from Reserva r").getResultList();
			
			em.close();
			
			return reserva;
		}
	}
}
