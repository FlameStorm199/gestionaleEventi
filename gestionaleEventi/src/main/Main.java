package main;

import java.awt.EventQueue;

import control.ControllerLogin;
import model.RegistroUtenti;
import view.Login;

public class Main{

	public static void main(String[] args) {		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login login = new Login();
					RegistroUtenti registro=new RegistroUtenti();
					ControllerLogin controller_login=new ControllerLogin(login, registro);
					login.setVisible(true);
				
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
