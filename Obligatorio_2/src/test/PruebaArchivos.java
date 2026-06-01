
package test;
import interfaz.ArchivoLectura;
import java.util.Scanner;
import java.nio.file.Paths;
import java.io.IOException;

public class PruebaArchivos {
    
    public static void main(String[] args) {
        
        try {
            Scanner arch = new Scanner(Paths.get("TARIFAS.txt"));

            while (arch.hasNext()) {
                System.out.println("Contenido " + arch.nextLine());
            }

            arch.close();

        } catch (IOException e) {
            System.out.println("error");
        }
        
    }
    
}





