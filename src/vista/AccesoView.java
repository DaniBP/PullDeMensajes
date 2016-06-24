package vista;

import java.awt.Container;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingConstants;

import controlador.RegistroController;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

/**
 * 
 * @author DanielBP
 *
 */
public class AccesoView extends JFrame{
	private JLabel lblUsuario = new JLabel("Nombre de usuario:");
	private JLabel lblPassword = new JLabel("Contrase\u00F1a:");

	private JButton btnAcceder = new JButton("Acceder");
	private JButton btnRegistrarse = new JButton("Crear cuenta");
	
	private JTextField txtUsuario;
	private JPasswordField txtPassword;
	
	private Container c = getContentPane();

	
	/**
	 * Constructor de la clase AccesoView
	 */
	public AccesoView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Acceso");
		this.setBounds(100, 100, 270, 186);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		c.setLayout(null);
		
		btnAcceder.setBounds(10, 97, 120, 30);
		btnRegistrarse.setBounds(134, 97, 120, 30);
		
		lblUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUsuario.setBounds(0, 31, 116, 14);
		
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword.setBounds(10, 59, 106, 14);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(122, 28, 132, 20);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(122, 56, 132, 20);
		
		c.add(btnAcceder);
		c.add(btnRegistrarse);
		c.add(lblUsuario);
		c.add(lblPassword);
		c.add(txtUsuario);
		c.add(txtPassword);
	}

	/**
	 * @return the btnAcceder
	 */
	public JButton getBtnAcceder() {
		return btnAcceder;
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
		btnAcceder.addActionListener(al);
		btnRegistrarse.addActionListener(al);
	}
	
	/**
	 * Método para mostrar la ventana de registro de usuarios
	 */
	public void mostrarVentanaRegistro(){
		RegistroView registroView = new RegistroView();
		RegistroController registroController = new RegistroController(registroView);
		this.setVisible(false);
		registroView.setVisible(true);
	}
}
