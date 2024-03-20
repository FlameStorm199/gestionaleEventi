package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

import model.ListaEventi;
import model.RegistroUtenti;
import model.Utente;
import view.EventiAdmin;
import view.EventiTecnico;
import view.Login;

/**
 * La classe ControllerLogin implementa l'interfaccia ActionListener e gestisce
 * le interazioni dell'utente con la finestra di login.
 */
public class ControllerLogin implements ActionListener {
	private Login login;
	private RegistroUtenti registro;
	private ListaEventi lista;

	/**
	 * 
	 * Costruttore della classe ControllerLogin
	 * 
	 * @param login    Finestra di login
	 * @param registro Registro degli utenti
	 * @param lista    Lista degli eventi
	 */
	public ControllerLogin(Login login, RegistroUtenti registro, ListaEventi lista) {
		this.login = login;
		this.registro = registro;
		this.lista = lista;
		login.registraEvento(this);
	}

	/**
	 * Metodo che gestisce l'evento generato dalla pressione dal tasto di login o di
	 * aggiunta di un utente
	 * 
	 * @param e Evento generato
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if ("login".equals(e.getActionCommand())) {
			gestisciLogin(login, registro);
		}

		if (e.getActionCommand().equals("aggiungi")) {
			login.aggiungiUtenteGUI(this, registro);
		}
	}

	/**
	 * Metodo che gestisce l'accesso dell'utente al programma
	 * 
	 * @param login    Finestra di login
	 * @param registro Registro degli utenti
	 */
	public void gestisciLogin(Login login, RegistroUtenti registro) {
		String username = login.getUsername();
		String password = login.getPassword();
		if (registro.eseguiAccesso(username, password)) {
			login.dispose();
			controllaFinestraEventi(username);
		} else {
			JOptionPane.showMessageDialog(login, "Username o password errati!");
		}
	}

	/**
	 * Metodo che controlla quale finestra mostrare all'utente in funzione della sua
	 * mansione e del suo tipo di account
	 * 
	 * @param username Username dell'utente
	 */
	public void controllaFinestraEventi(String username) {
		String mansione = registro.getMansione(username);
		boolean admin = registro.isAdmin(username);

		if (admin) {
			EventiAdmin eventi = new EventiAdmin();
			eventi.stampaEventi(lista);
			ControllerEventiAdmin controller_eventi = new ControllerEventiAdmin(registro, eventi, username, lista);
		} else {
			EventiTecnico eventi = new EventiTecnico();
			eventi.stampaEventi(lista, mansione);
			ControllerEventiTecnico controller_eventi = new ControllerEventiTecnico(registro, eventi, mansione,
					username, lista);
		}
	}

	/**
	 * Metodo che permette di aggiungere un nuovo utente al registro
	 * 
	 * @param username Useranme dell'utente
	 * @param password Password dell'utente
	 * @param nome     Nome dell'utente
	 * @param cognome  cognome dell'utente
	 * @param mansione Mansione dell'utente
	 * @param admin    Tipo di account dell'utente
	 */
	public void aggiungiUtenteController(String username, String password, String nome, String cognome, String mansione,
			boolean admin) {
		Utente u = new Utente(username, password, nome, cognome, mansione, admin);
		registro.aggiungiUtente(u);
	}

}