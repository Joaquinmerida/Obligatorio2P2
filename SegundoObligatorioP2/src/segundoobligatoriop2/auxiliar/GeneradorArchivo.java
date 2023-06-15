package segundoobligatoriop2.auxiliar;

import java.io.FileOutputStream;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Font;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import segundoobligatoriop2.Sistema;

public class GeneradorArchivo {

    public static void GenerarPDF(int desde, int hasta, String nombreArchivo, String tipoMovimiento, ArrayList<String> elementosSeleccionados) {

        ArrayList<Transaccion> listaTransacciones = Sistema.getListaTransacciones();

        Collections.sort(listaTransacciones, Comparator.comparingInt(Transaccion::getNumeroTransaccion));

        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream("./" + nombreArchivo + ".pdf"));
            document.open();

            Paragraph titulo = new Paragraph("Reporte de transacciones", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18));
            Paragraph subTitulo = new Paragraph(tipoMovimiento, FontFactory.getFont(FontFactory.HELVETICA_OBLIQUE, 14));
            titulo.setAlignment(Element.ALIGN_CENTER);
            titulo.setSpacingAfter(10);
            document.add(titulo);
            document.add(subTitulo);
            Font fontEncabezado = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 15);
            Font fontContenido = FontFactory.getFont(FontFactory.HELVETICA, 13);
            PdfPTable table = new PdfPTable(6);
            table.setWidthPercentage(100);

            float[] columnWidths = {0.5f, 1f, 1f, 1f, 1f, 1f};

            table.setWidths(columnWidths);

            añadirCelda(table, "N°", fontEncabezado);
            añadirCelda(table, "Item", fontEncabezado);
            añadirCelda(table, "Puesto", fontEncabezado);
            añadirCelda(table, "Tipo movimiento", fontEncabezado);
            añadirCelda(table, "Cantidad", fontEncabezado);
            añadirCelda(table, "Precio", fontEncabezado);

            for (Transaccion transaccion : listaTransacciones) {
                for (String nombre : elementosSeleccionados) {

                    if (transaccion.getNumeroTransaccion() >= desde && transaccion.getNumeroTransaccion() <= hasta) {
                        if ((tipoMovimiento.equalsIgnoreCase("Ventas") && transaccion.getComprador().equalsIgnoreCase("Publico"))&&(transaccion.getVendedor().equals(nombre))) {
                            añadirCelda(table, Integer.toString(transaccion.getNumeroTransaccion()), fontContenido);
                            añadirCelda(table, transaccion.getItemVenta().getNombre(), fontContenido);
                            añadirCelda(table, transaccion.getVendedor(), fontContenido);
                            añadirCelda(table, "V", fontContenido);
                            añadirCelda(table, Double.toString(transaccion.getCantidad()), fontContenido);
                            añadirCelda(table, Integer.toString(transaccion.getPrecio()), fontContenido);

                        }

                        if ((tipoMovimiento.equalsIgnoreCase("Compras") && !transaccion.getComprador().equalsIgnoreCase("Publico"))&&(transaccion.getComprador().equals(nombre))) {
                            añadirCelda(table, Integer.toString(transaccion.getNumeroTransaccion()), fontContenido);
                            añadirCelda(table, transaccion.getItemVenta().getNombre(), fontContenido);
                            añadirCelda(table, transaccion.getComprador(), fontContenido);
                            añadirCelda(table, "C", fontContenido);
                            añadirCelda(table, Double.toString(transaccion.getCantidad()), fontContenido);
                            añadirCelda(table, Integer.toString(transaccion.getPrecio()), fontContenido);

                        }

                        if ((tipoMovimiento.equalsIgnoreCase("Todo"))&&((transaccion.getComprador().equals(nombre)||(transaccion.getVendedor().equals(nombre))))) {
                            añadirCelda(table, Integer.toString(transaccion.getNumeroTransaccion()), fontContenido);
                            añadirCelda(table, transaccion.getItemVenta().getNombre(), fontContenido);

                            if (transaccion.getComprador().equalsIgnoreCase("Publico")) {
                                añadirCelda(table, transaccion.getVendedor(), fontContenido);
                                añadirCelda(table, "V", fontContenido);
                            } else {
                                añadirCelda(table, transaccion.getComprador(), fontContenido);
                                añadirCelda(table, "C", fontContenido);
                            }
                            añadirCelda(table, Double.toString(transaccion.getCantidad()), fontContenido);
                            añadirCelda(table, Integer.toString(transaccion.getPrecio()), fontContenido);
                        }
                    }

                }

            }
            document.add(table);
            document.close();
            System.out.println("El archivo PDF se ha creado correctamente.");
        } catch (Exception e) {
            System.out.println("No se pudo crear el reporte PDF: " + e.getMessage());
        }
    }

    private static void añadirCelda(PdfPTable table, String text, Font font) {
        PdfPCell celda = new PdfPCell(new Paragraph(text, font));
        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(celda);
    }
}
