package creacionclases.gestionempleados;

public abstract class Empleado {
	private String nombre;
	private Integer idEmpleado;
	private Double salario;

	public Empleado(String nombre, Integer idEmpleado, Double salario) {
		this.nombre=nombre;
		this.idEmpleado=idEmpleado;
		this.salario=salario;
	}

}
