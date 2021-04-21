package br.upe.ProjetoPOO.Classes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Column;
import javax.persistence.Table;

@Entity
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
	@OneToOne
	private Apartamento apartamento;
	
//Constructors	
	public Veiculo() {
	}
	public Veiculo(String modelo, String tipo, String placa, String cor) {
		this.modelo=modelo;
		this.tipo=tipo;
		this.placa=placa;
		this.cor=cor;
//		this.apartamento=apartamento;
	}
	
//Gets & Sets
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
	public Apartamento getApartamento() {
		return apartamento;
	}
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
	public void setApartamento(Apartamento apartamento) {
		this.apartamento=apartamento;
	}
}