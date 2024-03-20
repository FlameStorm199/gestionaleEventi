package model;

import java.util.ArrayList;

public class ListaEventi {
	private ArrayList<Evento> lista;
	
	public ListaEventi() {
		lista=new ArrayList<Evento>();
	}

	public ArrayList<Evento> getLista() {
		return lista;
	}

	public void setLista(ArrayList<Evento> lista) {
		this.lista = lista;
	}
	
	public boolean aggiungiEvento(String nome, Data data, String luogo, ArrayList<String> tecnici, ArrayList<String> materiale) {
		int eventID=lista.get(lista.size()-1).getEventID()+1;
		
		Evento e=new Evento(nome, data, luogo, tecnici, materiale, eventID);
		
		return lista.add(e);
	}
	
	public int ricercaEvento(String nome) {
		int j=0;
		int ric=-1;
		for(int i=0;i<lista.size();i++) {
			if(lista.get(i).getNome().equals(nome)) {
				j++;
				ric=i;
			}
		}
		
		if(ric==-1) {
			return -1;
		}else if(j==1) {
			return ric;
		}else {
			return j;
		}
	}
	
	public int eliminaEvento(String nome) {
		int res=this.ricercaEvento(nome);
		
		if(res==-1) {
			return -1;
		}else if(res>1) {
			return 2;
		}else {
			lista.remove(res);
			return 0;
		}
	}
}
