package modelo.fabrica;

import modelo.LivroDAO;

public interface DAOFactory {

	public LivroDAO criarLivroDAO(String tipo);
	
}
