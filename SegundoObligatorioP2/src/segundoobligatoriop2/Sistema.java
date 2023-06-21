package segundoobligatoriop2;

/*
      ---------------------------------------------------------
    |                    Sistema desarrollado por                               |
  |    Joaquin Merida 253076 y Juan Manuel Mera  273527 |
 ---------------------------------------------------------
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;
import segundoobligatoriop2.interfaz.*;
import segundoobligatoriop2.auxiliar.*;

public class Sistema {

    private static ArrayList<Item> listaItems;
    private static ArrayList<Mayorista> listaMayoristas;
    private static ArrayList<Puesto> listaPuesto;
    private static ArrayList<Dueno> listaDuenos;
    private static ArrayList<Transaccion> listaTransacciones;
    private static int numeroTransaccion;

    public static void main(String[] args) {
        listaItems = new ArrayList<>();
        listaMayoristas = new ArrayList<>();
        listaDuenos = new ArrayList<>();
        listaPuesto = new ArrayList<>();
        listaTransacciones = new ArrayList<>();
        MenuPrincipal m = new MenuPrincipal();
        m.setVisible(true);
    }

    public static ArrayList<Item> getListaItems() {
        return listaItems;
    }

    public static int getNumeroTransaccion() {
        return numeroTransaccion;
    }

    public static void aumentarNumeroTransaccion() {
        numeroTransaccion++;
    }

    public static ArrayList<Mayorista> getListaMayoristas() {
        return listaMayoristas;
    }

    public static ArrayList<Dueno> getListaDuenos() {
        return listaDuenos;
    }

    public static ArrayList<Puesto> getListaPuesto() {
        return listaPuesto;
    }

    public static ArrayList<Transaccion> getListaTransacciones() {
        return listaTransacciones;
    }

    public static void agregarItem(Item unItem) {
        listaItems.add(unItem);
    }

    public static Boolean itemUnico(String nombreItem, ArrayList<Item> listaItems) {
        Boolean existe = true;
        for (Item item : listaItems) {
            if (item.getNombre().equals(nombreItem)) {
                existe = false;
            }
        }
        return existe;
    }

    public static Mayorista getMayorista(String rut) {
        Mayorista mayoristaEncontrado = null;
        for (Mayorista mayorista : listaMayoristas) {
            if (mayorista.getRut().equalsIgnoreCase(rut)) {
                mayoristaEncontrado = mayorista;
                break;
            }
        }
        return mayoristaEncontrado;
    }

    public static int getIndexItem(String nombreItem) {
        int index = 0;
        for (Item item : listaItems) {
            if (item.getNombre().equals(nombreItem)) {
                index = listaItems.indexOf(item);
            }
        }
        return index;
    }

    public static int getTotalDineroVentaPuestos(Item unItem) {
        int total = 0;
        for (Transaccion transaccion : listaTransacciones) {
            if (transaccion.getItemVenta().getNombre().equals(unItem.getNombre()) && transaccion.getComprador().equals("Publico") && transaccion.getItemVenta() != null) {
                total += transaccion.getPrecio() * transaccion.getCantidad();
            }
        }
        return total;
    }

    public static int getTotalDineroVentaMayoristas(Item unItem) {
        int total = 0;
        for (Transaccion transaccion : listaTransacciones) {
            if (transaccion.getItemVenta().getNombre().equals(unItem.getNombre()) && !transaccion.getComprador().equalsIgnoreCase("Publico")) {
                total += transaccion.getPrecio() * transaccion.getCantidad();
            }
        }
        return total;
    }

    public static int getKgTotalVendidoPuestos(Item unItem) {
        int totalKg = 0;
        for (Transaccion transaccion : listaTransacciones) {
            if (transaccion.getComprador().equalsIgnoreCase("Publico") && transaccion.getItemVenta().getFormaVenta().equalsIgnoreCase("Kilogramo") && transaccion.getItemVenta().getNombre().equals(unItem.getNombre())) {
                totalKg += transaccion.getCantidad();
            }
        }
        return totalKg;
    }

    public static int getUnidadesTotalVendidoPuestos(Item unItem) {
        int totalUnidades = 0;
        for (Transaccion transaccion : listaTransacciones) {
            if (transaccion.getComprador().equalsIgnoreCase("Publico") && transaccion.getItemVenta().getFormaVenta().equalsIgnoreCase("Unidad") && transaccion.getItemVenta().getNombre().equals(unItem.getNombre())) {
                totalUnidades += transaccion.getCantidad();
            }
        }
        return totalUnidades;
    }

    public static int getKgTotalCompradoPuestos(Item unItem) {
        int totalKg = 0;
        for (Transaccion transaccion : listaTransacciones) {
            if (!transaccion.getComprador().equalsIgnoreCase("Publico") && transaccion.getItemVenta().getFormaVenta().equalsIgnoreCase("Kilogramo") && transaccion.getItemVenta().getNombre().equals(unItem.getNombre())) {
                totalKg += transaccion.getCantidad();
            }
        }
        return totalKg;
    }

    public static int getUnidadesTotalCompradoPuestos(Item unItem) {
        int totalUnidades = 0;
        for (Transaccion transaccion : listaTransacciones) {
            if (!transaccion.getComprador().equalsIgnoreCase("Publico") && transaccion.getItemVenta().getFormaVenta().equalsIgnoreCase("Unidad") && transaccion.getItemVenta().getNombre().equals(unItem.getNombre())) {
                totalUnidades += transaccion.getCantidad();
            }
        }
        return totalUnidades;
    }

    public static int getMinimoVendido(Item unItem) {
        int minimo = Integer.MAX_VALUE;
        for (Transaccion transaccion : listaTransacciones) {
            if (transaccion.getComprador().equals("Publico") && transaccion.getItemVenta().getNombre().equals(unItem.getNombre()) && transaccion.getPrecio() < minimo) {
                minimo = transaccion.getPrecio();
            }
        }
        if (minimo == Integer.MAX_VALUE) {
            minimo = 0;
        }
        return minimo;
    }

    public static int getMaximoVendido(Item unItem) {
        int maximo = 0;
        for (Transaccion transaccion : listaTransacciones) {
            if (transaccion.getComprador().equals("Publico") && transaccion.getItemVenta().getNombre().equals(unItem.getNombre()) && transaccion.getPrecio() > maximo) {
                maximo = transaccion.getPrecio();
            }
        }
        return maximo;
    }

    public static void agregarTransaccion(String vendedor, String comprador, Item item, int precio, double cantidad) {
        aumentarNumeroTransaccion();
        int numeroTransaccion = getNumeroTransaccion();
        listaTransacciones.add(new Transaccion(numeroTransaccion, vendedor, comprador, item, precio, cantidad));
    }

    public static void realizarCompraDePuesto(String vendedor, String comprador, String itemVendido, int precio, double cantidad) {
        Item itemObjeto = null;
        Mayorista mayorista = getMayorista(vendedor);
        for (Item itemMayorista : mayorista.getListaItems()) {
            if (itemMayorista.getNombre().equals(itemVendido)) {
                if (itemMayorista.getFormaVenta().equalsIgnoreCase("Kilogramo")) {
                    itemObjeto = new Item(itemMayorista.getNombre(), itemMayorista.getDescripcion(), itemMayorista.getTipo(), itemMayorista.getFormaVenta(), itemMayorista.getImagen());
                    itemObjeto.setCantidad(cantidad);
                } else {
                    itemObjeto = new Item(itemMayorista.getNombre(), itemMayorista.getDescripcion(), itemMayorista.getTipo(), itemMayorista.getFormaVenta(), itemMayorista.getImagen());
                    itemObjeto.setCantidad((int) Math.floor(cantidad));
                }
            }
        }
        for (Puesto puesto : listaPuesto) {
            if (puesto.getIdentificacion().equals(comprador)) {
                boolean itemEncontrado = false;
                for (Item itemEnStock : puesto.getStock()) {
                    if (itemEnStock.getNombre().equalsIgnoreCase(itemObjeto.getNombre())) {
                        if (itemEnStock.getFormaVenta().equalsIgnoreCase("Kilogramo")) {
                            itemEncontrado = true;
                            itemEnStock.sumarCantidad(cantidad);
                            agregarTransaccion(vendedor + "", comprador, itemObjeto, precio, cantidad);
                        } else {
                            itemEncontrado = true;
                            itemEnStock.sumarCantidad((int) Math.floor(cantidad));
                            agregarTransaccion(vendedor + "", comprador, itemObjeto, precio, (int) Math.floor(cantidad));
                        }
                    }
                }
                if (!itemEncontrado) {
                    if (itemObjeto.getFormaVenta().equalsIgnoreCase("Kilogramo")) {
                        itemObjeto.setCantidad(cantidad);
                        puesto.añadirItem(itemObjeto);
                        agregarTransaccion(vendedor + "", comprador, itemObjeto, precio, cantidad);
                    } else {
                        itemObjeto.setCantidad((int) Math.floor(cantidad));
                        puesto.añadirItem(itemObjeto);
                        agregarTransaccion(vendedor + "", comprador, itemObjeto, precio, (int) Math.floor(cantidad));
                    }
                }
            }
        }
    }

    public static boolean realizarCompraDePublico(String idVendedor, String comprador, Item itemVendido, int precio, double cantidad) {
        boolean correcta = true;
        for (Puesto puesto : listaPuesto) {
            if (puesto.getIdentificacion().equals(idVendedor)) {
                for (Item item : puesto.getStock()) {
                    if (itemVendido.getNombre().equals(item.getNombre())) {
                        if (item.getFormaVenta().equalsIgnoreCase("Kilogramo")) {
                            if (item.getCantidad() >= cantidad) {
                                agregarTransaccion(idVendedor, "Publico", itemVendido, precio, cantidad);
                                item.sumarCantidad(cantidad * -1);
                            } else {
                                correcta = false;
                            }
                        } else {
                            if (item.getCantidad() >= (int) Math.floor(cantidad)) {
                                agregarTransaccion(idVendedor, "Publico", itemVendido, precio, (int) Math.floor(cantidad));
                                item.sumarCantidad(cantidad * -1);
                            } else {
                                correcta = false;
                            }
                        }
                    }
                }
            }
        }
        return correcta;
    }

    public static void agregarMayorista(String nombre, String rut, String direccion, ArrayList<String> items) {
        ArrayList<Item> itemsDelNuevoMayorista = new ArrayList<>();
        if (mayoristaUnico(rut)) {
            for (String itemString : items) {
                for (Item item : listaItems) {
                    if (item.getNombre().equals(itemString)) {
                        itemsDelNuevoMayorista.add(new Item(item.getNombre(), item.getDescripcion(), item.getTipo(), item.getFormaVenta(), item.getImagen()));
                    }
                }
            }
            Mayorista unMayorista = new Mayorista(rut, nombre, direccion, itemsDelNuevoMayorista);
            listaMayoristas.add(unMayorista);
        }
    }

    public static ArrayList<Item> getItemsAVenderMayorista(String rut) {
        ArrayList<Item> listaItems = new ArrayList<Item>();
        for (Mayorista mayorista : listaMayoristas) {
            if (mayorista.getRut().equalsIgnoreCase(rut)) {
                listaItems.addAll(mayorista.getListaItems());
            }
        }
        return listaItems;
    }

    public static Boolean mayoristaUnico(String rut) {
        Boolean existe = true;
        for (Mayorista mayorista : listaMayoristas) {
            if (mayorista.getRut().equalsIgnoreCase(rut)) {
                existe = false;
            }
        }
        return existe;
    }

    public static void agregarPuesto(String identificacion, String dueno, String ubicacion, int empleados) {
        if (identificacionUnico(identificacion)) {

        } else {
            Dueno nuevoDueno = null;
            for (Dueno verDueno : listaDuenos) {
                if (verDueno.getNombre().equals(dueno)) {
                    nuevoDueno = new Dueno(verDueno.getNombre(), verDueno.getEdad(), verDueno.getAExperiencia());
                }
            }
            Puesto unPuesto = new Puesto(identificacion, nuevoDueno, ubicacion, empleados);
            listaPuesto.add(unPuesto);
        }
    }

    public static void agregarDueno(String nombre, int edad, int experiencia) {
        if (!nombreDuenoUnico(nombre)) {
            Dueno unDueño = new Dueno(nombre, edad, experiencia);
            Sistema.getListaDuenos().add(unDueño);
        }
    }

    public static Boolean identificacionUnico(String identificacion) {
        Boolean existe = false;
        for (Puesto puesto : listaPuesto) {
            if (puesto.getIdentificacion().equalsIgnoreCase(identificacion)) {
                existe = true;
            }
        }
        return existe;
    }

    public static Boolean nombreDuenoUnico(String nombre) {
        Boolean existe = false;
        for (Dueno Dueños : listaDuenos) {
            if (Dueños.getNombre().contains(nombre)) {
                existe = true;
            }
        }
        return existe;
    }

    public static void generarArchivo(int desde, int hasta, String nombreArchivo, String tipoMovimiento, ArrayList<String> elementosSeleccionados) {
        GeneradorArchivo.GenerarPDF(desde, hasta, nombreArchivo, tipoMovimiento, elementosSeleccionados);
    }

    public static void guardarProceso() {
        try {
            Formatter arch = new Formatter("archivo.txt");
            arch.format("%s%n", "-items");
            for (Item item : listaItems) {
                arch.format("%s%n", item.getNombre() + "@" + item.getDescripcion() + "@" + item.getTipo() + "@" + item.getFormaVenta() + "@" + item.getImagen() + "@" + item.getCantidad());
            }
            arch.format("%s%n", "-mayoristas");
            for (Mayorista mayorista : listaMayoristas) {
                String items = "#";
                for (Item item : mayorista.getListaItems()) {
                    items += item.getNombre() + "#";
                }
                arch.format("%s%n", mayorista.getRut() + "/" + mayorista.getNombre() + "/" + mayorista.getDireccion() + "/" + items);
            }
            arch.format("%s%n", "-duenos");
            for (Dueno dueno : listaDuenos) {
                arch.format("%s%n", dueno.getNombre() + "/" + dueno.getEdad() + "/" + dueno.getAExperiencia());
            }
            arch.format("%s%n", "-puestos");
            for (Puesto puesto : listaPuesto) {
                String items = "#";
                for (Item item : puesto.getStock()) {
                    items += item.getNombre() + "#";
                }
                arch.format("%s%n", puesto.getIdentificacion() + "/" + puesto.getDueno().getNombre() + "/" + puesto.getUbicacion() + "/" + puesto.getCantidadEmpleados() + "/" + items);
            }
            arch.format("%s%n", "-transacciones");
            for (Transaccion transaccion : listaTransacciones) {
                arch.format("%s%n", transaccion.getNumeroTransaccion() + "/" + transaccion.getVendedor() + "/" + transaccion.getComprador() + "/" + transaccion.getItemVenta().getNombre() + "/" + transaccion.getPrecio() + "/" + transaccion.getCantidad());
            }
            arch.close();
        } catch (FileNotFoundException e) {
        }
    }

    public static void leerArchivo(int opcion) {
        try {
            String ruta = "";
            if (opcion == 1) {
                ruta = "archivo.txt";
            } else if (opcion == 2) {
                ruta = "productos.txt";
            }
            Scanner scanner = new Scanner(new File(ruta));
            String currentSection = "";
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.startsWith("-")) {
                    currentSection = line.substring(1);
                } else {
                    switch (currentSection) {
                        case "items":
                            if (line.equals("-mayoristas")) {
                                currentSection = "";
                            } else {
                                String[] itemValues = line.split("@");
                                String nombre = itemValues[0];
                                String descripcion = itemValues[1];
                                String tipo = itemValues[2];
                                String formaVenta = itemValues[3];
                                String imagen = "";
                                if (itemValues.length >= 4) {
                                    imagen = itemValues[4];
                                }
                                Item item = new Item(nombre, descripcion, tipo, formaVenta, imagen);
                                agregarItem(item);
                            }
                            break;
                        case "mayoristas":
                            if (line.equals("-duenos")) {
                                currentSection = "";
                            } else {
                                String[] mayoristaValues = line.split("/");
                                String rut = mayoristaValues[0];
                                String nombre = mayoristaValues[1];
                                String direccion = mayoristaValues[2];
                                String items = mayoristaValues[3];
                                String[] itemsGuardados = items.split("#");
                                ArrayList<Item> listaItemsDelMayorista = new ArrayList<>();
                                for (String nombreItem : itemsGuardados) {
                                    for (Item item : listaItems) {
                                        if (nombreItem.equals(item.getNombre())) {
                                            listaItemsDelMayorista.add(new Item(item.getNombre(), item.getDescripcion(), item.getTipo(), item.getFormaVenta(), item.getImagen()));
                                        }
                                    }
                                }
                                Mayorista mayorista = new Mayorista(rut, nombre, direccion, listaItemsDelMayorista);
                                listaMayoristas.add(mayorista);
                            }
                            break;
                        case "duenos":
                            if (line.equals("-puestos")) {
                                currentSection = "";
                            } else {
                                String[] duenoValues = line.split("/");
                                String nombre = duenoValues[0];
                                int edad = Integer.parseInt(duenoValues[1]);
                                int aExperiencia = Integer.parseInt(duenoValues[2]);
                                agregarDueno(nombre, edad, aExperiencia);
                            }
                            break;
                        case "puestos":
                            if (line.equals("-transacciones")) {
                                currentSection = "";
                            } else {
                                String[] puestoValues = line.split("/");
                                String identificacion = puestoValues[0];
                                String dueno = puestoValues[1];
                                String ubicacion = puestoValues[2];
                                int cantidadEmpleados = Integer.parseInt(puestoValues[3]);
                                String stock = puestoValues[4];
                                String[] stockItems = stock.substring(1).split("#");
                                Dueno duenoParaAgregar = null;
                                for (Dueno duenoParaPuesto : listaDuenos) {
                                    if (duenoParaPuesto.getNombre().equalsIgnoreCase(dueno)) {
                                        duenoParaAgregar = new Dueno(duenoParaPuesto.getNombre(), duenoParaPuesto.getEdad(), duenoParaPuesto.getAExperiencia());
                                    }
                                }
                                Puesto puestoAAgregar = new Puesto(identificacion, duenoParaAgregar, ubicacion, cantidadEmpleados);
                                for (String nombreItem : stockItems) {
                                    for (Item itemAGuardar : listaItems) {
                                        if (nombreItem.equalsIgnoreCase(itemAGuardar.getNombre())) {
                                            puestoAAgregar.añadirItem(new Item(itemAGuardar.getNombre(), itemAGuardar.getDescripcion(), itemAGuardar.getTipo(), itemAGuardar.getFormaVenta(), itemAGuardar.getImagen()));
                                        }
                                    }
                                }
                                listaPuesto.add(puestoAAgregar);
                            }
                            break;
                        case "transacciones":
                            String[] transaccionValues = line.split("/");
                            int numeroTransaccion = Integer.parseInt(transaccionValues[0]);
                            String vendedor = transaccionValues[1];
                            String comprador = transaccionValues[2];
                            String itemVenta = transaccionValues[3];
                            int precio = Integer.parseInt(transaccionValues[4]);
                            double cantidad = Double.parseDouble(transaccionValues[5]);
                            Item itemParaAgregar = null;
                            for (Item itemTransaccion : listaItems) {
                                if (itemTransaccion.getNombre().equalsIgnoreCase(itemVenta)) {
                                    itemParaAgregar = new Item(itemTransaccion.getNombre(), itemTransaccion.getDescripcion(), itemTransaccion.getTipo(), itemTransaccion.getFormaVenta(), itemTransaccion.getImagen());
                                    itemParaAgregar.setCantidad(cantidad);
                                }
                            }
                            listaTransacciones.add(new Transaccion(numeroTransaccion, vendedor, comprador, itemParaAgregar, precio, cantidad));
                            break;
                        default:
                            break;
                    }
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {}
    }
}
