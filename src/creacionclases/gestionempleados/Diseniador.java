package creacionclases.gestionempleados;

public class Diseniador extends Empleado {
	private String[] listaHerramientas;

	public Diseniador(String nombre, Integer idEmpleado, Double salario) {
		super(nombre, idEmpleado, salario);
		this.listaHerramientas = new String[100];
	}
	
	

}
