package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import control.ControllerEventiAdmin;
import datechooser.beans.DateChooserCombo;
import model.ListaEventi;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Frame;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JScrollPane;
import javax.swing.border.MatteBorder;
import javax.swing.plaf.FontUIResource;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import java.awt.Toolkit;

/**
 * La classe EventiAdmin crea, con la lbreria Java.swing un'interfaccia grafica
 * per l'utente loggato come admin.
 */
public class EventiAdmin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblLogo, lblNome, lblCognome, lblRuolo, logOut, lblInserimento, lblElimina, lblRicerca,
			lblEventiPassati, lblOrdina, lblOrario, lblData, lblEliminaTutto;
	private JTable table;
	private JButton btnInserisci, btnOrdina, btnCerca, btnElimina, btnEliminaTutto;
	private JScrollPane scrollPane_1;
	private DefaultTableModel model;
	private JTextField textFieldRicerca;
	private JCheckBox chckbxEventiPassati;

	/**
	 * Costruttore della classe EventiAdmin
	 */
	public EventiAdmin() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(EventiAdmin.class.getResource("/images/k_firma_mail.jpg")));
		setTitle("Finestra admin");
		setBackground(new Color(0, 0, 0));
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		/**
		 * Crea una JLabel per l'orario e la data attuali, implementati con i thread
		 */
		lblOrario = new JLabel("orario orario orario orario");
		lblOrario.setBounds(22, 10, 105, 31);
		lblOrario.setForeground(new Color(255, 255, 255));
		lblOrario.setFont(new Font("Century Gothic", Font.PLAIN, 19));
		lblData = new JLabel("data data data data data data data data data data");
		lblData.setBounds(22, 40, 388, 36);
		lblData.setForeground(new Color(255, 255, 255));
		lblData.setFont(new Font("Century Gothic", Font.PLAIN, 19));
		Thread t = new Thread(new Orologio(lblOrario, lblData));
		t.start();
		contentPane.setLayout(null);
		contentPane.add(lblOrario);
		contentPane.add(lblData);

		/**
		 * Crea una JLabel per l'immagine
		 */
		lblLogo = new JLabel("");
		lblLogo.setBounds(543, 0, 450, 130);
		lblLogo.setForeground(new Color(0, 0, 0));
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setIcon(new ImageIcon("src/images/logo_bianco03 (Personalizzato).png"));
		contentPane.add(lblLogo);

		/**
		 * Crea una JLabel per il nome dell'utente
		 */
		lblNome = new JLabel("nome");
		lblNome.setBounds(1291, 11, 227, 31);
		lblNome.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNome.setForeground(new Color(255, 255, 255));
		lblNome.setFont(new Font("Century Gothic", Font.PLAIN, 17));
		contentPane.add(lblNome);

		/**
		 * Crea una JLabel per il cognome dell'utente
		 */
		lblCognome = new JLabel("cognome");
		lblCognome.setBounds(1291, 40, 227, 31);
		lblCognome.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCognome.setForeground(Color.WHITE);
		lblCognome.setFont(new Font("Century Gothic", Font.PLAIN, 17));
		contentPane.add(lblCognome);

		/**
		 * Crea una JLabel per il ruolo dell'utente
		 */
		lblRuolo = new JLabel("ruolo");
		lblRuolo.setBounds(1291, 73, 227, 31);
		lblRuolo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRuolo.setForeground(Color.WHITE);
		lblRuolo.setFont(new Font("Century Gothic", Font.PLAIN, 17));
		contentPane.add(lblRuolo);

		/**
		 * Crea una JLabel per il bottone di LOG OUT
		 */
		logOut = new JLabel("LOG OUT");
		logOut.setBounds(1291, 108, 227, 31);
		logOut.setHorizontalAlignment(SwingConstants.RIGHT);
		logOut.setForeground(Color.WHITE);
		logOut.setFont(new Font("Century Gothic", Font.BOLD, 17));
		logOut.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		contentPane.add(logOut);

		/**
		 * Crea uno ScrollPane
		 */
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 240, 1533, 557);

		/**
		 * Crea una tabella contenente gli eventi con i parametri specifici
		 */
		table = new JTable();
		model = new DefaultTableModel(new Object[][] {},
				new String[] { "Evento", "Data", "Luogo", "N. Tecnici", "Crew" }) {
			Class[] columnTypes = new Class[] { String.class, String.class, String.class, Integer.class, String.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}

			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table.setModel(model);
		scrollPane_1.setViewportView(table);
		table.setForeground(Color.WHITE);
		table.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		table.setBorder(new MatteBorder(1, 2, 1, 1, (Color) new Color(255, 255, 255)));
		table.setBackground(new Color(0, 0, 0));
		contentPane.add(scrollPane_1);

		/**
		 * Crea un JButton per l'inserimento di un nuovo evento
		 */
		btnInserisci = new JButton("Inserisci");
		btnInserisci.setBackground(Color.WHITE);
		btnInserisci.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		btnInserisci.setBounds(253, 160, 112, 22);
		btnInserisci.setActionCommand("inserisci");
		btnInserisci.setFocusPainted(false);
		contentPane.add(btnInserisci);

		/**
		 * Crea una JLabel per l'inserimento
		 */
		lblInserimento = new JLabel("Inserisci un nuovo evento:");
		lblInserimento.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lblInserimento.setForeground(new Color(255, 255, 255));
		lblInserimento.setBackground(new Color(0, 0, 0));
		lblInserimento.setBounds(22, 153, 245, 36);
		contentPane.add(lblInserimento);

		/**
		 * Crea un JButton per l'eliminazione di un evento
		 */
		btnElimina = new JButton("Elimina");
		btnElimina.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		btnElimina.setFocusPainted(false);
		btnElimina.setBackground(Color.WHITE);
		btnElimina.setActionCommand("elimina");
		btnElimina.setBounds(729, 160, 112, 22);
		contentPane.add(btnElimina);

		/**
		 * Crea una JTextField per la ricerca di un evento
		 */
		textFieldRicerca = new JTextField();
		textFieldRicerca.setBounds(1170, 160, 227, 22);
		contentPane.add(textFieldRicerca);
		textFieldRicerca.setColumns(10);

		/**
		 * Crea una JLabel per l'eliminazione dell'evento selezionato
		 */
		lblElimina = new JLabel("Elimina evento/i selezionato/i:");
		lblElimina.setForeground(Color.WHITE);
		lblElimina.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lblElimina.setBackground(Color.BLACK);
		lblElimina.setBounds(474, 153, 245, 36);
		contentPane.add(lblElimina);

		/**
		 * Crea una JLabel per cercare il nome dell'evento
		 */
		lblRicerca = new JLabel("Digita il nome di un evento:");
		lblRicerca.setForeground(Color.WHITE);
		lblRicerca.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lblRicerca.setBackground(Color.BLACK);
		lblRicerca.setBounds(930, 153, 237, 36);
		contentPane.add(lblRicerca);

		/**
		 * Crea una JButton per l'immagine della lente d'ingrandimento
		 */
		btnCerca = new JButton("");
		btnCerca.setIcon(new ImageIcon("src/images/190821_glass_720x720 (Personalizzato).png"));
		btnCerca.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		btnCerca.setFocusPainted(false);
		btnCerca.setBackground(Color.WHITE);
		btnCerca.setActionCommand("cerca");
		btnCerca.setBounds(1397, 160, 22, 22);
		contentPane.add(btnCerca);

		/**
		 * Crea una JLabel per nascondere gli eventi passati
		 */
		lblEventiPassati = new JLabel("Non mostrare eventi passati");
		lblEventiPassati.setForeground(Color.WHITE);
		lblEventiPassati.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lblEventiPassati.setBackground(Color.BLACK);
		lblEventiPassati.setBounds(53, 192, 227, 36);
		contentPane.add(lblEventiPassati);

		/**
		 * Crea una JCheckBox per nascondere gli eventi passati
		 */
		chckbxEventiPassati = new JCheckBox("");
		chckbxEventiPassati.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxEventiPassati.setBackground(Color.BLACK);
		chckbxEventiPassati.setBounds(22, 196, 30, 31);
		chckbxEventiPassati.setActionCommand("eventiPassati");
		contentPane.add(chckbxEventiPassati);

		/**
		 * Crea una JLabel per ordinare gli eventi
		 */
		lblOrdina = new JLabel("Ordina gli eventi per criterio:");
		lblOrdina.setForeground(Color.WHITE);
		lblOrdina.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lblOrdina.setBackground(Color.BLACK);
		lblOrdina.setBounds(1037, 192, 227, 36);
		contentPane.add(lblOrdina);

		/**
		 * Crea una JButton per ordinare gli eventi
		 */
		btnOrdina = new JButton("Ordina");
		btnOrdina.setBounds(1274, 202, 123, 21);
		btnOrdina.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		btnOrdina.setBackground(Color.WHITE);
		btnOrdina.setFocusPainted(false);
		btnOrdina.setActionCommand("ordina");
		contentPane.add(btnOrdina);

		/**
		 * Crea una JLabel per eliminare tutti gli eventi
		 */
		lblEliminaTutto = new JLabel("Elimina tutti gli eventi:");
		lblEliminaTutto.setForeground(Color.WHITE);
		lblEliminaTutto.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lblEliminaTutto.setBackground(Color.BLACK);
		lblEliminaTutto.setBounds(494, 194, 245, 36);
		contentPane.add(lblEliminaTutto);

		/**
		 * Crea un JButton per eliminare tutti gli eventi
		 */
		btnEliminaTutto = new JButton("Elimina tutto");
		btnEliminaTutto.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		btnEliminaTutto.setFocusPainted(false);
		btnEliminaTutto.setBackground(Color.WHITE);
		btnEliminaTutto.setActionCommand("svuota");
		btnEliminaTutto.setBounds(683, 203, 138, 22);
		contentPane.add(btnEliminaTutto);

		/**
		 * Crea un oggetto DefaultTableCellRenderer per centrare il testo all'interno
		 * delle celle della tabella
		 */
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		table.getTableHeader().setBackground(Color.BLACK);
		table.getTableHeader().setFont(new Font("Century Gothic", Font.PLAIN, 16));
		table.getTableHeader().setForeground(Color.WHITE);
		table.getTableHeader().setPreferredSize(new Dimension(65, 50));

		for (int i = 0; i < 5; i++) {
			table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
			table.getTableHeader().getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
		}

		if (!getRicerca().equals("")) {
			table.setRowSelectionAllowed(false);
		}

		scrollPane_1.getViewport().setBackground(Color.BLACK);

		this.setVisible(true);

	}

	/**
	 * Metodo che registra un controller per gestire gli eventi dei componenti
	 * dell'interfaccia.
	 * 
	 * @param controller Il controller degli eventi da registrare
	 */
	public void registraEvento(ControllerEventiAdmin controller) {
		btnInserisci.addActionListener(controller);
		btnCerca.addActionListener(controller);
		btnElimina.addActionListener(controller);
		btnOrdina.addActionListener(controller);
		logOut.addMouseListener(controller);
		textFieldRicerca.addKeyListener(controller);
		chckbxEventiPassati.addActionListener(controller);
		btnEliminaTutto.addActionListener(controller);
	}

	/**
	 * Metodo che imposta l'intestazione della finestra con il nome e il cognome
	 * dell'utente e il ruolo "admin".
	 * 
	 * @param nome    Il nome dell'utente da visualizzare nell'intestazione.
	 * @param cognome Il cognome dell'utente da visualizzare nell'intestazione.
	 */
	public void setIntestazione(String nome, String cognome) {
		lblNome.setText(nome);
		lblCognome.setText(cognome);
		lblRuolo.setText("admin");
	}

	/**
	 * Metodo che restituisce il JLabel per il logout dell'utente.
	 * 
	 * @return Il JLabel per il logout dell'utente
	 */
	public JLabel getLogOut() {
		return logOut;
	}

	/**
	 * Metodo che restituisce il campo di testo per la ricerca degli eventi.
	 * 
	 * @return Il campo di testo per la ricerca degli eventi
	 */
	public JTextField getTextFieldRicerca() {
		return textFieldRicerca;
	}
	
	/**
	 * Metodo che crea una serie di InputDialog per inserire i parametri
	 * dell'evento. La selezione della data usufruisce della libreria
	 * DateChooser.jar, mentre la selezione delle mansioni avviene tramite la
	 * selezione di vari JCheckBox
	 * 
	 * @param controller Il controller degli eventi da registrare
	 */
	public void inserisciEvento(ControllerEventiAdmin controller) {
		String evento="";
		String data="";
		String luogo="";
		int ntec=0;
		ArrayList<String> mansioni=new ArrayList<String>();
		UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Century Gothic", Font.PLAIN, 14))); 
		int r;
		
		try {
			
			//evento
			do {
				evento=JOptionPane.showInputDialog(contentPane, "Inserisci il nome dell'evento:\n", "", JOptionPane.PLAIN_MESSAGE);
				if(evento==null) {
					throw new Exception();
				}
			}while(evento.equals(""));
			
			//data
			DateChooserCombo selData=new DateChooserCombo();
			String messaggio ="Seleziona la data dell'evento:\n";
			Object[] parametri = {messaggio, selData};
			r=JOptionPane.showConfirmDialog(contentPane, parametri, "", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
			if(r==JOptionPane.CANCEL_OPTION) {
				throw new Exception();
			}
			Calendar cal = selData.getSelectedDate();
			SimpleDateFormat formatoData = new SimpleDateFormat("dd-MM-yyyy");
			data = formatoData.format(cal.getTime());
			
			//luogo
			do {
				luogo=JOptionPane.showInputDialog(contentPane, "Inserisci il luogo dell'evento:\n", "", JOptionPane.PLAIN_MESSAGE);
				if(luogo==null) {
					throw new Exception();
				}
			}while(luogo.equals(""));
			
			//numero tecnici
			do {
				String temp=JOptionPane.showInputDialog(contentPane, "Inserisci il numero di tecnici per l'evento:\n", "", JOptionPane.PLAIN_MESSAGE);
				if(!isNumeric(temp)) {
					JOptionPane.showMessageDialog(contentPane, "Attenzione! Non è stato inserito un numero", "", JOptionPane.ERROR_MESSAGE);
				}else {
					ntec=Integer.parseInt(temp);
					if(ntec<=0) {
						JOptionPane.showMessageDialog(contentPane, "Attenzione! Inserire un numero maggiore o uguale a 1", "", JOptionPane.ERROR_MESSAGE);
					}
				}
			}while(ntec<=0);
			
			//mansioni
			
			messaggio ="Seleziona i tecnici richiesti per l'evento:\n";
			int selezionati=0;
			
			JCheckBox chckbxFOHEngineer = new JCheckBox("FOH engineer");
			
			JCheckBox chckbxSoundEngineer = new JCheckBox("Sound engineer");
			
			JCheckBox chckbxMonitorEngineer = new JCheckBox("Monitor engineer");
			
			JCheckBox chckbxSoundDesigner = new JCheckBox("Sound designer");
			
			JCheckBox chckbxPAManager = new JCheckBox("PA manager");
			
			JCheckBox chckbxRFManager = new JCheckBox("RF manager");
			
			JCheckBox chckbxLightingDesigner = new JCheckBox("Lighting designer");
			
			JCheckBox chckbxLightingOperator = new JCheckBox("Lighting operator");
			
			JCheckBox chckbxVideoOperator = new JCheckBox("Video operator");
			
			JCheckBox chckbxStageManager = new JCheckBox("Stage manager");
			
			JCheckBox chckbxVideoDesigner = new JCheckBox("Video designer");
			
			JCheckBox chckbxSystemDesigner = new JCheckBox("System designer");
			
			JCheckBox chckbxScaff = new JCheckBox("Scaff");
			
			JCheckBox chckbxRigger= new JCheckBox("Rigger");
			
			JCheckBox chckbxBackliner = new JCheckBox("Backliner");
			
			Object[] parametri2= {messaggio, chckbxFOHEngineer, chckbxSoundEngineer, chckbxMonitorEngineer, chckbxSoundDesigner, chckbxPAManager, chckbxRFManager, chckbxLightingDesigner, chckbxLightingOperator, chckbxVideoOperator, chckbxStageManager, chckbxVideoDesigner, chckbxSystemDesigner, chckbxScaff, chckbxRigger, chckbxBackliner};
			
			do {
				r=JOptionPane.showConfirmDialog(contentPane, parametri2, "", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
				if(r==JOptionPane.CANCEL_OPTION) {
					throw new Exception();
				}
				if(chckbxFOHEngineer.isSelected()) {
					mansioni.add("FOH engineer");
					selezionati++;
				}
				
				if(chckbxSoundEngineer.isSelected()) {
					mansioni.add("Sound engineer");
					selezionati++;
				}
				
				if(chckbxMonitorEngineer.isSelected()) {
					mansioni.add("Monitor engineer");
					selezionati++;
				}
				
				if(chckbxSoundDesigner.isSelected()) {
					mansioni.add("Sound designer");
					selezionati++;
				}
				
				if(chckbxPAManager.isSelected()) {
					mansioni.add("PA manager");
					selezionati++;
				}
				
				if(chckbxRFManager.isSelected()) {
					mansioni.add("RF manager");
					selezionati++;
				}
				
				if(chckbxLightingDesigner.isSelected()) {
					mansioni.add("Lighting designer");
					selezionati++;
				}
				
				if(chckbxLightingOperator.isSelected()) {
					mansioni.add("Lighting operator");
					selezionati++;
				}
				
				if(chckbxVideoOperator.isSelected()) {
					mansioni.add("Video operator");
					selezionati++;
				}
				
				if(chckbxStageManager.isSelected()) {
					mansioni.add("Stage manager");
					selezionati++;
				}
				
				if(chckbxVideoDesigner.isSelected()) {
					mansioni.add("Video designer");
					selezionati++;
				}
				
				if(chckbxSystemDesigner.isSelected()) {
					mansioni.add("System designer");
					selezionati++;
				}
				
				if(chckbxScaff.isSelected()) {
					mansioni.add("Scaff");
					selezionati++;
				}
				
				if(chckbxRigger.isSelected()) {
					mansioni.add("Rigger");
					selezionati++;
				}
				
				if(chckbxBackliner.isSelected()) {
					mansioni.add("Backliner");
					selezionati++;
				}
				if(selezionati==0) {
					JOptionPane.showMessageDialog(contentPane, "Attenzione! Selezionare almeno un tecnico", "", JOptionPane.ERROR_MESSAGE);
				}
			}while(selezionati==0);
				
			controller.aggiungiEvento(evento, data, luogo, ntec, mansioni);
		
		}catch(Exception e) {
			JOptionPane.showMessageDialog(contentPane, "Inserimento annullato", "", JOptionPane.ERROR_MESSAGE);

		}
	}
	
	/**
	 * Metodo che stampa gli eventi presenti nella lista degli eventi specificata
	 * come parametro. Regola l'altezza delle righe della tabella in base al numero
	 * di mansioni associate all'evento.
	 * 
	 * @param l La lista degli eventi da stampare
	 */
	public void stampaEventi(ListaEventi l) {
		model.setRowCount(0);
		for(int i=0;i<l.size();i++) {
			model.addRow(new Object[] {l.get(i).getNome(), l.get(i).getData(), l.get(i).getLuogo(), l.get(i).getNtec(), l.get(i).stampaMansioni()});
			if(l.get(i).getMansioni().size()==0) {
				table.setRowHeight(i, 50);
			}else {
				table.setRowHeight(i, 35*l.get(i).getMansioni().size()+15);
			}
		}
		table.setRowSelectionAllowed(true);
	}
	
	/**
	 * Metodo che permette di eliminare uno o più eventi selezionati dalla tabella.
	 * 
	 * @param controller Il controller degli Eventi dell'utente loggato come Admin
	 */
	public void eliminaEvento(ControllerEventiAdmin controller) {
		int selezionati[]=table.getSelectedRows();
		
		for(int i=0;i<selezionati.length;i++) {
			controller.eliminaEvento(selezionati[i]);
			
			for(int j=i;j<selezionati.length;j++) {
				selezionati[j]--;
			}
		}
	}
	
	/**
	 * Metodo che restituisce il testo inserito nel campo di ricerca.
	 * 
	 * @return Una stringa contenente il testo inserito nel campo di ricerca
	 */
	public String getRicerca() {
		return textFieldRicerca.getText();
	}
	
	/**
	 * Metodo che stampa la ricerca di eventi contenente la stringa specificata
	 * 
	 * @param ricerca La stringa di ricerca
	 * @param l       La lista degli eventi da filtrare
	 */
	public void stampaRicerca(String ricerca, ListaEventi l) {
		model.setRowCount(0);
		int i=0;
		for(i=0;i<l.size();i++) {
			if(l.get(i).getNome().contains(ricerca)) {
				model.addRow(new Object[] {l.get(i).getNome(), l.get(i).getData(), l.get(i).getLuogo(), l.get(i).getNtec(), l.get(i).stampaMansioni()});
				
			}
		}
		for(i=0;i<l.size();i++) {
			if(l.get(i).getMansioni().size()==0) {
				table.setRowHeight(i, 50);
			}else {
				table.setRowHeight(i, 35*l.get(i).getMansioni().size()+15);
			}
		}
		if(!getRicerca().equals("")) {
			table.setRowSelectionAllowed(false);
		}else {
			table.setRowSelectionAllowed(true);
		}
	}
	
	/**
	 * Metodo che gestisce il caso in cui l'opzione "Eventi passati" sia
	 * selezionata. Se è selezionata mostra solo gli eventi con data maggiore o
	 * uguale alla data attuale.
	 * 
	 * @param l La lista degli eventi
	 * @throws ParseException Se si verifica un errore durante il parsing della data
	 */
	public void nascondiEventiPassati(ListaEventi l) throws ParseException {
		model.setRowCount(0);
		int i=0;
		if(chckbxEventiPassati.isSelected()) {
			for(i=0;i<l.size();i++) {
				Date data=new SimpleDateFormat("dd-MM-yyyy").parse(l.get(i).getData());
				LocalDate dataTemp = LocalDate.now();
				Date dataOggi=java.util.Date.from(dataTemp.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
				if(data.compareTo(dataOggi)>=0) {
					model.addRow(new Object[] {l.get(i).getNome(), l.get(i).getData(), l.get(i).getLuogo(), l.get(i).getNtec(), l.get(i).stampaMansioni()});
				}
			}
			for(i=0;i<l.size();i++) {
				if(l.get(i).getMansioni().size()==0) {
					table.setRowHeight(i, 50);
				}else {
					table.setRowHeight(i, 35*l.get(i).getMansioni().size()+15);
				}
			}
			table.setRowSelectionAllowed(false);
		}else {
			stampaEventi(l);
			table.setRowSelectionAllowed(true);
		}
	}
	
	/**
	 * Metodo che verifica se una stringa è convertibile in un numero double.
	 * 
	 * @param str La stringa da verificare
	 * @return True se la stringa è convertibile in un numero double, altrimenti
	 *         false
	 */
	public static boolean isNumeric(String str) { 
		  try {  
			  Double.parseDouble(str);  
			  return true;
		  } catch(NumberFormatException e){  
			  return false;  
		  }  
	}
	
	/**
	 * Metodo che restituisce il tipo di ordinamento selezionato dall'utente,
	 * tramite una finestra di dialogo con tre opzioni di ordinamento
	 * 
	 * @return Scelta - una stringa che rappresenta il tipo di ordinamento
	 *         selezionato dall'utente.
	 */
	public String getOrdinamento() {
		int selezionati=0;
		String scelta="";
		String messaggio="Seleziona che tipo di ordinamento vuoi effettuare:";
		UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Century Gothic", Font.PLAIN, 14)));
		ButtonGroup buttonGroup = new ButtonGroup();
		JRadioButton rdbtnNome = new JRadioButton("Per nome");
		JRadioButton rdbtnData = new JRadioButton("Per data");
		JRadioButton rdbtnNTec = new JRadioButton("Per numero di tecnici");
		buttonGroup.add(rdbtnNTec);
		buttonGroup.add(rdbtnData);
		buttonGroup.add(rdbtnNome);
		try {
			do {
				Object[] parametri = {messaggio, rdbtnNome, rdbtnData, rdbtnNTec};
				int r=JOptionPane.showConfirmDialog(contentPane, parametri, "", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
				if(r==JOptionPane.CANCEL_OPTION) {
					throw new Exception();
				}
				if(rdbtnNome.isSelected()) {
					scelta="nome";
					selezionati++;
				}
				if(rdbtnData.isSelected()) {
					scelta="data";
					selezionati++;
				}
				if(rdbtnNTec.isSelected()) {
					scelta="ntec";
					selezionati++;
				}
				if(selezionati==0) {
					JOptionPane.showMessageDialog(contentPane, "Attenzione! Selezionare un ordinamento", "", JOptionPane.ERROR_MESSAGE);
				}
			}while(selezionati==0);
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(contentPane, "Ordinamento annullato", "", JOptionPane.ERROR_MESSAGE);

		}
		
		return scelta;
	}
	
	/**
	 * Metodo che mostra una finestra di dialogo per chiedere conferma per
	 * l'eliminazione di tutti gli eventi
	 * 
	 * @return Un intero corrispondente alla scelta dell'utente: 0 per sì, 1 per no
	 */
	public int mostraConferma() {
		return JOptionPane.showConfirmDialog(contentPane, "Vuoi eliminare tutti gli eventi?", "", JOptionPane.YES_NO_OPTION);
	}
}