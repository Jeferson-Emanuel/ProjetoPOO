
public class Veiculo implements java.io.Serializable {
	
	private String modelo;
	private String tipo;
	private String placa;
	private String cor;
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
}