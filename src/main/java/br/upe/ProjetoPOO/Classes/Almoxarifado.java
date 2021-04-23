package br.upe.ProjetoPOO.Classes;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="almoxarifado")
public class Almoxarifado {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Produto> fluxoProdutos;
	//Produto produto;	
	private String tipo;
	private String data;
	
	
	/*private List<Movimentacao> movimentacao;

	public void adicionarMovimetacaoEntrada(Produto produto, int quantidade) {
		Movimentacao movimentacao = new Movimentacao();
		this.movimentacao.add(movimentacao);
		produto.setQuant(quantidade + produto.getQuant());
	}*/

//Constructor
	public Almoxarifado(){	
	}
	public Almoxarifado(List<Produto> fluxoProdutos, String tipo, String data){	
	}

//Gets & Sets
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Produto> getFluxoProdutos() {
		return fluxoProdutos;
	}

	public void setFluxoProdutos(List<Produto> fluxoProdutos) {
		this.fluxoProdutos = fluxoProdutos;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	
}