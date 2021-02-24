
public class Reserva implements java.io.Serializable {
	
	private String tipo_espaco;
	private String horaIni;
	private String horaFim;
	private String data;
	
	public Reserva() {
	}
//CONSTRUTOR
	public Reserva(String tipo_espaco, String horaIni, String horaFim, String data) {
		this.tipo_espaco=tipo_espaco;
		this.horaIni=horaIni;
		this.horaFim=horaFim;
		this.data=data;
	}
	
//GET's
	public String getEspaco() {
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
	
//SET's
	public void setEspaco(String tipo_espaco) {
		this.tipo_espaco=tipo_espaco;
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
