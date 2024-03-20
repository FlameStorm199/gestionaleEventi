package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.RegistroUtenti;
import view.EventiTecnico;

public class ControllerEventiTecnico implements ActionListener{
	private RegistroUtenti registro;
	private EventiTecnico eventi;
	private String mansione;
	
	public ControllerEventiTecnico(RegistroUtenti registro, EventiTecnico eventi, String mansione) {
		this.registro=registro;
		this.eventi=eventi;
		this.mansione=mansione;
		eventi.registraEvento(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
