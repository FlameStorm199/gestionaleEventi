package view;

import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import control.ControllerLogin;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;

public class Login extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldUsername;
	//private JTextField textFieldPassword;
	private JLabel lblLogo, lblUsername, lblPassword;
	private JButton btnLogin;
	private JPasswordField password;

	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 200, 550, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblLogo = new JLabel("logo logo logo logo logo logo");
		lblLogo.setBounds(209, 47, 124, 60);
		contentPane.add(lblLogo);
		ImageIcon logo=new ImageIcon("images/logo_bianco03 (Personalizzato) (1).png");
		Image imgLogo=logo.getImage();
		Image scaledLogo=imgLogo.getScaledInstance(145, 58, java.awt.Image.SCALE_SMOOTH);
		logo=new ImageIcon(scaledLogo);
		lblLogo.setIcon(new ImageIcon("images/logo_bianco03 (Personalizzato) (1).png"));
		
		btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Century Gothic", Font.BOLD, 14));
		btnLogin.setBounds(209, 248, 110, 33);
		btnLogin.setActionCommand("login");
		contentPane.add(btnLogin);
		
		lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		lblUsername.setForeground(new Color(255, 255, 255));
		lblUsername.setBounds(132, 132, 69, 21);
		contentPane.add(lblUsername);
		
		lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		lblPassword.setForeground(new Color(255, 255, 255));
		lblPassword.setBounds(132, 174, 69, 21);
		contentPane.add(lblPassword);
		
		textFieldUsername = new JTextField();
		textFieldUsername.setBounds(223, 135, 156, 19);
		contentPane.add(textFieldUsername);
		textFieldUsername.setColumns(10);
		
		/*textFieldPassword = new JTextField();
		textFieldPassword.setBounds(223, 175, 156, 19);
		contentPane.add(textFieldPassword);
		textFieldPassword.setColumns(10);*/
		
		password = new JPasswordField();
		password.setBounds(223, 175, 156, 19);
		contentPane.add(password);
		
		
		//premendo il tasto enter è come se venisse premuto questo tasto
		this.getRootPane().setDefaultButton(btnLogin);
	}

	public void registraEvento(ControllerLogin controller) {
		// TODO Auto-generated method stub
		btnLogin.addActionListener(controller);
	}

	public String getUsername() {
		// TODO Auto-generated method stub
		return textFieldUsername.getText();
	}
	
	public String getPassword() {
		// TODO Auto-generated method stub
		char[] charPass=password.getPassword();
		String strPass="";
		
		for(int i=0;i<charPass.length;i++) {
			strPass+=charPass[i];
		}
		
		return strPass;
	}
	
}
