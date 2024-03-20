package view;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JLabel;

/**
 * Classe che permette di recuperare l'ora, i minuti, i secondi, l'anno, il mese e il giorno attuali, 
 * che vengono costantemente aggiornati in quanto viene implementata l'interfaccia Runnable e si usa 
 * la classe come thread per le intestazioni dlle finestre EventiTecnico e EventiAdmin.
 */
public class Orologio implements Runnable{
	private GregorianCalendar gc;
	private JLabel orario;
	private JLabel data;
	
	/**
	 * Costruttore della classe Orologio
	 * @param orario la JLabel contenente l'orario
	 * @param data la JLabel contenente la data
	 */
	public Orologio(JLabel orario, JLabel data) {
		this.orario=orario;
		this.data=data;
	}
	
	/**
	 * Metodo run, in cui vengono recuperati anno, mese, giorno, ora, minuto e secondo attuali, e vengono
	 * riconvertiti in stringa.
	 */
	@Override
	public void run() {
		while(true) {
			gc=new GregorianCalendar();
			int ore=gc.get(Calendar.HOUR_OF_DAY);
			int minuti=gc.get(Calendar.MINUTE);
			int secondi=gc.get(Calendar.SECOND);
			int gS=gc.get(Calendar.DAY_OF_WEEK);
			int giornoM=gc.get(Calendar.DAY_OF_MONTH);
			int m=gc.get(Calendar.MONTH);
			int anno=gc.get(Calendar.YEAR);
			if(minuti<10 && secondi<10 ) {
				orario.setText(ore+":0"+minuti+":0"+secondi);
			}else if(minuti<10) {
				orario.setText(ore+":0"+minuti+":"+secondi);
			}else if(secondi<10) {
				orario.setText(ore+":"+minuti+":0"+secondi);
			}else {
				orario.setText(ore+":"+minuti+":"+secondi);
			}
			
			String giornoS="";
			String mese="";
			switch(gS) {
				case 1:
					giornoS="Domenica";
					break;
				case 2:
					giornoS="Lunedì";
					break;
				case 3:
					giornoS="Martedì";
					break;
				case 4:
					giornoS="Mercoledì";
					break;
				case 5:
					giornoS="Giovedì";
					break;
				case 6:
					giornoS="Venerdì";
					break;
				case 7:
					giornoS="Sabato";
					break;
					
			}
			
			switch(m) {
				case 0:
					mese="gennaio";
					break;
				case 1:
					mese="febbraio";
					break;
				case 2:
					mese="marzo";
					break;
				case 3:
					mese="aprile";
					break;
				case 4:
					mese="maggio";
					break;
				case 5:
					mese="giugno";
					break;
				case 6:
					mese="luglio";
					break;
				case 7:
					mese="agosto";
					break;
				case 8:
					mese="settembre";
					break;
				case 9:
					mese="ottobre";
					break;
				case 10:
					mese="novembre";
					break;
				case 11:
					mese="dicembre";
					break;
			}
			data.setText(giornoS+", "+giornoM+" "+mese+" "+anno);
		}
	}

}
