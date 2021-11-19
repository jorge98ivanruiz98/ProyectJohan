package clase;

public class Cargos {
	private String cargo;
	private double sueldo;
	
public Cargos(String cargo, double sueldo){
	this.cargo = cargo;
	this.sueldo = sueldo;
}

public String getCargo() {
	return cargo;
}

public void setCargo(String cargo) {
	this.cargo = cargo;
}

public double getSueldo() {
	return sueldo;
}

public void setSueldo(double sueldo) {
	this.sueldo = sueldo;
}

}
