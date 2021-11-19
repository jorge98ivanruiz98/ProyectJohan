package clase;

public class Cliente {
	int codigo;
	private String  nombre,apellido;
	private int edad, dni,tlf;
	
	public Cliente(int codigo, String nombre, String apellido, int edad, int dni, int tlf){
		this.codigo = codigo;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.dni = dni;
		this.tlf = tlf;
	}
	
	public void setDni(int dni){
		this.dni = dni;
	}
	public int getDni() {
		return dni;
	}
	public void setTlf(int tlf){
		this.tlf = tlf;
	}
	public int getTlf() {
		return tlf;
	}


	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

}
