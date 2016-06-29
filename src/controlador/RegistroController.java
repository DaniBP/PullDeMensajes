package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import bd.GestionBD;
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
	GestionBD gestionBD;
	
	/**
	 * Constructor de la clase RegistroController
	 * @param registroView vista
	 */
	public RegistroController(RegistroView registroView) {
		this.registroView=registroView;
		this.usuarioModel=UsuarioModel.getUsuarioModel();
		this.gestionBD=GestionBD.getGestionBD();
		
		registroView.onClickBotones(this);
	}

	/**
	 * Método que controla la acción de los botones
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==registroView.getBtnRegistrarse()){
			if(registroView.getTxtUsuario().getText().isEmpty()){
				registroView.mostrarAlerta("Ingrese su nombre de usuario");
				return;
			}else if(registroView.getTxtPassword().getText().isEmpty()){
				registroView.mostrarAlerta("Ingrese su contraseña");
				return;
			}else if(registroView.getTxtPassword2().getText().isEmpty()){
				registroView.mostrarAlerta("Ingrese de nuevo su contraseña");
				return;
			}else if(!registroView.getTxtPassword().getText().equals(registroView.getTxtPassword2().getText())){
				registroView.mostrarAlerta("Las contraseñas con coinciden");
				return;
			}
			
			usuarioModel.setNombreUsuario(registroView.getTxtUsuario().getText());
			usuarioModel.setPasswordUsuario(registroView.getTxtPassword().getText());
			
			try {
				gestionBD.registrarUsuario(usuarioModel);
				registroView.mostrarMensaje("Usuario registrado correctamente");
				registroView.limpiarVentana();
			} catch (Exception ex) {
				registroView.mostrarError(ex.getMessage());
			}
		
		}else if(e.getSource()==registroView.getBtnRegresar()){
			registroView.mostrarVentanaAcceso();
		}
	}
}
