package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

/**
 * 
 * @author DanielBP
 *
 */
public final class ConexionBD {
	
	private static final ConexionBD conexionBD = new ConexionBD();

	private String nombreBD;
	private String usuario;
	private String passw;
	private String ruta;
	
	/**
	 * Constructor de la clase ConexionBD
	 */
	private ConexionBD(){
		nombreBD="pullmensajes";
		usuario="root";
		passw=null;
		ruta="jdbc:mysql://localhost/"+nombreBD;
	}
	
	/**
	 * M�todo para recuperar la instancia de la clase ConexionBD
	 * @return conexionBD instancia de la clase
	 */
	public static ConexionBD getConexionBD(){
		return conexionBD;
	}
	
	/**
	 * M�todo para ejecutar la conexion con la BD
	 * @return conn Resultado de la conexi�n
	 */
	public Connection conectarBD(){
		Connection conn=null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn=DriverManager.getConnection(ruta, usuario, passw);
			JOptionPane.showMessageDialog(null, "Conexi�n al pull de mensajes exitosa");
		} catch (InstantiationException e) {
			JOptionPane.showMessageDialog(null, "Conexi�n al pull de mensajes fallida \n\n"
					+ "Motivo: No se pudo crear la instancia con el driver", "Conexi�n fallida", JOptionPane.ERROR_MESSAGE);
		} catch (IllegalAccessException e) {
			JOptionPane.showMessageDialog(null, "Conexi�n al pull de mensajes fallida \n\n"
					+ "Motivo: No tiene acceso al driver", "Conexi�n fallida", JOptionPane.ERROR_MESSAGE);
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Conexi�n al pull de mensajes fallida \n\n"
					+ "Motivo: No encontro el driver", "Conexi�n fallida", JOptionPane.ERROR_MESSAGE);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Conexi�n al pull de mensajes fallida \n\n"
					+ "Motivo: Nombre de usuario o contrase�a incorrectos", "Conexi�n fallida", JOptionPane.ERROR_MESSAGE);
		}
		return conn;
	}
		
	/**
	 * M�todo para testear conexion con la BD
	 * @param args metodo main
	 */
	public static void main(String[] args) {
		 ConexionBD obj = getConexionBD();
			obj.conectarBD();
	}

}