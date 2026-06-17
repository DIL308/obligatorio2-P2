package interfaz;
import dominio.Sistema;

/*
 * Trabajo realizado por 
 * (333503) Daniel López
 * (372277) Lautaro Moreno
 */
public class MainSistema {
    public static void main(String[] args) {
        
        /*Sistema sistema;
        
        try{
            sistema = Sistema.deserializar();
            if(sistema == null){
                sistema = new Sistema();
            }
        } catch (Exception e){
            System.out.println("Aviso :Error al cargar archivo de persistencia.");
            sistema = new Sistema();
        }
        final Sistema sistemaFinal = sistema;
        java.awt.EventQueue.invokeLater(() ->{
            new MenuPrincipal(sistemaFinal).setVisible(true);
            });
        */
        ComenzarCon cc = new ComenzarCon();
        cc.setVisible(true);
        
    }
    
}
