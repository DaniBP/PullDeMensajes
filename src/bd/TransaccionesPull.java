package bd;

import java.sql.SQLException;
import java.util.List;

import modelo.UsuarioModel;
import modelo.MensajeModel;;

/**
 * 
 * @author DanielBP
 *
 */
public interface TransaccionesPull {
	
	/**
	 * Método para registrar un usuario en la BD 
	 * @param usuarioModel modelo del usuario
	 * @throws SQLException Excepción de transacción SQL
	 */
	public void registrarUsuario(UsuarioModel usuarioModel) throws SQLException;
	
	/**
	 * Método para verificar el acceso del usuario
	 * @param usuarioModel modelo del usuario
	 * @return boolean estado del acceso
	 * @throws SQLException Excepción de la transacción SQL
	 */
	public boolean verificarUsuario(UsuarioModel usuarioModel) throws SQLException;
	
	/**
	 * Método para consultar los mensajes del pull
	 * @return Lista con los modelos de los mensajes
	 * @throws SQLException Excepción de la transacción SQL
	 */
	public List<MensajeModel> consultarMensajes() throws SQLException;
	
	/**
	 * Método para agregar un nuevo mensaje al pull
	 * @param mensajeModel modelo del mensaje
	 * @throws SQLException Excepción de la transacción SQL
	 */
	public void agregarMensaje(MensajeModel mensajeModel) throws SQLException;
}
