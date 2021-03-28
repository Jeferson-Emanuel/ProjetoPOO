package Classes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Column;
import javax.persistence.Table;

@Entity
@Table(name="morador")
public class Morador {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String nome;
	@Column
	private String tipo;
	@ManyToOne
	private Apartamento apt;
	
//Constructors
	public Morador() {
	}
	public Morador(int id, String nome, String tipo, Apartamento apt) {
		this.id=id;
		this.nome=nome;
		this.tipo=tipo;
		this.apt=apt;
	}
	
//Gets & Sets
	public int getId() {
		return id;
	}	
	public String getNome() {
		return nome;
	}	
	public String getTipo() {
		return tipo;
	}	
	public Apartamento getApt() {
		return apt;
	}	
	public void setId(int id) {
		this.id=id;
	}	
	public void setNome(String nome) {
		this.nome=nome;
	}	
	public void setTipo(String tipo) {
		this.tipo=tipo;
	}	
	public void setApt(Apartamento apt) {
		this.apt = apt;
	}
}
