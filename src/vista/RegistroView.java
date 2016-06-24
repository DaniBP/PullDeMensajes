package vista;

import java.awt.Container;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingConstants;

import controlador.AccesoController;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

/**
 * 
 * @author DanielBP
 *
 */
public class RegistroView extends JFrame{
	private JLabel lblUsuario = new JLabel("Nombre de usuario:");
	private JLabel lblPassword = new JLabel("Contrase\u00F1a:");

	private JButton btnRegresar = new JButton("Regresar");
	private JButton btnRegistrarse = new JButton("Registrarse");
	
	private JTextField txtUsuario;
	private JPasswordField txtPassword;
	
	private Container c = getContentPane();
	private JLabel lblPassword2 = new JLabel("Repetir contrase\u00F1a:");
	private JPasswordField txtPassword2 = new JPasswordField();

	
	/**
	 * Constructor de la clase AccesoView
	 */
	public RegistroView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Acceso");
		this.setBounds(100, 100, 280, 200);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		c.setLayout(null);
		
		btnRegresar.setBounds(10, 130, 110, 30);
		btnRegistrarse.setBounds(154, 130, 110, 30);
		
		lblUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUsuario.setBounds(0, 29, 128, 14);
		
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword.setBounds(28, 57, 100, 14);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(132, 26, 132, 20);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(132, 54, 132, 20);
		
		c.add(btnRegresar);
		c.add(btnRegistrarse);
		c.add(lblUsuario);
		c.add(lblPassword);
		c.add(txtUsuario);
		c.add(txtPassword);
		lblPassword2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword2.setBounds(0, 85, 128, 14);
		
		getContentPane().add(lblPassword2);
		txtPassword2.setBounds(132, 82, 132, 20);
		
		getContentPane().add(txtPassword2);
	}

	/**
	 * @return the btnAcceder
	 */
	public JButton getBtnRegresar() {
		return btnRegresar;
	}

	/**
	 * @return the btnRegistrarse
	 */
	public JButton getBtnRegistrarse() {
		return btnRegistrarse;
	}
	
	/**
	 * @return the lblUsuario
	 */
	public JLabel getLblUsuario() {
		return lblUsuario;
	}

	/**
	 * @return the lblPassword
	 */
	public JLabel getLblPassword() {
		return lblPassword;
	}

	/**
	 * @return the lblPassword2
	 */
	public JLabel getLblPassword2() {
		return lblPassword2;
	}

	/**
	 * @return the txtPassword2
	 */
	public JPasswordField getTxtPassword2() {
		return txtPassword2;
	}

	/**
	 * @return the textField
	 */
	public JTextField getTextField() {
		return txtUsuario;
	}

	/**
	 * @return the passwordField
	 */
	public JPasswordField getPasswordField() {
		return txtPassword;
	}

	/**
	 * Método para asignar el evento click a los botones
	 * @param al evento click
	 */
	public void onClickBotones(ActionListener al){
		btnRegresar.addActionListener(al);
		btnRegistrarse.addActionListener(al);
	}
	
	/**
	 * Método para mostrar la ventana de acceso
	 */
	public void mostrarVentanaAcceso(){
		AccesoView accesoView = new AccesoView();
		AccesoController accesoController = new AccesoController(accesoView);
		this.setVisible(false);
		accesoView.setVisible(true);
	}
}
