package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class io {

    /**
     * Devuelve Los valores asociados al proceso/dia indicado
     * 
     * @param busqueda
     *            (String) El dato a buscar correspondiente a la primera columna
     *            de las tablas
     * @return Devuelve un Array de Integers de 2 posiciones conteniendo los
     *         valores correspondientes a la columna 2 y 3 para el valor buscado
     */
    public static int[] buscarEnArchivo(String busqueda) {
	BufferedReader bReader = null;
	String linea = null;
	StringTokenizer tokenizer = null;
	int[] tokens = new int[2];

	busqueda = "(^)" + busqueda + "(.*)";

	try {
	    bReader = new BufferedReader(new FileReader("Tablas.txt"));
	} catch (IOException e) {
	    e.printStackTrace();
	}

	try {
	    while ((linea = bReader.readLine()) != null) {
		if (linea.matches(busqueda)) {
		    int i = 0;
		    tokenizer = new StringTokenizer(linea, ":,");

		    // Se descarta el primer token, ya que es el patron de
		    // busqueda
		    tokenizer.nextToken();

		    while (tokenizer.hasMoreTokens()) {
			tokens[i] = Integer.parseInt(tokenizer.nextToken()
				.trim());
			i++;
		    }
		    return tokens;
		}
	    }
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} finally {
	    try {
		bReader.close();
	    } catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
	}

	return tokens;
    }

}
