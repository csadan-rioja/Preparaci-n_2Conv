package creacionclases.gestionempleados;

public class Desarrollador extends Empleado {

	private String[] listaLenguajes;

	public Desarrollador(String nombre, Integer idEmpleado, Double salario) {
		super(nombre, idEmpleado, salario);
		this.listaLenguajes = new String[100];
	}
	
	
	
}
