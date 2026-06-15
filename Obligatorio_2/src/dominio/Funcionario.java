package dominio;

/**
 * Trabajo realizado por 
 * (333503) Daniel López
 * (372277) Lautaro Moreno
 */
public class Funcionario extends Persona{ //Ya implementa serializable por Persona
    
    private int nroFuncionario;
    private int anioIngreso;
    
    public Funcionario(String nombre, String celular, int nroFuncionario, int anioIngreso){
        super (nombre, celular);
        this.setNroFuncionario(nroFuncionario);
        this.setAnioIngreso(anioIngreso);
    }
    
    public Funcionario(){
        this.setNroFuncionario(0);
        this.setAnioIngreso(0);
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
        return this.getNombre() + " " + nroFuncionario  ; 
    }
    
}
