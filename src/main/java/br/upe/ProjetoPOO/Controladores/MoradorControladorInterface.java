package br.upe.ProjetoPOO.Controladores;

import java.util.List;

import br.upe.ProjetoPOO.Classes.Morador;

public interface MoradorControladorInterface {
	
	void criarMorador(Morador novoMorador);
	void removerMorador(Morador removeMorador);
	List<Morador> lista();
	
}
