package dominio;

/**
 * Trabajo realizado por 
 * (333503) Daniel López
 * (372277) Lautaro Moreno
 */
public class Cliente extends Persona{
    
    private String email;
        
    public Cliente(String nombre, String celular, String email){
        this.setEmail(email);
    }
    
    public Cliente(){
        this.setEmail("SIN-EMAIL");
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
