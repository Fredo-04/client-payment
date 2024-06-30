package sia.teoria;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.IOException;
import java.util.Date;

public class GenerarPDFBox {
    public static void generar(String tipo, String numeroDocumento) {
        try (PDDocument document = new PDDocument()) {
            PDPage page = new PDPage();
            document.addPage(page);
            try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {
                contentStream.setFont(PDType1Font.TIMES_ROMAN, 12); // Establecer la fuente y tamaño de la fuente
                contentStream.beginText(); // Comenzar el bloque de texto
                contentStream.newLineAtOffset(100, 700);
                contentStream.showText("Comprobante de " + tipo.toUpperCase());
                contentStream.newLineAtOffset(0, -15);
                contentStream.showText("Fecha: " + new Date());
                contentStream.newLineAtOffset(0, -15);
                contentStream.showText("Número de Documento: " + numeroDocumento);
                contentStream.endText(); // Finalizar el bloque de texto
            }
            document.save(tipo + "_comprobante.pdf");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

