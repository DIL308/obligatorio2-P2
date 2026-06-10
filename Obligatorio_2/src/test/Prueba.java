
package test;
import dominio.*;
import interfaz.*;
import java.text.SimpleDateFormat;

public class Prueba {
    
    public static void main(String[] args) {
        
        Sistema modelo = new Sistema();
        MenuPrincipal mp = new MenuPrincipal(modelo);
        mp.setVisible(true);
        
        Cliente c1 = new Cliente("Pepe", "099123456", "algo@algo.com");
        Cliente c2 = new Cliente("Nombre Unico", "099123456", "algo@algo.com");
        Cliente c3 = new Cliente("Pepe", "099123456", "algo@algo.com");
        modelo.agregarCliente(c1);
        modelo.agregarCliente(c2);
        modelo.agregarCliente(c3);
        
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
        try{
            
            Paquete p1 = new Paquete("123", c1, sdf.parse("01/01/2025"), "Destino", "Direccion", "Artigas", 1000, 500, "NORTE");
            Paquete p2 = new Paquete("123", c1, sdf.parse("01/01/2025"), "Destino", "Direccion", "Colonia", 1000, 500, "OESTE");
            Paquete p3 = new Paquete("123", c1, sdf.parse("01/01/2025"), "Destino", "Direccion", "Paysandú", 1000, 500, "NORTE");
            
            modelo.agregarPaquete(p1);
            modelo.agregarPaquete(p2);
            modelo.agregarPaquete(p3);
        }
        catch(Exception e){
            System.out.println("Error");
        }
        
    }
}
