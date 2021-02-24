
public class Funcionario implements java.io.Serializable {
	
	private String nome;
	private String funcao;
	private String endereco;
	private String contato;
	
	public Funcionario() {
	}
//CONSTRUTOR
	public Funcionario(String nome, String funcao, String endereco, String contato) {
		this.nome=nome;
		this.funcao=funcao;
		this.endereco=endereco;
		this.contato=contato;
	}
	
//GET's
	public String getNome() {
		return nome;
	}
	
	public String getFuncao() {
		return funcao;
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
	
	public void setFuncao(String funcao) {
		this.funcao=funcao;
	}
	
	public void setEndereco(String endereco) {
		this.endereco=endereco;
	}
	
	public void setContato(String contato) {
		this.contato=contato;
	}
}
