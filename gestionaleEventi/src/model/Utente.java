package model;

public class Utente {
	private String username;
	private String password;
	private String nome;
	private String cognome;
	private String mansione;
	private boolean admin;
	private int IDUtente;
	
	public Utente(String username, String password, String nome, String cognome, String mansione, boolean admin) {
		super();
		this.username = username;
		this.password = password;
		this.nome = nome;
		this.cognome = cognome;
		this.mansione = mansione;
		this.admin = admin;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getMansione() {
		return mansione;
	}
	public void setMansione(String mansione) {
		this.mansione = mansione;
	}
	public boolean isAdmin() {
		return admin;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public int getIDUtente() {
		return IDUtente;
	}

	public void setIDUtente(int iDUtente) {
		IDUtente = iDUtente;
	}

	@Override
	public String toString() {
		return "Dati utente:\n\tusername=" + username + "\n\tpassword=" + password + "\n\tnome=" + nome + "\n\tcognome=" + cognome
				+ "\n\tmansione=" + mansione + "\n\tadmin=" + admin;
	}
	
	
}
