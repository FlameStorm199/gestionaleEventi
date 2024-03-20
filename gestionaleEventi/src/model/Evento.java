package model;

import java.util.ArrayList;

public class Evento {
	private String nome;
	private Data data;
	private String luogo;
	private ArrayList<String> tecnici;
	private ArrayList<String> materiale;
	private int eventID;
	
	public Evento(String nome, Data data, String luogo, ArrayList<String> tecnici, ArrayList<String> materiale, int eventID) {
		this.nome=nome;
		this.data=data;
		this.luogo=luogo;
		this.tecnici=tecnici;
		this.materiale=materiale;
		this.eventID=eventID;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}

	public String getLuogo() {
		return luogo;
	}

	public void setLuogo(String luogo) {
		this.luogo = luogo;
	}

	public ArrayList<String> getTecnici() {
		return tecnici;
	}

	public void setTecnici(ArrayList<String> tecnici) {
		this.tecnici = tecnici;
	}

	public ArrayList<String> getMateriale() {
		return materiale;
	}

	public void setMateriale(ArrayList<String> materiale) {
		this.materiale = materiale;
	}

	public int getEventID() {
		return eventID;
	}

	/*public void setEventID(int eventID) {
		this.eventID = eventID;
	}*/
	
	
}
