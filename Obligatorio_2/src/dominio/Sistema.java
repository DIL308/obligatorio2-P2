package dominio;
import java.util.ArrayList;
import interfaz.ArchivoLectura;
import interfaz.ArchivoGrabacion;
import java.util.Observable;
import java.util.Observer;
import javax.swing.DefaultListModel;
import java.util.Collections;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.Serializable;
import java.io.FileNotFoundException;
import javax.swing.JOptionPane;

/*
 * Trabajo realizado por 
 * (333503) Daniel López
 * (372277) Lautaro Moreno

 */
public class Sistema extends Observable  implements Serializable{
    
    private static final long serialVersionUID = 1L;
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
    
    public void serializar(){
        
        try{
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("sistema.ser"));
            out.writeObject(this);
        }catch (IOException e){
            e.printStackTrace();
        }
        
    }
    
    public static Sistema deserializar(){
        
        Sistema sistema = null;
        
        try{
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("sistema.ser"));
            sistema = (Sistema) in.readObject();
            in.close();
        }catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null,"No existe archivo de serialización. Se inicia un sistema nuevo.","Error",JOptionPane.ERROR_MESSAGE);
            sistema = new Sistema();

        }catch (IOException | ClassNotFoundException ex){
            ex.printStackTrace();
        }
        
        return sistema;
        
    }
    
    public void addObserver(Observer o){
        super.addObserver(o);
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
        ArchivoLog.registrar("Ingreso de cliente " + cliente.getNombre());
        this.actualizarCambios();
    }
    
    public ArrayList<Cliente> getClientes() {
        Collections.sort(this.clientes);
        return clientes;
    }
    
    public void agregarFuncionario(Funcionario funcionario) {

        this.getFuncionarios().add(funcionario);
        this.setChanged();
        this.notifyObservers();
        ArchivoLog.registrar("Ingreso de nuevo funcionario: " + funcionario.getNombre());
        this.actualizarCambios();
    }

    public ArrayList<Funcionario> getFuncionarios() {
        Collections.sort(this.funcionarios);
        return funcionarios;
    }

    public ArrayList<Paquete> getPaquetes() {
        return paquetes;
    }

    public void agregarPaquete(Paquete paquete) {
        this.getPaquetes().add(paquete);
        this.setChanged();
        this.notifyObservers();
        ArchivoLog.registrar("Ingreso de paquete de cliente " + paquete.getCliente());
        this.actualizarCambios();
    }

    public ArrayList<Envio> getEnvios() {
        return envios;
    }
  
    public void agregarEnvios(Envio envio) {
        this.getEnvios().add(envio);
        ArchivoLog.registrar("Ingreso de nuevo envío núm " + envio.getId());
        this.actualizarCambios();
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
               
    }
    
    public void sobreescribirTarifas(){
        ArchivoGrabacion arch = new ArchivoGrabacion("TARIFAS.txt");
        
        for(int i=0; i<getTarifas().size(); i++){
            Tarifa t = getTarifas().get(i);
            arch.grabarLinea(t.toString());
            
        }
        arch.cerrar();
        
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
    
    public ArrayList<Paquete> getPaquetesPendientesPorZona(String zona){
        
        ArrayList<Paquete> paquetesFiltrados = new ArrayList<Paquete>();
        
        for(int i=0; i<this.getPaquetes().size(); i++){
            
            Paquete unPaquete = this.getPaquetes().get(i);
            
            if((unPaquete.getZona().equals(zona)) && (unPaquete.getEstado().equals("Pendiente"))){
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

        return tieneLetra || tieneNumero;
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
    
    public boolean NombreYaExisteEnSistema(String nombre){
        boolean existe = false;
        for (int i=0; i<this.clientes.size() && !existe;i++){
            if (this.clientes.get(i).getNombre().equalsIgnoreCase(nombre)){
                existe = true;
            }
            
        }
        for (int j=0;j<this.funcionarios.size() && !existe;j++){
            if (this.funcionarios.get(j).getNombre().equalsIgnoreCase(nombre)){
                existe = true;
            }
        }
        return existe;
    }
    
    public boolean nroFuncionarioYaExiste(int nroFuncionario){
        boolean existe = false;

        for (int i=0; (i<this.funcionarios.size()) && (!existe); i++){
            if(nroFuncionario == this.getFuncionarios().get(i).getNroFuncionario()){
                existe = true;                
            }
        }

        return existe;
    }
        
    public double pesoDePaquetes(DefaultListModel<Object> paquetes, boolean enKilos){
        
        double peso = 0.0;
        
        for(int i=0; i<paquetes.size(); i++){
            Paquete p = (Paquete) paquetes.get(i);
            peso += p.getPeso();
        }
        
        if(enKilos){
            peso = peso / 1000;
        }
        
        return peso;
    }
    
    public int precioDePaquetes(DefaultListModel<Object> paquetes){
        
        int precio = 0;
        
        for(int i=0; i<paquetes.size(); i++){
            Paquete p = (Paquete) paquetes.get(i);
            precio += p.getPrecio();
        }
       
        
        return precio;
    }
    
    public ArrayList<Envio> getEnviosOrdenadosDescendente() {

        ArrayList<Envio> env = new ArrayList<>(this.getEnvios());
        Collections.sort(env);
        return env;
}
    
    public int contarPaquetesPorClienteYEstado(Cliente unCliente, String unEstado){
        int contador = 0;
        for (int i=0;i<this.paquetes.size();i++){
            Paquete p =  this.paquetes.get(i);
            if(p.getEstado().equals(unEstado) && p.getCliente().getEmail().equals(unCliente.getEmail()))
                contador++;
        }
        return contador;
    }
    
    public Cliente buscarClientePorEmail(String unEmail){
        Cliente clienteEncontrado = null;
        int i = 0;
        
        while(i<this.clientes.size() && clienteEncontrado == null){
            if(this.clientes.get(i).getEmail().equalsIgnoreCase(unEmail)){
                clienteEncontrado = this.clientes.get(i);
            }
            i++;
        }return clienteEncontrado;
    } 
    
    public int contarPaquetesPorZonaYEstado(String zona, String estado){
        int contador = 0;
        
        if(this.paquetes != null){
            for (int i=0; i<this.paquetes.size();i++){
                Paquete p = this.paquetes.get(i);
            
                if (p != null && p.getZona()!= null && p.getEstado() !=null){
                    if (p.getZona().equalsIgnoreCase(zona) && p.getEstado().equalsIgnoreCase(estado)){
                        contador++;
                
                    }
                }
            }
        }      
        return contador;
    }
    
    public void actualizarCambios(){
        this.setChanged();
        this.notifyObservers();
    }

}
