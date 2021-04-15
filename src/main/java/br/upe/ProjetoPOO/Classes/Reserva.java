package Classes;

//import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;

@Entity
@Table(name="reserva")
public class Reserva {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String tipo_espaco;
	@Column
	private String horaIni;
	@Column
	private String horaFim;
	@Column
	private String data;

//Constructors	
	public Reserva() {
	}
	public Reserva(int id, String tipo_espaco, String horaIni, String horaFim, String data) {
		this.id=id;
		this.tipo_espaco=tipo_espaco;
		this.horaIni=horaIni;
		this.horaFim=horaFim;
		this.data=data;
	}
	
//Gets & Sets
	public int getId() {
		return id;
	}	
	public String getTipo_espaco() {
		return tipo_espaco;
	}	
	public String getHoraIni() {
		return horaIni;
	}	
	public String getHoraFim() {
		return horaFim;
	}	
	public String getData() {
		return data;
	}	
	public void setId(int id) {
		this.id = id;
	}	
	public void setTipo_espaco(String tipo_espaco) {
		this.tipo_espaco = tipo_espaco;
	}	
	public void setHoraIni(String horaIni) {
		this.horaIni=horaIni;
	}	
	public void setHoraFim(String horaFim) {
		this.horaFim=horaFim;
	}	
	public void setData(String data) {
		this.data=data;
	}
}
