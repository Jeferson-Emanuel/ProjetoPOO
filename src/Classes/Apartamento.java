package Classes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.OneToMany;

//import java.util.List;

import javax.persistence.Column;
import javax.persistence.Table;

@Entity
@Table(name="apartamento")
public class Apartamento {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String bloco;
	@Column
	private int numero;
	
	/*@OneToMany (mappedBy="apt")
	private List<Morador> moradores;*/
	
	public Apartamento() {
	}
//CONSTRUTOR
	public Apartamento(int id, String bloco, int numero) {
		this.id=id;
		this.bloco=bloco;
		this.numero=numero;
	}

//GET's
	public int getId() {
		return id;
	}
	
	public String getBloco() {
		return bloco;
	}
	
	public int getNumero() {
		return numero;
	}
	
//SET's
	public void setId(int id) {
		this.id = id;
	}
	
	public void setBloco(String bloco) {
		this.bloco=bloco;
	}

	public void setNumero(int numero) {
		this.numero=numero;
	}
}
