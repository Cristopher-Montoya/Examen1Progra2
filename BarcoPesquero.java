package Examen1Progra2;
/**
 *
 * @author crist
 */
 import javax.swing.JOptionPane;
public final class BarcoPesquero extends Barco {
    int PecesCapturados;
    TipoPesquero TipodeBarco;
    public BarcoPesquero(String Nombre, TipoPesquero TipodeBarco){
        super(Nombre);
        this.TipodeBarco=TipodeBarco;
        PecesCapturados = 0;
    }
    public double vaciarCobrar() {
        int PecesCapturados2=PecesCapturados;
        if (PecesCapturados > 0){
            PecesCapturados = 0;
            return PecesCapturados2 * TipodeBarco.getPrecio();
        } else JOptionPane.showMessageDialog(null, "Peces no capturados");
        return 0;
    }
    public void agregarElemento() {
        PecesCapturados++;
    }
    public double precioElemento() {
        return TipodeBarco.getPrecio();
    }
    public String toString(){
        return super.toString() + "\nTipo barco: "+TipodeBarco+"\nPeces capturados: "+PecesCapturados;
    }
    
}
