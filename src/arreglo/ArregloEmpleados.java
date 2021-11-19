package arreglo;
import java.util.ArrayList;


import clase.Empleados;

public class ArregloEmpleados {
	private ArrayList<Empleados> emp;

	public ArregloEmpleados(){
		
		emp = new ArrayList<Empleados>();
		adicionar(new Empleados(1001,"Juan","Perez","74027395",19,"950773530"));
		adicionar(new Empleados(1002,"Rosa","Chavez","33123340",21,"960323003"));
		adicionar(new Empleados(1003,"Alberto","Rodrigues","75033245",28,"980977875"));
	}
	public void adicionar(Empleados x){
		emp.add(x);
		}
		public int tamaño(){
		return emp.size();
		}
		public Empleados obtener(int i){
		return emp.get(i);
		}
		public Empleados buscar(int codigo) {
		for (int i=0; i<tamaño(); i++)
			if (obtener(i).getCodigo() == codigo)
				return obtener(i);
		return null;
		}
		public void eliminar(Empleados x) {
		emp.remove(x);
		}
}
