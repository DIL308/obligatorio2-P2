package dominio;

/**
 * Trabajo realizado por 
 * (333503) Daniel López
 * (######) Lautaro Moreno
 */
public class Funcionario extends Persona{
    
    private int nroFuncionario;
    private int anioIngreso;
    
    public Funcionario(String nombre, String celular, int nroFuncionario, int anioIngreso){
        super (nombre,celular);     //ToDo: IDEM Cliente super() y setters
        this.nroFuncionario = nroFuncionario;
        this.anioIngreso = anioIngreso;
    }
    
    public Funcionario(){
        
    }
    
       public int getNroFuncionario() {
        return nroFuncionario;
    }

    public void setNroFuncionario(int nroFuncionario) {
        this.nroFuncionario = nroFuncionario;
    }

    public int getAnioIngreso() {
        return anioIngreso;
    }

    public void setAnioIngreso(int anioIngreso) {
        this.anioIngreso = anioIngreso;
    }
    
    @Override
    public String toString(){
        return nroFuncionario + " " + getNombre(); 
    }
    
}
