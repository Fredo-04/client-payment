package sia.teoria;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VentanaProducto extends JFrame {
    private final JTextField txtCodigo;
    private final JLabel lblResultado;
    private final JButton btnValidar;
    private final JButton btnAñadir;

    public VentanaProducto() {
        setTitle("Validación de Cliente");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1));

        JPanel panelCodigo = new JPanel();
        panelCodigo.add(new JLabel("Código de Cliente: "));
        txtCodigo = new JTextField(10);
        panelCodigo.add(txtCodigo);
        btnValidar = new JButton("Comprobar Cliente");
        panelCodigo.add(btnValidar);
        panel.add(panelCodigo);

        lblResultado = new JLabel("");
        panel.add(lblResultado);

        btnAñadir = new JButton("Pagar Deuda");
        btnAñadir.setEnabled(false);
        panel.add(btnAñadir);

        add(panel);

        btnValidar.addActionListener((ActionEvent e) -> {
            validarProducto();
        });

        btnAñadir.addActionListener((ActionEvent e) -> {
            añadirProducto();
        });
    }

    private void validarProducto() {
        String codigo = txtCodigo.getText();
        if (codigo.equals("1234")) {
            lblResultado.setText("<html>Cliente: Luis<br>Deuda: SI<br>Monto: S/.1299</html>");
            btnAñadir.setEnabled(true);
        } else if (codigo.length() != 4) {
            lblResultado.setText("Debe ser un número de 4 dígitos");
            btnAñadir.setEnabled(false);
        } else {
            lblResultado.setText("Cliente no encontrado");
            btnAñadir.setEnabled(false);
        }
    }

    private void añadirProducto() {
        VentanaPago ventanaPago = new VentanaPago();
        ventanaPago.setVisible(true);
        this.dispose();
    }
}
