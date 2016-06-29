package vista;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controlador.AccesoController;

/**
 * 
 * @author DanielBP
 *
 */
public class PullMensajesView extends JFrame{
	private JScrollPane scrollPane = new JScrollPane();
	private JLabel lblMensaje = new JLabel("Escribir mensaje:");
	private JTextField txtMensaje = new JTextField();
	private JButton btnAgregar = new JButton("Agregar");
	private JTable table = new JTable();
	private JButton btnCambiarUsuario;
	
	private Container c = getContentPane();

	
	/**
	 * Constructor de la clase PullMensajesView
	 */
	public PullMensajesView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Pull de mensajes");
		this.setBounds(100, 100, 720, 340);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		c.setLayout(null);
		
		scrollPane.setBounds(10, 11, 694, 198);
		scrollPane.getVerticalScrollBar().setUnitIncrement(10);
		
		btnAgregar.setBounds(614, 248, 90, 20);
		lblMensaje.setVerticalAlignment(SwingConstants.TOP);
		lblMensaje.setHorizontalAlignment(SwingConstants.LEFT);
		lblMensaje.setBounds(10, 225, 124, 20);
		txtMensaje.setBounds(10, 248, 594, 20);
		
		c.add(scrollPane);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Usuario", "Mensaje", "Fecha", "Hora"
			}
		){
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		});
		table.getColumnModel().getColumn(1).setPreferredWidth(300);
		table.getColumnModel().getColumn(2).setPreferredWidth(150);
		table.getColumnModel().getColumn(3).setPreferredWidth(50);
		
		scrollPane.setViewportView(table);
		c.add(btnAgregar);
		c.add(lblMensaje);
		c.add(txtMensaje);
		
		btnCambiarUsuario = new JButton("Cambiar usuario");
		btnCambiarUsuario.setBounds(10, 279, 130, 23);
		getContentPane().add(btnCambiarUsuario);
	}

	/**
	 * @return the scrollPane
	 */
	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	/**
	 * @return the txtMensaje
	 */
	public JTextField getTxtMensaje() {
		return txtMensaje;
	}

	/**
	 * @return the btnAgregar
	 */
	public JButton getBtnAgregar() {
		return btnAgregar;
	}

	/**
	 * @return the table
	 */
	public JTable getTable() {
		return table;
	}
	
	/**
	 * @return the btnCambiarUsuario
	 */
	public JButton getBtnCambiarUsuario() {
		return btnCambiarUsuario;
	}

	/**
	 * Método para agregar el evento click al boton
	 * @param al evento click
	 */
	public void onClickBotones(ActionListener al){
		btnAgregar.addActionListener(al);
		btnCambiarUsuario.addActionListener(al);
	}
	
	/**
	 * Método para mostrar mensaje en pantalla
	 * @param mensaje generado
	 */
	public void mostrarMensaje(String mensaje){
		JOptionPane.showMessageDialog(this, mensaje);
	}
	
	/**
	 * Método para mostrar alerta en pantalla
	 * @param alerta generada
	 */
	public void mostrarAlerta(String alerta){
		JOptionPane.showMessageDialog(this, alerta, "Alerta", JOptionPane.WARNING_MESSAGE);
	}
	
	/**
	 * Método para mostrar error en pantalla
	 * @param error generado
	 */
	public void mostrarError(String error){
		JOptionPane.showMessageDialog(this, error, "Error", JOptionPane.ERROR_MESSAGE);
	}
	
	/**
	 * Método para limpiar ventana
	 */
	public void limpiarVentana(){
		txtMensaje.setText(null);
	}
	
	public void mostrarInicio(){
		AccesoView accesoView=new AccesoView();
		AccesoController accesoController=new AccesoController(accesoView);
		this.setVisible(false);
		accesoView.setVisible(true);
	}
}
