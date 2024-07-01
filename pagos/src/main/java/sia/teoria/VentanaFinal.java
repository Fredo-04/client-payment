package sia.teoria;

import java.text.SimpleDateFormat;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class VentanaFinal extends JFrame {
    private final String tipoComprobante;
    private final JTextField txtNumeroDocumento;
    private final JButton btnGenerar;

    public VentanaFinal(String tipo) {
    this.tipoComprobante = tipo;

    setTitle("Generar Comprobante");
    setSize(400, 300);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);

    JPanel panel = new JPanel();
    panel.setLayout(new GridLayout(3, 2));

    JLabel lblNumeroDocumento = new JLabel(tipo.equals("factura") ? "Nro de RUC:" : "Nro de DNI:");
    panel.add(lblNumeroDocumento);

    txtNumeroDocumento = new JTextField(tipo.equals("factura") ? 11 : 8);
    panel.add(txtNumeroDocumento);

    btnGenerar = new JButton("Generar Comprobante");
    panel.add(btnGenerar);

    add(panel);

    // Usando lambda para el ActionListener del botón
    btnGenerar.addActionListener(e -> {
        if (txtNumeroDocumento.getText().length() == (tipo.equals("factura") ? 11 : 8)) {
            mostrarTablaComprobante();
        } else {
            JOptionPane.showMessageDialog(this, "Por favor ingrese el número correcto de caracteres.");
        }
    });
}


    private void mostrarTablaComprobante() {
    String numeroDocumento = txtNumeroDocumento.getText();
    String numeroComprobante = String.format("%05d", new Random().nextInt(100000));
    
    JFrame ventanaTabla = new JFrame("Comprobante de Pago");
    ventanaTabla.setSize(400, 300);
    ventanaTabla.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    ventanaTabla.setLocationRelativeTo(null);

    JPanel panel = new JPanel(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.insets = new Insets(5, 5, 5, 5);

    // Título
    JLabel lblTitulo = new JLabel(tipoComprobante.equals("factura") ? "FACTURA:" : "BOLETA:");
    lblTitulo.setFont(new Font("Arial", Font.BOLD, 16));
    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.gridwidth = 2;
    panel.add(lblTitulo, gbc);

    // Número de comprobante
    gbc.gridy++;
    gbc.gridwidth = 1;
    panel.add(new JLabel("Nro: " + numeroComprobante), gbc);

    // Fecha
    gbc.gridx = 1;
    panel.add(new JLabel("Fecha: " + obtenerFechaActual()), gbc);

    // Información del cliente
    gbc.gridx = 0;
    gbc.gridy++;
    gbc.gridwidth = 2;
    panel.add(new JLabel("Información Del Cliente"), gbc);

    // Nombre y Apellidos
    gbc.gridy++;
    gbc.gridwidth = 1;
    panel.add(new JLabel("Nombres y Apellidos:"), gbc);
    gbc.gridx = 1;
    panel.add(new JLabel("Luis"), gbc);

    // DNI
    gbc.gridx = 0;
    gbc.gridy++;
    panel.add(new JLabel(tipoComprobante.equals("factura") ? "RUC:" : "DNI:"), gbc);
    gbc.gridx = 1;
    panel.add(new JLabel(numeroDocumento), gbc);

    // Teléfono
    gbc.gridx = 0;
    gbc.gridy++;
    panel.add(new JLabel("Teléfono:"), gbc);
    gbc.gridx = 1;
    panel.add(new JLabel("123 456 789"), gbc);

    // Dirección
    gbc.gridx = 0;
    gbc.gridy++;
    panel.add(new JLabel("Dirección:"), gbc);
    gbc.gridx = 1;
    panel.add(new JLabel("Laboratorio 206"), gbc);

    // Monto
    gbc.gridx = 0;
    gbc.gridy++;
    panel.add(new JLabel("Monto:"), gbc);
    gbc.gridx = 1;
    panel.add(new JLabel("S/." + 1299), gbc);

    // Botón Imprimir
    JButton btnImprimir = new JButton("Imprimir");
    gbc.gridx = 0;
    gbc.gridy++;
    gbc.gridwidth = 2;
    panel.add(btnImprimir, gbc);

    ventanaTabla.add(panel);
    ventanaTabla.setVisible(true);

    btnImprimir.addActionListener(e -> {
        VentanaProducto ventanaProducto = new VentanaProducto();
        ventanaProducto.setVisible(true);
        ventanaTabla.dispose();
        this.dispose();
    });

    JOptionPane.showMessageDialog(this, "Comprobante generado");
}

// Métodos auxiliares para generar datos aleatorios
private String obtenerFechaActual() {
    return new SimpleDateFormat("dd/MM/yyyy").format(new Date());
}

}
