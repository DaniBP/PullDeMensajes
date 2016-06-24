package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.UsuarioModel;
import vista.RegistroView;

/**
 * 
 * @author DanielBP
 *
 */
public class RegistroController implements ActionListener{
	RegistroView registroView;
	UsuarioModel usuarioModel;
	
	/**
	 * Constructor de la clase RegistroController
	 * @param registroView vista
	 */
	public RegistroController(RegistroView registroView) {
		this.registroView=registroView;
		this.usuarioModel=UsuarioModel.getUsuarioModel();
		
		registroView.onClickBotones(this);
	}

	/**
	 * Método que controla la acción de los botones
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==registroView.getBtnRegistrarse()){
			//Registro de usuario
		}else if(e.getSource()==registroView.getBtnRegresar()){
			registroView.mostrarVentanaAcceso();
		}
	}
}
