package lecturaescrituraficheros;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

/**
 * Programa que solicita al usuario el identificador de una persona, el nombre
 * de la persona y el grupo al que pertenece; y dicha información la guardará en
 * CSV dentro de un fichero que se llama registro.txt. El programa terminará
 * cuando el usuario introduzca como identificador de persona un 0
 */
public class Ejercicio2 {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		
		//necesito declararlo antes para utilizarlo en el while
		String idPersona="";
		String nombrePersona ="";
		String grupoPersona="";
		
		while (!idPersona.equals("0")) {
			
			System.out.print("Id persona: ");
			idPersona = s.nextLine();
			if (!idPersona.equals("0")) {
				System.out.print("Nombre persona: ");
				nombrePersona = s.nextLine();
				
				System.out.print("Grupo persona: ");
				grupoPersona = s.nextLine();
				
				escribirInformacion(idPersona, nombrePersona, grupoPersona);
			}

		}

	}

	public static void escribirInformacion(String id, String nombre, String grupo) {
		BufferedWriter fw = null;

		try {
			fw = new BufferedWriter(new FileWriter("registro.csv", true));
			fw.write(id+","+nombre+","+grupo);
			fw.newLine();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

			try {
				if (fw != null)	fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

	
	
	
}
