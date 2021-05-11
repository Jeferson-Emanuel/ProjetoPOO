package br.upe.ProjetoPOO.Classes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="produto")
public class Produto {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column
	private String produto;
	/*@Column
	private String nome;
	@Column
	private String tipo;*/
	@Column
	private int quant;
	@Column
	private float preco;
	/*@Column
	private boolean disp;*/
	@ManyToOne//(targetEntity = Almoxarifado.class)
	//@JoinColumn(name = "almoxarifadoId")
	private Almoxarifado controleFluxo;

	//Constructors
	public Produto() {	
	}
	public Produto(String produto, int quant, float preco, Almoxarifado controleFluxo) {
		this.produto = produto;
		this.quant = quant;
		this.preco = preco;
		this.controleFluxo = controleFluxo;
	}
	
	//Gets & Sets
	public int getId() {
		return id;
	}
	public String getProduto() {
		return produto;
	}
	public int getQuant() {
		return quant;
	}
	public float getPreco() {
		return preco;
	}
	public Almoxarifado getControleFluxo() {
		return controleFluxo;
	}
	public void setId(int id) {
		this.id=id;
	}
	public void setProduto(String produto) {
		this.produto = produto;
	}
	public void setQuant(int quant) {
		this.quant=quant;
	}
	public void setPreco(float preco) {
		this.preco=preco;
	}
	public void setControleFluxo(Almoxarifado controleFluxo) {
		this.controleFluxo = controleFluxo;
	}
}