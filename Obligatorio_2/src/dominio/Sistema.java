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
    El sistmea debe incluir precargas? por ejemplo, de Funcionarios? NO

    Id de paquete alfanumérico, único. Alguna restricción de cantidad o minimo? Este dato lo ingresa el usuario o es automático?

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

    public void calcularPrecio(Paquete paquete){
        
        //instanciar el paquete con el precio ya calculado.
        //public void calcularPrecio(int categoriaPaquete, int precioCategoria){
        
        boolean precioEncontrado = false;
        int precio = 0;
        int categoriaPaquete = paquete.calcularCategoria();
        int precioCategoria = 0;
        String zonaPaquete = paquete.getZona();
        
        for(int i=0; (i< this.getTarifas().size()) && (!precioEncontrado); i++){
            Tarifa unaTarifa = this.getTarifas().get(i);
            
            if(unaTarifa.getZona().equals(zonaPaquete)){
                if(categoriaPaquete == 1){
                    precioCategoria = unaTarifa.getPrecioCat1();
                }
                else if(categoriaPaquete == 2){
                    precioCategoria = unaTarifa.getPrecioCat2();
                }
                else if(categoriaPaquete == 3){
                    precioCategoria = unaTarifa.getPrecioCat3();
                }
                else if(categoriaPaquete == 4){
                    precioCategoria = unaTarifa.getPrecioCat4();
                }
                precioEncontrado = true;
            } 
        }
        paquete.setPrecio(precioCategoria);
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


