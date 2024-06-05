package creacionclases.gestionempleados;

public class Tester extends Empleado {
	private Integer nBugsIdentificados;

	public Tester(String nombre, Integer idEmpleado, Double salario, Integer nBugsIdentificados) {
		super(nombre, idEmpleado, salario);
		this.nBugsIdentificados = nBugsIdentificados;
	}
	
	
	
}
