package dominio;
import java.io.Serializable;

/**
 * Trabajo realizado por 
 * (333503) Daniel López
 * (372277) Lautaro Moreno
 */
public abstract class Persona implements Serializable{
    
    private String nombre;
    private String celular;
       
    public Persona(){
        this.setNombre(nombre);
        this.setCelular(celular);
    }
    
    public Persona(String nombre, String celular) {
        this.nombre = nombre;
        this.celular = celular;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }
}
