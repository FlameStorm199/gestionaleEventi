package model;

/**
 * La classe Utente rappresenta un utente del sistema.
 */
public class Utente {
	private String username;
	private String password;
	private String nome;
	private String cognome;
	private String mansione;
	private boolean admin;

	/**
	 * Costruttore della classe Utente.
	 * 
	 * @param username Lo username dell'utente
	 * @param password La password dell'utente
	 * @param nome     Il nome dell'utente
	 * @param cognome  Il cognome dell'utente
	 * @param mansione La mansione dell'utente
	 * @param admin    True se l'utente è un amministratore, altrimenti false
	 */
	public Utente(String username, String password, String nome, String cognome, String mansione, boolean admin) {
		super();
		this.username = username;
		this.password = password;
		this.nome = nome;
		this.cognome = cognome;
		this.mansione = mansione;
		this.admin = admin;
	}

	/**
	 * Metodo che restituisce il nome utente dell'utente.
	 * 
	 * @return Il nome utente dell'utente
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Metodo che imposta il nome utente dell'utente.
	 * 
	 * @param username Il nuovo nome utente dell'utente
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Metodo che restituisce la password dell'utente.
	 * 
	 * @return La password dell'utente
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Metodo che imposta la password dell'utente.
	 * 
	 * @param password La nuova password dell'utente
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Metodo che restituisce il nome dell'utente.
	 * 
	 * @return Il nome dell'utente
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Metodo che imposta il nome dell'utente.
	 * 
	 * @param nome Il nuovo nome dell'utente
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Metodo che restituisce il cognome dell'utente.
	 * 
	 * @return Il cognome dell'utente
	 */
	public String getCognome() {
		return cognome;
	}

	/**
	 * Metodo che imposta il cognome dell'utente.
	 * 
	 * @param cognome Il nuovo cognome dell'utente
	 */
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	/**
	 * Metodo che restituisce la mansione dell'utente.
	 * 
	 * @return La mansione dell'utente
	 */
	public String getMansione() {
		return mansione;
	}

	/**
	 * Metodo che imposta la mansione dell'utente.
	 * 
	 * @param mansione La nuova mansione dell'utente
	 */
	public void setMansione(String mansione) {
		this.mansione = mansione;
	}

	/**
	 * Metodo che verifica se l'utente ha privilegi di amministratore.
	 * 
	 * @return True se l'utente ha privilegi di amministratore, altrimenti false
	 */
	public boolean isAdmin() {
		return admin;
	}

	/**
	 * Metodo che imposta i privilegi di amministratore per l'utente.
	 * 
	 * @param admin True se l'utente ha privilegi di amministratore, altrimenti
	 *              false
	 */
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	/**
	 * Metodo che restituisce una stringa che rappresenta l'oggetto corrente.
	 * 
	 * @return Una stringa che rappresenta l'oggetto corrente
	 */
	@Override
	public String toString() {
		return "Dati utente:\n\tusername=" + username + "\n\tpassword=" + password + "\n\tnome=" + nome + "\n\tcognome="
				+ cognome + "\n\tmansione=" + mansione + "\n\tadmin=" + admin;
	}

}
