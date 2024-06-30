package sia.teoria;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class VentanaComprobante extends JFrame {
    private final JButton btnBoleta;
    private final JButton btnFactura;

    public VentanaComprobante() {
        setTitle("Selección de Comprobante");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));

        btnBoleta = new JButton("Boleta");
        btnFactura = new JButton("Factura");

        panel.add(btnBoleta);
        panel.add(btnFactura);

        add(panel);

        btnBoleta.addActionListener((ActionEvent e) -> {
            abrirVentanaFinal("boleta");
        });

        btnFactura.addActionListener((ActionEvent e) -> {
            abrirVentanaFinal("factura");
        });
    }

    private void abrirVentanaFinal(String tipo) {
        VentanaFinal ventanaFinal = new VentanaFinal(tipo);
        ventanaFinal.setVisible(true);
        this.dispose();
    }
}
