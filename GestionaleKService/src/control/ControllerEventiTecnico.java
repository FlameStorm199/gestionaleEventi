package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;

import model.ListaEventi;
import model.RegistroUtenti;
import view.EventiTecnico;
import view.Login;

/**
 * La classe ControllerEventiTecnico gestisce gli eventi generati
 * dall'interfaccia grafica degli Eventi Tecnico, implementa le interfacce
 * ActionListener, MouseListener e KeyListener per gestire rispettivamente gli
 * eventi generati dai pulsanti e caselle di testo,dai click del mouse e dalla
 * pressione dei pulsanti.
 */
public class ControllerEventiTecnico implements ActionListener, MouseListener, KeyListener {
	private RegistroUtenti registro;
	private EventiTecnico eventi;
	private String mansione;
	private String username;
	private ListaEventi lista;

	/**
	 * Costruttore della classe ControllerEventiTecnico
	 * 
	 * @param registro Il registro degli utenti registrati nel sistema
	 * @param eventi   La finestra degli Eventi Tecnico
	 * @param mansione La mansione dell'utente che utilizza il sistema
	 * @param username Lo username dell'utente che utilizza il sistema
	 * @param lista    La lista degli eventi presenti nel sistema
	 */
	public ControllerEventiTecnico(RegistroUtenti registro, EventiTecnico eventi, String mansione, String username,
			ListaEventi lista) {
		this.registro = registro;
		this.eventi = eventi;
		this.mansione = mansione;
		this.username = username;
		this.lista = lista;
		eventi.registraEvento(this);
		setIntestazione();
	}

	/**
	 * Imposta l'intestazione della finestra degli Eventi Tecnico con il nome, il
	 * cognome e la mansione dell'utente.
	 */
	public void setIntestazione() {
		String nome = registro.getNome(this.username);
		String cognome = registro.getCognome(this.username);
		String mansione = registro.getMansione(this.username);

		eventi.setIntestazione(nome, cognome, mansione);
	}

	/**
	 * Metodo che viene chiamato quando un evento viene attivato. Gestisce l'azione
	 * da compiere in base all'evento scatenante.
	 * 
	 * @param e L'evento scatenante
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
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
	}

	/**
	 * Metodo che ordina la lista degli eventi in base alla scelta effettuata
	 * dall'utente tramite l'interfaccia grafica. La lista può essere ordinata per
	 * data, per nome dell'evento oppure per il numero dei tecnici richiesti.
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
		eventi.stampaEventi(lista, mansione);
	}

	/**
	 * Metodo che viene invocato quando viene effettuato un click con il mouse su un
	 * componente. Il metodo non effettua alcuna operazione.
	 * 
	 * @param e L'evento generato dal click del mouse
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	/**
	 * Metodo che viene chiamato quando un pulsante del mouse viene premuto. In
	 * questa implementazione, il metodo è vuoto e non effettua alcuna operazione.
	 * 
	 * @param e L'evento del mouse generato
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	/**
	 * Metodo che viene richiamato quando il tasto del mouse viene rilasciato su un
	 * componente della finestra controllatta dall'eggetto ControllerEventiTecnico.
	 * 
	 * @param e L'evento del mouse che ha causato l'invocazione del metodo
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
	 * Metodo che viene chiamato quando il cursore del mouse entra nella zona
	 * occupata dal componente su cui è stato registrato l'evento,
	 * 
	 * @param e L'evento che invoca questo metodo
	 */
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	/**
	 * Metodo che viene chiamato quando il cursore del mouse esce dalla zona
	 * occupata dal componente su cui è stato registrato l'evento.
	 * 
	 * @param e L'evento che invoca questo metodo
	 */
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	/**
	 * Metodo che viene chiamato quando un tasto viene digitato sulla tastiera.
	 * 
	 * @param e L'evento che invoca questo metodo
	 */
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	/**
	 * Metodo che viene chiamato quando un tasto viene premuto sulla tastiera.
	 * 
	 * @param e L'evento che invoca questo metodo
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	/**
	 * Metodo che viene chiamato quando un tasto viene rilasciato sulla tastiera.
	 * 
	 * @param e L'evento che ha causato l'invocazione di questo metodo
	 */
	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getSource() == eventi.getTextFieldRicerca()) {
			String ricerca = eventi.getRicerca();
			eventi.stampaRicerca(ricerca, lista, mansione);
		}
	}
}