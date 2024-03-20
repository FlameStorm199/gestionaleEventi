package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.RegistroUtenti;
import view.EventiAdmin;

public class ControllerEventiAdmin implements ActionListener{
	private RegistroUtenti registro;
	private EventiAdmin eventi;
	
	public ControllerEventiAdmin(RegistroUtenti registro, EventiAdmin eventi) {
		this.registro=registro;
		this.eventi=eventi;
		eventi.registraEvento(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("Inserisci")) {
			eventi.aggiungiRiga();
		}
	}
}
