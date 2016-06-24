package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.AccesoView;

/**
 * 
 * @author DanielBP
 *
 */
public class AccesoController implements ActionListener{
	private AccesoView accesoView;
	
	/**
	 * Constructor de la clase AccesoController
	 * @param accesoView vista
	 */
	public AccesoController(AccesoView accesoView) {
		this.accesoView=accesoView;
		
		accesoView.onClickBotones(this);
	}

	/**
	 * Método que controla la acción de los botones
	 */
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==accesoView.getBtnAcceder()){
			//ValidarUsuario
			//Acceder al pull
		}else if(ae.getSource()==accesoView.getBtnRegistrarse()){
			accesoView.mostrarVentanaRegistro();
		}
	}
	
}
