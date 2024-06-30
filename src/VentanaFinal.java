import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaFinal extends JFrame {
    private String tipoComprobante;
    private JTextField txtNumeroDocumento;
    private JButton btnGenerar;

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

        btnGenerar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generarPDF();
            }
        });
    }

    private void generarPDF() {
        // Aquí iría la lógica para generar el PDF usando una librería como iText
        String numeroDocumento = txtNumeroDocumento.getText();
        GenerarPDF.generar(tipoComprobante, numeroDocumento);
        JOptionPane.showMessageDialog(this, "Comprobante generado");
    }
}
