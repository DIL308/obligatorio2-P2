package dominio;
import java.util.ArrayList;

/*
 * Trabajo realizado por 
 * (333503) Daniel López
 * (372277) Lautaro Moreno
 */
public class Envio {
    
    private static int contador = 1;
    
    private int id;
    private int numero;
    private String fechaEnvio;
    private String zona;
    private Funcionario funcionario;
    private ArrayList<Paquete> paquetes;

    public Envio(int numero, String fechaEnvio, String zona, Funcionario funcionario, ArrayList<Paquete> paquetes) {
        
        this.id = this.contador;
        this.numero = numero;
        this.fechaEnvio = fechaEnvio;
        this.zona = zona;
        this.funcionario = funcionario;
        this.paquetes = paquetes;
        contador++;
    }
    
    public void quitarPaquete(Paquete paquete) {
        this.paquetes.remove(paquete);
    }
    
    public void agregarPaquete(Paquete paquete) {
        this.paquetes.add(paquete);
    }
    
    public int contarPaquetes(){
        return this.paquetes.size();
    }
    
    public int montoTotal(){
        return 0;
    }
    
    public double pesoTotal(){
        return 0.0;
    }
    
    public ArrayList<Paquete> getPaquetes() {
        return this.paquetes;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(String fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
    
}
