package main;

import java.awt.EventQueue;

import control.ControllerLogin;
import model.ListaEventi;
import model.RegistroUtenti;
import view.Login;

/**
 * Classe che contiene il metodo main per l'avvio dell'applicazione.
 */
public class Main{

	/**
	 * Metodo principale per l'avvio dell'applicazione.
	 *  
	 * @param args Argomenti della linea di comando
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login login = new Login();
					RegistroUtenti registro=new RegistroUtenti();
					ListaEventi lista=new ListaEventi();
					ControllerLogin controller_login=new ControllerLogin(login, registro, lista);
					login.setVisible(true);
				
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
