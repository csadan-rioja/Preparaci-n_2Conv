package ficheros;

import java.io.File;
import java.io.IOException;

public class EjerciciosFicheros {

	public static void main(String[] args) {
		generarArbolDirectorios();
	}

	/**
	 * Generar un sistema de directorios donde Directorio 1 será el padre y tenga
	 * como hijos los ficheros llamados fichero1.txt, fichero2.txt y el directorio
	 * llamado Directorio2. El Directorio 2 tendrá dentro un fichero llamado
	 * fichero21.txt
	 */
	public static void generarArbolDirectorios() {
		try {
			File directorio1 = new File("Directorio1");

			if (directorio1.mkdir()) {
				System.out.println("Directorio llamado Directorio 1 creado");
			}

			// File fichero1 = new File("Directorio1/fichero1.txt");
			File fichero1 = new File(directorio1, "fichero1.txt");
			if (fichero1.createNewFile()) {
				System.out.println("Fichero llamado fichero1.txt creado");
			}

			File fichero2 = new File(directorio1, "fichero2.txt");
			if (fichero2.createNewFile()) {
				System.out.println("Fichero llamado fichero2.txt creado");
			}

			File directorio2 = new File(directorio1, "Directorio2");
			if (directorio2.mkdir()) {
				System.out.println("Directorio llamado Directorio2 creado");
			}
			File fichero21 = new File(directorio2, "fichero21.txt");
			if (fichero21.createNewFile()) {
				System.out.println("Fichero llamado fichero21.txt creado");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Mostrar información del fichero pasado como parámetro. 
	 * */
	public static void mostrarInformacionFichero(File f) {
		
		if(f.exists() && f.isFile()) {
			System.out.println(f.get....);
			
			
		}else {
			System.out.println("El parametro no es un fichero o no existe");
		}
		
	}
	
}
