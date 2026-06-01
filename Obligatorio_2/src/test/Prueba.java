
package test;
import dominio.*;


public class Prueba {
    
    public static void main(String[] args) {
        
        Sistema s = new Sistema();

        Cliente c1 = new Cliente("Pepe", "099123456", "algo@algo.com");
        Paquete p1 = new Paquete("PK1", c1, "29/05/2026", "Juan Destino", "Lo de juan 1234", "Artigas", 80000);
        Paquete p2 = new Paquete("PK2", c1, "29/05/2026", "Pepe Maldonado", "Lo de juan 1234", "Maldonado", 80000);
        Paquete p3 = new Paquete("PK3", c1, "29/05/2026", "Juana Rocha", "Lo de juan 1234", "Rocha", 80000);
        
        s.agregarPaquete(p1);
        s.agregarPaquete(p2);
        s.agregarPaquete(p3);
    
        System.out.println(s.getPaquetes());
        System.out.println("--------------------------------------------------");
        
        System.out.println(s.filtrarPaquetesPendientesPorZona("NORTE"));
        
        

 
    }
}
