package Classes;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name="almoxarifado")
public class Almoxarifado {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	//@Column
	//private String registro_in;
	//@Column
	//private String registro_out;
	//@Column
	//private String pedido;
	
	@OneToMany(mappedBy = "almoxarifado", cascade=CascadeType.ALL)
	private List<Produto> produtosEntrada;
	@OneToMany(mappedBy = "almoxarifado", cascade=CascadeType.ALL)
	private List<Produto> produtosSaida;
	@Column
	private String data;
	

	public Almoxarifado(){	
	}
//CONSTRUTOR
	/*public Almoxarifado(int id, List<Produto> produtosEntrada, List<Produto> produtosSaida, String data) {
		this.id=id;
		this.produtosEntrada= produtosEntrada;
		this.produtosSaida= produtosSaida;
		this.data=data;
	}*/
	/*public Almoxarifado(int id, String registro_in, String registro_out, String pedido, Produto produto) {
		this.id=id;
		this.registro_in=registro_in;
		this.registro_out=registro_out;
		//this.pedido=pedido;
	}*/
	
//GET's	
	
	public int getId() {
		return id;
	}
	
	public List<Produto> getProdutosEntrada() {
		return produtosEntrada;
	}
	
	public List<Produto> getProdutosSaida() {
		return produtosSaida;
	}
	
	public String getData() {
		return data;
	}
	
	/*public String getRegistroIn() {
		return registro_in;
	}
	
	public String getRegistroOut() {
		return registro_out;
	}
	
	public String getPedido() {
		return pedido;
	}
	
	public Produto getProduto() {
		return (Produto) produto;
	}*/

//SET's
	
	public void setId(int id) {
		this.id=id;
	}
	
	public void setProdutosEntrada(List<Produto> produtosEntrada) {
		this.produtosEntrada = produtosEntrada;
	}
	
	public void setProdutosSaida(List<Produto> produtosSaida) {
		this.produtosSaida = produtosSaida;
	}
	
	public void setData(String data) {
		this.data = data;
	}	
	
	
	/*public void setRegistroIn(String registro_in) {
		this.registro_in=registro_in;
	}
	
	public void setRegistroOut(String registro_out) {
		this.registro_out=registro_out;
	}
	
	public void setPedido(String pedido) {
		this.pedido=pedido;
	}
	
	@SuppressWarnings("unchecked")
	public void setProduto(Produto produto) {
		this.produto= (List<Produto>) produto;
	}*/
}