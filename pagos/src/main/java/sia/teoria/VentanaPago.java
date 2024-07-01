package sia.teoria;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VentanaPago extends JFrame {
    private final JButton btnEfectivo;
    private final JButton btnTarjeta;

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

        btnEfectivo.addActionListener((ActionEvent e) -> {
            abrirVentanaComprobante();
        });

        btnTarjeta.addActionListener((ActionEvent e) -> {
            abrirVentanaTarjeta();
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
        panel.add(new JLabel());  // Añadir un espacio vacío
        panel.add(btnAceptar);

        ventanaTarjeta.add(panel);

        // Validación para asegurar que solo se ingresen números y que tengan la longitud correcta
        txtNumeroTarjeta.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) || txtNumeroTarjeta.getText().length() >= 16) {
                    e.consume(); // Ignorar el evento si no es un número o si ya tiene 16 dígitos
                }
            }
        });

        txtCVV.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) || txtCVV.getText().length() >= 3) {
                    e.consume(); // Ignorar el evento si no es un número o si ya tiene 3 dígitos
                }
            }
        });

        btnAceptar.addActionListener((ActionEvent e) -> {
            if (txtNumeroTarjeta.getText().length() == 16 && txtCVV.getText().length() == 3) {
                abrirVentanaComprobante();
                ventanaTarjeta.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Por favor ingrese un número de tarjeta de 16 dígitos y un CVV de 3 dígitos.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        ventanaTarjeta.setVisible(true);
    }
}
