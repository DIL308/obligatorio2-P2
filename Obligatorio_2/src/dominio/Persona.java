package dominio;

/**
 * Trabajo realizado por 
 * (333503) Daniel López
 * (######) Lautaro Moreno
 */
public abstract class Persona {
    
    private String nombre;
    private String celular;
    
    public Persona (String nombre, String celular){
        this.nombre = nombre;       
        this.celular = celular;
        
        /*
        ToDo: Recordar usar los setters en esta y todas las clases
        
        this.setNombre(nombre)
        this.setNombre(nombre)
        */
    }
    
    public Persona(){
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
