package arreglo;
import java.util.ArrayList;
import clase.Cargos;
import clase.Empleados;

public class ArregloCargos {
	private ArrayList<Cargos> car;
	
	public ArregloCargos(){
		car = new ArrayList<Cargos>();
	}
	public void adicionar(Cargos x){
		car.add(x);
		}
		public int tamaño(){
		return car.size();
		}
		public Cargos obtener(int i){
		return car.get(i);
		}
		public void eliminar(Cargos x) {
		car.remove(x);
		}
}
