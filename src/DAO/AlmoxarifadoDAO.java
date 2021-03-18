package DAO;

import java.util.List;
import Classes.Almoxarifado;

public interface AlmoxarifadoDAO {
	
	void salva(Almoxarifado a);
	void remove(Almoxarifado a);
	List<Almoxarifado> lista();
}
