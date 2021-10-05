package modelo;
 
public class ProveedorDTO {

	private Long nit_proveedor;
	private String nombre_proveedor; 
	private String dir_proveedor;
	private String tel_proveedor;
	private String ciudad_proveedor;
	
	//constructores general
	
		public ProveedorDTO(Long nit_proveedor, String nombre_proveedor, String dir_proveedor, String tel_proveedor,
				String ciudad_proveedor) {
			super();
			this.nit_proveedor = nit_proveedor;
			this.nombre_proveedor = nombre_proveedor;
			this.dir_proveedor = dir_proveedor;
			this.tel_proveedor = tel_proveedor;
			this.ciudad_proveedor = ciudad_proveedor;
		}
		// constructor nit proveedor
		
		public Long getNit_proveedor() {
			return nit_proveedor;
		}
		public ProveedorDTO(Long nit_proveedor) {
			super();
			this.nit_proveedor = nit_proveedor;
		}
		
		//setters y getters
		public void setNit_proveedor(Long nit_proveedor) {
			this.nit_proveedor= nit_proveedor;
		}
	
		public void setNombre_proveedor(String nombre_proveedor	) {
			this.nombre_proveedor= nombre_proveedor;
		}
		public String getNombre_proveedor() {
			return nombre_proveedor;
		}
		public void setDir_proveedor(String dir_proveedor	) {
			this.dir_proveedor= dir_proveedor;
		}
		public String getDir_proveedor() {
			return dir_proveedor;
		}
		public void setTel_proveedor(String tel_proveedor	) {
			this.tel_proveedor= tel_proveedor;
		}
		public String getTel_proveedor() {
			return tel_proveedor;
		}
		public void setCiudad_proveedor(String ciudad_proveedor	) {
			this.ciudad_proveedor= ciudad_proveedor;
		}
		public String getCiudad_proveedor() {
			return ciudad_proveedor;
		}

}
