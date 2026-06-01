
package interfaz;
import java.io.*;
import java.util.Formatter;

/*
 * Trabajo realizado por 
 * (333503) Daniel López
 * (372277) Lautaro Moreno
 */
public class ArchivoGrabacion {
    
    private Formatter out;
    
    public ArchivoGrabacion(String nombreArchivo){
        
        try{
            out = new Formatter(nombreArchivo);
        }
        catch(FileNotFoundException e){
            System.out.println("no se puede crear");
            System.exit(1);
        }
    }
    
    public ArchivoGrabacion(String nombreArchivo, boolean ext){
        
        try{
            FileWriter f = new FileWriter(nombreArchivo, ext);
            out = new Formatter(f);
        }
        catch(IOException e){
            System.out.println("no se puede crear/extender");
            System.exit(1);
        }
    }
    
    public void grabarLinea(String linea){
        out.format("%s%n",linea);
    }
    
    public void cerrar(){
        out.close();
    }
   
    
}
