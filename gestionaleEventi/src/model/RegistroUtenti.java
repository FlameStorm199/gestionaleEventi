package model;

import java.util.ArrayList;

public class RegistroUtenti {
	private ArrayList<Utente> registro;

	public RegistroUtenti() {
		super();
		this.registro=new ArrayList<Utente>();
		//Due utenti non possono avere lo stesso username
		Utente u1=new Utente("user", "123", "Emanuele", "Celotto", "spazzino", false);
		registro.add(u1);
		Utente u2=new Utente("admin", "456", "Erik", "Giuliano", "admin", true);
		registro.add(u2);
	}

	public ArrayList<Utente> getRegistro() {
		return registro;
	}

	public void setRegistro(ArrayList<Utente> registro) {
		this.registro = registro;
	}
	
	public boolean eseguiAccesso(String username, String password) {
		boolean ok=false;
		int i=0;
		
		while(i<registro.size()&&!ok) {
			if((registro.get(i).getUsername().equals(username))&&(registro.get(i).getPassword().equals(password))){
				ok=true;
			}else {
				i++;
			}
		}
		
		return ok;
	}
	
	public int ricercaUtente(String username) {
		int i=0;
		boolean ok=false;
		
		while(i<registro.size()&&!ok) {
			if(registro.get(i).getUsername().equals(username)){
				ok=true;
			}else {
				i++;
			}
		}
		
		return i;
	}
	
	public String getMansione(String username) {
		return registro.get(ricercaUtente(username)).getMansione();
	}
	
	public boolean isAdmin(String username) {
		return registro.get(ricercaUtente(username)).isAdmin();
	}
	
	@Override
	public String toString() {
		String out="";
		for(int i=0;i<registro.size();i++) {
			out+="\n"+registro.get(i).toString();
		}
		return out;
	}
	
	
	
}
