import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPago extends JFrame {
    private JButton btnEfectivo, btnTarjeta;

    public VentanaPago() {
        setTitle("Método de Pago");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));

        btnEfectivo = new JButton("Pago en efectivo");
        btnTarjeta = new JButton("Pago con tarjeta");

        panel.add(btnEfectivo);
        panel.add(btnTarjeta);

        add(panel);

        btnEfectivo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirVentanaComprobante();
            }
        });

        btnTarjeta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirVentanaTarjeta();
            }
        });
    }

    private void abrirVentanaComprobante() {
        VentanaComprobante ventanaComprobante = new VentanaComprobante();
        ventanaComprobante.setVisible(true);
        this.dispose();
    }

    private void abrirVentanaTarjeta() {
        JFrame ventanaTarjeta = new JFrame("Pago con tarjeta");
        ventanaTarjeta.setSize(400, 300);
        ventanaTarjeta.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventanaTarjeta.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));

        panel.add(new JLabel("Número de tarjeta:"));
        JTextField txtNumeroTarjeta = new JTextField(16);
        panel.add(txtNumeroTarjeta);

        panel.add(new JLabel("CVV:"));
        JTextField txtCVV = new JTextField(3);
        panel.add(txtCVV);

        JButton btnAceptar = new JButton("Aceptar");
        panel.add(btnAceptar);

        ventanaTarjeta.add(panel);

        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirVentanaComprobante();
                ventanaTarjeta.dispose();
            }
        });

        ventanaTarjeta.setVisible(true);
    }
}
