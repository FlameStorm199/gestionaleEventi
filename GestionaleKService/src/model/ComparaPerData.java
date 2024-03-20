package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

/**
 * La classe ComparaPerData implementa l'interfaccia Comparator per comparare
 * due oggetti di tipo Evento in base alla data.
 */
public class ComparaPerData implements Comparator<Evento> {

	/**
	 * Il metodo compare confronta due oggetti di tipo Evento in base alla data.
	 * 
	 * @param e1 L'evento da confrontare con e2
	 * @param e2 L'evento da confrontare con e1
	 * @return -1 se la data del primo oggetto è precedente alla data del secondo
	 *         oggetto, 1 se la data del primo oggetto è successiva alla data del
	 *         secondo oggetto, e 0 se le due date sono uguali.
	 */
	@Override
	public int compare(Evento e1, Evento e2) {
		Date data1;
		Date data2;
		try {
			data1 = new SimpleDateFormat("dd-MM-yyyy").parse(e1.getData());
			data2 = new SimpleDateFormat("dd-MM-yyyy").parse(e2.getData());
			if (data1.compareTo(data2) > 0) {
				return 1;
			} else if (data1.compareTo(data2) < 0) {
				return -1;
			} else {
				return 0;
			}
		} catch (ParseException e) {
			e.printStackTrace();
			return 0;
		}

	}

}
