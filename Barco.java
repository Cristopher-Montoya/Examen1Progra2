package Examen1Progra2;
/**
 *
 * @author crist
 */
import java.util.Calendar;
import java.util.Date;
public abstract class Barco {
    protected Date Circulacion;
    protected String Nombre;
    
    public Barco(String Nombre){
        Nombre=Nombre;
        Circulacion=Calendar.getInstance().getTime();
    }
    public final String getName(){
        return Nombre;
    }
    public final Date getFecha(){
        return Circulacion;
    }
    public String toString(){
        return "Nombre barco: "+Nombre;
    }
    public abstract void agregarElemento();
    public abstract double vaciarCobrar();
    public abstract double precioElemento();
}

