package interfaz;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

/*
 * Trabajo realizado por 
 * (333503) Daniel López
 * (372277) Lautaro Moreno
 */

public class ArchivoLectura {

    private Scanner in;
    private String linea;

    public ArchivoLectura(String nombreArchivo) {
        try {
            in = new Scanner(Paths.get(nombreArchivo));
        } catch (IOException e) {
            System.err.println("Error ");
            System.exit(1);
        }
    }

    public boolean hayMasLineas() {
        boolean hay = false;
        linea = null;

        if (in.hasNext()) {
            linea = in.nextLine();
            hay = true;
        }

        return hay;
    }

    public String linea() {
        // devuelve la última línea leída
        return linea;
    }

    public void cerrar() {
        in.close();
    }
}