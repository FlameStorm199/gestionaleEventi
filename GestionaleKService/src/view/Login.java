package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.FontUIResource;

import control.ControllerLogin;
import model.RegistroUtenti;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.UIManager;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;

/**
 * La classe Login crea una JFrame di dimensioni fisse che serve ad accedere al programma. Da
 * questa finestra è possibile inserire il proprio username e password se si è già registrati,
 * oppure premere il bottone in alto a destra per creare un nuovo utente e registrarsi.
 *
 */
public class Login extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldUsername;
	private JLabel lblLogo, lblUsername, lblPassword;
	private JButton btnLogin, btnAggiungiUtente;
	private JPasswordField password;
	
	/**
	 * Costruttore della finestra Login.
	 */
	public Login() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/images/k_firma_mail.jpg")));
		setTitle("Login");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 200, 550, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/**
		 * Crea una JLabel per ospitare l'immagine del logo.
		 */
		lblLogo = new JLabel("logo logo logo logo logo logo");
		lblLogo.setBounds(209, 47, 124, 60);
		contentPane.add(lblLogo);
		lblLogo.setIcon(new ImageIcon("src/images/logo_bianco03 (Personalizzato) (1).png"));
		
		/**
		 * Crea un JButton per eseguire il login.
		 */
		btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		btnLogin.setBounds(209, 248, 110, 33);
		btnLogin.setFocusPainted(false);
		btnLogin.setBackground(Color.WHITE);
		btnLogin.setActionCommand("login");
		contentPane.add(btnLogin);
		
		/**
		 * Crea una JLabel per indicare all'utente dove inserire lo username.
		 */
		lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		lblUsername.setForeground(new Color(255, 255, 255));
		lblUsername.setBounds(132, 132, 69, 21);
		contentPane.add(lblUsername);
		
		/**
		 * Crea una JLabel per indicare all'utente dove inserire la password.
		 */
		lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		lblPassword.setForeground(new Color(255, 255, 255));
		lblPassword.setBounds(132, 174, 69, 21);
		contentPane.add(lblPassword);
		
		/**
		 * Crea una JTextField per inserire lo username
		 */
		textFieldUsername = new JTextField();
		textFieldUsername.setBounds(223, 135, 156, 19);
		contentPane.add(textFieldUsername);
		textFieldUsername.setColumns(10);
		
		/**
		 * Crea una JPasswordField per inserire la password
		 */
		password = new JPasswordField();
		password.setBounds(223, 175, 156, 19);
		contentPane.add(password);
		
		/**
		 * Crea il JButton per aggiungere nuovi utenti: sul JButton è anche presente una immagine.
		 */
		btnAggiungiUtente = new JButton("");
		btnAggiungiUtente.setBackground(new Color(255, 255, 255));
		btnAggiungiUtente.setIcon(new ImageIcon("src/images/user1_89279 (Personalizzato).png"));
		btnAggiungiUtente.setBounds(496, 10, 30, 31);
		btnAggiungiUtente.setActionCommand("aggiungi");
		contentPane.add(btnAggiungiUtente);
		
		//premendo il tasto enter è come se venisse premuto questo tasto
		this.getRootPane().setDefaultButton(btnLogin);
	}
	
	/**
	 * Metodo che gestisce gli ActionListener per i componenti della finestra Login.
	 * @param controller Il controller della finestra Login
	 */
	public void registraEvento(ControllerLogin controller) {
		btnLogin.addActionListener(controller);
		btnAggiungiUtente.addActionListener(controller);;
	}
	
	/**
	 * Metodo che restituisce il testo all'interno della TextField dello username
	 * @return la stringa con il testo all'interno della JTextField
	 */
	public String getUsername() {
		return textFieldUsername.getText();
	}
	
	/**
	 * Metodo che recupera il testo all'interno della JPasswordField, esso però viene restituito come array
	 * di char e quindi vengono convertiti in stringa
	 * @return la stringa con il testo all'interno della JPasswordField
	 */
	public String getPassword() {
		char[] charPass=password.getPassword();
		String strPass="";
		
		for(int i=0;i<charPass.length;i++) {
			strPass+=charPass[i];
		}
		
		return strPass;
	}
	
	/**
	 * Metodo che permette di creare un nuovo utente, inserendo tutte le sue caratteristiche
	 * tramite una serie di InputDialog. L'inserimento dei permessi dell'utente e della sua mansione
	 * avviene tramite JRadioButton.
	 * @param controller il controller della finestra Login
	 * @param registro il registro degli utenti registrati
	 */
	public void aggiungiUtenteGUI(ControllerLogin controller, RegistroUtenti registro) {
		String username="";
		String password="";
		String nome="";
		String cognome="";
		String mansione="";
		boolean admin=false;
		String messaggio="";
		int r=0;
		UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Century Gothic", Font.PLAIN, 14))); 
		
		try {
			
			//username
			do {
				username=JOptionPane.showInputDialog(contentPane, "Inserisci l'username:\n", "", JOptionPane.PLAIN_MESSAGE);
				if(username==null) {
					throw new Exception();
				}
				if(registro.contains(username)) {
					JOptionPane.showMessageDialog(contentPane, "Attenzione! Username già usato", "", JOptionPane.ERROR_MESSAGE);
				}
			}while(username.equals("")||registro.contains(username));
			
			//password
			do {
				password=JOptionPane.showInputDialog(contentPane, "Inserisci la password:\n", "", JOptionPane.PLAIN_MESSAGE);
				if(password==null) {
					throw new Exception();
				}
			}while(password.equals(""));
			
			//nome
			do {
				nome=JOptionPane.showInputDialog(contentPane, "Inserisci il nome dell'utente:\n", "", JOptionPane.PLAIN_MESSAGE);
				if(nome==null) {
					throw new Exception();
				}
			}while(nome.equals(""));
			
			//cognome
			do {
				cognome=JOptionPane.showInputDialog(contentPane, "Inserisci il cognome dell'utente:\n", "", JOptionPane.PLAIN_MESSAGE);
				if(cognome==null) {
					throw new Exception();
				}
			}while(cognome.equals(""));
			
			//admin o utente;
			ButtonGroup buttonGroup=new ButtonGroup();
			messaggio="Seleziona la mansione svolta dall'utente:";
			int selezionati=0;
			JRadioButton rdbtnAdmin=new JRadioButton("Admin");
			JRadioButton rdbtnTecnico=new JRadioButton("Tecnico");
			buttonGroup.add(rdbtnAdmin);
			buttonGroup.add(rdbtnTecnico);
			
			do {
				Object[] parametri2= {messaggio, rdbtnAdmin, rdbtnTecnico};
				r=JOptionPane.showConfirmDialog(contentPane, parametri2, "", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
				if(r==JOptionPane.CANCEL_OPTION) {
					throw new Exception();
				}
				if(rdbtnAdmin.isSelected()) {
					admin=true;
					selezionati++;
				}
				if(rdbtnTecnico.isSelected()) {
					admin=false;
					selezionati++;
				}
				if(selezionati==0) {
					JOptionPane.showMessageDialog(contentPane, "Attenzione! Selezionare un ruolo", "", JOptionPane.ERROR_MESSAGE);
				}
			}while(selezionati==0);
			
			//ruolo
			if(admin==false) {
				int selezionati2=0;
				messaggio="Seleziona che tipo di ordinamento vuoi effettuare:";
				ButtonGroup buttonGroup2 = new ButtonGroup();
				
					JRadioButton rdbtnFOHEngineer = new JRadioButton("FOH engineer");
					buttonGroup2.add(rdbtnFOHEngineer);
					
					JRadioButton rdbtnSoundEngineer = new JRadioButton("Sound engineer");
					buttonGroup2.add(rdbtnSoundEngineer);
					
					JRadioButton rdbtnMonitorEngineer = new JRadioButton("Monitor engineer");
					buttonGroup2.add(rdbtnMonitorEngineer);
					
					JRadioButton rdbtnSoundDesigner = new JRadioButton("Sound designer");
					buttonGroup2.add(rdbtnSoundDesigner);
					
					JRadioButton rdbtnPAManager = new JRadioButton("PA manager");
					buttonGroup2.add(rdbtnPAManager);
					
					JRadioButton rdbtnRFManager = new JRadioButton("RF manager");
					buttonGroup2.add(rdbtnRFManager);
					
					JRadioButton rdbtnLightingDesigner = new JRadioButton("Lighting designer");
					buttonGroup2.add(rdbtnLightingDesigner);
					
					JRadioButton rdbtnLightingOperator = new JRadioButton("Lighting operator");
					buttonGroup2.add(rdbtnLightingOperator);
					
					JRadioButton rdbtnVideoOperator = new JRadioButton("Video operator");
					buttonGroup2.add(rdbtnVideoOperator);
					
					JRadioButton rdbtnStageManager = new JRadioButton("Stage manager");
					buttonGroup2.add(rdbtnStageManager);
					
					JRadioButton rdbtnVideoDesigner = new JRadioButton("Video designer");
					buttonGroup2.add(rdbtnVideoDesigner);
					
					JRadioButton rdbtnSystemDesigner = new JRadioButton("System designer");
					buttonGroup2.add(rdbtnSystemDesigner);
					
					JRadioButton rdbtnScaff = new JRadioButton("Scaff");
					buttonGroup2.add(rdbtnScaff);
					
					JRadioButton rdbtnRigger= new JRadioButton("Rigger");
					buttonGroup2.add(rdbtnRigger);
					
					JRadioButton rdbtnBackliner = new JRadioButton("Backliner");
					buttonGroup2.add(rdbtnBackliner);
					
					Object[] parametri2= {messaggio, rdbtnFOHEngineer, rdbtnSoundEngineer, rdbtnMonitorEngineer, rdbtnSoundDesigner, rdbtnPAManager, rdbtnRFManager, rdbtnLightingDesigner, rdbtnLightingOperator, rdbtnVideoOperator, rdbtnStageManager, rdbtnVideoDesigner, rdbtnSystemDesigner, rdbtnScaff, rdbtnRigger, rdbtnBackliner};
					
					do {
						r=JOptionPane.showConfirmDialog(contentPane, parametri2, "", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
						if(r==JOptionPane.CANCEL_OPTION) {
							throw new Exception();
						}
						if(rdbtnFOHEngineer.isSelected()) {
							mansione="FOH engineer";
							selezionati2++;
						}
						
						if(rdbtnSoundEngineer.isSelected()) {
							mansione="Sound engineer";
							selezionati2++;
						}
						
						if(rdbtnMonitorEngineer.isSelected()) {
							mansione="Monitor engineer";
							selezionati2++;
						}
						
						if(rdbtnSoundDesigner.isSelected()) {
							mansione="Sound designer";
							selezionati2++;
						}
						
						if(rdbtnPAManager.isSelected()) {
							mansione="PA manager";
							selezionati2++;
						}
						
						if(rdbtnRFManager.isSelected()) {
							mansione="RF manager";
							selezionati2++;
						}
						
						if(rdbtnLightingDesigner.isSelected()) {
							mansione="Lighting designer";
							selezionati2++;
						}
						
						if(rdbtnLightingOperator.isSelected()) {
							mansione="Lighting operator";
							selezionati2++;
						}
						
						if(rdbtnVideoOperator.isSelected()) {
							mansione="Video operator";
							selezionati2++;
						}
						
						if(rdbtnStageManager.isSelected()) {
							mansione="Stage manager";
							selezionati2++;
						}
						
						if(rdbtnVideoDesigner.isSelected()) {
							mansione="Video designer";
							selezionati2++;
						}
						
						if(rdbtnSystemDesigner.isSelected()) {
							mansione="System designer";
							selezionati2++;
						}
						
						if(rdbtnScaff.isSelected()) {
							mansione="Scaff";
							selezionati2++;
						}
						
						if(rdbtnRigger.isSelected()) {
							mansione="Rigger";
							selezionati2++;
						}
						
						if(rdbtnBackliner.isSelected()) {
							mansione="Backliner";
							selezionati2++;
						}
						if(selezionati2==0) {
							JOptionPane.showMessageDialog(contentPane, "Attenzione! Selezionare una mansione", "", JOptionPane.ERROR_MESSAGE);
						}
			
					}while(selezionati2==0);
					
			}else {
				mansione="admin";
			}
			controller.aggiungiUtenteController(username, password, nome, cognome, mansione, admin);
		}catch(Exception e) {
			JOptionPane.showMessageDialog(contentPane, "Inserimento annullato", "", JOptionPane.ERROR_MESSAGE);

		}
	}
}
