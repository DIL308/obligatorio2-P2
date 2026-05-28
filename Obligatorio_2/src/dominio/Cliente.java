package dominio;

/**
 * Trabajo realizado por 
 * (333503) Daniel López
 * (######) Lautaro Moreno
 */
public class Cliente extends Persona{
    
    private String email;
        
    public Cliente(String nombre, String celular, String email){
        super(nombre,celular); //ToDo: Ver cómo lo hicimos en clase, creo que pidió evitar el uso de SUPER(). Usar Setters
        this.email = email;
    }
    
    public Cliente(){
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
        
        
        
        @Override

            public String toString(){
                
                return getNombre() + "-" + email;
}
    
}
