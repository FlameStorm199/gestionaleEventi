package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.RegistroUtenti;
import view.EventiAdmin;
import view.EventiTecnico;
import view.Login;

public class ControllerLogin implements ActionListener{
	private Login login;
	private RegistroUtenti registro;
	
	public ControllerLogin(Login login, RegistroUtenti registro){
		this.login=login;
		this.registro=registro;
		login.registraEvento(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if("login".equals(e.getActionCommand())) {
			gestisciLogin(login, registro);
		}
	}
	
	public void gestisciLogin(Login login, RegistroUtenti registro) {
		String username=login.getUsername();
		String password=login.getPassword();
		if(registro.eseguiAccesso(username, password)) {
			login.dispose();
			controllaFinestraEventi(username);
		}else {
			JOptionPane.showMessageDialog(login, "Username o password errati!");
		}
	}
	
	public void controllaFinestraEventi(String username) {
		String mansione=registro.getMansione(username);
		boolean admin=registro.isAdmin(username);
		
		if(admin) {
			EventiAdmin eventi=new EventiAdmin();
			ControllerEventiAdmin controller_eventi=new ControllerEventiAdmin(registro, eventi);
		}else {
			EventiTecnico eventi=new EventiTecnico();
			ControllerEventiTecnico controller_eventi=new ControllerEventiTecnico(registro, eventi, mansione);
		}
	}
	
}
