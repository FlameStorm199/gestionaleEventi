package model;

import java.util.Comparator;

/**
 * La classe ComparaPerTecnici implementa l'interfaccia Comparator per
 * confrontare due oggetti di tipo Evento basandosi sul numero di tecnici
 * assegnati.
 */
public class ComparaPerTecnici implements Comparator<Evento> {

	/**
	 * Il metodo compare confronta due oggetti di tipo Evento basandosi sul numero
	 * di tecnici assegnati.
	 * 
	 * @param e1 Il primo oggetto di tipo Evento da confrontare
	 * @param e2 Il secondo oggetto di tipo Evento da confrontare
	 * @return -1 se il numero di tecnici del primo oggetto è inferiore al numero di
	 *         tecnici del secondo oggetto, 1 se il numero di tecnici del primo
	 *         oggetto è superiore al numero di tecnici del secondo oggetto, 0 se i
	 *         due numeri sono uguali.
	 */
	@Override
	public int compare(Evento e1, Evento e2) {

		if (e1.getNtec() > e2.getNtec()) {
			return 1;
		} else if (e1.getNtec() < e2.getNtec()) {
			return -1;
		} else {
			return 0;
		}

	}

}