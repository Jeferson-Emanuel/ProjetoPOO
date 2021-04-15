package Classes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;

@Entity
@Table(name="fornecedor")
public class Fornecedor {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String nome;
	@Column
	private String tipo;
	@Column
	private String endereco;
	@Column
	private String contato;
	
//Constructors
	public Fornecedor() {
	}
	public Fornecedor(int id, String nome, String tipo, String endereco, String contato) {
		this.id=id;
		this.nome=nome;
		this.tipo=tipo;
		this.endereco=endereco;
		this.contato=contato;
	}
	
//Gets & Sets
	public int getId() {
		return id;
	}	
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
	public void setId(int id) {
		this.id=id;
	}	
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
