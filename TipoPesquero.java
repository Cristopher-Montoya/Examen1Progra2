package Examen1Progra2;
/**
 *
 * @author crist
 */public enum TipoPesquero {
    PEZ(100), CAMARON(50), LANGOSTA(150);
    double precio;
    TipoPesquero(double precio){
      this.precio=precio;
    }
    public double getPrecio(){
        return precio;
    }
}