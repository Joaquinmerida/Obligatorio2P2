package segundoobligatoriop2;

import java.util.ArrayList;
import segundoobligatoriop2.interfaz.*;
import segundoobligatoriop2.auxiliar.*;

public class Sistema {

    private static ArrayList<Mayorista> listaMayoristas;
    private static ArrayList<Puesto> listaPuesto;
    private static ArrayList<Dueno> listaDuenos;
    private static ArrayList<Transaccion> listaTransacciones;

    public static void main(String[] args) {
        listaMayoristas = new ArrayList<>();
        listaDuenos = new ArrayList<>();
        listaPuesto = new ArrayList<>();
        listaTransacciones = new ArrayList<>();
        Interfaz v = new Interfaz();
        v.setVisible(true);
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

    public static void agregarTransaccion(String vendedor, String comprador, Item item, int precio, int cantidad) {
        listaTransacciones.add(new Transaccion(vendedor, comprador, item, precio, cantidad));
    }

    public static void realizarCompraDePuesto(int vendedor, String comprador, String itemVendido, int precio, int cantidad) {
        Item itemObjeto = null;
        Mayorista mayorista = getMayorista(vendedor);
        
       
        for (Item itemMayorista : mayorista.getListaItems()) {
            if (itemMayorista.getNombre().equals(itemVendido)) {
                itemObjeto = new Item(itemMayorista.getNombre(), itemMayorista.getDescripcion(), itemMayorista.getTipo(), itemMayorista.getFormaVenta(), itemMayorista.getImagen());
                itemObjeto.setCantidad(cantidad);
            }
        }

        for (Puesto puesto : listaPuesto) {
            if (puesto.getIdentificacion().equals(comprador)) {
                boolean itemEncontrado = false;
                for (Item itemEnStock : puesto.getStock()) {
                    if (itemEnStock.getNombre().equals(itemObjeto.getNombre())) {
                        itemEncontrado = true;
                        itemEnStock.sumarCantidad(cantidad);
                        agregarTransaccion(vendedor+"", comprador, itemObjeto, precio, cantidad);
                        break;
                    }
                }
                if (!itemEncontrado) {
                    itemObjeto.setCantidad(cantidad);
                    puesto.añadirItem(itemObjeto);
                    agregarTransaccion(vendedor+"", comprador, itemObjeto, precio, cantidad);
                }
            }
        }
        for (Transaccion transaccion : listaTransacciones) {
            System.out.println(transaccion.getRutVendedor() + " le vendio : " + transaccion.getCantidad() + " " + transaccion.getItemsVenta().getNombre() + " a " + transaccion.getPrecio());
        }
    }

    public static void realizarCompraDePublico(String idVendedor, String comprador, Item itemVendido, int precio, int cantidad) {
        for (Puesto puesto : listaPuesto) {
            if (puesto.getIdentificacion().equals(idVendedor)) {
                for (Item item : puesto.getStock()) {
                    if (itemVendido.getNombre().equals(item.getNombre())) {
                        if (item.getCantidad() >= cantidad) {
                            agregarTransaccion(idVendedor, "Publico", itemVendido,precio,cantidad);
                            System.out.println("Se agrega compra a publico: " + idVendedor + itemVendido.getNombre());
                        }else{
                            System.out.println("compra no valida");
                        }
                    }
                }
            }
        }
    }

    public static Boolean itemUnico(String nombreItem, ArrayList<Item> listaItems) {
        Boolean existe = false;
        for (Item item : listaItems) {
            if (item.getNombre().equals(nombreItem)) {
                existe = true;
            }
        }
        return existe;
    }

    public static void ventaAPuesto(int rutVendedor, String comprador, String item, int cantidad, int precio) {
//        for (Mayorista mayorista : listaMayoristas) {
//            if (mayorista.get().contains(rut)) {
//                existe = true;
//                System.out.println("ya hay un mayorista con ese rut");
//            }
//        }
    }

    public static void agregarMayorista(String nombre, int rut, String direccion) {
        if (!mayoristaUnico(rut)) {
            System.out.println("ya existe ese mayorista");
        } else {
            Mayorista unMayorista = new Mayorista(rut, nombre, direccion);
            Sistema.getListaMayoristas().add(unMayorista);
            System.out.println("se agrega mayorista");
        }
        for (Mayorista mayorista : listaMayoristas) {
            System.out.println(mayorista.getNombre());
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
            Puesto unpuesto = new Puesto(identificacion, dueno, ubicacion, empleados);
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

    public static void agregarItemAMayorista(int rutMayorista, String nombre, String descripcion, String tipo, String formaVenta, String imagen) {

        Item unItem = new Item(nombre, descripcion, tipo, formaVenta, imagen);

        for (int i = 0; i < Sistema.getListaMayoristas().size(); i++) {
            if (Sistema.getListaMayoristas().get(i).getRut() == rutMayorista) {
                if (Sistema.getListaMayoristas().get(i).itemUnico(nombre)) {
                    Sistema.getListaMayoristas().get(i).getListaItems().add(unItem);
                    System.out.println("item agregado");
                } else {
                    System.out.println("ese item ya existe en este mayorista");
                }
            }
        }

    }

    public void agregarPuesto(Puesto unPuesto) {
        this.getListaPuesto().add(unPuesto);
    }

    public static void altaItem(String nombre, String descripcion, String tipo, String formaVenta, String imagen) {

        System.out.println("se agrega");

    }

}
