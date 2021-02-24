
public class Almoxarifado implements java.io.Serializable {
	
	private float preco;
	private String registro_in;
	private String registro_out;
	private String pedido;
	private int id;
	private Produto produto;
	
	public Almoxarifado(){	
	}
//CONSTRUTOR	
	public Almoxarifado(float preco, String registro_in, String registro_out, String pedido, int id, Produto produto) {
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
	
	public String getRegistroIn() {
		return registro_in;
	}
	
	public String getRegistroOut() {
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
	
	public void setRegistroIn(String registro_in) {
		this.registro_in=registro_in;
	}
	
	public void setRegistroOut(String registro_out) {
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

VRAU