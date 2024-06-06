package lecturaescrituraficheros;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

/**
 * Ejercicio en el que se generarán dos ficheros con n números aleatorios y
 * posteriormente se sumarán o restarán en otro fichero
 */
public class Ejercicios1 {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		System.out.print("Introduce número de números dentro de los ficheros: ");
		int n = s.nextInt();
		s.nextLine();

		generarFichero("fichero1.txt", n);
		generarFichero("fichero2.txt", n);

		System.out.print("¿suma o resta? ");
		String operacion = s.nextLine();
		System.out.println(operacion);

		if (operacion.equalsIgnoreCase("suma") || operacion.equalsIgnoreCase("resta")) {

			realizarOperacion(operacion, "fichero1.txt", "fichero2.txt");

		} else {
			System.out.println("la operacion indicada no es la correcta");
		}

	}

	public static void realizarOperacion(String operacion, String f1, String f2) {

		BufferedReader br1 = null;
		BufferedReader br2 = null;

		BufferedWriter fw = null;

		try {
			fw = new BufferedWriter(new FileWriter("fichero3.txt"));
			br1 = new BufferedReader(new FileReader(f1));
			br2 = new BufferedReader(new FileReader(f2));

			String linea1 = br1.readLine();
			String linea2 = br2.readLine();
			while (linea1 != null && linea2 != null) {

				Integer n1 = Integer.parseInt(linea1);
				Integer n2 = Integer.parseInt(linea2);

				if (operacion.equalsIgnoreCase("suma")) {
					fw.write(String.valueOf(n1 + n2));
				} else if (operacion.equalsIgnoreCase("resta")) {
					fw.write(String.valueOf(n1 - n2));
				}
				fw.newLine();

				linea1 = br1.readLine();
				linea2 = br2.readLine();
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {

			try {
				if (fw != null)
					fw.close();
				if (br1 != null)
					br1.close();
				if (br2 != null)
					br2.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

	/**
	 * función que genera un fichero de nombre 'nombre' con n nuúmeros aleatorios
	 */
	public static void generarFichero(String nombre, int n) {

		BufferedWriter fw = null;

		try {
			fw = new BufferedWriter(new FileWriter(nombre));

			Random r = new Random();

			for (int i = 0; i < n; i++) {
				fw.write(String.valueOf(r.nextInt(100)));
				if (i < n - 1) {
					fw.newLine();
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {

			try {
				if (fw != null)
					fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

}
