package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import control.ControllerEventiTecnico;
import model.ListaEventi;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Frame;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
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
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.Toolkit;

/**
 * La classe EventiTecnico crea, con la lbreria Java.swing un'interfaccia
 * grafica per l'utente loggato come user.
 */
public class EventiTecnico extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblLogo, lblNome, lblCognome, lblRuolo, logOut, lblOrario, lblData, lblRicerca, lblEventiPassati,
			lblOrdina;
	private JTable table;
	private DefaultTableModel model;
	private JScrollPane scrollPane_1;
	private JTextField txtFieldCerca;
	private JButton btnCerca, btnOrdina;
	private JCheckBox chckbxEventiPassati;

	/**
	 * Costruttore della classe EventiTecnico
	 */
	public EventiTecnico() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(EventiTecnico.class.getResource("/images/k_firma_mail.jpg")));
		setTitle("Finestra tecnico");
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
		contentPane.add(scrollPane_1);
		
		/**
		 * Crea una tabella contenente gli eventi con i parametri specifici
		 */
		table = new JTable();
		model=new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Evento", "Data", "Luogo", "N. Tecnici", "Mansione"
				}
			) {
				Class[] columnTypes = new Class[] {
					String.class, String.class, String.class, Integer.class, String.class
				};
				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
				public boolean isCellEditable(int row, int column) {
				       return false;
				}
			};
		table.setModel(model);
		scrollPane_1.setViewportView(table);
		/*table.setRowSelectionAllowed(false);
		table.setRowHeight(65);*/
		table.setForeground(Color.WHITE);
		table.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		table.setBorder(new MatteBorder(1, 2, 1, 1, (Color) new Color(255, 255, 255)));
		table.setBackground(new Color(0, 0, 0));
		
		/**
		 * Crea una JLabel per cercare il nome dell'evento
		 */
		lblRicerca = new JLabel("Digita il nome di un evento:");
		lblRicerca.setForeground(Color.WHITE);
		lblRicerca.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lblRicerca.setBackground(Color.BLACK);
		lblRicerca.setBounds(22, 139, 227, 36);
		contentPane.add(lblRicerca);

		/**
		 * Crea una JTextField per la ricerca di un evento
		 */
		txtFieldCerca = new JTextField();
		txtFieldCerca.setColumns(10);
		txtFieldCerca.setBounds(259, 148, 227, 22);
		contentPane.add(txtFieldCerca);

		/**
		 * Crea una JButton per l'immagine della lente d'ingrandimento
		 */
		btnCerca = new JButton("");
		btnCerca.setIcon(new ImageIcon("src/images/190821_glass_720x720 (Personalizzato).png"));
		btnCerca.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		btnCerca.setFocusPainted(false);
		btnCerca.setBackground(Color.WHITE);
		btnCerca.setActionCommand("inserisci");
		btnCerca.setBounds(485, 148, 22, 22);
		contentPane.add(btnCerca);

		/**
		 * Crea una JLabel per nascondere gli eventi passati
		 */
		lblEventiPassati = new JLabel("Non mostrare eventi passati");
		lblEventiPassati.setForeground(Color.WHITE);
		lblEventiPassati.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lblEventiPassati.setBackground(Color.BLACK);
		lblEventiPassati.setBounds(686, 139, 227, 36);
		contentPane.add(lblEventiPassati);

		/**
		 * Crea una JCheckBox per nascondere gli eventi passati
		 */
		chckbxEventiPassati = new JCheckBox("");
		chckbxEventiPassati.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxEventiPassati.setBackground(new Color(0, 0, 0));
		chckbxEventiPassati.setBounds(655, 143, 30, 31);
		chckbxEventiPassati.setActionCommand("eventiPassati");
		contentPane.add(chckbxEventiPassati);

		/**
		 * Crea una JLabel per ordinare gli eventi
		 */
		lblOrdina = new JLabel("Ordina gli eventi per criterio:");
		lblOrdina.setForeground(Color.WHITE);
		lblOrdina.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lblOrdina.setBackground(Color.BLACK);
		lblOrdina.setBounds(1048, 139, 227, 36);
		contentPane.add(lblOrdina);

		/**
		 * Crea una JButton per ordinare gli eventi
		 */
		btnOrdina = new JButton("Ordina");
		btnOrdina.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		btnOrdina.setBackground(Color.WHITE);
		btnOrdina.setFocusPainted(false);
		btnOrdina.setActionCommand("ordina");
		btnOrdina.setBounds(1285, 149, 123, 21);
		contentPane.add(btnOrdina);

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

		scrollPane_1.getViewport().setBackground(Color.BLACK);

		this.setVisible(true);

	}

	/**
	 * Metodo che registra un controller per gestire gli eventi dei componenti
	 * dell'interfaccia.
	 * 
	 * @param controller Il controller degli eventi da registrare
	 */
	public void registraEvento(ControllerEventiTecnico controller) {
		btnCerca.addActionListener(controller);
		btnOrdina.addActionListener(controller);
		txtFieldCerca.addKeyListener(controller);
		chckbxEventiPassati.addActionListener(controller);
		logOut.addMouseListener(controller);
	}

	/**
	 * Metodo che imposta l'intestazione della finestra con il nome, cognome e
	 * mansione dell'utente.
	 * 
	 * @param nome     Il nome dell'utente da visualizzare nell'intestazione.
	 * @param cognome  Il cognome dell'utente da visualizzare nell'intestazione.
	 * @param mansione La mansione dell'utente da visualizzare nell'intestazione.
	 */
	public void setIntestazione(String nome, String cognome, String mansione) {
		lblNome.setText(nome);
		lblCognome.setText(cognome);
		lblRuolo.setText(mansione);
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
	 * Metodo che Restituisce il campo di testo per la ricerca degli eventi.
	 * 
	 * @return Il campo di testo per la ricerca degli eventi
	 */
	public JTextField getTextFieldRicerca() {
		return txtFieldCerca;
	}

	/**
	 * Metodo che restituisce il testo inserito nel campo di ricerca.
	 * 
	 * @return Il testo inserito nel campo di ricerca.
	 */
	public String getRicerca() {
		return txtFieldCerca.getText();
	}
	
	/**
	 * Metodo che stampa gli eventi che contengono la mansione specificata nella
	 * tabella degli eventi.
	 * 
	 * @param l        La lista degli eventi da stampare.
	 * @param mansione La mansione da cercare negli eventi.
	 */
	public void stampaEventi(ListaEventi l, String mansione) {
		model.setRowCount(0);
		int i=0;
		
		for(i=0;i<l.size();i++) {
			if(l.get(i).getMansioni().contains(mansione)) {
				model.addRow(new Object[] {l.get(i).getNome(), l.get(i).getData(), l.get(i).getLuogo(), l.get(i).getNtec(), l.get(i).stampaMansioni()});
				
			}
		}
		
		int j=0;
		for(i=0;i<l.size();i++) {
			if(l.get(i).getMansioni().contains(mansione)) {
				if(l.get(i).getMansioni().size()==0) {
					table.setRowHeight(j, 50);
				}else {
					table.setRowHeight(j, 35*l.get(j).getMansioni().size()+15);
				}
				j++;
			}
		}
		
		table.setRowSelectionAllowed(false);
	}
	
	/**
	 * Metodo che stampa gli eventi che contengono la mansione specificata e il
	 * testo di ricerca nel nome dell'evento nella tabella degli eventi.
	 * 
	 * @param ricerca  Il testo da cercare nei nomi degli eventi.
	 * @param l        La lista degli eventi da stampare.
	 * @param mansione La mansione da cercare negli eventi.
	 */
	public void stampaRicerca(String ricerca, ListaEventi l, String mansione) {
		model.setRowCount(0);
		int i=0, j=0;
		for(i=0;i<l.size();i++) {
			if(l.get(i).getMansioni().contains(mansione)) {
				if(l.get(i).getNome().contains(ricerca)) {
					model.addRow(new Object[] {l.get(i).getNome(), l.get(i).getData(), l.get(i).getLuogo(), l.get(i).getNtec(), l.get(i).stampaMansioni()});
				}
			}
		}
		for(i=0;i<l.size();i++) {
			if(l.get(i).getMansioni().size()==0) {
				table.setRowHeight(j, 50);
			}else {
				table.setRowHeight(j, 35*l.get(j).getMansioni().size()+15);
			}
			j++;
		}
		
		table.setRowSelectionAllowed(false);
	}
	
	/**
	 * Metodo che nasconde gli eventi passati dalla tabella degli eventi.
	 * 
	 * @param l La lista degli eventi da cui prendere gli eventi
	 * @throws ParseException Se si verifica un errore durante il parsing della data
	 */
	public void nascondiEventiPassati(ListaEventi l) throws ParseException {
		model.setRowCount(0);
		int i=0, j=0;
		if(chckbxEventiPassati.isSelected()) {
			for(i=0;i<l.size();i++) {
				Date data=new SimpleDateFormat("dd-MM-yyyy").parse(l.get(i).getData());
				LocalDate dataTemp = LocalDate.now();
				Date dataOggi=java.util.Date.from(dataTemp.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
				if(data.compareTo(dataOggi)>=0&&l.get(i).getMansioni().contains(lblRuolo.getText())) {
					model.addRow(new Object[] {l.get(i).getNome(), l.get(i).getData(), l.get(i).getLuogo(), l.get(i).getNtec(), l.get(i).stampaMansioni()});
				}
			}
			for(i=0;i<l.size();i++) {
				if(l.get(i).getMansioni().size()==0) {
					table.setRowHeight(j, 50);
				}else {
					table.setRowHeight(j, 35*l.get(j).getMansioni().size()+15);
				}
				j++;
			}
		}else {
			stampaEventi(l, lblRuolo.getText());
		}
		
		table.setRowSelectionAllowed(false);
	}
	
	/**
	 * Metodo che restituisce la scelta dell'ordinamento selezionato dall'utente
	 * tramite finestra di dialogo.
	 * 
	 * @return La stringa rappresentante il tipo di ordinamento selezionato
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
}