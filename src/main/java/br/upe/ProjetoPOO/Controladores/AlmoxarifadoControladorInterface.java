package br.upe.ProjetoPOO.Controladores;

import java.util.List;

import br.upe.ProjetoPOO.Classes.Almoxarifado;

public interface AlmoxarifadoControladorInterface {
	
	void registroAlmoxarifado(Almoxarifado novoAlmoxarifado);
	void removeAlmoxarifado(Almoxarifado removeAlmoxarifado);
	Almoxarifado obterPorId(Almoxarifado obterAlmoxarifado);
	List<Almoxarifado> lista();
}
