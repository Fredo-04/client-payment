import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.Random;

public class GenerarPDF {

    public static void generar(String tipo, String numeroDocumento) {
        Document document = new Document();

        try {
            PdfWriter.getInstance(document, new FileOutputStream(tipo + "_comprobante.pdf"));
            document.open();

            document.add(new Paragraph("Comprobante de " + tipo.toUpperCase()));
            document.add(new Paragraph("Fecha: " + new Date()));
            document.add(new Paragraph("Nombre: " + generarNombreAleatorio()));
            document.add(new Paragraph("Número de Documento: " + numeroDocumento));
            document.add(new Paragraph("Artículos:"));
            document.add(new Paragraph("1. Galleta - Precio: $1.00")); // Aquí añadirías los artículos del carrito
            // Aquí se añadirían más detalles según se requiera

            document.close();
        } catch (FileNotFoundException | DocumentException e) {
            e.printStackTrace();
        }
    }

    private static String generarNombreAleatorio() {
        String[] nombres = {"Juan", "Maria", "Pedro", "Luis", "Ana"};
        String[] apellidos = {"Perez", "Gonzalez", "Rodriguez", "Lopez", "Martinez"};
        Random rand = new Random();
        return nombres[rand.nextInt(nombres.length)] + " " + apellidos[rand.nextInt(apellidos.length)];
    }
}
