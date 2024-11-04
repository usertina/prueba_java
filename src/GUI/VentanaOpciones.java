package GUI;

import Clases.Banco;
import Clases.Persona;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaOpciones extends JFrame{
    private JButton sacarSaldoButton;
    private JButton contultarSaldoButton;
    private JButton ingresarDineroButton;
    public JPanel panelMain;
    private JLabel nombreLabel;
    private Persona persona;
    private Banco miBanco;
    public static JFrame v;

    public VentanaOpciones(Persona pPersona, JFrame jf){
        this.persona = pPersona;
        this.miBanco = Banco.getMiBanco();
        this.nombreLabel.setText("Cliente: " + this.persona.getNombre() + " " + this.persona.getApellido());
        this.nombreLabel.setFont(new Font("Serif", Font.BOLD, 16));
        sacarSaldoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jf.setVisible(false);
                v = new JFrame();
                v.setContentPane(new VentanaSacarDinero(persona, v).panelMain);
                v.setTitle("Mi Banco");
                v.setSize(600,600);
                v.setVisible(true);
                v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        });
        contultarSaldoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Tu saldo es: " + miBanco.getSaldoCliente(persona));
            }
        });
        ingresarDineroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jf.setVisible(false);
                v = new JFrame();
                v.setContentPane(new VentanaIngresarDinero(persona, v).panelMain);
                v.setTitle("Mi Banco");
                v.setSize(600,600);
                v.setVisible(true);
                v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        });
    }
}
