import java.util.Calendar;

public class Almoxarifado implements java.io.Serializable {
	
	private float preco;
	private Calendar registro_in;
	private Calendar registro_out;
	private String pedido;
	private int id;
	private Produto produto;
	
	public Almoxarifado(){	
	}
//CONSTRUTOR	
	public Almoxarifado(float preco, Calendar registro_in, Calendar registro_out, String pedido, int id, Produto produto) {
		this.preco=preco;
		this.registro_in=registro_in;
		this.registro_out=registro_out;
		this.pedido=pedido;
		this.id=id;
		this.produto=produto;
	}
	
//GETs	
	public float getPreco() {
		return preco;
	}
	
	public Calendar getRegistroIn() {
		return registro_in;
	}
	
	public Calendar getRegistroOut() {
		return registro_out;
	}
	
	public String getPedido() {
		return pedido;
	}
	
	public int getId() {
		return id;
	}
	
	public Produto getProduto() {
		return produto;
	}

//SETs
	public void setPreco(float preco) {
		this.preco=preco;
	}
	
	public void setRegistroIn(Calendar registro_in) {
		this.registro_in=registro_in;
	}
	
	public void setRegistroOut(Calendar registro_out) {
		this.registro_out=registro_out;
	}
	
	public void setPedido(String pedido) {
		this.pedido=pedido;
	}
	
	public void setId(int id) {
		this.id=id;
	}
	
	public void setProduto(int id, String nome, String tipo, int quant, float preco, boolean disp) {
		this.produto= new Produto(id, nome, tipo, quant, preco, disp);
	}
}
