package modelo;

/**
 * 
 * @author DanielBP
 *
 */
public final class UsuarioModel {
	
	private static final UsuarioModel usuarioModel = new UsuarioModel();

	private String nombreUsuario;
	private String passwors;
	
	/**
	 * constructor privado de la clase UsuarioModel
	 */
	private UsuarioModel(){
		
	}
	
	public static UsuarioModel getUsuarioModel(){
		return usuarioModel;
	}
	
	/**
	 * @return the nombreUsuario
	 */
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	/**
	 * @param nombreUsuario the nombreUsuario to set
	 */
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	/**
	 * @return the passwors
	 */
	public String getPasswors() {
		return passwors;
	}
	/**
	 * @param passwors the passwors to set
	 */
	public void setPasswors(String passwors) {
		this.passwors = passwors;
	}
}
