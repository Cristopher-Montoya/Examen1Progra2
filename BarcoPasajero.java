package Examen1Progra2;
/**
 *
 * @author crist
 */
import javax.swing.JOptionPane;
public final class BarcoPasajero extends Barco {
    private String[] Pasajeros;
    private double PrecioBoleto;
    private int Cont;

    public BarcoPasajero(String Nombre, int Cantidad, double PrecioBoleto) {
        super(Nombre);
        Pasajeros = new String[Cantidad];
        this.PrecioBoleto = PrecioBoleto;
        Cont=0;
    }
    public double vaciarCobrar() {
         int ContadorReplica = Cont;
         Cont=0;
         return ContadorReplica * PrecioBoleto;
    }
    public void agregarElemento() {
        try {
            if (Cont<Pasajeros.length) {
                String NombrePasajero = JOptionPane.showInputDialog(null, "Ingresar nombre: ");
                if (!NombrePasajero.isBlank()){
                    System.out.println("Agregado exitosamente.");
                    Pasajeros[Cont] = NombrePasajero;
                    Cont++;
                } else JOptionPane.showMessageDialog(null,"Error, casilla en blanco");
            } else JOptionPane.showMessageDialog(null, "Capacidad maxima");
        } catch (Exception e){}
    }
    public double precioElemento() {
     return PrecioBoleto;
    }
    public String toString(){
        return super.toString()+"\nCantidad de boletos: "+Cont;
    }
    public String Pasajeros(String Pasajeros, int pos){
    if(pos<Cont){
    Pasajeros+=this.Pasajeros[pos]+"\n";
    }    
    return Pasajeros;
    }
}