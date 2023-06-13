package segundoobligatoriop2.auxiliar;

import java.io.FileOutputStream;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import segundoobligatoriop2.Sistema;

public class GeneradorArchivo {

    public static void GenerarPDF() {

        ArrayList<Transaccion> listaTransacciones = Sistema.getListaTransacciones();
        Collections.sort(listaTransacciones, Comparator.comparingInt(Transaccion::getNumeroTransaccion));

        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream("./archivo.pdf"));
            document.open();

            for (Transaccion transaccion : listaTransacciones) {
                Paragraph paragraph = new Paragraph("Número de Transacción: " + transaccion.getNumeroTransaccion());
                document.add(paragraph);
            }

            document.close();
            
            System.out.println("El archivo PDF se ha creado correctamente.");
        } catch (Exception e) {
            System.out.println("No se pudo crear el reporte PDF: " + e.getMessage());
        }
    }
}