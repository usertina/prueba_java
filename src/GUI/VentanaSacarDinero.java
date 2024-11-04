package GUI;

import Clases.Banco;
import Clases.Persona;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class VentanaSacarDinero extends JFrame {
    private JTextField cantidadTextField;
    private JButton aceptarButton;
    private JLabel tituloLabel;
    private JLabel CantidadLabel;
    private JLabel PinLabel;
    private JPasswordField passwordField1;
    public JPanel panelMain;
    private JButton cancelarButton;
    private Persona persona;
    private Banco miBanco;
    private JFrame v;

    public VentanaSacarDinero(Persona pPersona, JFrame jf) {
        this.persona = pPersona;
        this.miBanco = Banco.getMiBanco();
        this.tituloLabel.setFont(new Font("Serif", Font.BOLD, 22));
        aceptarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Float cantidad = null;
                try {
                    cantidad = Float.parseFloat(cantidadTextField.getText().toString());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Introduce un número, por favor.");
                }
                if (cantidad != null) {
                    Integer pin = Integer.parseInt(fromArrayToString(Arrays.toString(passwordField1.getPassword())));
                    if (miBanco.sacarDinero(persona, cantidad, pin)) {
                        JOptionPane.showMessageDialog(null, "Tu saldo actual es: " + miBanco.getSaldoCliente(persona));
                        jf.setVisible(false);
                        v = new JFrame();
                        v.setContentPane(new VentanaOpciones(persona, v).panelMain);
                        v.setTitle("Mi Banco");
                        v.setSize(600, 600);
                        v.setVisible(true);
                        v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Pin incorrecto o cantidad no aceptada");
                    }
                }
            }
        });

        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jf.setVisible(false);
                v = new JFrame();
                v.setContentPane(new VentanaOpciones(persona, v).panelMain);
                v.setTitle("Mi Banco");
                v.setSize(800, 600);
                v.setVisible(true);
                v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        });
    }

    private String fromArrayToString(String array) {
        String s = array.replace("[", "");
        s = s.replace("]", "");
        s = s.replace(",", "");
        s = s.replace(" ", "");
        return s;
    }

}
