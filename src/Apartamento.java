
public class Apartamento implements java.io.Serializable {
	
	private int bloco;
	private int numero;
	
	public Apartamento() {
	}
//CONSTRUTOR
	public Apartamento(int bloco, int numero) {
		this.bloco=bloco;
		this.numero=numero;
	}

//GET's
	public int getBloco() {
		return bloco;
	}
	
	public int getNumero() {
		return numero;
	}
	
//SET's
	public void setBloco(int bloco) {
		this.bloco=bloco;
	}
	
	public void setNumero(int numero) {
		this.numero=numero;
	}
}
