package br.upe.ProjetoPOO.DAO;

import java.util.List;
import br.upe.ProjetoPOO.Classes.Almoxarifado;

public interface AlmoxarifadoDAO {
	
	void salva(Almoxarifado a);
	Almoxarifado obterPorId(int id);
	void remove(int id);
	List<Almoxarifado> lista();
}
