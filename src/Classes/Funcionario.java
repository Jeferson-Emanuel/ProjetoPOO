package Classes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;

@Entity
@Table(name="funcionario")
public class Funcionario {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String nome;
	@Column
	private String funcao;
	@Column
	private String endereco;
	@Column
	private String contato;
	
	public Funcionario() {
	}
//CONSTRUTOR
	public Funcionario(int id, String nome, String funcao, String endereco, String contato) {
		this.id=id;
		this.nome=nome;
		this.funcao=funcao;
		this.endereco=endereco;
		this.contato=contato;
	}
	
//GET's
	public int getId() {
		return id;
	}
	
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
	public void setId(int id) {
		this.id = id;
	}
	
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
