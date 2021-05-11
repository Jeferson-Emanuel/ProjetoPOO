package br.upe.ProjetoPOO.Classes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="veiculo")
public class Veiculo {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(unique = true)
	private String placa;
	@Column
	private String descricao;
	@OneToOne
	private Apartamento apartamento;

	//Constructors	
	public Veiculo() {
	}
	public Veiculo(String placa, String descricao, Apartamento apartamento) {
		this.placa = placa;
		this.descricao = descricao;
		this.apartamento = apartamento;
	}

	//Gets & Sets
	public int getId() {
		return id;
	}
	public String getPlaca() {
		return placa;
	}
	public String getDescricao() {
		return descricao;
	}
	public Apartamento getApartamento() {
		return apartamento;
	}
	public void setId(int id) {
		this.id = id;
	}	
	public void setPlaca(String placa) {
		this.placa=placa;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public void setApartamento(Apartamento apartamento) {
		this.apartamento=apartamento;
	}
}