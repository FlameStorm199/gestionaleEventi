package model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * La classe RegistroUtenti rappresenta il registro degli utenti
 * dell'applicazione. Viene utilizzata per la gestione e l'accesso agli account
 * degli utenti registrati.
 */
public class RegistroUtenti {
	private ArrayList<Utente> registro;

	/**
	 * Costruttore che inizializza il registro degli utenti. Se il file
	 * "registro.txt" non esiste, ne crea uno nuovo. Legge il contenuto del file
	 * "registro.txt" e crea gli oggetti Utente corrispondenti. Nel caso in cui ci
	 * siano errori, stampa un messaggio di errore e lancia un'eccezione.
	 */
	public RegistroUtenti() {
		super();
		try {
			File file = new File("registro.txt");
			if (file.createNewFile()) {
				System.out.println("File creato: " + file.getName());
			} else {
				System.out.println("Il file esiste già.");
			}
		} catch (IOException e) {
			System.out.println("Errore.");
			e.printStackTrace();
		}
		this.registro = new ArrayList<Utente>();
		try {
			File file = new File("registro.txt");
			Scanner reader = new Scanner(file);
			while (reader.hasNextLine()) {
				String username = reader.nextLine();
				String password = reader.nextLine();
				String nome = reader.nextLine();
				String cognome = reader.nextLine();
				String mansione = reader.nextLine();
				int ad = Integer.parseInt(reader.nextLine());
				boolean admin = false;
				if (ad == 1) {
					admin = true;
				} else {
					admin = false;
				}
				Utente u = new Utente(username, password, nome, cognome, mansione, admin);
				registro.add(u);
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("Errore.");
			e.printStackTrace();
		}
		// Due utenti non possono avere lo stesso username
		/*
		 * Utente u1=new Utente("user1", "123", "Emanuele", "Celotto", "FOH engineer",
		 * false); registro.add(u1); Utente a=new Utente("admin", "456", "Erik",
		 * "Giuliano", "admin", true); registro.add(a);
		 */
	}

	/**
	 * Metodo che restituisce l'ArrayList contenente tutti gli utenti registrati nel
	 * registro.
	 * 
	 * @return ArrayList contenente tutti gli utenti registrati.
	 */
	public ArrayList<Utente> getRegistro() {
		return registro;
	}

	/**
	 * Metodo che imposta l'ArrayList degli utenti registrati nel registro.
	 * 
	 * @param ArrayList contenente tutti gli utenti registrati.
	 */
	public void setRegistro(ArrayList<Utente> registro) {
		this.registro = registro;
	}

	/**
	 * Metodo che viene utilizzato per eseguire l'accesso al sistema controllando la
	 * corrispondenza tra il nome utente e la password inseriti dall'utente e quelli
	 * presenti nel registro.
	 * 
	 * @param username Il nome utente inserito dall'utente.
	 * @param password La password inserita dall'utente.
	 * @return True se il nome utente e la password corrispondono a quelli presenti
	 *         nel registro, altrimenti false.
	 */
	public boolean eseguiAccesso(String username, String password) {
		boolean ok = false;
		int i = 0;

		while (i < registro.size() && !ok) {
			if ((registro.get(i).getUsername().equals(username)) && (registro.get(i).getPassword().equals(password))) {
				ok = true;
			} else {
				i++;
			}
		}

		return ok;
	}

	/**
	 * Metodo che viene utilizzato per cercare un utente all'interno del registro
	 * tramite il suo nome utente.
	 * 
	 * @param username Il nome utente dell'utente da cercare.
	 * @return L'indice dell'utente nel registro se l'utente è stato trovato,
	 *         altrimenti -1
	 */
	public int ricercaUtente(String username) {
		int i = 0;
		boolean ok = false;

		while (i < registro.size() && !ok) {
			if (registro.get(i).getUsername().equals(username)) {
				ok = true;
			} else {
				i++;
			}
		}

		return i;
	}

	/**
	 * Metodo che restituisce la mansione dell'utente corrispondente allo username
	 * fornito come parametro.
	 * 
	 * @param username Lo username dell'utente di cui si vuole conoscere la
	 *                 mansione.
	 * @return La mansione dell'utente corrispondente allo username fornito come
	 *         parametro.
	 */
	public String getMansione(String username) {
		return registro.get(ricercaUtente(username)).getMansione();
	}

	/**
	 * Metodo che restituisce il nome dell'utente corrispondente allo username
	 * fornito come parametro.
	 * 
	 * @param username Lo username dell'utente di cui si vuole conoscere il nome.
	 * @return Il nome dell'utente corrispondente allo username fornito come
	 *         parametro.
	 */
	public String getNome(String username) {
		return registro.get(ricercaUtente(username)).getNome();
	}

	/**
	 * Metodo che restituisce il cognome dell'utente con il nome utente specificato.
	 * 
	 * @param username Il nome utente dell'utente di cui si vuole ottenere il
	 *                 cognome
	 * @return Il cognome dell'utente
	 */
	public String getCognome(String username) {
		return registro.get(ricercaUtente(username)).getCognome();
	}

	/**
	 * Metodo che restituisce true se l'utente con il nome utente specificato ha il
	 * ruolo di amministratore, altrimenti false.
	 * 
	 * @param username il nome utente dell'utente di cui si vuole verificare il
	 *                 ruolo
	 * @return True se l'utente ha il ruolo di amministratore, altrimenti false.
	 */
	public boolean isAdmin(String username) {
		return registro.get(ricercaUtente(username)).isAdmin();
	}

	/**
	 * Metodo che restituisce una stringa che rappresenta il contenuto del registro
	 * degli utenti.
	 * 
	 * @return Una stringa che rappresenta il contenuto del registro degli utenti.
	 */
	@Override
	public String toString() {
		String out = "";
		for (int i = 0; i < registro.size(); i++) {
			out += "\n" + registro.get(i).toString();
		}
		return out;
	}

	/**
	 * Metodo che viene utilizzato per aggiungere un utente al registro e scrivere
	 * le modifiche sul file "registro.txt".
	 * 
	 * @param u L'oggetto Utente da aggiungere al registro.
	 */
	public void aggiungiUtente(Utente u) {
		registro.add(u);
		try {
			FileWriter writer = new FileWriter("registro.txt");
			for (int i = 0; i < registro.size(); i++) {
				writer.write(registro.get(i).getUsername() + "\n");
				writer.write(registro.get(i).getPassword() + "\n");
				writer.write(registro.get(i).getNome() + "\n");
				writer.write(registro.get(i).getCognome() + "\n");
				writer.write(registro.get(i).getMansione() + "\n");
				if (registro.get(i).isAdmin()) {
					writer.write("1\n");
				} else {
					writer.write("0\n");
				}
			}
			writer.close();
		} catch (IOException ex) {
			System.out.println("Errore.");
			ex.printStackTrace();
		}
	}

	/**
	 * Metodo che viene utilizzato per verificare se il registro contiene un utente
	 * con lo stesso username fornito come parametro.
	 * 
	 * @param username Lo username dell'utente da cercare nel registro.
	 * @return True se il registro contiene l'utente cercato, altrimenti false.
	 */
	public boolean contains(String username) {
		boolean trovato = false;
		int i = 0;
		while (i < registro.size() && trovato == false) {
			if (registro.get(i).getUsername().equals(username)) {
				trovato = true;
			} else {
				i++;
			}
		}
		return trovato;
	}

}
