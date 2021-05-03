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
//import javax.persistence.UniqueConstraint;

@Entity
@Table(name="apartamento"/*, uniqueConstraints={@UniqueConstraint(columnNames = {"bloco" , "numero"})}*/)
public class Apartamento {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(unique = true)
	private String bloco;
	//@Column
	//private int numero;	
	@OneToMany (mappedBy = "apt")
	List<Morador> morador;
	
//Constructors	
	public Apartamento() {
	}
	public Apartamento(String bloco/*, int numero*/) {
		this.bloco=bloco;
		//this.numero=numero;
	}

//Gets & Sets
	public int getId() {
		return id;
	}	
	public String getBloco() {
		return bloco;
	}	
	/*public int getNumero() {
		return numero;
	}*/	
	public void setId(int id) {
		this.id = id;
	}	
	public void setBloco(String bloco) {
		this.bloco=bloco;
	}
	/*public void setNumero(int numero) {
		this.numero=numero;
	}*/
	@Override
	public String toString() {
		return "Apartamento " + bloco;
	}
}
