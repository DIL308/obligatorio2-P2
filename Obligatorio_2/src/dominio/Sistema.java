package dominio;
import java.util.ArrayList;
import interfaz.ArchivoLectura;
import java.util.Observable;

/*
 * Trabajo realizado por 
 * (333503) Daniel López
 * (372277) Lautaro Moreno

    MVC: El sistema debe actuar como Controlador? o se va a hacer en el mismo script que la vista.
    
    Arrancar un sistema nuevo, borra toda la información de la persistencia, incluido el TARIFAS.TXT? - Si, pero el tarifas.txt se mantiene tal cual la ultima modificacion

 */
public class Sistema extends Observable {
    
    private ArrayList<Cliente> clientes;
    private ArrayList<Funcionario> funcionarios;
    private ArrayList<Paquete> paquetes;
    private ArrayList<Envio> envios;
    private ArrayList<Tarifa> tarifas;
    
    public Sistema(){
         
        this.clientes = new ArrayList<Cliente>();
        this.funcionarios = new ArrayList<Funcionario>();
        this.paquetes = new ArrayList<Paquete>();
        this.envios = new ArrayList<Envio>();
        this.tarifas = new ArrayList<Tarifa>();
        
        cargarTarifas();
        
    }
    
    public boolean textoVacio(String texto){
        boolean estaVacio = false;
   
        if (texto == null) {
            estaVacio = true;
        } else {
            texto = texto.strip();

            if (texto.length() == 0) {
                estaVacio = true;
            }
        }        
        return estaVacio;
    }
    
    public void agregarCliente(Cliente cliente) {

        this.getClientes().add(cliente);
        this.setChanged();
        this.notifyObservers();
    }
    
    public ArrayList<Cliente> getClientes() {
        return clientes;
    }
    
    public void agregarFuncionario(Funcionario funcionario) {
        Funcionario existente = null;
        int i = 0;
        
        while(i<this.getFuncionarios().size() && existente == null){
            Funcionario f = this.getFuncionarios().get(i);
            if (f.getNroFuncionario() == funcionario.getNroFuncionario()){
                existente = f;
            }
            i++;
        }
        if (existente != null){
            existente.setNombre(funcionario.getNombre());
            existente.setCelular(funcionario.getCelular());
            existente.setAnioIngreso(funcionario.getAnioIngreso());
        }
        else{
        this.getFuncionarios().add(funcionario);
        }
        this.setChanged();
        this.notifyObservers();
    }

    public ArrayList<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public ArrayList<Paquete> getPaquetes() {
        return paquetes;
    }

    public void agregarPaquete(Paquete paquete) {
        this.getPaquetes().add(paquete);
        this.setChanged();
        this.notifyObservers();
    }

    public ArrayList<Envio> getEnvios() {
        return envios;
    }

    public void agregarEnvios(Envio envio) {
        this.getEnvios().add(envio);
        this.setChanged();
        this.notifyObservers();
    }

    public ArrayList<Tarifa> getTarifas() {
        return this.tarifas;
    }

    public void agregarTarifa(Tarifa tarifa) {
        this.getTarifas().add(tarifa);
        this.setChanged();
        this.notifyObservers();
    }
         
    public void cargarTarifas(){
        
        ArchivoLectura arch = new ArchivoLectura("TARIFAS.txt");

        while (arch.hayMasLineas()) {

            String linea = arch.linea();

            String[] partes = linea.split("#");
            String zona = partes[0];
            String[] precios =partes[1].split(",");

            int precio1 = Integer.parseInt(precios[0]);
            int precio2 = Integer.parseInt(precios[1]);
            int precio3 = Integer.parseInt(precios[2]);
            int precio4 = Integer.parseInt(precios[3]);

            Tarifa t = new Tarifa(zona, precio1, precio2, precio3, precio4);
            this.getTarifas().add(t);

        }
        arch.cerrar();
        System.out.println(arch);
               
    }
    
    public int calcularPrecio(String zona, int peso){
        
        boolean precioEncontrado = false;
        int precio = 0;
        int categoria = calcularCategoria(peso);
        
        for(int i=0; (i< this.getTarifas().size()) && (!precioEncontrado); i++){
            Tarifa unaTarifa = this.getTarifas().get(i);
            
            if(unaTarifa.getZona().equals(zona)){
                if(categoria == 1){
                    precio = unaTarifa.getPrecioCat1();
                }
                else if(categoria == 2){
                    precio = unaTarifa.getPrecioCat2();
                }
                else if(categoria == 3){
                    precio = unaTarifa.getPrecioCat3();
                }
                else if(categoria == 4){
                    precio = unaTarifa.getPrecioCat4();
                }
                precioEncontrado = true;
            }
        }
    
        return precio;
    }
    
    public ArrayList<Paquete> filtrarPaquetesPendientesPorZona(String zona){
        
        ArrayList<Paquete> paquetesFiltrados = new ArrayList<Paquete>();
        
        for(int i=0; i<this.getPaquetes().size(); i++){
            
            Paquete unPaquete = this.getPaquetes().get(i);
            
            if(unPaquete.getZona().equals(zona)){
                paquetesFiltrados.add(unPaquete);
            }
        }
        
        return paquetesFiltrados; 
    }

    public boolean esAlfanumerico(String texto) {
        boolean tieneLetra = false;
        boolean tieneNumero = false;

        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);

            if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')) {
                tieneLetra = true;
            }

            if (c >= '0' && c <= '9') {
                tieneNumero = true;
            }
        }

        return tieneLetra && tieneNumero;
    }

    public String zonaDepartamento(String departamento){
        
        //Dado un string Departamento, devuelve la zona que corresponde. 
        String zonaDepartamento = "";
        
        if (departamento.equalsIgnoreCase("Artigas")   ||
            departamento.equalsIgnoreCase("Salto")     ||
            departamento.equalsIgnoreCase("Paysandú")  ||
            departamento.equalsIgnoreCase("Rivera")    ||
            departamento.equalsIgnoreCase("Tacuarembó") ){
            
            zonaDepartamento = "NORTE";
        }
           else if
            (departamento.equalsIgnoreCase("Río Negro") ||
            departamento.equalsIgnoreCase("Soriano")    ||
            departamento.equalsIgnoreCase("Colonia")    ||
            departamento.equalsIgnoreCase("San josé")){
               
               zonaDepartamento = "OESTE";
           }
           else if
            (departamento.equalsIgnoreCase("Cerro Largo")   ||
            departamento.equalsIgnoreCase("Treinta y Tres") ||
            departamento.equalsIgnoreCase("Lavalleja")      ||
            departamento.equalsIgnoreCase("Rocha")          ||
            departamento.equalsIgnoreCase("Maldonado") ){
               
               zonaDepartamento = "ESTE";
           }
        
         else if
            (departamento.equalsIgnoreCase("Durazno")  ||
            departamento.equalsIgnoreCase("Flores")    ||
            departamento.equalsIgnoreCase("Florida")   ||
            departamento.equalsIgnoreCase("Canelones") ||
            departamento.equalsIgnoreCase("Montevideo")) {
               
               zonaDepartamento = "SUR";
           }
         else{
             zonaDepartamento= "DESCONOCIDA";
            }
        return zonaDepartamento;   
    }
    
    public int calcularCategoria(int peso){
        
        //Dado un peso, devuelve int con categoria (1 a 4 o -1 si error)
        int categoria = 0;

        if (peso<= 0){
            categoria = -1; // esto lo uso para validar que el peso sea real  //
        }
        else if (peso < 1000){
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


    
    public boolean esSoloLetrasYEspacios(String texto){
        boolean todoOk = true;

        for (int i=0;i<texto.length()&& todoOk;i++){
            char caracterActual = texto.charAt(i);

            if(!Character.isLetter(caracterActual) && caracterActual != ' '){
            todoOk = false;

            }
        }
        return todoOk;
    }
    
    public boolean clienteYaExiste(String nombre){
        boolean existe = false;
        for (int i=0; i<this.clientes.size() && !existe;i++){
            if (this.clientes.get(i).getNombre().equalsIgnoreCase(nombre)){
                existe = true;
            }
            
        }return existe;
    }
    
    public ArrayList<Cliente> getClientesOrdenados(){
        ArrayList<Cliente> listaOrdenada = new ArrayList<Cliente>(this.clientes);
        listaOrdenada.sort((c1,c2) -> c1.getNombre().compareToIgnoreCase(c2.getNombre()));
        return listaOrdenada;
    }

}
