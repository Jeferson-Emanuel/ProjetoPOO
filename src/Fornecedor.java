
public class Fornecedor implements java.io.Serializable {
	
	private String nome;
	private String tipo;
	private String endereco;
	private String contato;
	
	public Fornecedor() {
	}
//CONSTRUTOR
	public Fornecedor(String nome, String tipo, String endereco, String contato) {
		this.nome=nome;
		this.tipo=tipo;
		this.endereco=endereco;
		this.contato=contato;
	}
	
//GET's
	public String getNome() {
		return nome;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public String getContato() {
		return contato;
	}
	
//SET's
	public void setNome(String nome) {
		this.nome=nome;
	}
	
	public void setTipo(String tipo) {
		this.tipo=tipo;
	}
	
	public void setEndereco(String endereco) {
		this.endereco=endereco;
	}
	
	public void setContato(String contato) {
		this.contato=contato;
	}
}
