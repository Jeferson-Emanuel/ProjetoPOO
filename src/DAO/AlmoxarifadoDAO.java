package DAO;

import java.util.List;
import Classes.Almoxarifado;

public interface AlmoxarifadoDAO {
	
	void salva(Almoxarifado a);
	Almoxarifado obterPorId(int id);
	Almoxarifado remove(int id);
	List<Almoxarifado> lista();
}
