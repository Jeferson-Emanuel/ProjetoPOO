package Classes;

//import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;

//@Entity //NAO CONSEGUI
@Table(name="almoxarifado")
public class Almoxarifado {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column
	private float preco;
	@Column
	private String registro_in;
	@Column
	private String registro_out;
	@Column
	private String pedido;
	@Column
	private Produto produto;

	public Almoxarifado(){	
	}
//CONSTRUTOR	
	public Almoxarifado( int id, float preco, String registro_in, String registro_out, String pedido, Produto produto) {
		this.id=id;
		this.preco=preco;
		this.registro_in=registro_in;
		this.registro_out=registro_out;
		this.pedido=pedido;
		this.produto=produto;
	}
	
//GET's	
	
	public int getId() {
		return id;
	}
	
	public float getPreco() {
		return preco;
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
		return produto;
	}

//SET's
	
	public void setId(int id) {
		this.id=id;
	}
	
	public void setPreco(float preco) {
		this.preco=preco;
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
	
	public void setProduto(int id, String nome, String tipo, int quant, float preco, boolean disp) {
		this.produto= new Produto(id, nome, tipo, quant, preco, disp);
	}
}