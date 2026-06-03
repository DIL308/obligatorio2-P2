package dominio;

/**
 * Trabajo realizado por 
 * (333503) Daniel López
 * (372277) Lautaro Moreno
 * 
 * El precio y zona, deben calcularse en sistema o en paquete?
 */
public class Paquete {
    private String id;
    private Cliente cliente;
    private String fecha;
    private String destinatario;
    private String direccionEnvio;
    private String departamentoEnvio;
    private int peso;
    private String zona;
    private int precio;
    private String estado;
    
    public Paquete (String id, Cliente cliente, String fecha, String destinatario, String direccionEnvio, String departamentoEnvio, int peso){
        this.setId(id);
        this.setCliente(cliente);
        this.setFecha(fecha);
        this.setDestinatario(destinatario);
        this.setDireccionEnvio(direccionEnvio);
        this.setDepartamentoEnvio(departamentoEnvio);
        this.setPeso(peso);
        this.setZona();
        this.setPrecio(0);
        this.setEstado("Pendiente");      
    }
    
    public Paquete(){ 
    }
    
    @Override
    public String toString(){
        return id + " " + destinatario + " " + estado + " " + departamentoEnvio + " " + precio;
    }
        
    private String calcularZona(){
        
        String zonaCalculada = "";
        String departamento = this.getDepartamentoEnvio();
        
        if (departamento.equalsIgnoreCase("Artigas")   ||
            departamento.equalsIgnoreCase("Salto")     ||
            departamento.equalsIgnoreCase("Paysandú")  ||
            departamento.equalsIgnoreCase("Rivera")    ||
            departamento.equalsIgnoreCase("Tacuarembo") ){
            
            zonaCalculada = "NORTE";
        }
           else if
            (departamento.equalsIgnoreCase("Rio Negro") ||
            departamento.equalsIgnoreCase("Soriano")    ||
            departamento.equalsIgnoreCase("Colonia")    ||
            departamento.equalsIgnoreCase("San josé")){
               
               zonaCalculada = "OESTE";
           }
           else if
            (departamento.equalsIgnoreCase("Cerro Largo")   ||
            departamento.equalsIgnoreCase("Treinta y Tres") ||
            departamento.equalsIgnoreCase("Lavalleja")      ||
            departamento.equalsIgnoreCase("Rocha")          ||
            departamento.equalsIgnoreCase("Maldonado") ){
               
               zonaCalculada = "ESTE";
           }
        
         else if
            (departamento.equalsIgnoreCase("Durazno")  ||
            departamento.equalsIgnoreCase("Flores")    ||
            departamento.equalsIgnoreCase("Florida")   ||
            departamento.equalsIgnoreCase("Canelones") ||
            departamento.equalsIgnoreCase("Montevideo")) {
               
               zonaCalculada = "SUR";
           }
         else{
             zonaCalculada= "DESCONOCIDA";
            }
        return zonaCalculada;   
    }
   
    public int calcularCategoria(){
        int categoria = 0;

        if (peso<= 0){
            categoria = -1; // esto lo uso para validar que el peso sea real  //
        }
        else if (this.peso < 1000){
            categoria = 1;
        }
        else if (peso < 5000){
            categoria = 2;
        }
        else if (peso < 10000){
            categoria = 3;       
        }
        else {
            categoria = 4;       
        }
        return categoria;
    }

    /*public boolean estaPendiente(){
        boolean esta = false;
        if(estado.equalsIgnoreCase("Pendiente")){
            esta = true;
        }
        return esta;
    }*/
    
    
    
    
    /*
        GETTERS & SETTERS
    */
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getDireccionEnvio() {
        return direccionEnvio;
    }

    public void setDireccionEnvio(String direccionEnvio) {
        this.direccionEnvio = direccionEnvio;
    }

    public String getDepartamentoEnvio() {
        return departamentoEnvio;
    }

    public void setDepartamentoEnvio(String departamentoEnvio) {
        this.departamentoEnvio = departamentoEnvio;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getZona() {
        return zona;
    }

    public void setZona() {
        this.zona = calcularZona();
    }
    
}
