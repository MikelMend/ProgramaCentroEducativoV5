package profesores;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.Iterator;

public class FuncionesFicheros {

	public static void GuardarDatosPersonas(TreeMap<String, Persona> lista) throws IOException {
		try {
			FileOutputStream fichero = new FileOutputStream("C:\\ProyectoCentro\\Personas.dat");
			ObjectOutputStream grabarDatos = new ObjectOutputStream(fichero);
			grabarDatos.writeObject(lista);

			if (fichero != null)
				fichero.close();
			if (grabarDatos != null)
				grabarDatos.close();

		} catch (FileNotFoundException e) {
			System.out.println("Error! Fichero no encontrado.");
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}

	}

	public static TreeMap<String, Persona> obtenerTreeMapDeArchivo(File fichero) throws Exception {

		TreeMap<String, Persona> lista = new TreeMap<String, Persona>();

		try {

			if (!fichero.exists())
				throw new Exception("El fichero no existe.");
			FileInputStream entrada = new FileInputStream(fichero);
			ObjectInputStream lecturaDatos = new ObjectInputStream(entrada);
			lista = (TreeMap<String, Persona>) lecturaDatos.readObject();

			entrada.close();
			lecturaDatos.close();

		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return lista;
	}

}
