package br.upe.ProjetoPOO.Classes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Column;
import javax.persistence.Table;

@Entity
@Table(name="morador")
public class Morador {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(unique = true)
	private String cpf;
	@Column
	private String nome;
	@ManyToOne
	private Apartamento apt;
	
//Constructors
	public Morador() {
	}
	public Morador(String cpf, String nome, Apartamento apt) {
		this.cpf = cpf;
		this.nome = nome;
		this.apt = apt;
	}
	
//Gets & Sets
	public int getId() {
		return id;
	}
	public String getCpf() {
		return cpf;
	}
	public String getNome() {
		return nome;
	}	
	public Apartamento getApt() {
		return apt;
	}	
	public void setId(int id) {
		this.id = id;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}	
	public void setNome(String nome) {
		this.nome = nome;
	}		
	public void setApt(Apartamento apt) {
		this.apt = apt;
	}
}
