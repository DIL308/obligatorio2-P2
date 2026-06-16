package dominio;


/**
 * Trabajo realizado por 
 * (333503) Daniel López
 * (372277) Lautaro Moreno
 */
public class Cliente extends Persona{ //Ya implementa serializable por Persona
    
    private String email;
        
    public Cliente(String nombre, String celular, String email){
        super(nombre, celular);
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

        return getNombre();
    }
    
    @Override 
    public boolean equals(Object obj){
        boolean sonIguales = false;
        
        if(this == obj){
            sonIguales = true;
        }else{
            if(obj != null && getClass()==obj.getClass()){
                Cliente unCliente = (Cliente) obj;
                if(this.getEmail().equals(unCliente.getEmail())){
                    sonIguales = true;
                }
            }
        }
        return sonIguales;
    }
    
}
