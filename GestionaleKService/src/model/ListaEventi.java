package model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * La classe ListaEventi gestisce e rappresenta la lista degli Eventi
 */
public class ListaEventi {
	private ArrayList<Evento> lista;

	/**
	 * Costruttore della classe ListaEventi. Viene creato il file "lista.txt". Se
	 * non esiste e viene inizializzata la lista degli eventi.
	 */
	public ListaEventi() {
		try {
			File file = new File("lista.txt");
			if (file.createNewFile()) {
				System.out.println("File creato: " + file.getName());
			} else {
				System.out.println("Il file esiste già.");
			}
		} catch (IOException e) {
			System.out.println("Errore.");
			e.printStackTrace();
		}
		lista = new ArrayList<Evento>();
		try {
			File file = new File("lista.txt");
			Scanner reader = new Scanner(file);
			while (reader.hasNextLine()) {
				String nome = reader.nextLine();
				String data = reader.nextLine();
				String luogo = reader.nextLine();
				int ntec = Integer.parseInt(reader.nextLine());
				int size = Integer.parseInt(reader.nextLine());
				ArrayList<String> mansioni = new ArrayList<String>();
				for (int i = 0; i < size; i++) {
					mansioni.add(reader.nextLine());
				}
				Evento e = new Evento(nome, data, luogo, ntec, mansioni);
				lista.add(e);
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("Errore.");
			e.printStackTrace();
		}
	}

	/**
	 * Metodo che restituisce la lista degli eventi.
	 * 
	 * @return La lista degli eventi.
	 */
	public ArrayList<Evento> getLista() {
		return lista;
	}

	/**
	 * Metodo per impostare la lista degli eventi.
	 * 
	 * @param lista ArrayList di oggetti di tipo Evento da impostare come lista
	 *              degli eventi.
	 */
	public void setLista(ArrayList<Evento> lista) {
		this.lista = lista;
	}

	/**
	 * Metodo che aggiunge un nuovo evento alla lista degli eventi.
	 * 
	 * @param nome     Ll nome dell'evento
	 * @param data     La data dell'evento
	 * @param luogo    Il luogo dell'evento
	 * @param ntec     Il numero dei tecnici per l'evento
	 * @param mansioni L'elenco delle mansioni necessarie per l'evento
	 */
	public void aggiungiEvento(String nome, String data, String luogo, int ntec,
			ArrayList<String> mansioni /* ,ArrayList<String> materiale */) {
		Evento e = new Evento(nome, data, luogo, ntec, mansioni/* , materiale, */);
		lista.add(e);
		try {
			FileWriter writer = new FileWriter("lista.txt");
			for (int i = 0; i < lista.size(); i++) {
				writer.write(lista.get(i).getNome() + "\n");
				writer.write(lista.get(i).getData() + "\n");
				writer.write(lista.get(i).getLuogo() + "\n");
				writer.write(String.valueOf(lista.get(i).getNtec()) + "\n");
				writer.write(String.valueOf(lista.get(i).getMansioni().size()) + "\n");
				for (int j = 0; j < lista.get(i).getMansioni().size(); j++) {
					writer.write(lista.get(i).getMansioni().get(j) + "\n");
				}
			}
			writer.close();
		} catch (IOException ex) {
			System.out.println("Errore.");
			ex.printStackTrace();
		}
	}

	/**
	 * Metodo che ricerca un evento nella lista degli eventi.
	 * 
	 * @param evento   Il nome dell'evento
	 * @param data     La data dell'evento
	 * @param luogo    Il luogo dell'evento
	 * @param ntec     Il numero dei tecnici per l'evento
	 * @param mansioni L'elenco delle mansioni necessarie per l'evento
	 * @return L'indice dell'evento nella lista, -1 se l'evento non è stato trovato
	 */
	public int ricercaEvento(String evento, String data, String luogo, int ntec, String mansioni) {
		boolean ok = false;
		int i = 0;

		while (i < lista.size() && !ok) {
			if (lista.get(i).getNome().equals(evento) && lista.get(i).getData().equals(data)
					&& lista.get(i).getLuogo().equals(luogo) && lista.get(i).getNtec() == ntec
					&& lista.get(i).stampaMansioni().equals(mansioni)) {
				ok = true;
			} else {
				i++;
			}
		}

		return i;
	}

	/**
	 * Metodo che elimina un evento dalla lista degli eventi in base all'indice
	 * fornito come parametro.
	 * 
	 * @param ind L'indice dell'evento da eliminare
	 */
	public void eliminaEventoIndice(int ind) {
		lista.remove(ind);
		try {
			FileWriter writer = new FileWriter("lista.txt");
			for (int i = 0; i < lista.size(); i++) {
				writer.write(lista.get(i).getNome() + "\n");
				writer.write(lista.get(i).getData() + "\n");
				writer.write(lista.get(i).getLuogo() + "\n");
				writer.write(String.valueOf(lista.get(i).getNtec()) + "\n");
				writer.write(String.valueOf(lista.get(i).getMansioni().size()) + "\n");
				for (int j = 0; j < lista.get(i).getMansioni().size(); j++) {
					writer.write(lista.get(i).getMansioni().get(j) + "\n");
				}
			}
			writer.close();
		} catch (IOException ex) {
			System.out.println("Errore.");
			ex.printStackTrace();
		}
	}

	/**
	 * Metodo che restituisce la dimensione della lista degli eventi.
	 * 
	 * @return La dimensione della lista degli eventi.
	 */
	public int size() {
		return lista.size();
	}

	/**
	 * Metodo che restituisce l'evento nella posizione specificata nella lista degli
	 * eventi.
	 * 
	 * @param i La posizione dell'evento da restituire.
	 * @return L'evento nella posizione specificata nella lista degli eventi.
	 */
	public Evento get(int i) {
		return lista.get(i);
	}

	/**
	 * Medoto che ordina gli eventi in base alla data cronologica, utilizzando la
	 * classe @link {ComparaPerData}. Aggiorna il file "lista.txt" con gli eventi
	 * ordinati.
	 */
	public void ordinaEventiCrono() {
		Collections.sort(this.lista, new ComparaPerData());
		try {
			FileWriter writer = new FileWriter("lista.txt");
			for (int i = 0; i < lista.size(); i++) {
				writer.write(lista.get(i).getNome() + "\n");
				writer.write(lista.get(i).getData() + "\n");
				writer.write(lista.get(i).getLuogo() + "\n");
				writer.write(String.valueOf(lista.get(i).getNtec()) + "\n");
				writer.write(String.valueOf(lista.get(i).getMansioni().size()) + "\n");
				for (int j = 0; j < lista.get(i).getMansioni().size(); j++) {
					writer.write(lista.get(i).getMansioni().get(j) + "\n");
				}
			}
			writer.close();
		} catch (IOException ex) {
			System.out.println("Errore.");
			ex.printStackTrace();
		}
	}

	/**
	 * Metodo che ordina gli eventi della lista in ordine alfabetico per nome,
	 * usando la classe @link {Collections} e la classe @link {ComparaPerNome}.
	 * Salvando la lista nel file di testo "lista.txt"
	 */
	public void ordinaEventiNome() {
		Collections.sort(this.lista, new ComparaPerNome());
		try {
			FileWriter writer = new FileWriter("lista.txt");
			for (int i = 0; i < lista.size(); i++) {
				writer.write(lista.get(i).getNome() + "\n");
				writer.write(lista.get(i).getData() + "\n");
				writer.write(lista.get(i).getLuogo() + "\n");
				writer.write(String.valueOf(lista.get(i).getNtec()) + "\n");
				writer.write(String.valueOf(lista.get(i).getMansioni().size()) + "\n");
				for (int j = 0; j < lista.get(i).getMansioni().size(); j++) {
					writer.write(lista.get(i).getMansioni().get(j) + "\n");
				}
			}
			writer.close();
		} catch (IOException ex) {
			System.out.println("Errore.");
			ex.printStackTrace();
		}
	}

	/**
	 * Metodo che ordina gli eventi in base al numero di tecnici necessari, usando
	 * la classe @link {ComparaPerTecnici} e aggiorna il file "lista.txt"
	 */
	public void ordinaEventiNtec() {
		Collections.sort(this.lista, new ComparaPerTecnici());
		try {
			FileWriter writer = new FileWriter("lista.txt");
			for (int i = 0; i < lista.size(); i++) {
				writer.write(lista.get(i).getNome() + "\n");
				writer.write(lista.get(i).getData() + "\n");
				writer.write(lista.get(i).getLuogo() + "\n");
				writer.write(String.valueOf(lista.get(i).getNtec()) + "\n");
				writer.write(String.valueOf(lista.get(i).getMansioni().size()) + "\n");
				for (int j = 0; j < lista.get(i).getMansioni().size(); j++) {
					writer.write(lista.get(i).getMansioni().get(j) + "\n");
				}
			}
			writer.close();
		} catch (IOException ex) {
			System.out.println("Errore.");
			ex.printStackTrace();
		}
	}

	/**
	 * Metodo che scrive un evento nel file "lista.txt".
	 * 
	 * @param e L'evento da scrivere nel file.
	 */
	public void scriviEvento(Evento e) {
		try {
			FileWriter writer = new FileWriter("lista.txt");
			writer.write(e.getNome() + "\n");
			writer.write(e.getData() + "\n");
			writer.write(e.getLuogo() + "\n");
			writer.write(String.valueOf(e.getNtec()) + "\n");
			writer.write(String.valueOf(e.getMansioni().size()) + "\n");
			for (int i = 0; i < e.getMansioni().size(); i++) {
				writer.write(e.getMansioni().get(i) + "\n");
			}
			writer.close();
		} catch (IOException ex) {
			System.out.println("Errore.");
			ex.printStackTrace();
		}

	}

	/**
	 * Metodo che svuota la lista degli eventi e cancella il contenuto del file di
	 * testo "lista.txt".
	 */
	public void svuotaLista() {
		try {
			FileWriter writer = new FileWriter("lista.txt");
			writer.close();
		} catch (IOException ex) {
			System.out.println("Errore.");
			ex.printStackTrace();
		}

		lista.clear();
	}
}
