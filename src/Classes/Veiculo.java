package Classes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;

//@Entity
@Table(name="veiculo")
public class Veiculo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String modelo;
	@Column
	private String tipo;
	@Column
	private String placa;
	@Column
	private String cor;
	@Column
	private Morador dono;
	
	public Veiculo() {
	}
//CONSTRUTOR
	public Veiculo(int id, String modelo, String tipo, String placa, String cor, Morador dono) {
		this.id=id;
		this.modelo=modelo;
		this.tipo=tipo;
		this.placa=placa;
		this.cor=cor;
		this.dono=dono;
	}
	
//GET's
	public int getId() {
		return id;
	}

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
	public void setId(int id) {
		this.id = id;
	}
	
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
	
	public void setDono(Morador dono) {
		this.dono = dono;
	}
	/*public void setDono(String nome, int id, String tipo, Apartamento apt, Veiculo veiculo) {
		this.dono= new Morador(nome, id, tipo, apt, veiculo);
	}*/
}