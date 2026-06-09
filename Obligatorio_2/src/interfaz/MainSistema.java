package interfaz;
import dominio.Sistema;

/*
 * Trabajo realizado por 
 * (333503) Daniel López
 * (372277) Lautaro Moreno
 */
public class MainSistema {
    public static void main(String[] args) {
        
        Sistema modelo = new Sistema();
        MenuPrincipal mp = new MenuPrincipal(modelo);
        mp.setVisible(true);
        
    }
    
}
