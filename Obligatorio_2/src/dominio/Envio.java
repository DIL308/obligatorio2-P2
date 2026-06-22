package dominio;
import java.util.ArrayList;
import java.util.Date;
import java.io.Serializable;
import java.text.SimpleDateFormat;

/*
 * Trabajo realizado por 
 * (333503) Daniel López
 * (372277) Lautaro Moreno
 */
public class Envio implements Comparable<Envio>, Serializable{
    
    private static int contador = 1;
    
    private int id;
    private Date fechaEnvio;
    private String zona;
    private Funcionario funcionario;
    private ArrayList<Paquete> paquetes;
    private boolean recepcionRegistrada;

    @Override
    public int compareTo(Envio e) {
        return Integer.compare(e.getId(), this.getId());
    }
    
    public boolean getRecepcionRegistrada() {    
        return recepcionRegistrada;
    }
    
    public void setRecepcionRegistrada(boolean recepcionRegistrada) {
        this.recepcionRegistrada = recepcionRegistrada;
    }
    
    

    public Envio(Date fechaEnvio, String zona, Funcionario funcionario, ArrayList<Paquete> paquetes) {
        
        this.id = this.contador;
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
    
    public ArrayList<Paquete> getPaquetes() {
        return this.paquetes;
    }

    public int getId() {
        return id;
    }
    
    public static int getProximoId() {
        return contador;
    }

    public Date getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(Date fechaEnvio) {
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
    
    @Override
    public String toString(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return "Envío: " + this.getId() + " | Zona: " + this.getZona() + " |  Fecha: " + sdf.format(this.getFechaEnvio());
    }
    
}
