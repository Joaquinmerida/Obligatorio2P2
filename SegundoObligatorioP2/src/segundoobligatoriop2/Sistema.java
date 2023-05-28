package segundoobligatoriop2;

import java.util.ArrayList;
import segundoobligatoriop2.interfaz.*;
import segundoobligatoriop2.auxiliar.*;

public class Sistema {

    private static ArrayList<Mayorista> listaMayoristas;
    private static ArrayList<Puesto> listaPuestos;

    public static void main(String[] args) {
        listaMayoristas = new ArrayList<>();
        listaPuestos = new ArrayList<>();
        Interfaz v = new Interfaz();
        v.setVisible(true);

    }

    public static ArrayList<Mayorista> getListaMayoristas() {
        return listaMayoristas;
    }

    public ArrayList<Puesto> getListaPuestos() {
        return listaPuestos;
    }

    public static void agregarMayorista(String nombre, String rut, String direccion) {
        if (mayoristaUnico(rut)) {
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

    public static Boolean mayoristaUnico(String rut) {
        Boolean existe = false;
        for (Mayorista mayorista : listaMayoristas) {
            if (mayorista.getRut().contains(rut)) {
                existe = true;
                System.out.println("ya hay un mayorista con ese rut");
            }
        }
        return existe;
    }

    public static void agregarItemAMayorista(String nombreMayorista, String nombre, String descripcion, String tipo, String formaVenta, String imagen) {
        
        
        Item unItem= new Item(nombre,descripcion,tipo,formaVenta,imagen);

        for (int i = 0; i < Sistema.getListaMayoristas().size(); i++) {
            if (Sistema.getListaMayoristas().get(i).getNombre().equals(nombreMayorista)) {
                        if(Sistema.getListaMayoristas().get(i).itemUnico(nombre)){
                                       Sistema.getListaMayoristas().get(i).getListaItems().add(unItem);
                                       System.out.println("item agregado");
                        }else{
                            System.out.println("ese item ya existe en este mayorista");
                        }
            }
        }

    }

    public void agregarPuesto(Puesto unPuesto) {
        this.getListaPuestos().add(unPuesto);
    }

    public static void altaItem(String nombre, String descripcion, String tipo, String formaVenta, String imagen) {

        System.out.println("se agrega");

    }

}
