package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import bd.GestionBD;
import modelo.UsuarioModel;
import vista.AccesoView;

/**
 * 
 * @author DanielBP
 *
 */
public class AccesoController implements ActionListener{
	private AccesoView accesoView;
	private GestionBD gestionBD;
	private UsuarioModel usuarioModel;
	
	/**
	 * Constructor de la clase AccesoController
	 * @param accesoView vista
	 */
	public AccesoController(AccesoView accesoView) {
		this.accesoView=accesoView;
		this.gestionBD=GestionBD.getGestionBD();
		this.usuarioModel=UsuarioModel.getUsuarioModel();
		
		accesoView.onClickBotones(this);
	}

	/**
	 * Método que controla la acción de los botones
	 */
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==accesoView.getBtnAcceder()){
			if(accesoView.getTxtUsuario().getText().isEmpty()){
				accesoView.mostrarAlerta("Ingrese su nombre de usuario");
				return;
			}else if(accesoView.getTxtPassword().getText().isEmpty()){
				accesoView.mostrarAlerta("Ingrese su contraseña");
				return;
			}
			
			usuarioModel.setNombreUsuario(accesoView.getTxtUsuario().getText());
			usuarioModel.setPasswordUsuario(accesoView.getTxtPassword().getText());
			
			try {
				if(gestionBD.verificarUsuario(usuarioModel)){
					accesoView.mostrarMensaje("Acceso concedido");
					accesoView.mostrarPullMensajes();
				}else{
					accesoView.mostrarAlerta("Usuario o contraseña incorrectos");
				}
			} catch (SQLException e) {
				accesoView.mostrarError(e.getMessage());
			}
		}else if(ae.getSource()==accesoView.getBtnRegistrarse()){
			accesoView.mostrarVentanaRegistro();
		}
	}
}
