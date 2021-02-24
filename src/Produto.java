
public class Produto implements java.io.Serializable {
	
	private int id;
	private String nome;
	private String tipo;
	private int quant;
	private float preco;
	private boolean disp;
	
	public Produto() {	
	}
//CONSTRUTOR
	public Produto(int id, String nome, String tipo, int quant, float preco, boolean disp) {
		this.id=id;
		this.nome=nome;
		this.tipo=tipo;
		this.quant=quant;
		this.preco=preco;
		this.disp=disp;
	}
	
//GET's
	public int getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public int getQuant() {
		return quant;
	}
	
	public float getPreco() {
		return preco;
	}
	
	public boolean getDisp() {
		return disp;
	}
	
//SET's	
	public void setId(int id) {
		this.id=id;
	}
	
	public void setNome(String nome) {
		this.nome=nome;
	}
	
	public void setTipo(String tipo) {
		this.tipo=tipo;
	}
	
	public void setQuant(int quant) {
		this.quant=quant;
	}
	
	public void setPreco(float preco) {
		this.preco=preco;
	}
	
	public void setDisp(boolean disp) {
		this.disp=disp;
	}
}