package Examen1Progra2;
/**
 *
 * @author crist
 */
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.*;
public class Muelle extends JFrame{
    ArrayList<Barco> Barcos;
public Muelle(){
    Barcos = new ArrayList();
    setLayout(null);
    setSize(1378,768);
    setMainPanel();
    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    setTitle("Muelle");
    setLocationRelativeTo(null);
    setResizable(false);
    setVisible(true);
    }
    private void setMainPanel(){
        MainPanel = new JPanel();
        MainPanel.setBounds(0, 0, getWidth(), getHeight());
        MainPanel.setBackground(java.awt.Color.LIGHT_GRAY);
        MainPanel.setLayout(null);
        agregarBarco();
        agregarElemento();
        vaciarBarco();
        buscarBarco();
        add(MainPanel);
    }
    private void agregarBarco(){
        JButton Botones = new JButton();   
        Botones.setBounds(30,25, getWidth() - 55, 55);
        Botones.setText("Agregar barco: ");
        Botones.setFocusable(false);
        Botones.addActionListener((ActionEvent e)->{
        Object TipoNave = JOptionPane.showInputDialog(this, "Seleccionar tipo de barco", "Agregar barco", JOptionPane.INFORMATION_MESSAGE, null, (new String[] {"Barco Pesquero", "Barco de pasajeros"}), 0);
       try {
           if (TipoNave.toString().equals("Barco Pesquero")){
                    String Nombre = JOptionPane.showInputDialog(this, "Ingresar nombre del barco: ");
                    if (!Nombre.isBlank() && isNameValid(Nombre, 0)){
                        Object Tipo = JOptionPane.showInputDialog(this, "Seleccionar tipo de barco: ", "", JOptionPane.INFORMATION_MESSAGE, null, TipoPesquero.values(), 0);
                        if (!Tipo.toString().isBlank()){
                            Barcos.add(new BarcoPesquero(Nombre, (TipoPesquero) Tipo));
                        }
                    } else JOptionPane.showMessageDialog(null, "Error, Ingresar nombre correctamente.");
                } else {
                    String Nombre = JOptionPane.showInputDialog(this, "Ingresar nombre arco: ");
                    if (!Nombre.isBlank() && isNameValid(Nombre, 0)){
                        try {
                            String CantidadMax = JOptionPane.showInputDialog(this, "Ingresar limite de pasajeros.");
                            if (!CantidadMax.isBlank() && Integer.parseInt(CantidadMax)>0){
                                String PrecioBoleto = JOptionPane.showInputDialog(this, "Ingresar precio de boleto");
                                if (!PrecioBoleto.isBlank() && Double.parseDouble(PrecioBoleto) > 0){
                                    Barcos.add(new BarcoPasajero(Nombre, Integer.parseInt(CantidadMax), Double.parseDouble(PrecioBoleto)));
                                } else JOptionPane.showMessageDialog(null, "Por favor ingrese un precio mayor a 0");
                            } else JOptionPane.showMessageDialog(null, "Por favor ingrese una cantidad de personas mayores a 0");
                        } catch (Exception E){
                            JOptionPane.showMessageDialog(this, "Por favor limitese a ingresar numeros");
                        }
                    } else JOptionPane.showMessageDialog(null, "Por favor ingrese un nombre valido");
                } 
            } catch (Exception Ex) {}
        });
        MainPanel.add(Botones);
    }
    
    private boolean isNameValid(String Name, int Pos){
        if (Pos < Barcos.size()){
            if (Barcos.get(Pos).getName().equals(Name))
                return true;
        }
        return true;
    }
    
    private void agregarElemento(){
        JButton Botones = new JButton();
        
        Botones.setBounds(30,100, getWidth() - 55, 55);
        Botones.setText("Agregar elemento");
        Botones.setFocusable(false);
        Botones.addActionListener((ActionEvent e)->{
            try {
                if (!Barcos.isEmpty()){
                    String Nombre = JOptionPane.showInputDialog(this,"Ingrese el nombre del barco");
                    AgregarElemento(Nombre, 0);
                } JOptionPane.showMessageDialog(this, "Por favor ingrese un barco primero");
                
            } catch (Exception ex){}
        });
        MainPanel.add(Botones);
    }
    
    private void AgregarElemento(String Name, int Pos){
        if (Pos < Barcos.size()){
            if (Barcos.get(Pos).getName().equals(Name)){
                Barcos.get(Pos).agregarElemento();
            } else AgregarElemento(Name, Pos + 1);
        }
        JOptionPane.showMessageDialog(this, "Error, el barco no ha sido encontrado");
    }
       private void vaciarBarco(){
        JButton Botones = new JButton();
        
        Botones.setBounds(20, 175, getWidth() - 50, 50);
        Botones.setText("Vaciar barco");
        Botones.setFocusable(false);
        Botones.addActionListener((ActionEvent e)->{

        });
        MainPanel.add(Botones);
    }

    private void buscarBarco() {
        JButton Botones = new JButton();
        Botones.setBounds(30, 250, getWidth() - 55, 55);
        Botones.setText("Buscar barco");
        Botones.setFocusable(false);
        Botones.addActionListener((ActionEvent e) -> {
            String yearStr = JOptionPane.showInputDialog(this, "Ingrese el año desde el cual desea listar barcos:");
            try {
                int year = Integer.parseInt(yearStr);
                barcosDesde(year, 0);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Por favor ingrese un año válido.");
            }
        });
        MainPanel.add(Botones);
    }

    private void barcosDesde(int year, int Pos) {
        if (Pos < Barcos.size()) {
            Barco barco = Barcos.get(Pos);
            if (barco.getFecha().getYear() >= year) {
                JOptionPane.showMessageDialog(this, barco.getName() + " - Fecha de circulación: " + barco.getFecha());
            }
            barcosDesde(year, Pos + 1);
        }
    }

    public static void main(String[] args) {
        new Muelle().setVisible(true);
    }

    public JPanel MainPanel;
}