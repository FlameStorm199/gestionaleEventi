package model;

import java.util.ArrayList;

/**
 * La classe Evento rappresenta un evento con un nome, una data, un luogo, un
 * numero di tecnici e un elenco di mansioni.
 */
public class Evento {
	private String nome;
	private String data;
	private String luogo;
	private int ntec;
	private ArrayList<String> mansioni;

	/**
	 * Costruisce un nuovo oggetto Evento
	 * 
	 * @param nome     Il nome dell'evento.
	 * @param data     La data dell'evento
	 * @param luogo    Il luogo dell'evento
	 * @param ntec     Il numero dei tecnici per l'evento
	 * @param mansioni L'elenco delle mansioni necessarie per l'evento.
	 */
	public Evento(String nome, String data, String luogo, int ntec, ArrayList<String> mansioni) {
		this.nome = nome;
		this.data = data;
		this.luogo = luogo;
		this.ntec = ntec;
		this.mansioni = mansioni;
	}

	/**
	 * Meotodo che restituisce il nome dell'evento.
	 * 
	 * @return Il nome dell'evento
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Metodo che imposta il nome dell'evento.
	 * 
	 * @param nome Il nuovo nome da impostare.
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Meotodo che restituisce la data dell'evento.
	 * 
	 * @return La data dell'evento
	 */
	public String getData() {
		return data;
	}

	/**
	 * Metodo che imposta la data dell'evento.
	 * 
	 * @param data La nuova data da impostare
	 */
	public void setData(String data) {
		this.data = data;
	}

	/**
	 * Metodo che restituisce il luogo dell'evento.
	 * 
	 * @return Il luogo dell'evento
	 */
	public String getLuogo() {
		return luogo;
	}

	/**
	 * Metodo che imposta il luogo dell'evento
	 * 
	 * @param luogo Il nuovo luogo dell'evento
	 */
	public void setLuogo(String luogo) {
		this.luogo = luogo;
	}

	/**
	 * Metodo che restituisce l'elenco delle mansioni necessarie per l'evento.
	 * 
	 * @return L'elenco delle mansioni necessarie per l'evento.
	 */
	public ArrayList<String> getMansioni() {
		return mansioni;
	}

	/**
	 * Metodo che imposta l'elenco delle mansioni necessarie per l'evento.
	 * 
	 * @param mansioni Il nuovo elenco di mansioni da impostare.
	 */
	public void setMansioni(ArrayList<String> mansioni) {
		this.mansioni = mansioni;
	}

	/**
	 * Metodo che restituisce il numero di tecnici necessari per l'evento.
	 * 
	 * @return Il numero di tecnici necessari per l'evento.
	 */
	public int getNtec() {
		return ntec;
	}

	/**
	 * Metodo che imposta il numero di tecnici necessari per l'evento.
	 * 
	 * @param ntec Il nuovo numero di tecnici da impostare.
	 */
	public void setNtec(int ntec) {
		this.ntec = ntec;
	}

	/**
	 * Metodo che crea una stringa contenente l'elenco delle mansioni necessarie per
	 * l'evento.
	 * 
	 * @return Una stringa contenente l'elenco delle mansioni necessarie per
	 *         l'evento.
	 */
	public String stampaMansioni() {
		String out = "";
		for (int i = 0; i < mansioni.size(); i++) {
			out += "<html><div style='padding: 5px'>" + mansioni.get(i) + "</div>";
		}
		return out;
	}

}