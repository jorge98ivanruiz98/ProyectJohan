package arreglo;



import clase.Cliente;
import clase.Ventas;

import java.io.FileWriter;
import java.util.ArrayList;
import java.io.*;

public class ArregloVentas {
	
	//  Atributo privado
	private ArrayList <Ventas> alu;
	//  Constructor
	public ArregloVentas() {
    	alu = new ArrayList <Ventas> ();
    	cargarVentas();
    }
	//  Operaciones públicas básicas
	public void adicionar(Ventas x) {
		alu.add(x);
		GrabarVentas();
	}
	public int tamanio() {
		return alu.size();
	}
	public Ventas obtener(int i) {
		return alu.get(i);
	}
	//  Operaciones públicas complementarias
	public double Ganancias() {
    	double ganancias = 0.0;
    	for (int i=0; i<tamanio(); i++)
        	ganancias += obtener(i).importepagar();
	    return ganancias ;
    }
	public int NumeroCorrelativo(){
		if(tamanio() == 0)
			return 10001;
		else 
			return obtener(tamanio() -1).getCodigo();
	}
	private void GrabarVentas() {
		try {
			PrintWriter pw;
			String linea;
			Ventas x;
			Cliente c;
			pw = new PrintWriter(new FileWriter("ventas.txt"));
			for(int i = 0;i<tamanio() ;i ++){
				x = obtener(i);
				linea = x.getCodigo() + ";" +
						x.getNombre() + ";" +
						x.getApellido() + ";" +
				        x.getCantidad() + ";" +
						x.getModelo() + ";" + 
				        x.getPrecio();
				pw.println(linea);
			}
			pw.close();
		}
		catch (Exception e){
			
		}
	}

	private void cargarVentas() {
		try {
			BufferedReader br;
			String linea, nombre,apellido,modelo;
			String[] s;
			int codigo, cantidad;
			double precio;
			br = new BufferedReader(new FileReader("ventas.txt"));
			while ((linea = br.readLine()) != null) {
				s = linea.split(";");
				codigo = Integer.parseInt(s[0].trim());
				nombre = s[1];
				apellido = s[2];
				cantidad = Integer.parseInt(s[3].trim());
				modelo = s[4].trim();
				precio = Double.parseDouble(s[5].trim());
				adicionar(new Ventas(codigo,apellido,nombre, cantidad, modelo, precio));
			}
			br.close();
		}
		catch (Exception e) {
		}
	}
	public void actualizarArchivo(){
		GrabarVentas();
	}
	public void Eliminar(Ventas x){
		alu.remove(x);
		GrabarVentas();
	}
	public Ventas buscar(int codigo) {
		for (int i=0; i<tamanio(); i++)
			if (obtener(i).getCodigo() == codigo)
				return obtener(i);
		return null;
	}
}

