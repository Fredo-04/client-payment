package sia.teoria;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
        } else if (codigo.equals("5678")) {
            lblResultado.setText("<html>Cliente: Mario<br>Deuda: NO</html>");
            btnAñadir.setEnabled(false);
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

    /*private void validarProducto() {
        String codigo = txtCodigo.getText();
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "SELECT nombre, deuda, monto FROM mae_cliente WHERE pk_cliente = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, Integer.parseInt(codigo));
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String nombre = resultSet.getString("nombre");
                boolean deuda = resultSet.getBoolean("deuda");
                double monto = resultSet.getDouble("monto");
                lblResultado.setText(String.format("<html>Cliente: %s<br>Deuda: %s<br>Monto: S/.%.2f</html>", nombre, deuda ? "SI" : "NO", monto));
                btnAñadir.setEnabled(deuda);
            } else {
                lblResultado.setText("Cliente no encontrado");
                btnAñadir.setEnabled(false);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error de conexión: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }/* */
}
