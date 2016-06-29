package bd;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import modelo.MensajeModel;
import modelo.UsuarioModel;

/**
 * 
 * @author DanielBP
 *
 */
public final class GestionBD implements TransaccionesPull{
	
	private static final GestionBD gestionBD = new GestionBD(); 
	
	private Connection lineaConexion;
	private Statement sentencia;
	
	/**
	 * Constructor de la clase GestionBD
	 */
	private GestionBD(){
		lineaConexion=ConexionBD.getConexionBD().conectarBD();
	}
	
	/**
	 * Método para recuperar estancia de la clase GestionBD
	 * @return GestionBD instancia de la clase
	 */
	public static GestionBD getGestionBD(){
		return gestionBD;
	}
	
	/**
	 * Metodo para ejecutar una sentencia SQL
	 * @param sentenciaBD Sentencia que será ejecutada
	 */
	public void ejecutar(String sentenciaSQL){
		try {
			sentencia=lineaConexion.createStatement();
			sentencia.execute(sentenciaSQL);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "No se pudo ejecutar la sentencia"+e, "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Método para ejecutar una consulta SQL
	 * @param sentenciaSQL sentencia de la consulta que será ejecutada
	 * @return rs ResultSet resultado de la consulta
	 */
	public ResultSet consultar(String sentenciaSQL) {
		ResultSet rs=null;
		try {
			sentencia=lineaConexion.createStatement();
			rs=sentencia.executeQuery(sentenciaSQL);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "No se pudo realizar la consulta"+e,"Error",JOptionPane.ERROR_MESSAGE);
		}
		return rs;
	}
	
	/**
	 * Método para testear conexión a BD
	 * @param args
	 */
	public static void main(String[] args) {
		GestionBD.getGestionBD();
	}

	/**
	 * Método para registrar usuario
	 */
	@Override
	public void registrarUsuario(UsuarioModel usuarioModel) throws SQLException {
		String sql="INSERT INTO t_usuario (nombreUsuario,passwordUsuario) VALUES"
				+ "('"+usuarioModel.getNombreUsuario()+"',"
				+ "'"+usuarioModel.getPasswordUsuario()+"')";
		try {
			sentencia=lineaConexion.createStatement();
			sentencia.execute(sql);
		} catch (SQLException e) {
			System.out.println(e);
			throw new SQLException("No se pudo registrar el usuario");
		}
		usuarioModel.limpiarModelo();
	}

	/**
	 * Método para validar el acceso al usuario
	 */
	@Override
	public boolean verificarUsuario(UsuarioModel usuarioModel) throws SQLException {
		String sql = "SELECT * FROM t_usuario WHERE "
				+ "nombreUsuario = '"+usuarioModel.getNombreUsuario()+"' AND "
				+ "passwordUsuario = '"+usuarioModel.getPasswordUsuario()+"'";
		
		ResultSet rs=null;
		
		try {
			sentencia=lineaConexion.createStatement();
			rs=sentencia.executeQuery(sql);
		} catch (SQLException e) {
			System.out.println(e);
			throw new SQLException("No se pudo realizar la consulta");
		}
		
		if(rs.next()){
			usuarioModel.setIdUsuario(rs.getInt("idUsuario"));
			return true;
		}else{
			usuarioModel.limpiarModelo();
			return false;
		}
	}

	/**
	 * Método para consultar los mensajes almacenados en el pull
	 */
	@Override
	public List<MensajeModel> consultarMensajes() throws SQLException {
		
		List<MensajeModel> lista=new ArrayList<MensajeModel>();
				
		String sql = "SELECT * FROM t_mensaje";
		
		ResultSet rs=null;
		
		try {
			sentencia=lineaConexion.createStatement();
			rs=sentencia.executeQuery(sql);
			
			int c=0;
			
			while (rs.next()) {
				lista.add(new MensajeModel());
				lista.get(c).setIdMensaje(rs.getInt("idMensaje"));
				lista.get(c).setNombreUsuario(rs.getString("nombreUsuario"));
				lista.get(c).setMensaje(rs.getString("mensaje"));
				lista.get(c).setFecha(rs.getString("fecha"));
				lista.get(c).setHora(rs.getString("hora"));
				c++;
			}
		} catch (SQLException e) {
			System.out.println(e);
			throw new SQLException("No se pudo realizar la consulta");
		}
		
		return lista;
	}

	/**
	 * Método para agregar mensajes al pull
	 */
	@Override
	public void agregarMensaje(MensajeModel mensajeModel) throws SQLException {
		
		String sql="INSERT INTO t_mensaje VALUES(null,"
				+ "'"+mensajeModel.getNombreUsuario()+"',"
				+ "'"+mensajeModel.getMensaje()+"',"
				+ "'"+mensajeModel.getFecha()+"',"
				+ "'"+mensajeModel.getHora()+"')";
		
		try {
			sentencia=lineaConexion.createStatement();
			sentencia.execute(sql);
		} catch (SQLException e) {
			System.out.println(e);
			throw new SQLException("No se pudo insertar el mensaje");
		}
	}
}