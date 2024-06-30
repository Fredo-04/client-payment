package sia.teoria;

import java.awt.GridLayout;

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

        panel.add(new JLabel("Número de " + tipo + ":"));
        txtNumeroDocumento = new JTextField(tipo.equals("boleta") ? 8 : 11);
        panel.add(txtNumeroDocumento);

        btnGenerar = new JButton("Generar Comprobante");
        panel.add(btnGenerar);

        add(panel);

        // Usando lambda para el ActionListener del botón
        btnGenerar.addActionListener(e -> generarPDF());
    }

    private void generarPDF() {
        String numeroDocumento = txtNumeroDocumento.getText();
        
        GenerarPDFBox.generar(tipoComprobante, numeroDocumento);
        JOptionPane.showMessageDialog(this, "Comprobante generado");
    }
}
