package dominio;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * Trabajo realizado por 
 * (333503) Daniel López
 * (372277) Lautaro Moreno

    MVC: El sistema debe actuar como Controlador? o se va a hacer en el mismo script que la vista.
 */
public class Sistema {
    
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
    
    public void agregarCliente(Cliente cliente) {
        this.getClientes().add(cliente);
    }
    
    public ArrayList<Cliente> getClientes() {
        return clientes;
    }
    
    public void agregarFuncionario(Funcionario funcionario) {
        this.getFuncionarios().add(funcionario);
    }

    public ArrayList<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public ArrayList<Paquete> getPaquetes() {
        return paquetes;
    }

    public void agregarPaquete(Paquete paquete) {
        this.getPaquetes().add(paquete);
    }

    public ArrayList<Envio> getEnvios() {
        return envios;
    }

    public void agregarEnvios(Envio envio) {
        this.getEnvios().add(envio);
    }

    public ArrayList<Tarifa> getTarifas() {
        return this.tarifas;
    }

    public void agregarTarifa(Tarifa tarifa) {
        this.getTarifas().add(tarifa);
    }
         
    public void cargarTarifas(){
        
        try {
            Scanner arch = new Scanner(Paths.get("TARIFAS.txt"));

            while (arch.hasNext()) {
                
                String linea = arch.nextLine();
                
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
            arch.close();
            System.out.println(arch);

        } catch (IOException e) {
            System.out.println("error");
        }
        
    }

    public void calcularPrecio(Paquete paquete){
        
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
            
            if(unPaquete.getZona() == zona){
                paquetesFiltrados.add(unPaquete);
            }
        }
        
        return paquetesFiltrados; 
    }
}