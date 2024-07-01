package sia.teoria;

import java.awt.GridLayout;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

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

        panel.add(new JLabel(tipo.equals("factura") ? "Nro de RUC:" : "Nro de DNI:"));
        txtNumeroDocumento = new JTextField(tipo.equals("factura") ? 11 : 8);
        panel.add(txtNumeroDocumento);

        btnGenerar = new JButton("Generar Comprobante");
        panel.add(btnGenerar);

        add(panel);

        // Usando lambda para el ActionListener del botón
        btnGenerar.addActionListener(e -> mostrarTablaComprobante());
    }

    private void mostrarTablaComprobante() {
        String numeroDocumento = txtNumeroDocumento.getText();

        JFrame ventanaTabla = new JFrame("Comprobante de Pago");
        ventanaTabla.setSize(400, 300);
        ventanaTabla.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventanaTabla.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2));

        panel.add(new JLabel("Tipo de Comprobante:"));
        panel.add(new JLabel(tipoComprobante.equals("factura") ? "Factura" : "Boleta"));

        panel.add(new JLabel("Nombre:"));
        panel.add(new JLabel("Luis"));

        panel.add(new JLabel("Número de Documento:"));
        panel.add(new JLabel(numeroDocumento));

        panel.add(new JLabel("Monto:"));
        panel.add(new JLabel("S/.1299"));

        panel.add(new JLabel("Fecha:"));
        panel.add(new JLabel("30/06/2024"));



        JButton btnImprimir = new JButton("Imprimir");
        panel.add(btnImprimir);

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
}
