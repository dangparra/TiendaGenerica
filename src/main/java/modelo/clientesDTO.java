package modelo;

public class clientesDTO {
	private Long cc_cliente;
	private String dir_cliente;
	private String email_cliente;
	private String nombre_cliente;
	private String telefono_cliente;
	

	

	public clientesDTO(Long cc_cliente, String dir_cliente, String email_cliente, String nombre_cliente,
			String telefono_cliente) {
		
		this.cc_cliente = cc_cliente;
		this.dir_cliente = dir_cliente;
		this.email_cliente = email_cliente;
		this.nombre_cliente = nombre_cliente;
		this.telefono_cliente = telefono_cliente;
	}


	public clientesDTO(long cc_cli) {
		// TODO Auto-generated constructor stub
	}

	public long getCc_cliente() {
		return cc_cliente;
	}
	

	public void setCc_cliente(long cc_cliente) {
		this.cc_cliente = cc_cliente;
	}
	public String getDir_cliente() {
		return dir_cliente;
	}
	public void setDir_cliente(String dir_cliente) {
		this.dir_cliente = dir_cliente;
	}
	public String getEmail_cliente() {
		return email_cliente;
	}
	public void setEmail_cliente(String email_cliente) {
		this.email_cliente = email_cliente;
	}
	public String getNombre_cliente() {
		return nombre_cliente;
	}
	public void setNombre_cliente(String nombre_cliente) {
		this.nombre_cliente = nombre_cliente;
	}
	public String getTelefono_cliente() {
		return telefono_cliente;
	}
	public void setTelefono_cliente(String telefono_cliente) {
		this.telefono_cliente = telefono_cliente;
	}
	
	

	

}
