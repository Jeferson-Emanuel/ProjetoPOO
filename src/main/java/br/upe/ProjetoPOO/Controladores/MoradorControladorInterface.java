package br.upe.ProjetoPOO.Controladores;

import java.util.List;

import br.upe.ProjetoPOO.Classes.Morador;

public interface MoradorControladorInterface {
	
	void criarMorador(Morador novoMorador) throws Exception;
	Morador obterPorCpf(Morador obterMorador) throws Exception;
	void removerMorador(Morador removeMorador) throws Exception;
	List<Morador> lista();
	
}
