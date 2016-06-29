package modelo;

/**
 * 
 * @author DanielBP
 *
 */
public final class UsuarioModel {
	
	private static final UsuarioModel usuarioModel = new UsuarioModel();

	private int idUsuario;
	private String nombreUsuario;
	private String passwordUsuario;
	
	/**
	 * constructor privado de la clase UsuarioModel
	 */
	private UsuarioModel(){
		super();
	}
	
	public static UsuarioModel getUsuarioModel(){
		return usuarioModel;
	}
	
	/**
	 * @return the idUsuario
	 */
	public int getIdUsuario() {
		return idUsuario;
	}

	/**
	 * @param idUsuario the idUsuario to set
	 */
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
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
	 * @return the passwordUsuario
	 */
	public String getPasswordUsuario() {
		return passwordUsuario;
	}

	/**
	 * @param passwordUsuario the passwordUsuario to set
	 */
	public void setPasswordUsuario(String passwordUsuario) {
		this.passwordUsuario = passwordUsuario;
	}

	/**
	 * M�todo para limpiar el m�delo
	 */
	public void limpiarModelo(){
		nombreUsuario=null;
		passwordUsuario=null;
	}
}
