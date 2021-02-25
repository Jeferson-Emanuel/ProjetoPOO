import java.util.Calendar;

public class Reserva implements java.io.Serializable {
	
	private String tipo_espaco;
	private Calendar horaIni;
	private Calendar horaFim;
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
}
