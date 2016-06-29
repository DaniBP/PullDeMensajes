package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import bd.GestionBD;
import modelo.MensajeModel;
import modelo.UsuarioModel;
import vista.PullMensajesView;

/**
 * 
 * @author DanielBP
 *
 */
public class PullMensajesController implements ActionListener{
	private PullMensajesView pullMensajesView;
	private UsuarioModel usuarioModel;
	private List<MensajeModel> listaMensajes;
	private GestionBD gestionBD;
	
	/**
	 * Constructor de la clase PullMensajesController
	 * @param pullMensajesView Vista
	 */
	public PullMensajesController(PullMensajesView pullMensajesView) {
		this.pullMensajesView=pullMensajesView;
		this.usuarioModel=UsuarioModel.getUsuarioModel();
		this.gestionBD=GestionBD.getGestionBD();
		
		pullMensajesView.onClickBotones(this);
		
		cargarPull();
	}

	/**
	 * Método para cargar los mensajes del pull a la ventana
	 */
	private void cargarPull() {
		try {
			listaMensajes=gestionBD.consultarMensajes();
		} catch (SQLException e) {
			e.getMessage();
		}
		
		DefaultTableModel modelo = (DefaultTableModel) pullMensajesView.getTable().getModel();
		Object a[]={null};
		int count = modelo.getRowCount();
		
		for (int i = 0; i < count; i++) {
			modelo.removeRow(0);
		}
		
		for (int i = 0; i < listaMensajes.size(); i++) {
			modelo.addRow(a);
			
			pullMensajesView.getTable().setValueAt(listaMensajes.get(i).getNombreUsuario(), i, 0);
			pullMensajesView.getTable().setValueAt(listaMensajes.get(i).getMensaje(), i, 1);
			pullMensajesView.getTable().setValueAt(listaMensajes.get(i).getFecha(), i, 2);
			pullMensajesView.getTable().setValueAt(listaMensajes.get(i).getHora(), i, 3);
		}
		pullMensajesView.getScrollPane().getVerticalScrollBar().setValue(pullMensajesView.getScrollPane().getVerticalScrollBar().getMaximum());
	}

	/**
	 * Método que controla el evento del boton
	 */
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==pullMensajesView.getBtnAgregar()){
			if (pullMensajesView.getTxtMensaje().getText().isEmpty()){
				pullMensajesView.mostrarAlerta("Ingresar mensaje");
				return;
			}
			
			MensajeModel mensajeModel = new MensajeModel();
			
			String[] meses = new String[]{
					"Enero",
					"Febrero",
					"Marzo",
					"Abril",
					"Mayo",
					"Junio",
					"Julio",
					"Agosto",
					"Septiembre",
					"Octubre",
					"Noviembre",
					"Diciembre"}; 
			
			Calendar now = Calendar.getInstance();
			
			int dia = now.get(Calendar.DAY_OF_MONTH);
			String mes = meses[now.get(Calendar.MONTH)];
			int año = now.get(Calendar.YEAR);
			String hora,minutos,segundos,ampm;
			
			ampm = now.get(Calendar.AM_PM)==Calendar.AM?"AM":"PM";

			if(ampm.equals("PM")){
			 int h = now.get(Calendar.HOUR_OF_DAY)-12;

			 hora = h>9?""+h:"0"+h;

			}else{
				hora = now.get(Calendar.HOUR_OF_DAY)>9?""+now.get(Calendar.HOUR_OF_DAY):"0"+now.get(Calendar.HOUR_OF_DAY);            
			}
			
			minutos = now.get(Calendar.MINUTE)>9?""+now.get(Calendar.MINUTE):"0"+now.get(Calendar.MINUTE);
			segundos = now.get(Calendar.SECOND)>9?""+now.get(Calendar.SECOND):"0"+now.get(Calendar.SECOND);
		
			
			mensajeModel.setNombreUsuario(usuarioModel.getNombreUsuario());
			mensajeModel.setMensaje(pullMensajesView.getTxtMensaje().getText());
			mensajeModel.setFecha(dia+" de "+mes+" de "+año);
			mensajeModel.setHora(hora+":"+minutos+":"+segundos+" "+ampm);
			
			try {
				gestionBD.agregarMensaje(mensajeModel);
			} catch (SQLException e) {
				e.getMessage();
			}
			
			pullMensajesView.limpiarVentana();
			
			cargarPull();
		}else if(ae.getSource()==pullMensajesView.getBtnCambiarUsuario()){
			pullMensajesView.mostrarInicio();
		}
	}
}
