package clase;

public class Ventas {
	
	//  Atributos privados
	private double  importepagar,descuento,precio;
	private int codigo,cantidad;
	private String nombre, apellido,modelo;	
	//  Constructor
   
	//  Operaciones públicas
	
	public Ventas(int codigo,String nombre, int cantidad, String modelo, double precio) {
		
		this.codigo = codigo;
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.modelo = modelo;
		this.precio = precio;
		
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double descuento() {
		if(cantidad >=5)
			
		
			return precio * 0.18;
		
			else if (cantidad >=10)
				return precio * 0.40;
			else {
				return 0;
			}
	}
	public double importepagar(){
		return (precio * cantidad) - descuento();
	}
	
}