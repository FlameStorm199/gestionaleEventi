package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.util.ArrayList;

import model.ListaEventi;
import model.RegistroUtenti;
import view.EventiAdmin;
import view.Login;

/**
 * La classe ControllerEventiAdmin implementa le interfacce ActionListener,
 * MouseListener e KeyListener, e gestisce gli eventi generati dall'interfaccia
 * grafica dell'applicazione EventiAdmin, rispondendo+ alle interazioni
 * dell'utente con gli elementi grafici.
 */
public class ControllerEventiAdmin implements ActionListener, MouseListener, KeyListener {
	private RegistroUtenti registro;
	private ListaEventi lista;
	private EventiAdmin eventi;
	private String username;

	/**
	 * Costruttore della classe ControllerEventiAdmin
	 * 
	 * @param registro Oggetto di tipo RegistroUtenti che rappresenta il registro
	 *                 degli utenti dell'applicazione
	 * @param eventi   Oggetto di tipo EventiAdmin che rappresenta l'interfaccia
	 *                 grafica dell'applicazione
	 * @param username Username dell'utente loggato
	 * @param lista    Oggetto di tipo ListaEventi che rappresenta la lista degli
	 *                 eventi dell'applicazione
	 */
	public ControllerEventiAdmin(RegistroUtenti registro, EventiAdmin eventi, String username, ListaEventi lista) {
		this.registro = registro;
		this.eventi = eventi;
		this.username = username;
		this.lista = lista;
		eventi.registraEvento(this);
		setIntestazione();
	}

	/**
	 * Metodo che recupera il nome e il cognome dell'utente loggato dal registro
	 * degli utenti e li mostra nell'intestazione dell'interfaccia grafica.
	 */
	public void setIntestazione() {
		String nome = registro.getNome(this.username);
		String cognome = registro.getCognome(this.username);

		eventi.setIntestazione(nome, cognome);
	}

	/**
	 * Metodo che gestisce l'azione dell'evento.
	 * 
	 * @param e l'evento che è stato generato
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("inserisci")) {
			eventi.inserisciEvento(this);
		}

		/*
		 * if(e.getActionCommand().equals("magazzino")) { Magazzino magazzino=new
		 * Magazzino(); //magazzino.stampaEventi(lista); ControllerMagazzino
		 * controller=new ControllerMagazzino(registro, lista, magazzino, username); }
		 */

		if (e.getActionCommand().equals("elimina")) {
			eventi.eliminaEvento(this);
		}

		if (e.getActionCommand().equals("ordina")) {
			this.ordinaEventi();
		}
		if (e.getActionCommand().equals("eventiPassati")) {
			try {
				eventi.nascondiEventiPassati(lista);
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
		}

		if (e.getActionCommand().equals("svuota")) {
			if (eventi.mostraConferma() == 0) {
				lista.svuotaLista();
				eventi.stampaEventi(lista);
			}
		}
	}

	/**
	 * Metodo che ordina gli eventi in base al tipo di ordinamento scelto
	 * dall'utente.
	 * 
	 * @param lista La lista degli eventi da ordinare
	 */
	public void ordinaEventi() {
		String scelta = eventi.getOrdinamento();
		switch (scelta) {
		case "data":
			lista.ordinaEventiCrono();
			break;
		case "nome":
			lista.ordinaEventiNome();
			break;
		case "ntec":
			lista.ordinaEventiNtec();
			break;
		default:
			break;
		}
		eventi.stampaEventi(lista);
	}

	/**
	 * Metodo che viene chiamato quando viene cliccato col mouse su un componente
	 * 
	 * @param e L'evento del mouse che è stato cliccato
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	/**
	 * Metodo che viene chiamato quando il mouse viene premuto su un componente.
	 * 
	 * @param e L'evento del mouse che è stato premuto
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	/**
	 * Questo metodo viene chiamato quando il mouse viene rilasciato su un
	 * componente.
	 * 
	 * @param e L'evento del mouse che è stato rilasciato
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
		if (e.getSource() == eventi.getLogOut()) {
			eventi.dispose();
			Login login = new Login();
			ControllerLogin controller_login = new ControllerLogin(login, registro, lista);
			login.setVisible(true);
		}
	}

	/**
	 * Metodo che viene chiamato quando il cursore del mouse entra nella zona di un
	 * componente.
	 * 
	 * @param e L'evento del mouse che è stato generato
	 */
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	/**
	 * Metodo che viene chiamato quando il cursore del mouse esce dalla zona di un
	 * componente.
	 * 
	 * @param e L'evento del mouse che è stato generato
	 */
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	/**
	 * Metodo che aggiunge un nuovo evento alla lista degli eventi.
	 * 
	 * @param nome     Il nome dell'evento da aggiungere
	 * @param data     La data dell'evento da aggiungere
	 * @param luogo    Il luogo dell'evento da aggiungere
	 * @param ntec     Il numero di tecnici necessari per l'evento da aggiungere
	 * @param mansioni L'elenco delle mansioni necessarie per l'evento da aggiungere
	 */
	public void aggiungiEvento(String nome, String data, String luogo, int ntec, ArrayList<String> mansioni) {
		lista.aggiungiEvento(nome, data, luogo, ntec, mansioni);
		eventi.stampaEventi(lista);
	}

	/**
	 * Metodo che elimina l'evento con l'indice specificato dalla lista degli
	 * eventi.
	 * 
	 * @param ind L'indice dell'evento da eliminare
	 */
	public void eliminaEvento(int ind) {
		lista.eliminaEventoIndice(ind);
		eventi.stampaEventi(lista);
	}

	/**
	 * Metodo che viene chiamato quando viene digitato un carattere sulla tastiera
	 * mentre un componente ha il focus.
	 * 
	 * @param e L'evento della tastiera che è stato generato
	 */
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	/**
	 * Metodo che viene chiamato quando viene premuto un tasto sulla tastiera mentre
	 * un componente ha il focus.
	 * 
	 * @param e L'evento della tastiera che è stato generato
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	/**
	 * Metodo che viene chiamato quando viene rilasciato un tasto sulla tastiera
	 * mentre un componente ha il focus.
	 * 
	 * @param e l'evento della tastiera che è stato generato
	 */
	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getSource() == eventi.getTextFieldRicerca()) {
			String ricerca = eventi.getRicerca();
			eventi.stampaRicerca(ricerca, lista);
		}
	}
}