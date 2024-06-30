import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaComprobante extends JFrame {
    private JButton btnBoleta, btnFactura;

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

        btnBoleta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirVentanaFinal("boleta");
            }
        });

        btnFactura.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirVentanaFinal("factura");
            }
        });
    }

    private void abrirVentanaFinal(String tipo) {
        VentanaFinal ventanaFinal = new VentanaFinal(tipo);
        ventanaFinal.setVisible(true);
        this.dispose();
    }
}
