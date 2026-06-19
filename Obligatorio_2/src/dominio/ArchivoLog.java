package dominio;

import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ArchivoLog {
    
    private static final String ARCHIVO = "Transacciones.log";
    
    public static void registrar (String descripcion){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy HH:mm");
        String fechaYHora= sdf.format(new Date());
        String linea = fechaYHora + " - " + descripcion;
        
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO,true))){
            bw.write(linea);
            bw.newLine();
        }catch(IOException e) { 
            System.out.println("Error al escribir en el log" + e.getMessage());
        }
        
    }
    
        public static String obtenerContenido(){
            String contenido = "";
            try{
                java.io.File archivoFisico = new java.io.File(ARCHIVO);
                
                boolean existeElArchivo = archivoFisico.exists();
                
                if(existeElArchivo){
                    BufferedReader br = new BufferedReader(new FileReader(archivoFisico));
                    String linea;
                    
                    while ((linea = br.readLine()) != null){
                        contenido = contenido + linea + "\n";
                    }
                    br.close();
                } else{
                    contenido = "El archivo de log está vacío o aún no se ha creado";
                }
            } catch (IOException e) {
                contenido = "Error al leer el archivo de log.";
            }
            return contenido;
            
        }
        
        public static void borrarContenido() {
            try(FileWriter fw = new FileWriter(ARCHIVO,false)){ 
            } catch (IOException e){
                System.err.println("Error al vaciar el log:" + e.getMessage());
            }
        }
    
}
