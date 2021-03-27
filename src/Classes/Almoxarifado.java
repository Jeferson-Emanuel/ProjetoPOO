package Classes;

//import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Table;

@Entity
@Table(name="almoxarifado")
public class Almoxarifado {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String registro_in;
	@Column
	private String registro_out;
	@Column
	private String pedido;
	
	@OneToMany
	private List<Produto> produto;

	public Almoxarifado(){	
	}
//CONSTRUTOR	
	public Almoxarifado(int id, String registro_in, String registro_out, String pedido, Produto produto) {
		this.id=id;
		this.registro_in=registro_in;
		this.registro_out=registro_out;
		this.pedido=pedido;
	}
	
//GET's	
	
	public int getId() {
		return id;
	}
	
	public String getRegistroIn() {
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
	}

//SET's
	
	public void setId(int id) {
		this.id=id;
	}
	
	public void setRegistroIn(String registro_in) {
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
	}
}