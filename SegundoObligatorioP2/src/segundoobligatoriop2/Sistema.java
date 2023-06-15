package segundoobligatoriop2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import static java.lang.Double.parseDouble;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
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
        Interfaz v = new Interfaz();
        v.setVisible(true);
        guardarProceso();
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

    public static Mayorista getMayorista(int rut) {
        Mayorista mayoristaEncontrado = null;
        for (Mayorista mayorista : listaMayoristas) {
            if (mayorista.getRut() == rut) {
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
            if (transaccion.getItemVenta().getNombre().equals(unItem.getNombre()) && transaccion.getComprador().equals("Publico")) {
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

    public static void realizarCompraDePuesto(int vendedor, String comprador, String itemVendido, int precio, double cantidad) {
        Item itemObjeto = null;
        Mayorista mayorista = getMayorista(vendedor);

        for (Item itemMayorista : mayorista.getListaItems()) {
            if (itemMayorista.getNombre().equals(itemVendido)) {
                if (itemMayorista.getFormaVenta().equalsIgnoreCase("Kilogramo")) {
                    itemObjeto = new Item(itemMayorista.getNombre(), itemMayorista.getDescripcion(), itemMayorista.getTipo(), itemMayorista.getFormaVenta(), itemMayorista.getImagen());
                    itemObjeto.setCantidad(cantidad);
                    System.out.println("se agrega con , porque es kg" + cantidad);
                } else {
                    itemObjeto = new Item(itemMayorista.getNombre(), itemMayorista.getDescripcion(), itemMayorista.getTipo(), itemMayorista.getFormaVenta(), itemMayorista.getImagen());
                    itemObjeto.setCantidad((int) Math.floor(cantidad));
                    System.out.println("se agrega sin , porque es unidad" + (int) Math.floor(cantidad));
                }

            }
        }

        for (Puesto puesto : listaPuesto) {
            if (puesto.getIdentificacion().equals(comprador)) {
                boolean itemEncontrado = false;
                for (Item itemEnStock : puesto.getStock()) {
                    if (itemEnStock.getNombre().equals(itemObjeto.getNombre())) {
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
                        System.out.println("se agrega un item nuevo al stock porque no existia cantidad: " + cantidad);
                    } else {
                        itemObjeto.setCantidad((int) Math.floor(cantidad));
                        puesto.añadirItem(itemObjeto);
                        agregarTransaccion(vendedor + "", comprador, itemObjeto, precio, (int) Math.floor(cantidad));
                        System.out.println("se agrega un item nuevo al stock porque no existia cantidad: " + (int) Math.floor(cantidad));
                    }
                }
            }
        }
        for (Transaccion transaccion : listaTransacciones) {
            System.out.println(transaccion.getVendedor() + " le vendio : " + transaccion.getCantidad() + " " + transaccion.getItemVenta().getNombre() + " a " + transaccion.getPrecio());
        }
    }

    public static void realizarCompraDePublico(String idVendedor, String comprador, Item itemVendido, int precio, double cantidad) {
        for (Puesto puesto : listaPuesto) {
            if (puesto.getIdentificacion().equals(idVendedor)) {
                for (Item item : puesto.getStock()) {
                    if (itemVendido.getNombre().equals(item.getNombre())) {
                        if (item.getFormaVenta().equalsIgnoreCase("Kilogramo")) {
                            if (item.getCantidad() >= cantidad) {
                                agregarTransaccion(idVendedor, "Publico", itemVendido, precio, cantidad);
                                item.sumarCantidad(cantidad * -1);
                                System.out.println("Se agrega compra a publico: " + idVendedor + itemVendido.getNombre());
                            } else {
                                System.out.println("compra no valida");
                            }
                        } else {
                            if (item.getCantidad() >= (int) Math.floor(cantidad)) {
                                agregarTransaccion(idVendedor, "Publico", itemVendido, precio, (int) Math.floor(cantidad));
                                item.sumarCantidad(cantidad * -1);
                                System.out.println("Se agrega compra a publico: " + idVendedor + itemVendido.getNombre());
                            } else {
                                System.out.println("compra no valida");
                            }
                        }
                    }
                }
            }
        }
    }

    public static void ventaAPuesto(int rutVendedor, String comprador, String item, int cantidad, int precio) {
//        for (Mayorista mayorista : listaMayoristas) {
//            if (mayorista.get().contains(rut)) {
//                existe = true;
//                System.out.println("ya hay un mayorista con ese rut");
//            }
//        }
    }

    public static void agregarMayorista(String nombre, int rut, String direccion, ArrayList<String> items) {
        ArrayList<Item> itemsDelNuevoMayorista = new ArrayList<>();
        if (!mayoristaUnico(rut)) {
            System.out.println("ya existe ese mayorista");
        } else {
            for (String itemString : items) {
                for (Item item : listaItems) {
                    if (item.getNombre().equals(itemString)) {
                        itemsDelNuevoMayorista.add(new Item(item.getNombre(), item.getDescripcion(), item.getTipo(), item.getFormaVenta(), item.getImagen()));
                        System.out.println("se agrega al mayorista: " + itemString);
                    }
                }
            }

            Mayorista unMayorista = new Mayorista(rut, nombre, direccion, itemsDelNuevoMayorista);
            listaMayoristas.add(unMayorista);
            System.out.println("se agrega mayorista");
        }

        for (Mayorista mayorista : listaMayoristas) {
            System.out.println(mayorista.getNombre());
            System.out.println("items que vende:");
            for (Item item : mayorista.getListaItems()) {
                System.out.println(mayorista.getNombre() + " vende " + item.getNombre());
            }
            System.out.println("................");
        }
    }

    public static ArrayList<Item> getItemsAVenderMayorista(int rut) {
        ArrayList<Item> listaItems = new ArrayList<Item>();
        for (Mayorista mayorista : listaMayoristas) {
            if (mayorista.getRut() == rut) {
                listaItems.addAll(mayorista.getListaItems());
            }
        }
        return listaItems;
    }

    public static Boolean mayoristaUnico(int rut) {
        Boolean existe = true;
        for (Mayorista mayorista : listaMayoristas) {
            if (mayorista.getRut() == rut) {
                existe = false;
                System.out.println("ya hay un mayorista con ese rut");
            }
        }
        return existe;
    }

    public static void agregarPuesto(String identificacion, String dueno, String ubicacion, int empleados) {
        if (identificacionUnico(identificacion)) {
            System.out.println("Ya existe un puesto con esa identificacion");
        } else {
            Dueno nuevoDueno = null;
            for (Dueno verDueno : listaDuenos) {
                if (verDueno.getNombre().equals(dueno)) {
                    nuevoDueno = new Dueno(verDueno.getNombre(), verDueno.getEdad(), verDueno.getAExperiencia());
                }
            }
            Puesto unpuesto = new Puesto(identificacion, nuevoDueno, ubicacion, empleados);
            Sistema.getListaPuesto().add(unpuesto);
        }

    }

    public static void agregarDueno(String nombre, int edad, int experiencia) {
        if (nombreDueñoUnico(nombre)) {
            System.out.println("ya existe ese nombre");
        } else {
            Dueno unDueño = new Dueno(nombre, edad, experiencia);
            Sistema.getListaDuenos().add(unDueño);
            System.out.println("se agrego Dueño");
        }
        for (Dueno unDueño : listaDuenos) {
            System.out.println(unDueño.getNombre());
        }

    }

    public static Boolean identificacionUnico(String identificacion) {
        Boolean existe = false;
        for (Puesto puesto : listaPuesto) {
            if (puesto.getIdentificacion().equalsIgnoreCase(identificacion)) {
                existe = true;
                System.out.println("Ya hay un puesto con esa identificacion");

            }
        }
        return existe;
    }

    public static Boolean nombreDueñoUnico(String nombre) {
        Boolean existe = false;
        for (Dueno Dueños : listaDuenos) {
            if (Dueños.getNombre().contains(nombre)) {
                existe = true;
                System.out.println("Ya hay un Dueño con ese nombre");
            }
        }
        return existe;
    }

    public void agregarPuesto(Puesto unPuesto) {
        this.getListaPuesto().add(unPuesto);
    }

    public static void generarArchivo(int desde, int hasta, String nombreArchivo, String tipoMovimiento, ArrayList<String> elementosSeleccionados) {
        GeneradorArchivo.GenerarPDF(desde, hasta, nombreArchivo, tipoMovimiento, elementosSeleccionados);

    }

    public static void altaItem(String nombre, String descripcion, String tipo, String formaVenta, String imagen) {

        System.out.println("se agrega");

    }

    public static void guardarProceso() {
        try {

            Formatter arch = new Formatter("archiv.txt");
            arch.format("%s%n","-items-");
            for (Item item : listaItems) {
                arch.format("%s%n",item.getNombre() + "/" + item.getDescripcion() + "/" + item.getTipo() + "/" + item.getFormaVenta() + "/" + item.getImagen() + "/" + item.getCantidad());
            }
            arch.format("%s%n","-mayoristas-");
            for (Mayorista mayorista : listaMayoristas) {
                String items = "";
                for (Item item : mayorista.getListaItems()) {

                    items += item.getNombre() + "#";
                }
                arch.format("%s%n",mayorista.getRut() + "/" + mayorista.getNombre() + "/" + mayorista.getDireccion() + "/" + items);
            }
            for (Puesto puesto : listaPuesto) {
                String items = "";
                for (Item item : puesto.getStock()) {

                    items += item.getNombre() + "#";
                }

                arch.format("%s%n",puesto.getIdentificacion() + "/" + puesto.getDueno().getNombre() + "/" + puesto.getUbicacion() + "/" + puesto.getCantidadEmpleados() + "/" + items);

            }
            arch.format("%s%n","-Duenos-");
            for (Dueno dueno : listaDuenos) {
                arch.format("%s%n",dueno.getNombre() + "/" + dueno.getEdad() + "/" + dueno.getAExperiencia());
            }
            arch.format("%s%n","-Transacciones-");
            for (Transaccion transaccion : listaTransacciones) {
                arch.format("%s%n",transaccion.getNumeroTransaccion() + "/" + transaccion.getVendedor() + "/" + transaccion.getComprador() + "/" + transaccion.getItemVenta() + "/" + transaccion.getPrecio() + "/" + transaccion.getCantidad());
            }
            arch.close();
        } catch (FileNotFoundException e) {
            System.out.println("no se pudo cargar el archivo");

        }

    }

    public static void leerArchivo() {
        try {
            Scanner scanner = new Scanner(new File("archiv.txt"));

            String currentSection = "";

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                if (line.startsWith("-")) {
                    // Detectar el inicio de una nueva sección
                    currentSection = line.substring(1); // Ignorar el primer carácter "-"
                } else {
                    // Leer los datos correspondientes a la sección actual
                    switch (currentSection) {
                        case "items":
                            // Procesar datos de items
                            if (line.equals("-mayoristas-")) {
                                currentSection = ""; // Cambiar a la siguiente sección
                            } else {
                                // Leer y procesar la línea de datos del item
                                String[] itemValues = line.split("/");
                                // Crear objeto Item y hacer algo con los valores leídos
                                String nombre = itemValues[0];
                                String descripcion = itemValues[1];
                                String tipo = itemValues[2];
                                String formaVenta = itemValues[3];
                                String imagen = itemValues[4];
                                Item item = new Item(nombre, descripcion, tipo, formaVenta, imagen);
                                agregarItem(item);
                            }
                            break;
                        case "mayoristas":
                            // Procesar datos de mayoristas
                            if (line.equals("-Duenos-")) {
                                currentSection = ""; // Cambiar a la siguiente sección
                            } else {
                                // Leer y procesar la línea de datos del mayorista
                                String[] mayoristaValues = line.split("/");
                                // Crear objeto Mayorista y hacer algo con los valores leídos
                                String rut = mayoristaValues[0];
                                String nombre = mayoristaValues[1];
                                String direccion = mayoristaValues[2];
                                String items = mayoristaValues[3];
                                // Parsear los nombres de los items separados por "#"
                                String[] itemNames = items.split("#");
                                ArrayList<Item> listaItemsDelMayorista = new ArrayList<>();
                                ArrayList<String> itemsMayorista = new ArrayList<>();
                                for (String nombreItem : itemsMayorista) {
                                    for (Item item : listaItems) {
                                        if (nombreItem.equals(item.getNombre())) {
                                            listaItemsDelMayorista.add(new Item(item.getNombre(), item.getDescripcion(), item.getTipo(), item.getFormaVenta(), item.getImagen()));

                                        }
                                    }
                                }

                                Mayorista mayorista = new Mayorista(Integer.parseInt(rut), nombre, direccion, listaItems);
                                listaMayoristas.add(mayorista);
                            }
                            break;
                        case "Duenos":
                            // Procesar datos de dueños
                            if (line.equals("-Transacciones-")) {
                                currentSection = ""; // Cambiar a la siguiente sección
                            } else {
                                // Leer y procesar la línea de datos del dueño
                                String[] duenoValues = line.split("/");
                                // Crear objeto Dueno y hacer algo con los valores leídos
                                String nombre = duenoValues[0];
                                int edad = Integer.parseInt(duenoValues[1]);
                                boolean aExperiencia = Boolean.parseBoolean(duenoValues[2]);
                                // Crear objeto Dueno con los valores leídos
                                //Dueno dueno = new Dueno(nombre, edad, aExperiencia);
                                // Hacer algo con el objeto Dueno, como agregarlo a una lista
                            }
                            break;
                        case "Transacciones":
                            // Procesar datos de transacciones
                            // Leer y procesar la línea de datos de la transacción
                            String[] transaccionValues = line.split("/");
                            // Crear objeto Transaccion y hacer algo con los valores leídos
                            int numeroTransaccion = Integer.parseInt(transaccionValues[0]);
                            String vendedor = transaccionValues[1];
                            String comprador = transaccionValues[2];
                            String itemVenta = transaccionValues[3];
                            double precio = Double.parseDouble(transaccionValues[4]);
                            int cantidad = Integer.parseInt(transaccionValues[5]);
                            // Crear objeto Transaccion con los valores leídos
                            //Transaccion transaccion = new Transaccion(numeroTransaccion, vendedor, comprador, itemVenta, precio, cantidad);
                            // Hacer algo con el objeto Transaccion, como agregarlo a una lista
                            break;
                        default:
                            break;
                    }
                }
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("No se pudo encontrar el archivo.");
        }
    }

}
