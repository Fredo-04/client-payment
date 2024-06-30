package sia.teoria;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VentanaProducto ventanaProducto = new VentanaProducto();
            ventanaProducto.setVisible(true);
        });
    }
}
