package view;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import control.ControllerEventiAdmin;
import datechooser.beans.DateChooserCombo;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Frame;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.border.MatteBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class EventiAdmin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblLogo;
	private JLabel lblNome;
	private JLabel lblCognome;
	private JLabel lblRuolo;
	private JLabel logOut;
	private JTable table;
	private JButton btnProva;
	private JScrollPane scrollPane_1;
	private DefaultTableModel model;
	private JLabel lblInserimento;
	
	
	/**
	 * Create the frame.
	 */
	public EventiAdmin() {
		setBackground(new Color(0, 0, 0));
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JLabel lblOrario = new JLabel("orario orario orario orario");
		lblOrario.setBounds(22, 10, 105, 31);
		lblOrario.setForeground(new Color(255, 255, 255));
		lblOrario.setFont(new Font("Century Gothic", Font.PLAIN, 19));
		JLabel lblData = new JLabel("data data data data data data data data data data");
		lblData.setBounds(22, 40, 388, 36);
		lblData.setForeground(new Color(255, 255, 255));
		lblData.setFont(new Font("Century Gothic", Font.PLAIN, 19));
		Thread t=new Thread(new Orologio(lblOrario, lblData));
		t.start();
		contentPane.setLayout(null);
		contentPane.add(lblOrario);
		contentPane.add(lblData);
		
		lblLogo = new JLabel("");
		lblLogo.setBounds(543, 0, 450, 130);
		lblLogo.setForeground(new Color(0, 0, 0));
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setIcon(new ImageIcon("images/logo_bianco03 (Personalizzato).png"));
		contentPane.add(lblLogo);
		
		lblNome = new JLabel("nome");
		lblNome.setBounds(1291, 11, 227, 31);
		lblNome.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNome.setForeground(new Color(255, 255, 255));
		lblNome.setFont(new Font("Century Gothic", Font.PLAIN, 17));
		contentPane.add(lblNome);
		
		lblCognome = new JLabel("cognome");
		lblCognome.setBounds(1291, 40, 227, 31);
		lblCognome.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCognome.setForeground(Color.WHITE);
		lblCognome.setFont(new Font("Century Gothic", Font.PLAIN, 17));
		contentPane.add(lblCognome);
		
		lblRuolo = new JLabel("ruolo");
		lblRuolo.setBounds(1291, 73, 227, 31);
		lblRuolo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRuolo.setForeground(Color.WHITE);
		lblRuolo.setFont(new Font("Century Gothic", Font.PLAIN, 17));
		contentPane.add(lblRuolo);
		
		logOut = new JLabel("LOG OUT");
		logOut.setBounds(1291, 108, 227, 31);
		logOut.setHorizontalAlignment(SwingConstants.RIGHT);
		logOut.setForeground(Color.WHITE);
		logOut.setFont(new Font("Century Gothic", Font.BOLD, 17));
		contentPane.add(logOut);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 227, 1537, 686);
		contentPane.add(scrollPane_1);
		
		table = new JTable();
		model=new DefaultTableModel(
				new Object[][] {
					{"c", "i", "a", "o", "1"},
					{null, null, null, null, null},
					{null, null, null, null, null},
				},
				new String[] {
					"Evento", "Data", "Luogo", "N. Tecnici", "Mansione"
				}
			) {
				Class[] columnTypes = new Class[] {
					String.class, String.class, String.class, String.class, String.class
				};
				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
			};
		table.setModel(model);
		scrollPane_1.setViewportView(table);
		table.setRowSelectionAllowed(false);
		table.setRowHeight(65);
		table.setForeground(Color.WHITE);
		table.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		table.setBorder(new MatteBorder(1, 2, 1, 1, (Color) new Color(255, 255, 255)));
		table.setBackground(new Color(0, 0, 0));
		
		btnProva = new JButton("Inserisci");
		btnProva.setBackground(new Color(255, 255, 255));
		btnProva.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		btnProva.setBounds(397, 151, 112, 22);
		btnProva.setActionCommand("Inserisci");
		btnProva.setFocusPainted(false);
		contentPane.add(btnProva);
		
		lblInserimento = new JLabel("Clicca qui per inserire un nuovo evento:");
		lblInserimento.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lblInserimento.setForeground(new Color(255, 255, 255));
		lblInserimento.setBackground(new Color(0, 0, 0));
		lblInserimento.setBounds(22, 143, 341, 36);
		contentPane.add(lblInserimento);
		
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		table.getTableHeader().setBackground(Color.BLACK);
		table.getTableHeader().setFont(new Font("Century Gothic", Font.PLAIN, 16));
		table.getTableHeader().setForeground(Color.WHITE);
		table.getTableHeader().setPreferredSize(
			     new Dimension(65, 50)
			);
		
		for(int i=0;i<5;i++) {
			table.getColumnModel().getColumn(i).setCellRenderer( centerRenderer );
			table.getTableHeader().getColumnModel().getColumn(i).setCellRenderer( centerRenderer );
		}
			
		scrollPane_1.getViewport().setBackground(Color.BLACK);
		
		this.setVisible(true);
		
	}


	public void registraEvento(ControllerEventiAdmin controller) {
		// TODO Auto-generated method stub
		btnProva.addActionListener(controller);
	}
	
	public void aggiungiRiga() {
		model.addRow(new Object[] {null, null, null, null, null});
		String evento="";
		String data="";
		String luogo="";
		int ntec=0;
		String mansione="";
		
		//evento
		evento=JOptionPane.showInputDialog(contentPane, "Inserisci il nome dell'evento:\n", "", JOptionPane.PLAIN_MESSAGE);
		
		//data
		DateChooserCombo selData=new DateChooserCombo();
		String messaggio ="Seleziona la data dell'evento:\n";
		Object[] parametri = {messaggio, selData};
		JOptionPane.showConfirmDialog(contentPane, parametri, "", JOptionPane.PLAIN_MESSAGE);
		Calendar cal = selData.getSelectedDate();
		SimpleDateFormat formatoData = new SimpleDateFormat("dd-MM-yyyy");
		data = formatoData.format(cal.getTime());
		
		//luogo
		luogo=JOptionPane.showInputDialog(contentPane, "Inserisci il luogo dell'evento:\n", "", JOptionPane.PLAIN_MESSAGE);
	
		//numero tecnici
		ntec=Integer.parseInt(JOptionPane.showInputDialog(contentPane, "Inserisci il numero di tecnici per l'evento:\n", "", JOptionPane.PLAIN_MESSAGE));
		
		//mansione
		JComboBox selMansione=new JComboBox();
		selMansione.setModel(new DefaultComboBoxModel(new String[] {"Fonico", "Tecnico luci", }));
		messaggio ="Seleziona la mansione richiesta per l'evento:\n";
		Object[] parametri2 = {messaggio, selMansione};
		JOptionPane.showConfirmDialog(contentPane, parametri2, "", JOptionPane.PLAIN_MESSAGE);
		mansione=(String) selMansione.getSelectedItem();
		
		//stampa di prova
		System.out.println(evento+" "+data+" "+luogo+" "+ntec+" "+mansione);
	}
}