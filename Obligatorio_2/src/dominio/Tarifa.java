package dominio;
import java.io.Serializable;

/*
 * Trabajo realizado por 
 * (333503) Daniel López
 * (372277) Lautaro Moreno
 */
public class Tarifa implements Serializable{
    
    private String zona;
    private int precioCat1;
    private int precioCat2;
    private int precioCat3;
    private int precioCat4;

    public Tarifa(String zona, int precioCat1, int precioCat2, int precioCat3, int precioCat4) {
        
        setZona(zona);
        setPrecioCat1(precioCat1);
        setPrecioCat2(precioCat2);
        setPrecioCat3(precioCat3);
        setPrecioCat4(precioCat4);
    }
    
    public Tarifa(){}
    
    public void actualizarTarifa(int porcentaje, boolean aumento){
        
        double variacion;
        
        if(aumento){
            variacion = (porcentaje / 100.0) + 1;
            
        }else{
            variacion = 1 - (porcentaje / 100.0);
        }

        double nuevoPrecioCat1 = this.getPrecioCat1() * variacion;
        double nuevoPrecioCat2 = this.getPrecioCat2() * variacion;
        double nuevoPrecioCat3 = this.getPrecioCat3() * variacion;
        double nuevoPrecioCat4 = this.getPrecioCat4() * variacion;
        
        this.setPrecioCat1((int) Math.round(nuevoPrecioCat1));
        this.setPrecioCat2((int) Math.round(nuevoPrecioCat2));
        this.setPrecioCat3((int) Math.round(nuevoPrecioCat3));
        this.setPrecioCat4((int) Math.round(nuevoPrecioCat4));
   
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public int getPrecioCat1() {
        return precioCat1;
    }

    public void setPrecioCat1(int precioCat1) {
        this.precioCat1 = precioCat1;
    }

    public int getPrecioCat2() {
        return precioCat2;
    }

    public void setPrecioCat2(int precioCat2) {
        this.precioCat2 = precioCat2;
    }

    public int getPrecioCat3() {
        return precioCat3;
    }

    public void setPrecioCat3(int precioCat3) {
        this.precioCat3 = precioCat3;
    }

    public int getPrecioCat4() {
        return precioCat4;
    }

    public void setPrecioCat4(int precioCat4) {
        this.precioCat4 = precioCat4;
    }
    
    
    
}
