
package test;
import dominio.*;
import interfaz.*;
import java.text.SimpleDateFormat;

public class Prueba {
    
    public static void main(String[] args) {
        
        Sistema modelo = new Sistema();
        MenuPrincipal mp = new MenuPrincipal(modelo);
        //PaqueteEnvio mp = new PaqueteEnvio(modelo);
        mp.setVisible(true); 
        
        Cliente c1 = new Cliente("Pepe", "099123456", "algo1@algo.com");
        Cliente c2 = new Cliente("Juan", "099123456", "algo2@algo.com");
        Cliente c3 = new Cliente("Maria", "099123456", "algo3@algo.com");
        Funcionario f1 = new Funcionario("Julio", "099123456", 123, 2020);
        Funcionario f2 = new Funcionario("Santiago", "099123456", 456, 1998);
        Funcionario f3 = new Funcionario("Belen", "099123456", 789, 2030);
        modelo.agregarCliente(c1);
        modelo.agregarCliente(c2);
        modelo.agregarCliente(c3);        
        modelo.agregarFuncionario(f1);
        modelo.agregarFuncionario(f2);
        modelo.agregarFuncionario(f3);
        
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
        try{
            
            Paquete p1 = new Paquete("AAA", c1, sdf.parse("01/01/2025"), "Destinatario", "Direccion", "Artigas", 2000, 800, "NORTE");
            Paquete p2 = new Paquete("BBB", c2, sdf.parse("01/01/2025"), "Destinatario", "Direccion", "Colonia", 1000, 500, "OESTE");
            Paquete p3 = new Paquete("123", c1, sdf.parse("01/01/2025"), "Destinatario", "Direccion", "Paysandú", 750, 100, "NORTE");
            Paquete p4 = new Paquete("456", c1, sdf.parse("01/01/2025"), "Destinatario", "Direccion", "Rocha", 750, 100, "ESTE");
            Paquete p5 = new Paquete("789", c2, sdf.parse("01/01/2025"), "Destinatario", "Direccion", "Canelones", 750, 100, "SUR");
            Paquete p6 = new Paquete("1011", c3, sdf.parse("01/01/2025"), "Destinatario", "Direccion", "San José", 750, 100, "SUR");
            
            modelo.agregarPaquete(p1);
            modelo.agregarPaquete(p2);
            modelo.agregarPaquete(p3);
            modelo.agregarPaquete(p4);
            modelo.agregarPaquete(p5);
            modelo.agregarPaquete(p6);
        }
        catch(Exception e){
            System.out.println("Error");
        }
            
    }
}
