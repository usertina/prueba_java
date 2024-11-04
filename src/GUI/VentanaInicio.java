package GUI;

import Clases.Banco;
import Clases.Persona;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class VentanaInicio extends JFrame {
    private JButton buttonIniciarSesion;
    private JTextField nombreTextField;
    private JPasswordField passwordField;
    private JLabel miBancoLabel;
    private JLabel nombreLabel;
    private JLabel contrasenaLabel;
    private JPanel panelMain;
    private Banco miBanco;
    public static JFrame v;


    public VentanaInicio() {
        this.miBancoLabel.setFont(new Font("Serif", Font.BOLD, 28));
        this.nombreTextField.setFont(new Font("Serif", Font.BOLD, 16));
        this.passwordField.setFont(new Font("Serif", Font.BOLD, 16));
        this.miBanco = Banco.getMiBanco();
        this.buttonIniciarSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = nombreTextField.getText().toString();
                String password = fromArrayToString(Arrays.toString(passwordField.getPassword()));
                if (nombre.equals("") || password.equals("")) { // Los campos no están vacíos
                    JOptionPane.showMessageDialog(null, "Rellena todos los campos, por favor");
                } else {
                    Persona persona = miBanco.buscarCliente(nombre);
                    if (persona == null){ // La persona existe
                        JOptionPane.showMessageDialog(null, "Esa persona no existe");
                    }else{
                        if (persona.esMiDNI(password)) { // Contraseña correcta
                            v.setVisible(false);
                            v = new JFrame();
                            v.setContentPane(new VentanaOpciones(persona, v).panelMain);
                            v.setTitle("Mi Banco");
                            v.setSize(800,600);
                            v.setVisible(true);
                            v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        }else { // Contraseña incorrecta
                            JOptionPane.showMessageDialog(null, "Constraseña incorrecta");
                        }
                    }

                }
            }
        });
    }

    private String fromArrayToString(String array){
        String s = array.replace("[","");
        s = s.replace("]","");
        s = s.replace(",","");
        s = s.replace(" ","");
        return s;
    }

    public static void main(String[] args) {
        v = new JFrame();
        v.setContentPane(new VentanaInicio().panelMain);
        v.setTitle("Mi Banco");
        v.setSize(600,600);
        v.setVisible(true);
        v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
