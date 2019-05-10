package modelo.fabrica;

import modelo.LivroDAO;
import modelo.LivroDAOBD;
import modelo.LivroDAOClasse;

public class DAOFactoryImpl implements DAOFactory {

	public LivroDAO criarLivroDAO(String tipo) {
		LivroDAO livroDAO = null;
		if (tipo.equals("BD")) {
			livroDAO = new LivroDAOBD();	
		} else if (tipo.equals("Classe")) {
			livroDAO = new LivroDAOClasse();
		}
		return livroDAO;
	}

}
