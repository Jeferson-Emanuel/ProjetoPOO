package br.upe.ProjetoPOO.Classes;

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

	@Column(unique = true)
	private String cpf;
	@Column
	private String nome;
	@Column
	private String funcao;
	@Column
	private String endereco;
	@Column
	private String contato;

	/**
	 * Constructors da classe
	 */
	public Funcionario() {
	}
	public Funcionario(String cpf) {
		this.cpf=cpf;
	}
	public Funcionario(String cpf, String nome, String funcao, String endereco, String contato) {
		this.cpf=cpf;
		this.nome=nome;
		this.funcao=funcao;
		this.endereco=endereco;
		this.contato=contato;
	}

/**
 * M�todos de get e set
 *  @return Retorna nos m�todos get, o valor pedido do objeto da classe
 *  e os set definem o valor do objeto
 */
	public int getId() {
		return id;
	}
	public String getCpf() {
		return cpf;
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
	public void setId(int id) {
		this.id = id;
	}
	public void setCpf(String cpf) {
		this.cpf=cpf;
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