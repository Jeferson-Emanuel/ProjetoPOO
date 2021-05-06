package br.upe.ProjetoPOO.Classes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
//import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import java.util.List;

//import java.util.List;

import javax.persistence.Column;
import javax.persistence.Table;

@Entity
@Table(name="apartamento")
public class Apartamento {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(unique = true)
	private String bloco;
	@OneToMany (mappedBy = "apt")
	List<Morador> morador;
	@OneToOne (mappedBy = "apartamento")
	Veiculo veiculo;
	
//Constructors	
	public Apartamento() {
	}
	public Apartamento(String bloco) {
		this.bloco=bloco;
	}

//Gets & Sets
	public int getId() {
		return id;
	}	
	public String getBloco() {
		return bloco;
	}	
	public void setId(int id) {
		this.id = id;
	}	
	public void setBloco(String bloco) {
		this.bloco=bloco;
	}

	@Override
	public String toString() {
		return "Apartamento " + bloco;
	}
}
