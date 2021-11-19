package arreglo;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;


import clase.Cliente;
import clase.Ventas;

public class ArregloCliente {
	private ArrayList<Cliente> cli;
	
public ArregloCliente(){

	cli = new ArrayList<Cliente>();
	cargarClientes();
	
}
	public void adicionar(Cliente x){
	cli.add(x);
	GrabarClientes();
	}
	public int tamaño(){
	return cli.size();
	}
	public Cliente obtener(int i){
	return cli.get(i);
	}
	public Cliente buscar(int codigo) {
	for (int i=0; i<tamaño(); i++)
		if (obtener(i).getCodigo() == codigo)
			return obtener(i);
	return null;
	}
	public void eliminar(Cliente x) {
	cli.remove(x);
	GrabarClientes();
	}

	private void GrabarClientes() {
		try {
			PrintWriter pw;
			String linea;
			Cliente x;
			pw = new PrintWriter(new FileWriter("clientes.txt"));
			for(int i = 0;i<tamaño() ;i ++){
				x = obtener(i);
				linea = x.getCodigo() + ";" +
				        x.getNombre() + ";" +
						x.getApellido() + ";" + 
				        x.getEdad() + ";" +
						x.getDni() + ";" + 
				        x.getTlf();
				pw.println(linea);
			}
			pw.close();
		}
		catch (Exception e){
			
		}
	}

	private void cargarClientes() {
		try {
			BufferedReader br;
			String linea, nombre,apellido;
			String[] s;
			int codigo,edad, dni, tlf;
			double precio;
			br = new BufferedReader(new FileReader("clientes.txt"));
			while ((linea = br.readLine()) != null) {
				s = linea.split(";");
				codigo = Integer.parseInt(s[0].trim());
				nombre = s[1].trim();
				apellido = s[2].trim();
				edad = Integer.parseInt(s[3].trim());
				dni = Integer.parseInt(s[4].trim());
				tlf = Integer.parseInt(s[5].trim());
				adicionar(new Cliente(codigo, nombre, apellido, edad, dni, tlf));
			}
			br.close();
		}
		catch (Exception e) {
		}
	}
}
