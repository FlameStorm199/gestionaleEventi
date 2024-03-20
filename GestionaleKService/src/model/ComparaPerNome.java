package model;

import java.util.Comparator;

/**
 * La classe ComparaPerNome implementa l'interfaccia Comparator per confrontare
 * due oggetti di tipo Evento basandosi sul loro nome.
 */
public class ComparaPerNome implements Comparator<Evento> {

	/**
	 * Il metodo compare confronta due oggetti di tipo Evento basandosi sul loro
	 * nome.
	 * 
	 * @param e1 Il primo oggetto di tipo Evento da confrontare
	 * @param e2 Il secondo oggetto di tipo Evento da confrontare
	 * @return -1 se il nome del primo oggetto è precedente al nome del secondo
	 *         oggetto, 1 se il nome del primo oggetto è successivo al nome del
	 *         secondo oggetto, 0 se i due nomi sono uguali.
	 */
	@Override
	public int compare(Evento e1, Evento e2) {

		if (e1.getNome().compareTo(e2.getNome()) > 0) {
			return 1;
		} else if (e1.getNome().compareTo(e2.getNome()) < 0) {
			return -1;
		} else {
			return 0;
		}

	}

}