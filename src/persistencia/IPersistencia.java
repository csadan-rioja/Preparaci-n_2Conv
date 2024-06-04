package persistencia;

import java.util.ArrayList;

public interface IPersistencia {

	/**
	 * El siguiente método devolverá una lista de videojuegos disponibles para la
	 * plataforma que se pase por parámetro.
	 * 
	 * @param idPlataforma identificador de la plataforma para la que quieres
	 *                     consultar qué videojuegos hay
	 * @return lista de videojuegos disponibles para la plataforma con identificador
	 *         idPlataforma
	 */
	public ArrayList<Videojuego> consultarVideojuegos(Integer idPlataforma);

	/**
	 * El siguiente método insertará dentro de la base de datos la relación entre el
	 * videojuego que se pasa por parámetro y la plataforma que se pasa por
	 * parámetro. En caso de no existir el videojuego en la base de datos, deberá
	 * insertarlo, y en caso de no existir la plataforma, también deberá insertarla.
	 * Como media de seguridad, las instrucciones sobre la base de datos que
	 * ejecutes deberán ejecutarse de forma atómica; es decir, o se ejecutan todas
	 * correctamente o ninguna.
	 * 
	 * @param vj objeto de tipo Videojuego
	 * @param pf objeto de tipo Plataforma
	 * @return devolverá verdadero si ha conseguido insertar en la base de datos la
	 *         relación entre el videojuego y la plataforma.
	 */
	public Boolean insertarVideojuegoPlataforma(Videojuego vj, Plataforma pf);

}
