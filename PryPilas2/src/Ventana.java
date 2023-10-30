import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana {
    private JPanel Principal;
    private JTextField txtCodigo;
    private JButton btnVerificar;

    Pila coleccion=new Pila();

    public boolean codigoBalanceado(String codigo)throws Exception{
        for(int i=0; i<codigo.length(); i++){
            if(codigo.charAt(i)=='('){
                coleccion.insertar(codigo.charAt(i));
            }else{
                if (codigo.charAt(i)==')'){
                    if(coleccion.eliminar()!='('){
                        return false;
                    }
                }
            }
        }
        if (coleccion.estaVacia())
            return true;
        return false;
    }

    public Ventana() {
        btnVerificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String texto=txtCodigo.getText();
                try {
                    if (codigoBalanceado(texto)){
                        JOptionPane.showMessageDialog(null,"Codigo Correcto!");
                    }else {
                        JOptionPane.showMessageDialog(null, "Codigo Incorrecto");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null,"Falta elemento de apertura!");
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventana");
        frame.setContentPane(new Ventana().Principal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
